/**
 * 
 */
package com.danjersoft.list.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

/**
 * @author $Author$
 * @version $Revision$, $Date$
 * 
 */
@Entity
public class Item {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Key id;
   private String name;

   public Item() {}

   public Item(String name) {
      this.name = name;
   }

   public Key getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name.toLowerCase();
   }

   @Override
   public String toString() {
      return "Item [id=" + id + ", name=" + name + "]";
   }
}
