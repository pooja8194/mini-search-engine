package minisearchengine.controller;

import minisearchengine.MinisearchengineApplication;
import minisearchengine.service.SearchEngine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashSet;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class SearchController {

    private SearchEngine engine;

    public SearchController() {
    System.out.println("===== SearchController Loaded =====");
    engine = new SearchEngine(MiniSearchengineApplication.indexer.getIndex());
    }

    @GetMapping("/search")
    public HashSet<String> search(@RequestParam String keyword) {

        return new HashSet<>(engine.search(keyword));

    }
    @GetMapping("/search/and")
    public HashSet<String> searchAND(@RequestParam String keywords) {
    
        String[] words = keywords.split("\\s+");
    
        return new HashSet<>(engine.searchAND(words));
    }
    
    @GetMapping("/search/or")
    public HashSet<String> searchOR(@RequestParam String keywords) {
    
        String[] words = keywords.split("\\s+");
    
        return new HashSet<>(engine.searchOR(words));
    }
}