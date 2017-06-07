/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;


/**
 *
 * @author jmartinezlo
 */
public abstract class FactoriaUserDAO {
    private static final UserImp DAO = new UserDAO();
    public static UserImp get(){
        return DAO;
    }
}
