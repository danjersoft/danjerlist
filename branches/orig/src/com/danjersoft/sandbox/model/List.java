package com.danjersoft.sandbox.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class List {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Key key;
   private Date startedOn;
   private String name;

   /**
    * @return the startedOn
    */
   public Date getStartedOn() {
      return startedOn;
   }

   /**
    * @param startedOn
    *           the startedOn to set
    */
   public void setStartedOn(Date startedOn) {
      this.startedOn = startedOn;
   }

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
    * @return the key
    */
   public Key getKey() {
      return key;
   }

   public List() {
      super();
      this.startedOn = new Date();
   }

   public List(String name) {
      this();
      this.name = name;
   }

}
