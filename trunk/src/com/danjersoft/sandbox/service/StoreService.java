package com.danjersoft.sandbox.service;

import java.util.List;

import com.danjersoft.sandbox.dao.StoreDao;
import com.danjersoft.sandbox.dao.jpa.StoreDaoImpl;
import com.danjersoft.sandbox.model.Store;

public class StoreService {
   private StoreDao storeDao;

   public StoreService() {
      storeDao = new StoreDaoImpl();
   }

   public List<Store> getStores() {
      return storeDao.getAllStores();
   }

   public void addStore(Store store) {
      storeDao.addStore(store);
   }

}
