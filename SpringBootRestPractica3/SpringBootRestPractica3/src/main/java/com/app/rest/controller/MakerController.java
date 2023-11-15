package com.app.rest.controller;

import com.app.rest.dto.MakerDTO;
import com.app.rest.entities.Maker;
import com.app.rest.service.impl.MakerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/maker")
public class MakerController {

private MakerService makerService;

    public MakerController(MakerService makerService) {
        this.makerService = makerService;
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Maker> optionalMaker = makerService.findById(id);
        if(!optionalMaker.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Maker maker=optionalMaker.get();
        MakerDTO makerDTO= MakerDTO.builder()
                .id(maker.getId())
                .name(maker.getName())
                .products(maker.getProducts()).build();
      return ResponseEntity.ok(makerDTO);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<MakerDTO> makerDTOList  = makerService.findAll()
                .stream().map(MakerDTO::new).collect(Collectors.toList());

        //otra forma de hacerlo debe tener @Builder el entity
     /* List<MakerDTO> makerDTOList1  = makerService.findAll()
                .stream()
                        .map(maker->MakerDTO.builder()
                        .id(maker.getId()).name(maker.getName())
                                .products(maker.getProducts())
                                .build())
                .toList();*/

        return ResponseEntity.ok(makerDTOList);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMaker(@RequestBody @Valid MakerDTO makerDTO){
     Maker maker= Maker.builder()
                     .id(makerDTO.getId())
                             .name(makerDTO.getName())
                                     .products(makerDTO.getProducts()).build();
     makerService.save(maker);
        URI url= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(maker.getId()).toUri();

        //otra forma de poner el URI
        //return ResponseEntity.created(new URI("/api/maker/create")).build();
         return ResponseEntity.created(url).build();
    }
    @PutMapping("/update/{id}")
    public  ResponseEntity<?> updateMaker(@PathVariable Long id, @RequestBody MakerDTO makerDTO){
        Optional<Maker> optionalMaker = makerService.findById(id);
        if(!optionalMaker.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        Maker maker=optionalMaker.get();
        if(maker.getName()!= makerDTO.getName()){
            maker.setName(makerDTO.getName());
        }
        makerService.save(maker);
        return ResponseEntity.ok("Register Updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        if(id!=null){
            Optional<Maker> optionalMaker = makerService.findById(id);
            if (optionalMaker.isPresent()){
                makerService.deleteById(optionalMaker.get().getId());
                return ResponseEntity.ok("Record Deleted");
            }
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.badRequest().build();

    }
}
