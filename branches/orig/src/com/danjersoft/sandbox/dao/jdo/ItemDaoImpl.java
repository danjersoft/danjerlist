package com.danjersoft.sandbox.dao.jdo;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.annotations.Transactional;

import com.danjersoft.sandbox.dao.ItemDao;
import com.danjersoft.sandbox.model.Item;
import com.danjersoft.sandbox.util.PMF;

public class ItemDaoImpl implements ItemDao {

   /*
    * (non-Javadoc)
    * 
    * @see com.danjersoft.sandbox.dao.ItemDao#addItem(com.danjersoft.sandbox.model.Item)
    */
   @Override
   @Transactional
   public void addItem(Item item) {
      PersistenceManager pm = PMF.getPersistenceManager();
      try {
         pm.makePersistent(item);
      } finally {
         if (pm != null) {
            pm.close();
         }
      }
   }

   @SuppressWarnings("unchecked")
   @Override
   /* @Transactional */
   public List<Item> getAllItems() {
      PersistenceManager pm = PMF.getPersistenceManager();
      try {
         String query = "select from " + Item.class.getName() + " order by name";
         return (List<Item>) pm.newQuery(query).execute();
      } finally {
         if (pm != null) {
            pm.close();
         }
      }
   }
}
