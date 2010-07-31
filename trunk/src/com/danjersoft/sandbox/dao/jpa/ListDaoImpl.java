package com.danjersoft.sandbox.dao.jpa;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import com.danjersoft.sandbox.dao.ListDao;
import com.google.appengine.api.datastore.KeyFactory;

public class ListDaoImpl extends AbstractJpaDao implements ListDao {
   private static final Logger log = Logger.getLogger(ListDaoImpl.class.getName());

   /*
    * (non-Javadoc)
    * 
    * @see com.danjersoft.sandbox.dao.ListDao#addList(com.danjersoft.sandbox.model.List)
    */
   @Override
   public void addList(com.danjersoft.sandbox.model.List list) {
      EntityManager em = emf.createEntityManager();
      try {
         em.persist(list);
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }

   @SuppressWarnings("unchecked")
   @Override
   public List<com.danjersoft.sandbox.model.List> getAllLists() {
      EntityManager em = emf.createEntityManager();
      try {
         em.getTransaction().begin();
         List<com.danjersoft.sandbox.model.List> lists = em.createQuery(
               "select from " + com.danjersoft.sandbox.model.List.class.getName() + " order by startedOn")
               .getResultList();
         em.getTransaction().commit();
         return lists;
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }

   /*
    * (non-Javadoc)
    * 
    * @see com.danjersoft.sandbox.dao.ListDao#delete(java.lang.Long)
    */
   @Override
   public void delete(Long listId) {
      log.info("about to delete List with ID of '" + listId + "'");
      EntityManager em = emf.createEntityManager();
      try {
         em.getTransaction().begin();
         com.danjersoft.sandbox.model.List listToDelete = em.find(com.danjersoft.sandbox.model.List.class, KeyFactory
               .createKey(com.danjersoft.sandbox.model.List.class.getSimpleName(), listId));
         em.remove(listToDelete);
         em.getTransaction().commit();
      } catch (Exception e) {
         if ((em != null) && (em.getTransaction() != null)) {
            em.getTransaction().rollback();
         }
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }

}
