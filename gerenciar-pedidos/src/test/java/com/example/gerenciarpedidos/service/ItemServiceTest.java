package com.example.gerenciarpedidos.service;

import com.example.gerenciarpedidos.entity.Item;
import com.example.gerenciarpedidos.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Test
    public void testFindAll() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1L, "Item 1"));
        itemList.add(new Item(2L, "Item 2"));
        when(itemRepository.findAll()).thenReturn(itemList);
        List<Item> result = itemService.findAll();
        assertEquals(itemList, result);
    }

    @Test
    public void testFindById() {
        Item item = new Item(1L, "Item 1");
        when(itemRepository.findById(1L)).thenReturn(Optional.of(item));
        Item result = itemService.findById(1L);
        assertEquals(item, result);
    }

    @Test
    public void testSave() {
        Item item = new Item(1L, "Item 1");
        when(itemRepository.save(item)).thenReturn(item);
        Item result = itemService.save(item);
        assertEquals(item, result);
    }

    @Test
    public void testDeleteById() {
        itemService.deleteById(1L);
        verify(itemRepository, times(1)).deleteById(1L);
    }
}