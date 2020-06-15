/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Santiago Morales
 */
public class PedidosDaoTest {
    
    public PedidosDaoTest() {
    
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testRead() {
        PedidosDao instance = new PedidosDao();
        Pedido expResult = instance.read(11051);
        Pedido result = instance.read(11051);
        assertEquals(result.getId(),expResult.getId());
        assertEquals(result.getCliente_id(),expResult.getCliente_id());
        assertEquals(result.getEmpleado_id(),expResult.getEmpleado_id());
        
        Pedido expResult_1 = null;
        Pedido result_1 = instance.read(11100071);
        
        
    }

    @Test
    public void testInsert() {
        PedidosDao instance = new PedidosDao();
        Date fecha1 = new Date(1996-07-21);
        Date fecha2 = new Date(1996-05-15);
        Date fecha3 = new Date(1996-04-21);
        BigDecimal cargo = new BigDecimal (32.3800);
        Pedido pedido = new Pedido(11078, 80, 5, fecha1, fecha2, fecha3, 3, cargo, "test", "test", "test", "test", "test", "test");
        Integer expResult =null;
        Integer result= instance.insert(pedido);
        assertNotEquals(expResult, result);
        
        //error
        Pedido pedido2 = new Pedido(11078, 80, 5, fecha1, fecha2, fecha3, 8, cargo, "test", "test", "test", "test", "test", "test");
        Integer expResult2 =null;
        Integer result2= instance.insert(pedido);
        assertNotEquals(expResult, result);
    }

    @Test
    public void testUpdate() {
        PedidosDao instance = new PedidosDao();
        Date fecha1 = new Date(1996-07-21);
        Date fecha2 = new Date(1996-05-15);
        Date fecha3 = new Date(1996-04-21);
        BigDecimal cargo = new BigDecimal (32.3800);
        Pedido pedido = new Pedido(11078, 80, 5, fecha1, fecha2, fecha3, 3, cargo, "test", "test", "test", "test", "test", "test");
        Integer insert = instance.insert(pedido);
        Integer expected=1;
        Integer resultado= instance.update(pedido);
        assertEquals(expected, resultado);
        
        //error
        Pedido pedido2 = new Pedido(insert, 55, 5, fecha1, fecha2, fecha3, 3, cargo, "test", "test", "test", "test", "test", "test");
        Integer expResult = 0;
        Integer result= instance.update(pedido);
        assertEquals(expResult, result);
        instance.delete(insert);
        
    }
    @Test
    public void testDelete() {
       PedidosDao instance = new PedidosDao();
       Date fecha1 = new Date(1996-07-21);
       Date fecha2 = new Date(1996-05-15);
       Date fecha3 = new Date(1996-04-21);
       BigDecimal cargo = new BigDecimal (32.3800);
       Pedido pedido = new Pedido(11079,58,6,fecha1, fecha2, fecha3, 3, cargo,"test", "test", "test", "test", "test", "test");
       Integer resultinsert = instance.insert(pedido);
       Integer expResult = 1;
       Integer result = instance.delete(resultinsert);
       assertEquals(expResult, result);
       
       //fallo
       Integer resultado2 = instance.delete(5000);
       Integer expResult2 = 0;
       assertEquals(expResult2, resultado2);
    }

    @Test
    public void testListar() {
        PedidosDao instance = new PedidosDao();
        Integer pos =1;
        ArrayList<Pedido> expResult = null;
        ArrayList<Pedido> result = instance.listar(pos);
        assertEquals(expResult,result);
                
    }

    /**
     * Test of getConexion method, of class PedidosDao.
     */
    @Test
    public void testGetConexion() {
        PedidosDao instance = new PedidosDao();
        Connection expResult = null;
        Connection result = instance.getConexion();
        assertEquals(expResult, result);
    }
}
