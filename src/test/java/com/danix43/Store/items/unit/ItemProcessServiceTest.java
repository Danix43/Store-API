package com.danix43.Store.items.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.danix43.Store.item.dto.ItemDTO;
import com.danix43.Store.item.model.Categories;
import com.danix43.Store.item.model.Item;
import com.danix43.Store.item.repository.ItemRepository;
import com.danix43.Store.item.service.ItemProcessServiceImpl;

@ExtendWith(MockitoExtension.class)
class ItemProcessServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemProcessServiceImpl itemService;

    // items do not exist in the repo
    @Test
    void testGetAllItemsWhenNoItemsExist() {
        when(itemRepository.findAll()).thenReturn(Collections.emptyList());

        List<ItemDTO> items = itemService.getAllItems();

        assertEquals(0, items.size(), "Expected no items in the list");
    }

    @Test
    void testGetItemByIdWhenItemDoesNotExist() {
        Long nonExistentId = 999L;
        when(itemRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        var item = itemService.getItemById(nonExistentId);

        assertEquals(false, item.isPresent(), "Expected no item to be found for the given ID");
    }

    // items exist in the repo
    @Test
    void testGetItemByIdWhenItemExists() {
        long id = 1L;

        Item itemEntity = new Item();
        itemEntity.setId(id);
        itemEntity.setName("Test Item");
        itemEntity.setCategory(Categories.CATEGORY1);
        itemEntity.setPrice(10.0);
        itemEntity.setStockQty(5);
        itemEntity.setImageLink("image link");
        itemEntity.setSku("SKU-001");

        when(itemRepository.findById(id)).thenReturn(Optional.of(itemEntity));

        Optional<ItemDTO> gottenItem = itemService.getItemById(id);

        assertEquals(true, gottenItem.isPresent(), "Expected an item to be found for the given ID");
    }

    @Test
    void testGetItemByNameWhenItemExists() {
        String name = "Test Item";

        Item itemEntity = new Item();
        itemEntity.setId(1L);
        itemEntity.setName(name);
        itemEntity.setCategory(Categories.CATEGORY1);
        itemEntity.setPrice(10.0);
        itemEntity.setStockQty(5);
        itemEntity.setImageLink("image link");
        itemEntity.setSku("SKU-001");

        when(itemRepository.findByName(name)).thenReturn(Optional.of(itemEntity));

        Optional<ItemDTO> gottenItem = itemService.getItemByName(name);

        assertEquals(true, gottenItem.isPresent(), "Expected an item to be found for the given Name");
    }

}
