/**
 * 
 */
package com.danjersoft.list.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.directwebremoting.util.Logger;

import com.danjersoft.list.dao.ItemDao;
import com.danjersoft.list.model.Item;
import com.danjersoft.list.model.List;
import com.danjersoft.list.model.ListItem;
import com.danjersoft.list.util.EMF;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * @author $Author$
 * @version $Revision$, $Date$
 * 
 */
public class ListService {
   private static final Logger log = Logger.getLogger(ListService.class);
   private EntityManagerFactory emf;

   public ListService() {
      emf = EMF.get();
   }

   public java.util.List<List> getAllLists() {
      EntityManager em = emf.createEntityManager();
      try {
         Query q = em.createQuery("select from com.danjersoft.list.model.List order by addedOn");
         @SuppressWarnings("unchecked") java.util.List<List> lists = (java.util.List<List>) q.getResultList();
         log.debug("Total lists: " + lists.size());
         return lists;
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }

   public java.util.List<Item> getAllItems() {
      EntityManager em = emf.createEntityManager();
      try {
         java.util.List<Item> items = new ItemDao(em).getAll();
         log.debug("Total items: " + items.size());
         return items;
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }

   public List addList(List list) {
      EntityManager em = emf.createEntityManager();
      try {
         em.persist(list);
         return list;
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }

   public void deleteListById(long listId) {
      EntityManager em = emf.createEntityManager();
      try {
         // load list from id
         Key key = KeyFactory.createKey(List.class.getSimpleName(), listId);
         List list = em.find(List.class, key);
         // delete list if one is found
         if (list != null) {
            em.remove(list);
         }
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }

   public java.util.List<ListItem> getListItems(List list) {
      EntityManager em = emf.createEntityManager();
      try {
         Query q = em.createQuery("select from ListItem where list = :list order by inTheCart, addedOn");
         q.setParameter("list", list);
         @SuppressWarnings("unchecked") java.util.List<ListItem> listItems = q.getResultList();
         log.debug("total items in list: " + listItems.size());
         return listItems;
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }

   public Item getItemByName(String itemName) {
      log.debug("Getting item with name: " + itemName);
      EntityManager em = emf.createEntityManager();
      Item item = null;
      try {
         item = new ItemDao(em).getItemByName(itemName);
      } finally {
         if (em != null) {
            em.close();
         }
      }
      return item;
   }

   public List getListById(long listId) {
      Key key = KeyFactory.createKey(List.class.getSimpleName(), listId);
      EntityManager em = emf.createEntityManager();
      try {
         return em.find(List.class, key);
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }

   public void addItemToList(ListItem listItem) {
      EntityManager em = emf.createEntityManager();
      try {
         em.persist(listItem);
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }

   public void saveList(List list) {
      EntityManager em = emf.createEntityManager();
      try {
         em.merge(list);
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }
}
