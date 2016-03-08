package jeu;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author herisata
 */
public class Frame {
    private List<Integer> lancers= new ArrayList(JeuBowling.MAX_LANCERS_PAR_FRAME);
    private boolean full=false;
    

    public void addLancer(int quilles) {
        lancers.add(quilles);
        if(lancers.size()==JeuBowling.MAX_LANCERS_PAR_FRAME||getScore()==JeuBowling.MAX_QUILLES_PAR_FRAME) this.full=true;
    }

    public int getScore() {
        int score=0;
        for(Integer points:lancers){
            if(points!=null) score+=points;
        }
        return score;
    }

    public boolean isFull() {
        return this.full;
    }

    public boolean isStrike() {
        return !this.lancers.isEmpty()&&this.lancers.get(0)!=null&&this.lancers.get(0)==JeuBowling.MAX_QUILLES_PAR_FRAME;
    }

    public boolean isSpare() {
        return !isStrike()&&getScore()==JeuBowling.MAX_QUILLES_PAR_FRAME;
    }

    public Integer getPointsLancer(int i) {
        if(i>=this.lancers.size()) return null;
        return this.lancers.get(i);
    }

    protected List<Integer> getLancers() {
        return lancers;
    }

    protected void setFull(boolean full) {
        this.full = full;
    }

    public int getIndexApresSpare() {
        int score=0;
        Integer points;
        
        for(int i=0; i<lancers.size(); i++){
            points=lancers.get(i);
            if(points!=null) score+=points;
            if(score==JeuBowling.MAX_QUILLES_PAR_FRAME) return i+1;
        }
        return 0;
    }
    
}
