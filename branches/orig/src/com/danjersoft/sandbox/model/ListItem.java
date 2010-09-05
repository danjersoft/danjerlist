package com.danjersoft.sandbox.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class ListItem {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Key key;
   private List list;
   private int quantity;
   private Item item;
   private boolean show;

   /**
    * @return the list
    */
   public List getList() {
      return list;
   }

   /**
    * @param list
    *           the list to set
    */
   public void setList(List list) {
      this.list = list;
   }

   /**
    * @return the quantity
    */
   public int getQuantity() {
      return quantity;
   }

   /**
    * @param quantity
    *           the quantity to set
    */
   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   /**
    * @return the item
    */
   public Item getItem() {
      return item;
   }

   /**
    * @param item
    *           the item to set
    */
   public void setItem(Item item) {
      this.item = item;
   }

   /**
    * @return the key
    */
   public Key getKey() {
      return key;
   }

   /**
    * @return the show
    */
   public boolean isShow() {
      return show;
   }

   /**
    * @param show
    *           the show to set
    */
   public void setShow(boolean show) {
      this.show = show;
   }

   public ListItem() {}

   public ListItem(List list, int quantity, Item item) {
      super();
      this.list = list;
      this.quantity = quantity;
      this.item = item;
   }
}
