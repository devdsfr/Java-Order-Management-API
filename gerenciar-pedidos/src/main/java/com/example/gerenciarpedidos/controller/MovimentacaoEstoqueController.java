package com.example.gerenciarpedidos.controller;

import com.example.gerenciarpedidos.entity.MovimentacaoEstoque;
import com.example.gerenciarpedidos.service.MovimentacaoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimentacoes")
public class MovimentacaoEstoqueController {
    @Autowired
    private MovimentacaoEstoqueService movimentacaoEstoqueService;

    @GetMapping
    public List<MovimentacaoEstoque> findAll() {
        return movimentacaoEstoqueService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<MovimentacaoEstoque> findById(@PathVariable Long id) {
        return movimentacaoEstoqueService.findById(id);
    }

    @PostMapping
    public MovimentacaoEstoque save(@RequestBody MovimentacaoEstoque movimentacaoEstoque) {
        return movimentacaoEstoqueService.save(movimentacaoEstoque);
    }

    @PutMapping("/{id}")
    public MovimentacaoEstoque update(@PathVariable Long id, @RequestBody MovimentacaoEstoque movimentacaoEstoque) {
        movimentacaoEstoque.setId(id);
        return movimentacaoEstoqueService.save(movimentacaoEstoque);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        movimentacaoEstoqueService.deleteById(id);
    }
}




