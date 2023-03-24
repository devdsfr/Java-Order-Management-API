package com.example.gerenciarpedidos.service;

import com.example.gerenciarpedidos.entity.Ordem;
import com.example.gerenciarpedidos.repository.OrdemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemService {

    @Autowired
    private OrdemRepository ordemRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrdemService.class);

    public List<Ordem> findAll() {
        return ordemRepository.findAll();
    }

    public Ordem findById(Long id) {
        return ordemRepository.findById(id).orElse(null);
    }

    public Ordem save(Ordem ordem) {
        LOGGER.info("Ordem criado com sucesso!");
        return ordemRepository.save(ordem);
    }

    public void deleteById(Long id) {
        ordemRepository.deleteById(id);
    }
}
