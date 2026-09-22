package com.danix43.Store.item.service;

import java.util.List;
import java.util.Optional;

import com.danix43.Store.item.dto.ItemDTO;
import com.danix43.Store.item.model.Item;

public interface ItemProcessService {

    public List<ItemDTO> getAllItems();

    public Optional<Item> getItemById(Long id);

    public Optional<Item> getItemByName(String name);

    public Item saveNewItem(Item newItem);

}
