package com.example.testcratorspring.author;

import com.example.testcratorspring.author.Author;
import com.example.testcratorspring.author.AuthorRepository;
import com.example.testcratorspring.test.Test;
import com.example.testcratorspring.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<Test> getAllAuthorByUser(User user){
        List<Author> authors = authorRepository.findByUser(user);
        List<Test> tests = new ArrayList<>();
        for(Author author : authors){
            tests.add(author.getTest());
        }
        return tests;
    }

    public void deleteAuthor(String id){
        authorRepository.deleteById(Long.parseLong(id));
    }

/*

    public List<Test> getAllTestByUser(User user){
        List<Test> testList = new ArrayList<>();
        List<Author> authors = authorRepository.findByUser(user);

        for (Author a : authors) {
            testList.add(a.getTest());
        }
        return testList;
    }
*/

}
