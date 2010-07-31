package com.danjersoft.sandbox.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import com.danjersoft.sandbox.dao.ItemDao;
import com.danjersoft.sandbox.model.Item;

public class ItemDaoImpl extends AbstractJpaDao implements ItemDao {

   /*
    * (non-Javadoc)
    * 
    * @see com.danjersoft.sandbox.dao.ItemDao#addItem(com.danjersoft.sandbox.model.Item)
    */
   @Override
   public void addItem(Item item) {
      EntityManager em = emf.createEntityManager();
      try {
         em.persist(item);
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }

   @SuppressWarnings("unchecked")
   @Override
   public List<Item> getAllItems() {
      EntityManager em = emf.createEntityManager();
      try {
         em.getTransaction().begin();
         List<Item> items = em.createQuery("select from " + Item.class.getName() + " order by name").getResultList();
         em.getTransaction().commit();
         return items;
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }
}
