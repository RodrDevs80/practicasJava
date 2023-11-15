package com.sertec.clonGoogleBack.services;

import com.sertec.clonGoogleBack.entities.WebPage;
import com.sertec.clonGoogleBack.repositories.WepPageRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class SearchService {
    private WepPageRepository repository;

    public SearchService(WepPageRepository repository) {
        this.repository = repository;
    }
    @Transactional
    public List<WebPage> search(String textsearch){
        List<WebPage> webPages = repository.search(textsearch);
        return webPages;
    }

    public List<WebPage> getLinksToIndex() {
    }

    public boolean exist(String link) {
    }

    public void save(WebPage webPage) {
    }
}
