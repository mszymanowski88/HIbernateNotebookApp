package com.example.hibernatenotebookapp.notebookrepo;

import com.example.hibernatenotebookapp.models.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotebookRepo extends JpaRepository<Notebook, Long> {


}
