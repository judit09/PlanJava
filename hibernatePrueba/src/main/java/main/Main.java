/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import beans.Persona;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateHook;
import util.HibernateUtil;

/**
 *
 * @author jmartinezlo
 */
public class Main {

    private SessionFactory sessionFactory;

    public static void main(String[] args) {
        Main main = new Main();
        main.inicializarHibernate();
        Persona p = new Persona("Anais");

        Session s = main.sessionFactory.getCurrentSession();
        s.getTransaction().begin();
        s.persist(p);
        s.getTransaction().commit();
        
    }

    private void inicializarHibernate() {
        Runtime.getRuntime().addShutdownHook(new HibernateHook());
        sessionFactory = HibernateUtil.getSessionFactory();
    }

}
