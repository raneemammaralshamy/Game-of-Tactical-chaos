package Champions.Damage;


public class BasicAttackDodgeDamageCalculater extends DamageDecorator {

    public BasicAttackDodgeDamageCalculater(Damage damage) {
        super(damage);
    }

    public Damage DamageCalculator() {
        return super.DamageCalculator();
    }
}
