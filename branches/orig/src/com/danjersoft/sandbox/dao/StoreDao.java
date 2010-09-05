package com.danjersoft.sandbox.dao;

import java.util.List;

import com.danjersoft.sandbox.model.Store;

public interface StoreDao {
   List<Store> getAllStores();

   void addStore(Store store);
}
