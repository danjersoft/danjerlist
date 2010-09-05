package com.danjersoft.sandbox.dao;

import java.util.List;

public interface ListDao {

   List<com.danjersoft.sandbox.model.List> getAllLists();

   void addList(com.danjersoft.sandbox.model.List list);

   void delete(Long listId);

   com.danjersoft.sandbox.model.List getById(Long listId);

}
