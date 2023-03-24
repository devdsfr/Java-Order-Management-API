package com.example.gerenciarpedidos.service;

import com.example.gerenciarpedidos.entity.Item;
import com.example.gerenciarpedidos.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemService.class);

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item save(Item item) {
        LOGGER.info("Item criado com sucesso!");
        return itemRepository.save(item);
    }

    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }
}

