package org.lessons.java.spring_alexandria_library.controller;

import org.lessons.java.spring_alexandria_library.model.Borrowing;
import org.lessons.java.spring_alexandria_library.repository.BorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/borrowings")
public class BorrowingController {

    @Autowired
    private BorrowingRepository repository;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("borrowing") Borrowing formBorrowing,
    BindingResult bindingResult, Model model){
        
        if (bindingResult.hasErrors()) {
            
            return "borrowings/create";
        }

        repository.save(formBorrowing);


        return "redirect:/books";
    }

    
}
