/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.userDAOimp;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Usuario;

/**
 *
 * @author jmartinezlo
 */
@WebService(serviceName = "SOAP")
public class SOAP {

    @EJB
    private userDAOimp userDAOimp;
    
    @WebMethod(operationName = "nuevoUser")
    public Usuario nuevoUser(@WebParam(name = "username") final String username, @WebParam(name = "password") final String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return new Usuario();
        } else {
            Usuario u = new Usuario(username, password);
            return userDAOimp.newUser(u);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "autentificar")
    public Usuario autentificar(@WebParam(name = "username") final String username, @WebParam(name = "password") final String password) {
        Usuario user = new Usuario(username, password);
        return userDAOimp.autentificarUser(user);
    }
    
    
    

}
