package com.danjersoft.sandbox.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
   private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("transactions-optional");

   private EMF() {}

   public static final EntityManager getEM() {
      return emf.createEntityManager();
   }

   public static final EntityManagerFactory getEMF() {
      return emf;
   }
}
