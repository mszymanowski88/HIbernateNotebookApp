package com.example.hibernatenotebookapp.controller;

import com.example.hibernatenotebookapp.models.Notebook;
import com.example.hibernatenotebookapp.service.NotebookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotebookController {


    private final NotebookServiceImpl notebookServiceImpl;

    @Autowired
    public NotebookController(NotebookServiceImpl notebookServiceImpl) {


        this.notebookServiceImpl = notebookServiceImpl;
    }


    @PostMapping("/add")
    public String writeNews(@ModelAttribute Notebook notebook) {

        notebookServiceImpl.saveNote(notebook);


        return "redirect:/notebook";
    }

    @GetMapping("/notebook")
    public String seeNews(Model model) {


        model.addAttribute("userInputs", notebookServiceImpl.findAllNotes());
        model.addAttribute("note", new Notebook());


        return "notebook";
    }

    @PostMapping("/edit")
    public String editsNews(@ModelAttribute Notebook notebook) {

        notebookServiceImpl.saveUpdate(notebook);

        return "redirect:/notebook";
    }


    @GetMapping("/notebook/{id}")
    public String getCarById(@PathVariable Long id, Model model) {

        model.addAttribute("newsToUpdate", notebookServiceImpl.findNoteById(id));

        return "edit";

    }


}
