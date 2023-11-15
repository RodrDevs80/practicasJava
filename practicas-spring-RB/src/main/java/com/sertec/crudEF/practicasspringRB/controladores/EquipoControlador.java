package com.sertec.crudEF.practicasspringRB.controladores;

import com.sertec.crudEF.practicasspringRB.modelo.Equipo;
import com.sertec.crudEF.practicasspringRB.modelo.RespuestaEquipo;
import com.sertec.crudEF.practicasspringRB.repositorio.EquipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipos")
public class EquipoControlador {
    @Autowired
    private EquipoRepositorio equipoRepositorio;

    @PostMapping
    public ResponseEntity<Equipo> guardarEquipo(@RequestBody Equipo equipo){
        Equipo equipoGuardado = equipoRepositorio.save(equipo);
        //return ResponseEntity.ok(equipoGuardado);
        URI url= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(equipoGuardado.getId()).toUri();
        return ResponseEntity.created(url).build();
    }

    @GetMapping
    public ResponseEntity<Page<Equipo>> listarEquipos(Pageable pageable){
        List<Equipo> equipos = equipoRepositorio.findAll();
        Page<Equipo> pageEquipos= new PageImpl<>(equipos);

        return  ResponseEntity.ok(pageEquipos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Equipo> eliminarEquipo(@PathVariable Integer id){
        Optional<Equipo> optionalEquipo=equipoRepositorio.findById(id);
        if(!optionalEquipo.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        equipoRepositorio.delete(optionalEquipo.get());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizarEquipo(@PathVariable Integer id, @RequestBody Equipo equipo){
        Optional<Equipo> optionalEquipo=equipoRepositorio.findById(id);
        if(!optionalEquipo.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
       equipo.setId(optionalEquipo.get().getId());
        equipoRepositorio.save(equipo);

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> buscarEquipoPorId(@PathVariable Integer id){
        Optional<Equipo> optionalEquipo=equipoRepositorio.findById(id);
        if(!optionalEquipo.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        Equipo equipoBuscado = optionalEquipo.get();

        return  ResponseEntity.ok(equipoBuscado);
    }
}
