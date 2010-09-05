package com.danjersoft.sandbox.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Item {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Key key;
   private String name;
   private String shortcuts;

   /**
    * @return the name
    */
   public String getName() {
      return name;
   }

   /**
    * @param name
    *           the name to set
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * @return the shortcuts
    */
   public String getShortcuts() {
      return shortcuts;
   }

   /**
    * @param shortcuts
    *           the shortcuts to set
    */
   public void setShortcuts(String shortcuts) {
      this.shortcuts = shortcuts;
   }

   /**
    * @return the key
    */
   public Key getKey() {
      return key;
   }

   public Item() {}

   public Item(String name, String shortcuts) {
      super();
      this.name = name;
      this.shortcuts = shortcuts;
   }

}
