package com.example.hibernatenotebookapp.service;

import com.example.hibernatenotebookapp.models.Notebook;

import java.util.List;

public interface NotebookService {

    void saveNote(Notebook notebook);

    void saveUpdate(Notebook notebook);

    List<Notebook> findAllNotes();

    Notebook findNoteById(Long id);


}
