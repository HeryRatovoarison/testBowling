package jeu;

import java.util.ArrayList;
import java.util.List;
/**
 * @author herisata
 */
public class JeuBowling {
    public static final int 
            MAX_FRAMES=5,
            MAX_QUILLES_PAR_FRAME=15,
            MAX_LANCERS_PAR_FRAME=3;
    
    private final List<Frame> frames;
    private int indexFrameCourant=0;

    public JeuBowling() {
        frames=new ArrayList<>(MAX_FRAMES);
        for(int i=1; i<MAX_FRAMES; i++) frames.add(new Frame());
        frames.add(new DernierFrame());
    }
    
    /**
     * Appelé chaque lancer
     * @param quilles Nombre de quilles renversés
     */
    public void lancer(int quilles) throws Exception{
        frames.get(indexFrameCourant).addLancer(quilles);
        if(frames.get(indexFrameCourant).isFull()) nextFrame();
    }
    /**
     * Appelé en fin de jeu
     * @return le score final
     */
    public int scoreFinal(){
        int score=0;
        int i=0;
        for(int iFrame=0; iFrame<=indexFrameCourant&&iFrame<MAX_FRAMES; iFrame++) {
            if(frames.get(iFrame).isStrike()) score+=MAX_QUILLES_PAR_FRAME+lancersSuivants(iFrame,3);
            else if(frames.get(iFrame).isSpare()) score+=MAX_QUILLES_PAR_FRAME+lancersSuivants(iFrame,2);
            else score+=frames.get(iFrame).getScore();
        }
        return score;
    }
    /**
     * Frame suivant, teste si le dernier frame est rempli
     * @throws Exception 
     */
    private void nextFrame() throws Exception {
        if(indexFrameCourant==MAX_FRAMES) throw new Exception("Dernier frame rempli. Fin du jeu");
        indexFrameCourant++;
    }
    /**
     * Appelé apres un spare ou strike pour calculer les points suivants
     * @param iFrameActuel l'index du frame auquel est effectué le strike/spare
     * @param iLancersSuivants  nombre de lancers suivants à ajouter aux points 
     * @return le bonus de points à ajouter
     */
    private int lancersSuivants(int iFrameActuel, int iLancersSuivants) {
        int bonus=0;
        Integer points;
        int indexStart=0, maxLancers=MAX_LANCERS_PAR_FRAME;
        Frame frame;
        if(iLancersSuivants==0) return 0;
        if(iFrameActuel==MAX_FRAMES-1){
            frame=frames.get(iFrameActuel);
            indexStart=frame.getIndexApresSpare();
            maxLancers++;
        }
        else{
            if(iFrameActuel+1>indexFrameCourant) return 0;//throw new Exception("Points des lancers suivants necessaires");
            frame=frames.get(iFrameActuel+1);
        }
        for(int i=indexStart; i<maxLancers;i++) {
            points=frame.getPointsLancer(i);
            if(points!=null) {
                bonus+=points;
                iLancersSuivants--;
                if(iLancersSuivants==0) return bonus;
            }
        }
        bonus+=lancersSuivants(iFrameActuel+1, iLancersSuivants);

        return bonus;
    }

    /**
     * 
     * @return le numéro du frame courant
     */
    public int getFrameCourant() {
        return (indexFrameCourant<JeuBowling.MAX_FRAMES)?indexFrameCourant+1:0;
    }
    /**
     * 
     * @return le numéro du lancer courant
     */
    public int getLancerCourant() {
        return (indexFrameCourant<JeuBowling.MAX_FRAMES)
                ?this.frames.get(indexFrameCourant).getLancers().size()+1
                :0;
    }
}
