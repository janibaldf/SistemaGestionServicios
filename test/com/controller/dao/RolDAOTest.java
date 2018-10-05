/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.dao;

import com.model.dto.eRol;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class RolDAOTest {
    
    public RolDAOTest() {
    }

    /**
     * Test of selectOne method, of class RolDAO.
     */
    @Test
    public void testSelectOne() {
        System.out.println("selectOne");
        int id = 0;
        RolDAO instance = new RolDAO();
        eRol expResult = null;
        eRol result = instance.selectOne(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectAll method, of class RolDAO.
     */
    @Test
    public void testSelectAll() {
        System.out.println("selectAll");
        RolDAO instance = new RolDAO();
        List<eRol> expResult = null;
        List<eRol> result = instance.selectAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class RolDAO.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        eRol element = null;
        RolDAO instance = new RolDAO();
        boolean expResult = false;
        boolean result = instance.add(element);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class RolDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        RolDAO instance = new RolDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class RolDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        eRol elemen = null;
        RolDAO instance = new RolDAO();
        boolean expResult = false;
        boolean result = instance.update(elemen);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateAll method, of class RolDAO.
     */
    @Test
    public void testUpdateAll() {
        System.out.println("updateAll");
        int id = 0;
        RolDAO instance = new RolDAO();
        boolean expResult = false;
        boolean result = instance.updateAll(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
