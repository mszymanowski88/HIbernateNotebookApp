package com.example.hibernatenotebookapp.service;

import com.example.hibernatenotebookapp.models.Notebook;
import com.example.hibernatenotebookapp.notebookrepo.NotebookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotebookServiceImpl implements NotebookService {

    private final NotebookRepo notebookRepo;


    @Autowired
    public NotebookServiceImpl(NotebookRepo notebookRepo) {
        this.notebookRepo = notebookRepo;

    }


    @Override
    public void saveNote(Notebook notebook) {
        notebookRepo.save(new Notebook(notebook.getInput()));

    }

    @Override
    public void saveUpdate(Notebook notebook) {
        notebookRepo.save(notebook);

    }

    @Override
    public List<Notebook> findAllNotes() {
        return notebookRepo.findAll();

    }

    @Override
    public Notebook findNoteById(Long id) {

        return notebookRepo.findById(id).stream()
                .filter(x -> x.getId()
                        .equals(id))
                .findFirst()
                .get();


    }


}
