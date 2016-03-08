import jeu.JeuBowling;
import junit.framework.TestCase;

/**
 *
 * @author herisata
 */
public class BowlingTest extends TestCase{
    private JeuBowling jeu;
    
    @Override
    protected void setUp(){
        jeu=new JeuBowling();
    }
    
    
    private void lancerPlusieurs(int totalLancer, int quilles) throws Exception {
        for(int i=0; i<totalLancer; i++){
            jeu.lancer(quilles);
        }
    }
    
    public void testTousRatés() throws Exception{
        lancerPlusieurs(15, 0);
        assertEquals(0, jeu.scoreFinal());
    }
    public void testTous1() throws Exception{
        lancerPlusieurs(15, 1);
        assertEquals(15, jeu.scoreFinal());
        
    }
    public void testSpareDernierFrame() throws Exception{
        jeu.lancer(5);   
        jeu.lancer(5);   
        jeu.lancer(4);
        
        jeu.lancer(5);   
        jeu.lancer(5);   
        jeu.lancer(4);
        
        jeu.lancer(5);   
        jeu.lancer(5);   
        jeu.lancer(4);
        
        jeu.lancer(5);   
        jeu.lancer(5);   
        jeu.lancer(4);
        
        jeu.lancer(5);
        jeu.lancer(10); //Spare
        jeu.lancer(5);
        
        jeu.lancer(5);
        
        assertEquals(81, jeu.scoreFinal());
    }
    public void testSpareDernierFrame2() throws Exception{
        jeu.lancer(5);   
        jeu.lancer(5);   
        jeu.lancer(4);
        
        jeu.lancer(5);   
        jeu.lancer(5);   
        jeu.lancer(4);
        
        jeu.lancer(5);   
        jeu.lancer(5);   
        jeu.lancer(4);
        
        jeu.lancer(5);   
        jeu.lancer(5);   
        jeu.lancer(4);
        
        jeu.lancer(5);
        jeu.lancer(5); 
        jeu.lancer(5);//Spare
        
        jeu.lancer(5);
        
        assertEquals(76, jeu.scoreFinal());
    }
    public void testStrikeDernierFrame() throws Exception{
        jeu.lancer(5);   
        jeu.lancer(5);   
        jeu.lancer(4);
        
        jeu.lancer(5);   
        jeu.lancer(5);   
        jeu.lancer(4);
        
        jeu.lancer(5);   
        jeu.lancer(5);   
        jeu.lancer(4);
        
        jeu.lancer(5);   
        jeu.lancer(5);   
        jeu.lancer(4);
        
        jeu.lancer(15);//Strike
        jeu.lancer(5); 
        jeu.lancer(5);
        
        jeu.lancer(5);
        
        assertEquals(86, jeu.scoreFinal());
    }
    public void testTousStrike() throws Exception{
        jeu.lancer(15);//Strikes normaux        
        jeu.lancer(15);
        jeu.lancer(15);
        jeu.lancer(15);
        jeu.lancer(15);
        
        jeu.lancer(15);//lancers supplementaires
        jeu.lancer(15);
        jeu.lancer(15);
        
        assertEquals(300, jeu.scoreFinal());
    }
    public void testSujetCas1() throws Exception{
        jeu.lancer(8);        
        jeu.lancer(1);
        jeu.lancer(1);
        
        jeu.lancer(8);
        jeu.lancer(7);
        
        jeu.lancer(1);
        jeu.lancer(2);
        jeu.lancer(1);
        
        jeu.lancer(15);
        
        jeu.lancer(1);
        jeu.lancer(2);
        jeu.lancer(1);
        
        //55 mais non 53, sujet erroné
        assertEquals(55, jeu.scoreFinal());
    }
    public void testSujetCas2() throws Exception{
        jeu.lancer(15);   
        
        jeu.lancer(8);
        jeu.lancer(1);
        jeu.lancer(2);
        
        jeu.lancer(1);
        jeu.lancer(2);
        jeu.lancer(12);
        
        jeu.lancer(6);
        jeu.lancer(4);
        jeu.lancer(1);
        
        jeu.lancer(15);
        jeu.lancer(8);
        jeu.lancer(2);
        
        jeu.lancer(3);
        
        assertEquals(101, jeu.scoreFinal());
    }
    
}
