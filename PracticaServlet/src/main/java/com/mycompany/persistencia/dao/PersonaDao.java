/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.persistencia.dao;

import com.mycompany.persistencia.modelo.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dpalomar
 */
@Stateless
public class PersonaDao {

    @PersistenceContext(unitName = "Persistence")
    private EntityManager em;

    public void nueva(Persona object) {
        em.persist(object);
    }

    public List<Persona> todas() {
        return em.createQuery("select p from Persona p", Persona.class).getResultList();
    }
}
