package Moves.WalkMove;

import Champions.Champion;

public class WalkMoveFactory {
    private Champion champion;
    public WalkMoveFactory(Champion champion){ this.champion=champion; }
    public WalkMove getMoveInstance (String state) {
        WalkMove move = null;

        if (state.equals("WalkDown")) {
            move = new WalkDown(champion);
        } else if (state.equals("WalkUp")) {
            move = new WalkUp(champion);
        } else if (state.equals("WalkLeft")) {
            move = new WalkLeft(champion);
        } else if (state.equals("WalkRight")) {
            move = new WalkRight(champion);
        }
        return move;
    }
}