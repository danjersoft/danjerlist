package com.danjersoft.sandbox.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Store {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Key key;
   private String name;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Key getId() {
      return key;
   }

   public Store() {}

   public Store(String name) {
      super();
      this.name = name;
   }

}
