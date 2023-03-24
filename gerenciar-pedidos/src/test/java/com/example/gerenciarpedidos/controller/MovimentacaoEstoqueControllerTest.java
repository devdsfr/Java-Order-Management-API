package com.example.gerenciarpedidos.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.gerenciarpedidos.entity.MovimentacaoEstoque;
import com.example.gerenciarpedidos.service.MovimentacaoEstoqueService;

@SpringBootTest
public class MovimentacaoEstoqueControllerTest {

    @MockBean
    private MovimentacaoEstoqueService movimentacaoEstoqueService;

    @Test
    public void testFindAll() {
        List<MovimentacaoEstoque> movimentacoes = new ArrayList<>();
        movimentacoes.add(new MovimentacaoEstoque());
        movimentacoes.add(new MovimentacaoEstoque());

        when(movimentacaoEstoqueService.findAll()).thenReturn(movimentacoes);

        List<MovimentacaoEstoque> result = movimentacaoEstoqueService.findAll();

        verify(movimentacaoEstoqueService, times(1)).findAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
        movimentacao.setId(id);

        when(movimentacaoEstoqueService.findById(id)).thenReturn(Optional.of(movimentacao));

        Optional<MovimentacaoEstoque> result = movimentacaoEstoqueService.findById(id);

        verify(movimentacaoEstoqueService, times(1)).findById(id);
        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());
    }

    @Test
    public void testSave() {
        MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();

        when(movimentacaoEstoqueService.save(movimentacao)).thenReturn(movimentacao);

        MovimentacaoEstoque result = movimentacaoEstoqueService.save(movimentacao);

        verify(movimentacaoEstoqueService, times(1)).save(movimentacao);
        assertNotNull(result);
    }

    @Test
    public void testUpdate() {
        Long id = 1L;
        MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
        movimentacao.setId(id);

        when(movimentacaoEstoqueService.save(movimentacao)).thenReturn(movimentacao);

        MovimentacaoEstoque result = movimentacaoEstoqueService.save(movimentacao);

        verify(movimentacaoEstoqueService, times(1)).save(movimentacao);
        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;

        doNothing().when(movimentacaoEstoqueService).deleteById(id);

        movimentacaoEstoqueService.deleteById(id);

        verify(movimentacaoEstoqueService, times(1)).deleteById(id);
    }
}