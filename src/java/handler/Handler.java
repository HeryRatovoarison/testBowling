package handler;

import jeu.JeuBowling;

/**
 *
 * @author herisata
 */
public class Handler {
    private static JeuBowling jeu;
    
    public static JeuBowling getJeu(){
        if(jeu==null) jeu=new JeuBowling();
        return jeu;
    }

    public static void newJeu() {
        jeu=new JeuBowling();
    }
    public static int getMaxQuilles(){
        return JeuBowling.MAX_QUILLES_PAR_FRAME;
    }
}
