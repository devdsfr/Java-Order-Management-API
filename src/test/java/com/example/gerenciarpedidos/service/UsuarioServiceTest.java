package com.example.gerenciarpedidos.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import com.example.gerenciarpedidos.entity.Usuario;
import com.example.gerenciarpedidos.repository.UsuarioRepository;
import com.example.gerenciarpedidos.service.UsuarioService;

public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private Logger logger;

    @InjectMocks
    private UsuarioService usuarioService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1L, "usuario1", "email1"));
        usuarios.add(new Usuario(2L, "usuario2", "email2"));
        when(usuarioRepository.findAll()).thenReturn(usuarios);

        List<Usuario> result = usuarioService.findAll();

        assertEquals(2, result.size());
        assertEquals("usuario1", result.get(0).getNome());
    }

    @Test
    public void testFindById() {
        Usuario usuario = new Usuario(1L, "usuario1", "email");
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Optional<Usuario> result = usuarioService.findById(1L);

        assertEquals("usuario1", result.get().getNome());
        assertEquals("email", result.get().getEmail());
    }

    @Test
    public void testSave() {
        Usuario usuario = new Usuario(1L, "usuario1", "email");
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario result = usuarioService.save(usuario);

        assertEquals("usuario1", result.getNome());
        assertEquals("email", result.getEmail());

    }

    @Test
    public void testDeleteById() {
        usuarioService.deleteById(1L);

        // verify that the deleteById method of the repository was called once with the correct argument
        verify(usuarioRepository, times(1)).deleteById(1L);
    }
}