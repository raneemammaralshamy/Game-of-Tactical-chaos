package Champions;

import Champions.Classes.Classes;
import Moves.BattleMove;

import java.io.Serializable;
import java.util.ArrayList;


public class Champion implements Serializable {


    static final long serialVersionUID = 232L;
    private String name;
    private ChampionAttributes attributes;
    private ArrayList<BattleMove> moves;
    private ArrayList<Champion> potentialTargets;
    private ChampionStates state;
    private ArrayList<Classes> classesList;
    private int x,y;


//Damage damage;
      //new BasicDamage(new ManaBurnerDamageCalculater(damage));
    public int getIntendedDamage(){
        return attributes.getBaseDamage();
    }

    public void AcceptDamage(int IntendedDamage){
        attributes.setCurrentHealth(attributes.getCurrentHealth()-IntendedDamage);

    }


    public Champion(String name) {
        this.name = name;
        moves=new ArrayList();
        potentialTargets=new ArrayList(); }


        public void addMove(BattleMove x){
        moves.add(x);
        }
        private class ChampionAttributes implements IAttributes, Serializable{


            static final long serialVersionUID = 2006L;

            private int baseHealth, currentHealth,currentMaxHealth;
            private int baseVisionRange,currentVisionRange;
            private int baseMoveSpeed,currentMoveSpeed;
            private int baseMagicResist,currentMagicResist;
            private int baseDamage, currentDamage;
            private int baseAttackRange,currentAttackRange;
            private int baseArmor,currentArmor;
            private int baseCricitalStrikeChance,currentCricitalStrikeChance;
            private float baseCricitalStrikeDamage,currentCricitalStrikeDamage;








            public void setAttribute
                    (int health
                    ,int movespeed
                    ,int visionrange
                    ,int Damage
                    ,int AttackRange
                    ,int armor
                    ,int cricitalStrikeChance
                    ,float cricitalStrikeDamage
                    ,int magicResist) {
                this.baseHealth =health;
                currentMaxHealth=baseHealth;
                currentHealth =health;

                this.baseAttackRange =AttackRange;
                currentAttackRange=baseAttackRange;

                this.baseMoveSpeed =movespeed;
                currentMoveSpeed=baseMoveSpeed;

                this.baseVisionRange =visionrange;
                currentVisionRange=baseVisionRange;

                this.baseDamage=Damage;
                this.currentDamage=baseDamage;

                this.baseArmor =armor;
                currentArmor=baseArmor;



                this.baseCricitalStrikeDamage =cricitalStrikeDamage;
                this.baseCricitalStrikeChance =cricitalStrikeChance;
                this.baseMagicResist =magicResist;
            }
            public int getCurrentHealth() { return currentHealth; }
            public int getBaseVisionRange() { return baseVisionRange; }
            public int getBaseAttackRange(){return baseAttackRange;}
            public int getBaseDamage(){ return baseDamage; }
            public int getBaseMoveSpeed() { return baseMoveSpeed; }
            public int getBaseArmor() {
                return baseArmor;
            }
            public float getBaseCricitalStrikeDamage() {
                return baseCricitalStrikeDamage;
            }
            public int getBaseCricitalStrikeChance() {
                return baseCricitalStrikeChance;
            }
            public int getBaseMagicResist() {
                return baseMagicResist;
            }


            public void setcurrentArmor(int currentarmor) { currentArmor=currentarmor; }
            public void setBaseArmor(int baseArmor) {
                this.baseArmor = baseArmor;
            }
            public void setBaseAttackRange(int baseAttackRange) {
                this.baseAttackRange = baseAttackRange;
            }
            public void setBaseDamage(int baseDamage) {
                this.baseDamage = baseDamage;
            }
            public void setBaseCricitalStrikeChance(int baseCricitalStrikeChance) {
                this.baseCricitalStrikeChance = baseCricitalStrikeChance;
            }
            public void setBaseCricitalStrikeDamage(float baseCricitalStrikeDamage) {
                this.baseCricitalStrikeDamage = baseCricitalStrikeDamage;
            }
            public void setBaseMagicResist(int baseMagicResist) {
                this.baseMagicResist = baseMagicResist;
            }
            public void setBaseVisionRange(int baseVisionRange) {
                this.baseVisionRange = baseVisionRange;
            }
            public void setBaseMoveSpeed(int movespeed) { this.baseMoveSpeed = movespeed; }
            public void setCurrentHealth(int currentHealth) { this.currentHealth = currentHealth; }
            public void setBaseHealth(int baseHealth){this.baseHealth = baseHealth;}

        public String toString() {
            return "ChampionAttributes{" +
                    "health:" + currentHealth + '/' + baseHealth + " VR:"+ baseVisionRange +" MS:"+ baseMoveSpeed
                    + " AR:"+ baseAttackRange +" BD:"+baseDamage+" Armor:"+ baseArmor +" MR:"+ baseMagicResist
                    + " CSC:"+ baseCricitalStrikeChance +'%'+" CSD:"+ baseCricitalStrikeDamage +'}';
        }
    }

    public ArrayList<Classes> getClasses() { return classesList; }
    public ArrayList<BattleMove> getListOfMoves(){
        return moves;
    }
    public ChampionAttributes getAttributesInstance(){
        return new ChampionAttributes();
    }
    public ChampionAttributes getAttributes() { return attributes; }
    public void setAttributes(IAttributes Attributes){
        this.attributes =(ChampionAttributes)Attributes;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){this.name=name;}
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setState(ChampionStates state){this.state=state;}
    public ChampionStates getState() {
        return state;
    }

    public String toString() {
        return "Champion{" +
                "Name='" + name + '\'' +
                "," +" Position("+x+','+y+')'+','+ attributes +
                '}';
    }
}