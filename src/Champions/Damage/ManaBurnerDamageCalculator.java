package Champions.Damage;

public class ManaBurnerDamageCalculator extends DamageDecorator {
    public ManaBurnerDamageCalculator(Damage damage) {
        super(damage);
    }

    public Damage DamageCalculator() {
        return super.damage.DamageCalculator();
    }
}
