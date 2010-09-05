package com.danjersoft.sandbox.dao;

import java.util.List;

import com.danjersoft.sandbox.model.Item;

public interface ItemDao {
   void addItem(Item item);

   List<Item> getAllItems();
}
