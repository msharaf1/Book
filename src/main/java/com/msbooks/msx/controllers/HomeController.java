package com.msbooks.msx.controllers;

import java.util.List;

import com.msbooks.msx.models.Author;
import com.msbooks.msx.services.AuthorService;
import com.msbooks.msx.services.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// @Controller
public class HomeController {
    // BookService bookServ;
    // AuthorService authServ;

    // public HomeController(AuthorService authServ){
    //     this.authServ = authServ;
    //     // this.bookServ = bookserv;
    // }

    // @GetMapping("/authors")
    // public String allAuths(Model model){
    //     List<Author> authors = authServ.findAllAuths();
    //     model.addAttribute("authors", authors);
        
    //     return "index";
    // }
}
