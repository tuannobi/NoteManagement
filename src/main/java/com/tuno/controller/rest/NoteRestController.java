package com.tuno.controller.rest;

import com.tuno.model.Note;
import com.tuno.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/notes")
public class NoteRestController {

    private NoteService noteService;

    @Autowired
    public NoteRestController(NoteService noteService){
        this.noteService=noteService;
    }

    @GetMapping
    public List<Note> getAll(){
        return noteService.findAll();
    }

    @GetMapping("/{id}")
    public Note get(@PathVariable("id") Long id){
        return noteService.findById(id);
    }

    @PostMapping
    public Note add(@RequestBody Note note){
        Note responseNote=noteService.create(note);
        return responseNote;
    }

    @PutMapping
    public Note update(@RequestBody Note note){
        Note responseNote=noteService.update(note);
        return responseNote;
    }

    @DeleteMapping
    public void delete(@RequestBody Note note){
        System.out.println(note);
        noteService.delete(note);
    }
}
