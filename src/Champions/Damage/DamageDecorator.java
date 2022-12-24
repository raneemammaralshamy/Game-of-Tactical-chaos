package Champions.Damage;

public class DamageDecorator extends Damage{
    Damage damage;
    public DamageDecorator(Damage damage) {
        this.damage = damage;
    }

    @Override
    public Damage DamageCalculator() {
        return this.damage.DamageCalculator();
    }
}
