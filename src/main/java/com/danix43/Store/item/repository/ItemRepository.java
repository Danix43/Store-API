package com.danix43.Store.item.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.danix43.Store.item.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

    public Optional<Item> findByName(String name);

}
