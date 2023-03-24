package com.example.gerenciarpedidos.service;

import com.example.gerenciarpedidos.entity.Item;
import com.example.gerenciarpedidos.entity.Ordem;
import com.example.gerenciarpedidos.entity.Usuario;
import com.example.gerenciarpedidos.repository.OrdemRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OrdemServiceTest {

    @Mock
    private OrdemRepository ordemRepository;

    @InjectMocks
    private OrdemService ordemService;

    @Test
    public void testFindAll() {
        Date dataHoraAtual = new Date();
        List<Ordem> ordens = new ArrayList<>();
        ordens.add(new Ordem(1L, dataHoraAtual, new Item(1L, "Item 1"), 1, new Usuario(1L, "Usuario 1", "usuario1")));
        ordens.add(new Ordem(2L, dataHoraAtual, new Item(2L, "Item 2"), 1, new Usuario(1L, "Usuario 2", "usuario2")));
        when(ordemRepository.findAll()).thenReturn(ordens);

        List<Ordem> result = ordemService.findAll();

        assertEquals(2, result.size());
        verify(ordemRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Date dataHoraAtual = new Date();
        Ordem ordem = new Ordem(1L, dataHoraAtual, new Item(1L, "Item 1"), 1, new Usuario(1L, "Usuario 1", "usuario1"));
        when(ordemRepository.findById(1L)).thenReturn(Optional.of(ordem));

        Ordem result = ordemService.findById(1L);

        assertEquals(ordem, result);
        verify(ordemRepository, times(1)).findById(1L);
    }

    @Test
    public void testSave() {
        Date dataHoraAtual = new Date();

        Ordem ordem = new Ordem(1L, dataHoraAtual, new Item(1L, "Item 1"), 1, new Usuario(1L, "Usuario 1", "usuario1"));
        when(ordemRepository.save(ordem)).thenReturn(ordem);

        Ordem result = ordemService.save(ordem);

        assertEquals(ordem, result);
        verify(ordemRepository, times(1)).save(ordem);
    }

    @Test
    public void testDeleteById() {
        ordemService.deleteById(1L);

        verify(ordemRepository, times(1)).deleteById(1L);
    }
}