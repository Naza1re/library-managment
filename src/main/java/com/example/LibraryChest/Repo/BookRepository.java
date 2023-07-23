package com.example.LibraryChest.Repo;

import com.example.LibraryChest.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
