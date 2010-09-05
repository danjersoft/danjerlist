package com.danjersoft.sandbox.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import com.danjersoft.sandbox.dao.StoreDao;
import com.danjersoft.sandbox.model.Store;

public class StoreDaoImpl extends AbstractJpaDao implements StoreDao {

   @SuppressWarnings("unchecked")
   @Override
   public List<Store> getAllStores() {
      EntityManager em = emf.createEntityManager();
      try {
         em.getTransaction().begin();
         List<Store> stores = em.createQuery("select from " + Store.class.getName() + " order by name").getResultList();
         em.getTransaction().commit();
         return stores;
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }

   @Override
   public void addStore(Store store) {
      EntityManager em = emf.createEntityManager();
      try {
         // em.getTransaction().begin();
         em.persist(store);
         // em.getTransaction().commit();
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }

}
