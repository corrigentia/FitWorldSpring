/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.corrigentia.fitrest.bbll.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.corrigentia.fitrest.adal.domain.entity.MartialArtEntity;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

/**
 *
 * @author gr.costache
 */
public class MartialArtServiceImplIT {

    private static final Logger LOG = Logger.getLogger(MartialArtServiceImplIT.class.getName());

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    public MartialArtServiceImplIT() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByNameContainsIgnoreCase method, of class
     * MartialArtServiceImpl.
     */
    @Test
    public void testFindByNameContainsIgnoreCase() {
        System.out.println("findByNameContainsIgnoreCase");
        String name = "";
        MartialArtServiceImpl instance = null;
        List<MartialArtEntity> expResult = null;
        List<MartialArtEntity> result = instance.findByNameContainsIgnoreCase(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByEnabledTrue method, of class MartialArtServiceImpl.
     */
    @Test
    public void testFindByEnabledTrue_int_int() {
        System.out.println("findByEnabledTrue");
        int page = 0;
        int size = 0;
        MartialArtServiceImpl instance = null;
        Page<MartialArtEntity> expResult = null;
        Page<MartialArtEntity> result = instance.findByEnabledTrue(page, size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByEnabledTrue method, of class MartialArtServiceImpl.
     */
    @Test
    public void testFindByEnabledTrue_3args() {
        System.out.println("findByEnabledTrue");
        int page = 0;
        int size = 0;
        Sort sort = null;
        MartialArtServiceImpl instance = null;
        Page<MartialArtEntity> expResult = null;
        Page<MartialArtEntity> result = instance.findByEnabledTrue(page, size, sort);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findOneById method, of class MartialArtServiceImpl.
     */
    @Test
    public void testFindOneById() {
        System.out.println("findOneById");
        long id = 0L;
        MartialArtServiceImpl instance = null;
        Optional<MartialArtEntity> expResult = null;
        Optional<MartialArtEntity> result = instance.findOneById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class MartialArtServiceImpl.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        MartialArtEntity entity = null;
        MartialArtServiceImpl instance = null;
        MartialArtEntity expResult = null;
        MartialArtEntity result = instance.insert(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class MartialArtServiceImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        long id = 0L;
        MartialArtEntity entity = null;
        MartialArtServiceImpl instance = null;
        MartialArtEntity expResult = null;
        MartialArtEntity result = instance.update(id, entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MartialArtServiceImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        long id = 0L;
        MartialArtServiceImpl instance = null;
        MartialArtEntity expResult = null;
        MartialArtEntity result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
