package com.example.gerenciarpedidos.controller;

import com.example.gerenciarpedidos.email.EmailService;
import com.example.gerenciarpedidos.entity.Ordem;
import com.example.gerenciarpedidos.service.OrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ordens")
public class OrdemController {

    @Autowired
    private OrdemService ordemService;

    @Autowired
    private EmailService emailService;

    @GetMapping
    public List<Ordem> findAll() {
        return ordemService.findAll();
    }

    @GetMapping("/{id}")
    public Ordem findById(@PathVariable Long id) {
        return ordemService.findById(id);
    }

    @PostMapping
    public Ordem save(@RequestBody Ordem ordem) {
        emailService.sendSimpleMessage("teste@gmail.com", "Assunto do e-mail", "Corpo do e-mail");
        return ordemService.save(ordem);
    }

    @PutMapping("/{id}")
    public Ordem update(@PathVariable Long id, @RequestBody Ordem ordem) {
        ordem.setId(id);
        return ordemService.save(ordem);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        ordemService.deleteById(id);
    }
}

