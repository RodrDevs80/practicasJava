package com.sertec.clonGoogleBack.controllers;

import com.sertec.clonGoogleBack.entities.WebPage;
import com.sertec.clonGoogleBack.services.SearchService;
import com.sertec.clonGoogleBack.services.SpiderService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
//@CrossOrigin("*")
public class SearchController {
   private SearchService searchService;
   private SpiderService spiderService;
    public SearchController(SearchService searchService, SpiderService spiderService) {
        this.searchService = searchService;
        this.spiderService = spiderService;
    }


    @GetMapping("/search")
    public List<WebPage> search(@RequestParam Map<String,String> params){
        List<WebPage> result=new ArrayList<>();
        String query=params.get("query");
        query="% "+query+" %";
        result=searchService.search(query);
        return result;
    }
    @GetMapping("/test")
    public void test() {
        spiderService.indexWebPages();
    }
}
