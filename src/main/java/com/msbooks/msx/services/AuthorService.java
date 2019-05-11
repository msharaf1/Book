package com.msbooks.msx.services;

import com.msbooks.msx.repositories.AuthorRepository;
import com.msbooks.msx.models.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private AuthorRepository authorRepo;

    public AuthorService(AuthorRepository authorRepo){
        this.authorRepo = authorRepo;
    }

    public List<Author> getAuthors(){
        return authorRepo.findAll();
    }
    public Author createAuthor(Author author){
        return authorRepo.save(author);
    }

    public Author getAuthorId(Long id){
        Optional<Author> optionalAutor = authorRepo.findById(id);
        if(optionalAutor.isPresent()){
            return optionalAutor.get();
        } else {
            return null;
        }

    }
    public void deleteAuthor(Long id){
        authorRepo.deleteById(id);
    }

}