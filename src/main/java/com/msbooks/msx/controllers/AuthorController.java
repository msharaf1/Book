package com.msbooks.msx.controllers;

import java.util.List;

import javax.validation.Valid;

import com.msbooks.msx.models.Author;
import com.msbooks.msx.services.AuthorService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {
    private AuthorService authServ;

    public AuthorController(AuthorService authServ){
        this.authServ = authServ;
    }

    @GetMapping("/authors")
    public String getAllAuthors(Model model){
        List<Author> authorsList = authServ.getAuthors();
        model.addAttribute("authorCom", authorsList);
        // System.out.println(authorsList.iterator());
                // for(int i = 0; i < authorsList.size(); i++){
                //     System.out.println(authorsList.get(i).getEmail());
                // }
        return "showAuthors";
    }
//authorObj
    @GetMapping("/authors/new")
    public String newAuthorPage(@ModelAttribute("authorObj") Author author){
        return "newAuthor";
    }
    @PostMapping("/authors/new")
    public String newAuthor(@Valid @ModelAttribute("authorObj") Author author, BindingResult result){
        // model.addAttribute("authorObj", authorObj);
        if(result.hasErrors()){
            return "redirect:/newAuthor";
        } else {
            Author newAuthor = authServ.createAuthor(author);
            return "redirect:/authors";
        }
    }

}