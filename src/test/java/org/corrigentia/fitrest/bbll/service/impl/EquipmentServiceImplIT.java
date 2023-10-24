/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.corrigentia.fitrest.bbll.service.impl;

import org.corrigentia.fitrest.adal.domain.entity.EquipmentEntity;
import org.corrigentia.fitrest.adal.exceptions.EquipmentNullException;
import org.corrigentia.fitrest.bbll.service.EquipmentService;
import org.junit.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author gr.costache
 */
public class EquipmentServiceImplIT {

    private static final Logger LOG = Logger.getLogger(EquipmentServiceImplIT.class.getName());
    private EquipmentService instance;

    public EquipmentServiceImplIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new EquipmentServiceImpl(new EquipmentRepositoryImpl());
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class EquipmentServiceImpl.
     */
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerException() {
        System.out.println("insert");
        EquipmentEntity entity = null;
        EquipmentServiceImpl instance = null;
        EquipmentEntity expResult = null;
        EquipmentEntity result = instance.insert(entity);
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class EquipmentServiceImpl.
     */
    @Test(expected = EquipmentNullException.class)
    public void shouldThrowNullEquipment() {
        System.out.println("insert");
        EquipmentEntity entity = null;
//        EquipmentServiceImpl instance = null;
        EquipmentEntity expResult = null;
        EquipmentEntity result = instance.insert(entity);
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class EquipmentServiceImpl.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        EquipmentEntity entity = new EquipmentEntity("some name", 12.2345);
//        EquipmentServiceImpl instance = null;
//        EquipmentEntity expResult = null;
        EquipmentEntity result = instance.insert(entity);
//        assertEquals(expResult, result);
        assertEquals(entity.getName(), result.getName());
        assertEquals(entity.getPrice(), result.getPrice(), 0);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getByName method, of class EquipmentServiceImpl.
     */
    @Test
    public void testGetByName() {
        System.out.println("getByName");
        String name = "just for insert";
        EquipmentEntity insertedEntity = instance.insert(new EquipmentEntity(name, 12.3456));
//        EquipmentServiceImpl instance = null;
        List<EquipmentEntity> expResult = List.of(insertedEntity);
        List<EquipmentEntity> result = instance.getByName(name);
        assertEquals(expResult, result
        );
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getByName method, of class EquipmentServiceImpl.
     */
    @Test(expected = AssertionError.class)
    public void testGetByNameNone() {
        System.out.println("getByName");
        String name = "";
//        EquipmentServiceImpl instance = null;
        List<EquipmentEntity> expResult = List.of();
        List<EquipmentEntity> result = instance.getByName(name);
        assertEquals(expResult, result
        );
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByName method, of class EquipmentServiceImpl.
     */
    @Test(expected = AssertionError.class)
    public void testGetByNameFail() {
        System.out.println("getByName");
        String name = "";
//        EquipmentServiceImpl instance = null;
        List<EquipmentEntity> expResult = null;
        List<EquipmentEntity> result = instance.getByName(name);
        assertEquals(expResult, result
        );
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByPrice method, of class EquipmentServiceImpl.
     */
    @Test
    public void testGetByPrice() {
        System.out.println("getByPrice");
        double price = 0.0;
//        EquipmentServiceImpl instance = null;
        List<EquipmentEntity> expResult = null;
        List<EquipmentEntity> result = instance.getByPrice(price);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByEnabledTrue method, of class EquipmentServiceImpl.
     */
    @Test
    public void testFindByEnabledTrue_3args() {
        System.out.println("findByEnabledTrue");
        int page = 0;
        int size = 0;
        Sort sort = null;
//        EquipmentServiceImpl instance = null;
        Page<EquipmentEntity> expResult = null;
        Page<EquipmentEntity> result = instance.findByEnabledTrue(page, size, sort);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByEnabledTrue method, of class EquipmentServiceImpl.
     */
    @Test
    public void testFindByEnabledTrue_int_int() {
        System.out.println("findByEnabledTrue");
        int page = 0;
        int size = 0;
//        EquipmentServiceImpl instance = null;
        Page<EquipmentEntity> expResult = null;
        Page<EquipmentEntity> result = instance.findByEnabledTrue(page, size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findOneById method, of class EquipmentServiceImpl.
     */
    @Test
    public void testFindOneById() {
        System.out.println("findOneById");
        long id = 0L;
//        EquipmentServiceImpl instance = null;
        Optional<EquipmentEntity> expResult = null;
        Optional<EquipmentEntity> result = instance.findOneById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class EquipmentServiceImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        long id = 0L;
        EquipmentEntity entity = null;
//        EquipmentServiceImpl instance = null;
        EquipmentEntity expResult = null;
        EquipmentEntity result = instance.update(id, entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class EquipmentServiceImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        long id = 0L;
//        EquipmentServiceImpl instance = null;
        EquipmentEntity expResult = null;
        EquipmentEntity result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findEquipmentByName method, of class EquipmentServiceImpl.
     */
    @Test
    public void testFindEquipmentByName() {
        System.out.println("findEquipmentByName");
        String name = "";
//        EquipmentServiceImpl instance = null;
        EquipmentEntity expResult = null;
        EquipmentEntity result = instance.findEquipmentByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
