package Moves.WalkMove;

import Champions.Champion;
import Arena.Arena;
import Champions.IAttributes;

public class WalkUp extends WalkMove {
    Champion champion;
    public WalkUp(Champion champion){super(champion);}
    @Override
    public void performMove() {
        int x=champion.getX();
        int y=champion.getY();
        IAttributes championAttributes=champion.getAttributes();
        int movespeed=championAttributes.getBaseMoveSpeed();
        if(!Arena.getArena().exists(champion,x,y) || Arena.getArena().outOfBound(x,y-movespeed))
            return ;
            champion.setX(x);
            champion.setY(y-movespeed);
            Arena.getArena().add(champion,x,y-movespeed);
        Arena.getArena().remove(champion,x,y);
    }
}
