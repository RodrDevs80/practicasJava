package com.sertec.clonGoogleBack.repositories;

import com.sertec.clonGoogleBack.entities.WebPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WepPageRepository extends JpaRepository<WebPage,Long> {

    @Modifying
    @Query(value = "SELECT * FROM webpage WHERE title LIKE :textsearch",nativeQuery = true)
    public List<WebPage> search(String textsearch);
}
