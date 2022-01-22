package com.example.hibernatenotebookapp.controller;

import com.example.hibernatenotebookapp.newsrepo.News;
import com.example.hibernatenotebookapp.newsrepo.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewsController {


    NewsRepo newsRepo;

    @Autowired
    public NewsController(NewsRepo newsRepo) {

        this.newsRepo = newsRepo;
    }

    @PostMapping("/add")
    public String writeNews(@RequestParam(value = "input", required = true) String input, Model model) {


        model.addAttribute("memo", newsRepo.save(new News(input)));

        return "redirect:/notebook";
    }

    @GetMapping("/notebook")
    public String seeNews(Model model) {


        model.addAttribute("userInputs", newsRepo.findAll());


        return "notebook";
    }

    @PostMapping("/edit")
    public String editseeNews(@ModelAttribute News news) {
        newsRepo.save(news);

        return "redirect:/notebook";
    }


    @GetMapping("/notebook/{id}")
    public String getCarById(@PathVariable Long id, Model model) {

        model.addAttribute("newsToUpdate", newsRepo.findById(id).stream()
                .filter(x -> x.getId()
                        .equals(id))
                .findFirst()
                .get()
        );

        return "edit";

    }


}
