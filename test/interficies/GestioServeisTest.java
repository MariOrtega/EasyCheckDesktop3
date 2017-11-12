/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interficies;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maria
 */
public class GestioServeisTest {
    
    public GestioServeisTest() {
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
     * Test of nomTreballador method, of class GestioServeis.
     * comprova si l'id del treballador dona com a resultat el
     * nom esperat
     */
    @Test
    public void testNomTreballador() {
        System.out.println("nomTreballador");
        Integer userID = 3;
        GestioServeis instance = new GestioServeis();
        String expResult = "Maria Ortega Cobo";
        String result = instance.nomTreballador(userID);
        assertEquals(expResult, result);
       
      
    }

   
//
    /**
     * Test of obtenirTreballador method, of class GestioServeis.
     * comprova si el nom del treballador dona com a resultat l'id 
     * esperat
     */
    @Test
    public void testObtenirTreballador() {
        System.out.println("obtenirTreballador");
        String nom = "Maria Ortega Cobo";
        GestioServeis instance = new GestioServeis();
        Integer expResult = 3;
        Integer result = instance.obtenirTreballador(nom);
        assertEquals(expResult, result);
      
        
    }

    
}
