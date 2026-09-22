package com.danix43.Store.item.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.danix43.Store.item.dto.ItemDTO;
import com.danix43.Store.item.model.Item;
import com.danix43.Store.item.repository.ItemRepository;

@Service
public class ItemProcessServiceImpl implements ItemProcessService {

    Logger logger = LoggerFactory.getLogger(ItemProcessServiceImpl.class);

    private final ItemRepository itemRepository;

    public ItemProcessServiceImpl(ItemRepository itmRepo) {
        this.itemRepository = itmRepo;
    }

    @Override
    public ItemDTO saveNewItem(ItemDTO item) {
        return new ItemDTO();
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> results = new ArrayList<>();
        itemRepository.findAll().forEach(results::add);

        logger.error("Found {} items in the database", results.size());

        return results;
    }

    @Override
    public Optional<Item> getItemByName(String name) {
        return itemRepository.findByName(name);
    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

}
