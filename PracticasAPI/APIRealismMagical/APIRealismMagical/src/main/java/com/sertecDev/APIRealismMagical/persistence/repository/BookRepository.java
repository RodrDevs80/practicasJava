package com.sertecDev.APIRealismMagical.persistence.repository;

import com.sertecDev.APIRealismMagical.persistence.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
