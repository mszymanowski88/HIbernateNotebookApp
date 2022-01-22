package com.example.hibernatenotebookapp.newsrepo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepo extends JpaRepository<News, Long> {


}
