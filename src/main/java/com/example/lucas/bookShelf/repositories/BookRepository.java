package com.example.lucas.bookShelf.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.lucas.bookShelf.models.Books;

@Repository
public interface BookRepository extends CrudRepository<Books, Integer>{
}
