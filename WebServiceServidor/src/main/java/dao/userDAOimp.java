/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Usuario;

/**
 *
 * @author jmartinezlo
 */
@Stateless
public class userDAOimp {

    @PersistenceContext(unitName = "PersistenceJPA")
    private EntityManager em;

    public Usuario newUser(Usuario user) {
        em.persist(user);
        return user;
    }

    public Usuario autentificarUser(Usuario user) {
        try {
            String q = "SELECT u FROM Usuario u WHERE u.username = :username AND u.password = :password";
            TypedQuery<Usuario> query = em.createQuery(q, Usuario.class);
            query.setParameter("username", user.getUsername());
            query.setParameter("password", user.getPassword());
            return query.getSingleResult();
        } catch (Exception e) {
            Usuario u = new Usuario("No existe", "No existe");
            u.setId(0L);
            return u;
        }

    }

}
