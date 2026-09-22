package com.danix43.Store.item.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.danix43.Store.item.dto.ItemDTO;
import com.danix43.Store.item.model.Item;
import com.danix43.Store.item.repository.ItemRepository;

@Service
public class ItemProcessServiceImpl implements ItemProcessService {

    Logger logger = LoggerFactory.getLogger(ItemProcessServiceImpl.class);

    private final ModelMapper modelMapper;

    private final ItemRepository itemRepository;

    public ItemProcessServiceImpl(ItemRepository itmRepo) {
        this.itemRepository = itmRepo;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Item saveNewItem(Item newItem) {
        logger.info("saved a new item entity: {}", newItem);
        newItem.setId(null);
        return itemRepository.save(newItem);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> results = new ArrayList<>();
        itemRepository.findAll().forEach(results::add);

        List<ItemDTO> itemDTOs = new ArrayList<>();
        for (Item item : results) {
            ItemDTO itemDTO = modelMapper.map(item, ItemDTO.class);
            itemDTOs.add(itemDTO);
        }

        return itemDTOs;
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
