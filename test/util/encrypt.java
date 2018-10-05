/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.junit.Test;
import static org.junit.Assert.*;
import com.controller.dao.UsuarioDAO;
/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class encrypt {
    
    public encrypt() {
    }
    @Test
    public  void encriptar_test(){
           String nueva;
           UsuarioDAO udato = new UsuarioDAO();
           nueva= udato.encryptPassword("jadf14");
           System.out.print(nueva);
          
     
    }
    
}
