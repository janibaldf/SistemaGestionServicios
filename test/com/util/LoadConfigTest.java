/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.model.dto.ConfigBean;
import java.io.InputStream;
import java.util.Properties;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoadConfigTest {


    @Test
    public void testGetConfiguration() {
        System.out.println("getConfiguration");
        LoadConfig instance = LoadConfig.getInstance();
        ConfigBean expResult = null;
        ConfigBean result = instance.getConfiguration();    
        assertNotNull(result);
    }
    
}
