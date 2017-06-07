/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.mycompany.dao.FactoriaUserDAO;
import com.mycompany.dao.UserImp;
import com.mycompany.modelo.User;
import java.util.Scanner;

/**
 *
 * @author jmartinezlo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserImp u = FactoriaUserDAO.get();
        Scanner scn = new Scanner(System.in);
        System.out.print("Inserta username: ");
        String username = scn.nextLine();
        System.out.print("Inserta password: ");
        String password = scn.nextLine();
        User user = new User(username, password);
        u.nueva(user);
        

    }

}
