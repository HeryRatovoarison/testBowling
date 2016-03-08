package jeu;

/**
 *  Le DernierFrame est différent des autres Frame en comportement
 * @author herisata
 */
public class DernierFrame extends Frame{
    

    @Override
    public boolean isSpare() {
        boolean spare=false;
        int score=0;
        for(int i=0; i<JeuBowling.MAX_LANCERS_PAR_FRAME; i++){
            if(getPointsLancer(i)!=null) score+=getPointsLancer(i);
            if(score==15) spare=true;
        }
        return !isStrike()&&spare;
    }

    @Override
    public void addLancer(int quilles) {
        getLancers().add(quilles);
        if((isStrike()||isSpare())){
            if(getLancers().size()==JeuBowling.MAX_LANCERS_PAR_FRAME+1) setFull(true);
        }
        else if(getLancers().size()==JeuBowling.MAX_LANCERS_PAR_FRAME) setFull(true);
    }
    
}
