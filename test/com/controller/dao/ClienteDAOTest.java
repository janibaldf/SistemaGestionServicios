/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.dao;

import com.model.dto.eCliente;
import java.math.BigDecimal;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
    }

    /**
     * Test of selectOne method, of class ClienteDAO.
     */
    @Test
    public void testSelectOne() {
        System.out.println("selectOne");
        int id = 3;
        ClienteDAO instance = new ClienteDAO();
        eCliente expResult = null;
        eCliente result = instance.selectOne(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectAll method, of class ClienteDAO.
     */
    //@Test
    public void testSelectAll() {
        System.out.println("selectAll");
        ClienteDAO instance = new ClienteDAO();
        List<eCliente> expResult = null;
        List<eCliente> result = instance.selectAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class ClienteDAO.
     */
   //  @Test
    public void testAdd() {
        System.out.println("add");
        eCliente c = null;
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = false;
        boolean result = instance.add(c);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ClienteDAO.
     */
   //  @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSaldo method, of class ClienteDAO.
     */
   //  @Test
    public void testUpdateSaldo() {
        System.out.println("updateSaldo");
        int codigoCliente = 0;
        BigDecimal nuevoSaldo = null;
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = false;
        boolean result = instance.updateSaldo(codigoCliente, nuevoSaldo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ClienteDAO.
     */
   //  @Test
    public void testUpdate() {
        System.out.println("update");
        eCliente c = null;
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = false;
        boolean result = instance.update(c);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateAll method, of class ClienteDAO.
     */
   // @Test
    public void testUpdateAll() {
        System.out.println("updateAll");
        int id = 0;
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = false;
        boolean result = instance.updateAll(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
