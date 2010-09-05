package com.danjersoft.sandbox.util;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

public class PMF {
   private static final PersistenceManagerFactory instance = JDOHelper
         .getPersistenceManagerFactory("transactions-optional");

   public static PersistenceManager getPersistenceManager() {
      return instance.getPersistenceManager();
   }

   private PMF() {}
}
