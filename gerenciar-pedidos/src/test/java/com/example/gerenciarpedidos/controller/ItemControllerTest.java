package com.example.gerenciarpedidos.controller;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.gerenciarpedidos.entity.Item;
import com.example.gerenciarpedidos.service.ItemService;

@SpringBootTest
public class ItemControllerTest {

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    @Test
    public void testFindAll() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1L, "Item 1"));
        itemList.add(new Item(2L, "Item 2"));

        when(itemService.findAll()).thenReturn(itemList);

        List<Item> result = itemController.findAll();

        verify(itemService, times(1)).findAll();
        assertEquals(itemList, result);
    }

    @Test
    public void testFindById() {
        Item item = new Item(1L, "Item 1");

        when(itemService.findById(1L)).thenReturn(item);

        Item result = itemController.findById(1L);

        verify(itemService, times(1)).findById(1L);
        assertEquals(item, result);
    }

    @Test
    public void testSave() {
        Item item = new Item(1L, "Item 1");

        when(itemService.save(item)).thenReturn(item);

        Item result = itemController.save(item);

        verify(itemService, times(1)).save(item);
        assertEquals(item, result);
    }

    @Test
    public void testUpdate() {
        Item item = new Item(1L, "Item 1");

        when(itemService.save(item)).thenReturn(item);

        Item result = itemController.update(1L, item);

        verify(itemService, times(1)).save(item);
        assertEquals(item, result);
    }

    @Test
    public void testDeleteById() {
        itemController.deleteById(1L);

        verify(itemService, times(1)).deleteById(1L);
    }
}