/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.corrigentia.fitrest.adal.repo;

import org.corrigentia.fitrest.adal.domain.entity.EquipmentEntity;
import org.corrigentia.fitrest.bbll.service.impl.EquipmentRepositoryImpl;
import org.junit.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author gr.costache
 */
public class EquipmentRepositoryIT {

    private static final Logger LOG = Logger.getLogger(EquipmentRepositoryIT.class.getName());

    public EquipmentRepositoryIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of existsByNameAndPriceAllIgnoreCase method, of class
     * EquipmentRepository.
     */
    @Test
    public void testExistsByNameAndPriceAllIgnoreCaseDefault() {
        System.out.println("existsByNameAndPriceAllIgnoreCase");
        String name = "";
        double price = 0.0;
        EquipmentRepository instance = new EquipmentRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.existsByNameAndPriceAllIgnoreCase(name, price);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of existsByNameAndPriceAllIgnoreCase method, of class
     * EquipmentRepository.
     */
    @Test
    public void testExistsByNameAndPriceAllIgnoreCase() {
        System.out.println("existsByNameAndPriceAllIgnoreCase");
        String name = "some name";
        double price = 12.3456789;
        EquipmentRepository instance = new EquipmentRepositoryImpl();
        instance.save(new EquipmentEntity(name, price));
        boolean expResult = true;
        boolean result = instance.existsByNameAndPriceAllIgnoreCase(name, price);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findFirstByNameAllIgnoreCase method, of class
     * EquipmentRepository.
     */
    @Test
    public void testFindFirstByNameAllIgnoreCaseDefault() {
        System.out.println("findFirstByNameAllIgnoreCase");
        String name = "";
        EquipmentRepository instance = new EquipmentRepositoryImpl();
        Optional<EquipmentEntity> expResult = Optional.empty();
        Optional<EquipmentEntity> result = instance.findFirstByNameAllIgnoreCase(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findFirstByNameAllIgnoreCase method, of class
     * EquipmentRepository.
     */
    @Test
    public void testFindFirstByNameAllIgnoreCase() {
        System.out.println("findFirstByNameAllIgnoreCase");
        String name = "another name";
        EquipmentRepository instance = new EquipmentRepositoryImpl();
        EquipmentEntity insertedEntity = instance.save(new EquipmentEntity(name, 123.456789));
        Optional<EquipmentEntity> expResult = Optional.of(insertedEntity);
        Optional<EquipmentEntity> result = instance.findFirstByNameAllIgnoreCase(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getByName method, of class EquipmentRepository.
     */
    @Test(expected = AssertionError.class)
    public void testGetByNameAssertionError() {
        System.out.println("getByName");
        String name = "";
        EquipmentRepository instance = new EquipmentRepositoryImpl();
        List<EquipmentEntity> expResult = null;
        List<EquipmentEntity> result = instance.getByName(name);
        Assert.assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByName method, of class EquipmentRepository.
     */
    @Test
    public void testGetByName() {
        System.out.println("getByName");
        String name = "sword";
        EquipmentEntity equipment1 = new EquipmentEntity(name, 10.45213);
        EquipmentEntity equipment2 = new EquipmentEntity(name, 35);
        EquipmentRepository instance = new EquipmentRepositoryImpl();
//        List<EquipmentEntity> expResult = null;
        EquipmentEntity insertedEntity1 = instance.save(equipment1);
        EquipmentEntity insertedEntity2 = instance.save(equipment2);
        List<EquipmentEntity> result = instance.getByName(name);
        List<EquipmentEntity> expResult = List.of(insertedEntity1, insertedEntity2);
        Assert.assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getByPrice method, of class EquipmentRepository.
     */
    @Test
    public void testGetByPriceDefault() {
        System.out.println("getByPrice");
        double price = 0.0;
        EquipmentRepository instance = new EquipmentRepositoryImpl();
        List<EquipmentEntity> expResult = List.of();
        List<EquipmentEntity> result = instance.getByPrice(price);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getByPrice method, of class EquipmentRepository.
     */
    @Test
    public void testGetByPrice() {
        System.out.println("getByPrice");
        double price = 123.4567890;
        EquipmentRepository instance = new EquipmentRepositoryImpl();
        EquipmentEntity insertedEntity = instance.save(new EquipmentEntity(
                "some name", price));
        List<EquipmentEntity> expResult = List.of(insertedEntity);
        List<EquipmentEntity> result = instance.getByPrice(price);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findByEnabledTrue method, of class EquipmentRepository.
     */
    @Test
    public void testFindByEnabledTrue() {
        System.out.println("findByEnabledTrue");
        Pageable pageable = null;
        EquipmentRepository instance = new EquipmentRepositoryImpl();
        Page<EquipmentEntity> expResult = null; // new PageImpl<>(); // TODO: FIXME: HACK: Cannot infer type arguments for PageImpl<>Java(16778094) // probably unsupported syntax in JDK 17
        Page<EquipmentEntity> result = instance.findByEnabledTrue(pageable);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
