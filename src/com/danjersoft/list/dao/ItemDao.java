/**
 * 
 */
package com.danjersoft.list.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.danjersoft.list.model.Item;

/**
 * @author $Author$
 * @version $Revision$, $Date$
 * 
 */
public class ItemDao {
   private EntityManager em;

   public ItemDao(EntityManager em) {
      this.em = em;
   }

   public Item getItemByName(String name) {
      @SuppressWarnings("unchecked") List<Item> items = em.createQuery("select from Item where name = :name")
            .setParameter("name", name).getResultList();
      if (items.isEmpty()) {
         return new Item(name);
      } else {
         return items.get(0);
      }
   }

   public void saveItem(Item item) {
      em.persist(item);
   }

   @SuppressWarnings("unchecked")
   public java.util.List<Item> getAll() {
      return em.createQuery("select from Item where name is not null").getResultList();
   }
}
