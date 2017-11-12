/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comprovacions;

import Utils.DescargaTreballador;
import clases.Treballador;
import java.awt.Choice;
import java.util.ArrayList;
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
public class CarregaChoiceTest {
    
    public CarregaChoiceTest() {
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
     * Test of carrega method, of class CarregaChoice.
     */
    @Test
    public void testCarrega() {
        System.out.println("carrega");
        Choice choice = null;
        int x = 60;
        int h = 60;
        CarregaChoice.carrega(choice, x, h);
       
    }

/**
 * Test per descarregar del servidor i afegir al choice
 */
    @Test
    public void testCarregaTreballador() {
        System.out.println("carregaTreballador");
        DescargaTreballador descarrega= new DescargaTreballador();
        Choice choice = new Choice();
        ArrayList<Treballador> treb=(ArrayList<Treballador>) descarrega.obtenirTreballadorsDelServer() ;
        CarregaChoice.carregaTreballador(choice, treb);
        
      
    }

    /**
     * Test of carregaAny method, of class CarregaChoice.
     */
    @Test
    public void testCarregaAny() {
        System.out.println("carregaAny");
        Choice choice2 = new Choice();
        CarregaChoice.carregaAny(choice2);
        
      
    }
    
}
