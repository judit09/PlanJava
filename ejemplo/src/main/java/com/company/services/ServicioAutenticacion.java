/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.services;

import com.mycompany.modelo.User;

/**
 *
 * @author jmartinezlo
 */
public interface ServicioAutenticacion {
    boolean autentificar (final User user);
    
}
