package com.danjersoft.sandbox.service;

import java.util.List;

import com.danjersoft.sandbox.dao.ListDao;
import com.danjersoft.sandbox.dao.jpa.ListDaoImpl;

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

}
