package Moves.WalkMove;

import Champions.Champion;
import Arena.Arena;
import Moves.BattleMove;

public abstract class WalkMove extends BattleMove {

    Champion champion;
    public WalkMove(Champion champion){ this.champion=champion; }
    @Override
    public abstract void performMove();
}
