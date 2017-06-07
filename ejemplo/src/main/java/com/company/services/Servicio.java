/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.services;

import com.mycompany.dao.FactoriaUserDAO;
import com.mycompany.dao.UserImp;
import com.mycompany.modelo.User;

/**
 *
 * @author jmartinezlo
 */
class Servicio implements ServicioAutenticacion{

    @Override
    public boolean autentificar(User user) {
    return true;        
    }
    
}
