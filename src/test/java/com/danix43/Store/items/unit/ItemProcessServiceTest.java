package com.danix43.Store.items.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.danix43.Store.item.dto.ItemDTO;
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
        List<ItemDTO> items = itemService.getAllItems();

        assertEquals(0, items.size(), "Expected no items in the list");
    }

    @Test
    void testGetItemByIdWhenItemDoesNotExist() {
        Long nonExistentId = 999L;
        var item = itemService.getItemById(nonExistentId);

        assertEquals(false, item.isPresent(), "Expected no item to be found for the given ID");
    }

    // items exist in the repo
    @Test
    void testGetItemByIdWhenItemExists() {
        long id = 1L;

        Optional<ItemDTO> optionalItem = Optional.of(new ItemDTO("Test Item", "Test Item Description", 10.0, 5));

        when(itemService.getItemById(id)).thenReturn((optionalItem));

        Optional<ItemDTO> gottenItem = itemService.getItemById(id);

        assertEquals(true, gottenItem.isPresent(), "Expected an item to be found for the given ID");
    }

    @Test
    void testGetItemByNameWhenItemExists() {
        String name = "Test Item";

        Optional<ItemDTO> optionalItem = Optional.of(new ItemDTO(name, "Test Item Description", 10.0, 5));

        when(itemService.getItemByName(name)).thenReturn((optionalItem));

        Optional<ItemDTO> gottenItem = itemService.getItemByName(name);

        assertEquals(true, gottenItem.isPresent(), "Expected an item to be found for the given Name");
    }

}
