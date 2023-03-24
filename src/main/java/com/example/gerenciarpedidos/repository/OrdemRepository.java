package com.example.gerenciarpedidos.repository;

import com.example.gerenciarpedidos.entity.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemRepository extends JpaRepository<Ordem, Long> {
}

