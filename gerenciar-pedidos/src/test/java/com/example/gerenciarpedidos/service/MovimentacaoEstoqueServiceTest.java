package com.example.gerenciarpedidos.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import com.example.gerenciarpedidos.entity.MovimentacaoEstoque;
import com.example.gerenciarpedidos.repository.MovimentacaoEstoqueRepository;

public class MovimentacaoEstoqueServiceTest {

    @Mock
    private MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    @InjectMocks
    private MovimentacaoEstoqueService movimentacaoEstoqueService;

    @Mock
    private Logger logger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        List<MovimentacaoEstoque> movimentacoes = new ArrayList<>();
        movimentacoes.add(new MovimentacaoEstoque());
        when(movimentacaoEstoqueRepository.findAll()).thenReturn(movimentacoes);

        List<MovimentacaoEstoque> result = movimentacaoEstoqueService.findAll();

        assertEquals(1, result.size());
    }

    @Test
    public void testFindById() {
        MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
        movimentacao.setId(1L);
        Optional<MovimentacaoEstoque> optional = Optional.of(movimentacao);
        when(movimentacaoEstoqueRepository.findById(1L)).thenReturn(optional);

        Optional<MovimentacaoEstoque> result = movimentacaoEstoqueService.findById(1L);

        assertEquals(movimentacao, result.get());
    }

    @Test
    public void testSave() {
        MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
        when(movimentacaoEstoqueRepository.save(movimentacao)).thenReturn(movimentacao);

        MovimentacaoEstoque result = movimentacaoEstoqueService.save(movimentacao);

        assertEquals(movimentacao, result);
    }

    @Test
    public void testDeleteById() {
        movimentacaoEstoqueService.deleteById(1L);

        // verify that the deleteById method was called on the repository
        mock(MovimentacaoEstoqueRepository.class).deleteById(1L);
    }

}