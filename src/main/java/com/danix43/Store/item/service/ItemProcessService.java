package com.danix43.Store.item.service;

import java.util.List;
import java.util.Optional;

import com.danix43.Store.item.dto.ItemDTO;

public interface ItemProcessService {

    public List<ItemDTO> getAllItems();

    public Optional<ItemDTO> getItemById(Long id);

    public Optional<ItemDTO> getItemByName(String name);

    public ItemDTO saveNewItem(ItemDTO newItem);

    public String bulkSaveNewItems(List<ItemDTO> newItems);
}
