package com.danjersoft.sandbox.service;

import java.util.List;

import com.danjersoft.sandbox.dao.ItemDao;
import com.danjersoft.sandbox.dao.jpa.ItemDaoImpl;
import com.danjersoft.sandbox.model.Item;

public class ItemService {
   private ItemDao itemDao;

   public ItemService() {
      itemDao = new ItemDaoImpl();
   }

   /**
    * @param item
    */
   public void addItem(Item item) {
      itemDao.addItem(item);
   }

   /**
    * @return
    */
   public List<Item> getItems() {
      return itemDao.getAllItems();
   }
}
