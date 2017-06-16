/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientesoap;

import com.mycompany.clientesoap.ws.NewWebService;
import com.mycompany.clientesoap.ws.NewWebService_Service;

/**
 *
 * @author jmartinezlo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try { // Call Web Service Operation
            NewWebService_Service service = new NewWebService_Service();
            NewWebService port = service.getNewWebServicePort();
            // TODO initialize WS operation arguments here
            java.lang.String name = "jejejejej";
            // TODO process result here
            java.lang.String result = port.hello(name);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

    }
    
}
