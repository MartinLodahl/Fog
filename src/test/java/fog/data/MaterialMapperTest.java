package fog.data;

import fog.business.OrderCalculation;
import fog.domain.Material;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MaterialMapperTest {
    
    public MaterialMapperTest() {
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
     * Test of CreateMaterialList method, of class MaterialMapper.
     */
    @Test
    public void testCreateMaterialList() throws Exception {
        
        Connector con = new Connector();
        System.out.println("CreateMaterialList");
        int length = 200;
        int width = 500;
        boolean skur = false;
        int heigth = 200;
        OrderCalculation instance = new OrderCalculation();
        ArrayList<Material> expResult = new ArrayList<>();
        expResult.add(new Material(1, "stolpe", "stolpe", 200, 10.00, 4));
        expResult.add(new Material(4, "Plastik braedde2", "braedde", 200, 5.00*length/100, 2));
        expResult.add(new Material(3, "Trae braedde", "braedde", 500, 10.00, 2));
        expResult.add(new Material(5, "Normalt tag", "tag", 500, 200, (10.00*length*width)/10000, 1));
        ArrayList<Material> result = instance.createMaterialList(length, width, skur, heigth);
      // Assert.assertArrayEquals(expResult.toArray(), result.toArray());
        for (int i = 0; i < expResult.size(); i++) {
            Assert.assertEquals(expResult.get(i).toString(), result.get(i).toString());   
        }
    }

    
}