package com.example.gerenciarpedidos.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.gerenciarpedidos.entity.Item;
import com.example.gerenciarpedidos.entity.Usuario;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.gerenciarpedidos.email.EmailService;
import com.example.gerenciarpedidos.entity.Ordem;
import com.example.gerenciarpedidos.service.OrdemService;

@SpringBootTest
public class OrdemControllerTest {

    @Mock
    private OrdemService ordemService;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private OrdemController ordemController;

    @Test
    public void testFindAll() {
        Date dataHoraAtual = new Date();

        List<Ordem> ordens = new ArrayList<>();
        ordens.add(new Ordem(1L, dataHoraAtual, new Item(1L, "Item 1"), 1, new Usuario(1L, "Usuario 1", "usuario1")));
        ordens.add(new Ordem(1L, dataHoraAtual, new Item(2L, "Item2"), 2, new Usuario(2L, "Usuario 2", "usuario2")));
        when(ordemService.findAll()).thenReturn(ordens);

        List<Ordem> result = ordemController.findAll();

        verify(ordemService, times(1)).findAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testFindById() {
        Date dataHoraAtual = new Date();

        Ordem ordem = new Ordem(1L, dataHoraAtual, new Item(1L, "Item 1"), 1, new Usuario(1L, "Usuario 1", "usuario1"));
        when(ordemService.findById(1L)).thenReturn(ordem);

        Ordem result = ordemController.findById(1L);

        verify(ordemService, times(1)).findById(1L);
        assertEquals(ordem, result);
    }

    @Test
    public void testSave() {
        Date dataHoraAtual = new Date();

        Ordem ordem = new Ordem(1L, dataHoraAtual, new Item(1L, "Item 1"), 1, new Usuario(1L, "Usuario 1", "usuario1"));
        when(ordemService.save(ordem)).thenReturn(ordem);

        Ordem result = ordemController.save(ordem);

        verify(emailService, times(1)).sendSimpleMessage("teste@gmail.com", "Assunto do e-mail", "Corpo do e-mail");
        verify(ordemService, times(1)).save(ordem);
        assertEquals(ordem, result);
    }

    @Test
    public void testUpdate() {
        Date dataHoraAtual = new Date();

        Ordem ordem = new Ordem(1L, dataHoraAtual, new Item(1L, "Item 1"), 1, new Usuario(1L, "Usuario 1", "usuario1"));
        when(ordemService.save(ordem)).thenReturn(ordem);

        Ordem result = ordemController.update(1L, ordem);

        verify(ordemService, times(1)).save(ordem);
        assertEquals(ordem, result);
    }

    @Test
    public void testDeleteById() {
        ordemController.deleteById(1L);

        verify(ordemService, times(1)).deleteById(1L);
    }
}