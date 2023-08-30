package br.com.java.exploringrestwithspringboot.Repositories;

import br.com.java.exploringrestwithspringboot.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}
