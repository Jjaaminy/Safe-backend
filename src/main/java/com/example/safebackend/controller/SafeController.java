package com.example.safebackend.controller;

import com.example.safebackend.model.Passwort;
import com.example.safebackend.repo.SafeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class SafeController {

    private SafeRepo repo;
    private List<Passwort> list;

    @Autowired
    public SafeController(SafeRepo repo) {
        this.repo = repo;
    }

    @GetMapping("passwort")
    public List<Passwort> getPlayers() {
        return (List<Passwort>) repo.findAll();
    }

    @GetMapping("/passwort/{id}")
    public Passwort getById(@PathVariable int id) {
        return list.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .get();
    }

    @DeleteMapping("/passwort/{id}")
    private void deleteTodo(@PathVariable int deleteid) {
        Passwort del = list.stream()
                .filter(todo -> todo.getId() == deleteid)
                .findFirst()
                .get();
        list.remove(del);
    }


    @DeleteMapping("/passwort")
    private void deleteall(){
        list.clear();
    }


    @PutMapping("/passwort/{id}")
    public void updateTeam(@RequestBody Passwort pass, @PathVariable int id) {
        Passwort update = list.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .get();
        update.setUser(pass.getUser());
        update.setPasswort(pass.getPasswort());
        update.setUrl(pass.getUrl());

    }

    @PostMapping("/passwort")
    Passwort createNewPasswort(@RequestBody Passwort newPasswort) {
        return repo.save(newPasswort);
    }

}
