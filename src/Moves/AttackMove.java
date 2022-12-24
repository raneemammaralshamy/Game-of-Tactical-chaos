package Moves;

import Champions.Champion;
import Champions.ChampionStates;
import Champions.IAttributes;

public class AttackMove extends BattleMove{
    Champion Attacker;
    Champion Attacked;
    public AttackMove(Champion Attacker,Champion Attacked){
        this.Attacker=Attacker;
        this.Attacked=Attacked;
    }
    public void performMove() {
        IAttributes attackedAttributes=Attacked.getAttributes();
        if(attackedAttributes.getCurrentHealth()==0) {
            Attacked.setState(ChampionStates.Dead);
            return ;
        }
        Attacked.AcceptDamage(Attacker.getIntendedDamage());
    }
}
