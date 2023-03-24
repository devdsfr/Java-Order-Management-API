package com.example.gerenciarpedidos.controller;

import com.example.gerenciarpedidos.entity.Item;
import com.example.gerenciarpedidos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable Long id) {
        return itemService.findById(id);
    }

    @PostMapping
    public Item save(@RequestBody Item item) {
        return itemService.save(item);
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable Long id, @RequestBody Item item) {
        item.setId(id);
        return itemService.save(item);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        itemService.deleteById(id);
    }
}
