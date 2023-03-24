package com.example.gerenciarpedidos.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.gerenciarpedidos.entity.Usuario;
import com.example.gerenciarpedidos.service.UsuarioService;

@SpringBootTest
public class UsuarioControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @Test
    public void testFindAll() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1L, "John", "email"));
        usuarios.add(new Usuario(2L, "Jane", "email"));
        when(usuarioService.findAll()).thenReturn(usuarios);

        List<Usuario> result = usuarioController.findAll();

        verify(usuarioService, times(1)).findAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testFindById() {
        Usuario usuario = new Usuario(1L, "John", "email");
        when(usuarioService.findById(1L)).thenReturn(Optional.of(usuario));

        Optional<Usuario> result = usuarioController.findById(1L);

        verify(usuarioService, times(1)).findById(1L);
        assertTrue(result.isPresent());
        assertEquals("John", result.get().getNome());
        assertEquals("email", result.get().getEmail());
    }

    @Test
    public void testSave() {
        Usuario usuario = new Usuario(1L, "John", "email");
        when(usuarioService.save(usuario)).thenReturn(usuario);

        Usuario result = usuarioController.save(usuario);

        verify(usuarioService, times(1)).save(usuario);
        assertEquals("John", result.getNome());
        assertEquals("email", result.getEmail());
    }

    @Test
    public void testDeleteById() {
        usuarioController.deleteById(1L);

        verify(usuarioService, times(1)).deleteById(1L);
    }
}