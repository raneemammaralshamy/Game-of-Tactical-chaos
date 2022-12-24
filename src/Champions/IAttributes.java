package Champions;

public interface IAttributes {
    void setAttribute(int health,int moveSpeed,int visionRange,
                      int Damage,int AttackRange,int armor,
                      int cricitalStrikeChance,float cricitalStrikeDamage,
                      int magicResist);

    void setBaseMoveSpeed(int movespeed);
    void setCurrentHealth(int Health);
    void setBaseHealth(int baseHealth);
    void setBaseArmor(int baseArmor);
    void setBaseAttackRange(int baseAttackRange);
    void setBaseDamage(int baseDamage);
    void setBaseCricitalStrikeChance(int baseCricitalStrikeChance);
    void setBaseCricitalStrikeDamage(float baseCricitalStrikeDamage);
    void setBaseMagicResist(int baseMagicResist);
    void setBaseVisionRange(int baseVisionRange);
    void setcurrentArmor(int currentarmor);


    int getBaseMoveSpeed();
    int getCurrentHealth();
    int getBaseVisionRange();
    int getBaseDamage();
    int getBaseAttackRange();
    int getBaseArmor();
    int getBaseCricitalStrikeChance();
    float getBaseCricitalStrikeDamage();
    int getBaseMagicResist();
}
