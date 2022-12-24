package Moves.WalkMove;

import Champions.Champion;
import Arena.Arena;
import Champions.IAttributes;

public class WalkRight extends WalkMove {
    public WalkRight(Champion champion){super(champion);}
    @Override
    public void performMove() {
        int x=champion.getX();
        int y=champion.getY();
        IAttributes championAttributes=champion.getAttributes();
        int movespeed=championAttributes.getBaseMoveSpeed();
        if(!Arena.getArena().exists(champion,x,y) || Arena.getArena().outOfBound(x+movespeed,y))
            return ;
            champion.setX(x+movespeed);
            champion.setY(y);
            Arena.getArena().add(champion,x+movespeed,y);
        Arena.getArena().remove(champion,x,y);
    }
}
