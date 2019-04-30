package com.msbooks.msx.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

import com.msbooks.msx.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Optional<Author> findById(Long id);
    List<Author> findAll();

    Author findByName(String firstname);
    Author findByFirstAndLastName(String firstName, String lastName);

}
