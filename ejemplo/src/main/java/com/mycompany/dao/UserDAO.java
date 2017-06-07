/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.modelo.User;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author jmartinezlo
 */
class UserDAO implements UserImp {

    private static List<User> users;

    @Override
    public void nueva(User user) {
        Objects.requireNonNull(user);
        assert Objects.isNull(user.getUsername());
        assert Objects.isNull(user.getPassword());
        
        users.add(user);
    }

    @Override
    public Boolean existe(User user) {
        for (User u : users) {
            if (u == user) {
                return true;
            }
        }
        return false;
    }

}
