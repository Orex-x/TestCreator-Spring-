package com.example.testcratorspring.author;

import com.example.testcratorspring.author.Author;
import com.example.testcratorspring.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Iterable<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthor(String id){
        return authorRepository.findById(Long.parseLong(id));
    }
    public void addAuthor(Author author){
        authorRepository.save(author);
    }

    public void addAuthor(String id, Author author){
        Author author1 = getAuthor(id).get();
        author1.setTest(author.getTest());
        author1.setUser(author.getUser());
        authorRepository.save(author1);
    }

    public void deleteAuthor(String id){
        authorRepository.deleteById(Long.parseLong(id));
    }
}
