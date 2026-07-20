package com.example.estudos_spring_boot.book.repository;

import com.example.estudos_spring_boot.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
