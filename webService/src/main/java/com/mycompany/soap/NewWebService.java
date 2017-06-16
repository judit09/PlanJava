/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soap;

import com.mycompany.model.Personas;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jmartinezlo
 */
@WebService(serviceName = "NewWebService")
@Stateless
public class NewWebService {

    @PersistenceContext
    private EntityManager em;

    /**
     * This is a sample web service operation
     */
    public String getPersona(@WebParam(name = "name") String id) {
        Personas p = em.find(Personas.class, id);
        return "Persona finded: ID: " + id + " Nombre: " + p.getNombre();
    }

    /**
     * This is a sample web service operation
     */
    public String createPersona(Integer id, String nombre) {
        Personas p = new Personas(id, nombre);
        em.persist(p);
        return "Bien";
    }
}
