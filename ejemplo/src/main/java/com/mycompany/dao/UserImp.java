/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.modelo.User;
import java.util.List;

/**
 *
 * @author jmartinezlo
 */
public interface UserImp {
    void nueva(User user);
    Boolean existe(User user);
}
