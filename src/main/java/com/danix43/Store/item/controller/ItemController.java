package com.danix43.Store.item.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danix43.Store.item.model.Item;
import com.danix43.Store.item.service.ItemProcessService;
import com.danix43.Store.item.service.ItemProcessServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemProcessService itemService;

    public ItemController(ItemProcessServiceImpl itmService) {
        this.itemService = itmService;
    }

    @GetMapping("/all")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/:id")
    public Optional<Item> getItemById(@RequestParam long id) {
        return itemService.getItemById(id);
    }

}
