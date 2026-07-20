package com.example.estudos_spring_boot.book.service;

import com.example.estudos_spring_boot.author.entity.Author;
import com.example.estudos_spring_boot.author.repository.AuthorRepository;
import com.example.estudos_spring_boot.book.entity.Book;
import com.example.estudos_spring_boot.book.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class bookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public bookService(
            BookRepository bookRepository,
            AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Book CadastrarLivro(String title, Long authorId, BigDecimal price) {

        Author author = authorRepository.findById(authorId)
                .orElseThrow(()-> new IllegalArgumentException("autor não encontrado"));

        Book book = Book.builder()
            .title(title)
            .author(author)
            .price(price)
            .build();

        bookRepository.save(book);

        author.incrementarTotalLivros();
        authorRepository.save(author);

        return book;
    }

}
