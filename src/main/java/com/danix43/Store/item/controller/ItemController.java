package com.danix43.Store.item.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danix43.Store.item.dto.ItemDTO;
import com.danix43.Store.item.service.ItemProcessService;
import com.danix43.Store.item.service.ItemProcessServiceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final Logger logger = LoggerFactory.getLogger(ItemController.class);

    private final ItemProcessService itemService;

    public ItemController(ItemProcessServiceImpl itmService) {
        this.itemService = itmService;
    }

    @GetMapping("/all")
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/item")
    public Optional<ItemDTO> getItemById(@RequestParam(required = false) Long id,
            @RequestParam(required = false) String name) {
        if (id != null) {
            logger.info("Searching for item with ID: {}", id);
            return itemService.getItemById(id);
        } else if (name != null) {
            logger.info("Searching for item with name: {}", name);
            return itemService.getItemByName(name);
        } else {
            logger.warn("No id or name specified in the url params");
            return Optional.empty();
        }
    }

    @PostMapping("/newItem")
    public ItemDTO postNewItem(@RequestBody ItemDTO entity) {
        return itemService.saveNewItem(entity);
    }

    @PostMapping("/bulkAddItems")
    public ResponseEntity<String> postBulkAddItems(@RequestBody List<ItemDTO> entities) {
        String result = itemService.bulkSaveNewItems(entities);
        return ResponseEntity.ok()
                .body(result);
    }

    // used for testing
    @GetMapping("/testException")
    public ResponseEntity<String> getTestExceptions() {
        return ResponseEntity.badRequest().body("You shouldn't be here");
    }

}
