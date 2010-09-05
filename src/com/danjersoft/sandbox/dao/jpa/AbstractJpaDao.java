package com.danjersoft.sandbox.dao.jpa;

import javax.persistence.EntityManagerFactory;

import com.danjersoft.sandbox.util.EMF;

public abstract class AbstractJpaDao {
   protected EntityManagerFactory emf;

   public AbstractJpaDao() {
      emf = EMF.getEMF();
   }
}
