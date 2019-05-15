package com.msbooks.msx.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book{
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 2, max = 255, message = "Must be between 2 and 255")
    private String bookName;
    
    @Size(min = 2, max = 255, message = "Must be between 2 and 255")
    private String publisher;
    

    
    @Size(min = 2, max = 255, message = "Must be between 2 and 255")
    private String location;
    
    // @Join tables:
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name="author_id")
    // private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;


    public void setAId(Long id){
        this.author.setId (id);
    }

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "authorId", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    // private Author author;





    // @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    
    //Empty constructor
    public Book(){};



    // public Book(Long id, String bookName, String publisher, String location, Author author, Date createdAt, Date updatedAt) {
    //     this.id = id;
    //     this.bookName = bookName;
    //     this.publisher = publisher;
    //     this.location = location;
    //     this.author = getAuthor();
    // }






    // public Book(Long id, String bookName, String publisher, String location,  Date createdAt, Date updatedAt) {
    //     this.id = id;
    //     this.bookName = bookName;
    //     this.publisher = publisher;
    //     this.location = location;
    //     // this.author = author;
    //     this.createdAt = createdAt;
    //     this.updatedAt = updatedAt;
    // }

   
    //setters and getters

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }



    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    public Author getAuthor(){
        return this.author;
    }


}