package Champions.Damage;

public class BasicDamage extends DamageDecorator {

    public BasicDamage(Damage damage) {
        super(damage);
    }

    public Damage DamageCalculator() {
        return super.DamageCalculator();
    }
}
