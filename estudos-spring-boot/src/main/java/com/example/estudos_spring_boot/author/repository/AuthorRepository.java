package com.example.estudos_spring_boot.author.repository;

import com.example.estudos_spring_boot.author.entity.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

//    resolve problema de N+1
    @Query("SELECT DISTINCT a FROM Author a LEFT JOIN FETCH a.books")
    List<Author> findAllWithBooks();


//    resolve problema de N+1
    @EntityGraph(attributePaths = {"books"})
    List<Author> findAllWithBooks2();

}
