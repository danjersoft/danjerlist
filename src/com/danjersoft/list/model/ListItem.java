/**
 * 
 */
package com.danjersoft.list.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;

/**
 * @author $Author$
 * @version $Revision$, $Date$
 * 
 */
@Entity
public class ListItem {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Key id;
   @ManyToOne(cascade = { CascadeType.ALL })
   private Item item;
   private Date addedOn = new Date();
   private boolean inTheCart = false;
   @ManyToOne(cascade = { CascadeType.ALL })
   private List list;

   public ListItem() {}

   public ListItem(List list, Item item) {
      this.list = list;
      this.list.addItem(this);
      this.item = item;
   }

   public Item getItem() {
      return item;
   }

   public void setItem(Item item) {
      this.item = item;
   }

   public Date getAddedOn() {
      return addedOn;
   }

   public void setAddedOn(Date addedOn) {
      this.addedOn = addedOn;
   }

   public boolean isInTheCart() {
      return inTheCart;
   }

   public void setInTheCart(boolean inTheCart) {
      this.inTheCart = inTheCart;
   }

   public List getList() {
      return list;
   }

   public void setList(List list) {
      this.list = list;
   }

   public Key getId() {
      return id;
   }

   @Override
   public String toString() {
      return "ListItem [id=" + id + ", item=" + item + ", addedOn=" + addedOn + ", inTheCart=" + inTheCart + ", list="
            + list + "]";
   }

}
