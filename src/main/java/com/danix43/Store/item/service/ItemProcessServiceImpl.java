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
    public ItemDTO saveNewItem(ItemDTO newItem) {
        logger.info("saved a new item entity: {}", newItem);

        Item item = modelMapper.map(newItem, Item.class);
        item.setId(null);

        itemRepository.save(item);

        return newItem;
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
    public Optional<ItemDTO> getItemByName(String name) {
        Optional<Item> foundItem = itemRepository.findByName(name);

        if (foundItem.isPresent()) {
            ItemDTO itemDTO = modelMapper.map(foundItem.get(), ItemDTO.class);
            return Optional.of(itemDTO);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ItemDTO> getItemById(Long id) {
        Optional<Item> foundItem = itemRepository.findById(id);

        if (foundItem.isPresent()) {
            ItemDTO itemDTO = modelMapper.map(foundItem.get(), ItemDTO.class);
            return Optional.of(itemDTO);
        } else {
            return Optional.empty();
        }
    }

}
