package com.danix43.Store.item.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danix43.Store.item.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

    public Optional<Item> findByName(String name);

    public Optional<Item> findBySku(String sku);

}
