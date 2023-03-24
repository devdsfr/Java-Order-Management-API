package com.example.gerenciarpedidos.service;

import com.example.gerenciarpedidos.entity.MovimentacaoEstoque;
import com.example.gerenciarpedidos.repository.MovimentacaoEstoqueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoEstoqueService {

    @Autowired
    private MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(MovimentacaoEstoque.class);

    public List<MovimentacaoEstoque> findAll() {
        return movimentacaoEstoqueRepository.findAll();
    }

    public Optional<MovimentacaoEstoque> findById(Long id) {
        return movimentacaoEstoqueRepository.findById(id);
    }

    public MovimentacaoEstoque save(MovimentacaoEstoque movimentacaoEstoque) {
        LOGGER.info("Movimento de estoque com sucesso!");
        return movimentacaoEstoqueRepository.save(movimentacaoEstoque);
    }

    public void deleteById(Long id) {
        movimentacaoEstoqueRepository.deleteById(id);
    }

}
