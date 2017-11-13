/**
 * 
 *Classe per fer Test de comprovacions de dates introduides
 * 
 * @author Maria Remedios Ortega
*/
package Comprovacions;

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
public class ValidaDataTest {

    public ValidaDataTest() {
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
     * Test per comprovar la validesa de la data introduida
     */
    @Test
    public void testCheckDay() {
        System.out.println("checkDay");
        int day = 0;
        int month = 0;
        int year = 0;
        boolean expResult = true;
        //comprovació any de traspas -> 2020 es traspas
        assertEquals(expResult, ValidaData.checkDay(29, 2, 2020));
        //mes amb 31 dies
        assertEquals(expResult, ValidaData.checkDay(31, 7, 2017));
        // mes amb dies equivocats -> fals que febrer tingui 31 dies
        assertFalse(ValidaData.checkDay(30, 2, 2020));
        // mes amb 31 dies 
        assertTrue(ValidaData.checkDay(31, 8, 2017));

    }

    /**
     * Test per comprovar la data introduida es inferior a la data actual
     */
    @Test
    public void testComprovaData() {
        System.out.println("comprovaData");
        String dataSeleccionada = "";
        boolean expResult = false;
        // data a comprovar false perque es anterior a la data actual
        assertFalse(ValidaData.comprovaData("10/11/2017"));
        
        // data a comprovar true perque es data posterior a la data actual
        assertTrue(ValidaData.comprovaData("25/12/2017"));

    }

    /**
     * Test per comprovar dues opcions:
     * 1. si falten dades al origen i al desti de servei
     * 2. si el treballador es admin no pot tindre serveis associats
     * ni assignarli serveis.
     */
    @Test
    public void testComprovaFormulari() {
        System.out.println("comprovaFormulari");
        String o = "x";
        String d = "x";
        int t = 2;
        boolean expResult = true;
        // formulari completament complert
        boolean result = ValidaData.comprovaFormulari(o, d, t);
        assertEquals(expResult, result);
        // prova per comprovar dades sense omplir
        assertFalse(ValidaData.comprovaFormulari("", "", 2));
        // prova per comprovar si s'assigna servei a usuari admin
        assertFalse(ValidaData.comprovaFormulari("c", "c", 1));

        
       
    }
}
