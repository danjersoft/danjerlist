package com.danjersoft.sandbox.service;

import java.util.List;

import com.danjersoft.sandbox.dao.ListDao;
import com.danjersoft.sandbox.dao.jpa.ItemDaoImpl;
import com.danjersoft.sandbox.dao.jpa.ListDaoImpl;
import com.danjersoft.sandbox.model.Item;
import com.danjersoft.sandbox.model.ListItem;

public class ListService {
   private ListDao listDao;

   public ListService() {
      listDao = new ListDaoImpl();
   }

   public List<com.danjersoft.sandbox.model.List> getLists() {
      return listDao.getAllLists();
   }

   public void addList(com.danjersoft.sandbox.model.List list) {
      listDao.addList(list);
   }

   public void deleteListById(Long listId) {
      listDao.delete(listId);
   }

   public com.danjersoft.sandbox.model.List getListById(Long listId) {
      return listDao.getById(listId);
   }

   public List<Item> getAllItems() {
      return new ItemDaoImpl().getAllItems();
   }

   public List<ListItem> getItemsForList(com.danjersoft.sandbox.model.List list) {
      // TODO Auto-generated method stub
      return null;
   }

   public Object getAvailableItems() {
      return new ItemDaoImpl().getAllItems();
   }

}
