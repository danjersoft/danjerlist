/**
 * 
 */
package com.danjersoft.list.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author $Author$
 * @version $Revision$, $Date$
 * 
 */
public class EMF {
   private static final EntityManagerFactory emfInstance = Persistence
         .createEntityManagerFactory("transactions-optional");

   private EMF() {}

   public static EntityManagerFactory get() {
      return emfInstance;
   }
}
