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
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

/**
 * @author $Author$
 * @version $Revision$, $Date$
 * 
 */
@Entity
public class List {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Key id;
   private String name;
   private Date addedOn = new Date();
   @OneToMany(mappedBy = "list", cascade = { CascadeType.MERGE, CascadeType.PERSIST })
   private java.util.List<ListItem> items;

   public Key getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Date getAddedOn() {
      return addedOn;
   }

   public java.util.List<ListItem> getItems() {
      return items;
   }

   public void setItems(java.util.List<ListItem> items) {
      this.items = items;
   }

   public boolean addItem(ListItem listItem) {
      if (items != null) {
         return items.add(listItem);
      } else {
         return false;
      }
   }

   public List() {}

   public List(String name) {
      super();
      this.name = name;
   }

   @Override
   public String toString() {
      return "List [id=" + id + ", name=" + name + ", addedOn=" + addedOn + "]";
   }
}
