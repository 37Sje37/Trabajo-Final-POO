package items.weapon.sniper;

import characters.GameCharacter;
import effect.Paralysis;
import ornaments.Colors;

public class L115A3 extends SniperRifle {

    private double critProbability;
    private double stunProbability;

    public L115A3(int level) {
        super("Accuracy International L115A3", 30, 10, level);
        recalculateStats();
    }

    private void recalculateStats() {
        this.critProbability = Math.min(1.0, 0.45 + 0.04 * this.level);
        this.stunProbability = Math.min(1.0, 0.35 + 0.03 * this.level);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        recalculateStats();
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
        recalculateStats();
    }

    @Override
    public int getDamage() {
        int damage = super.getDamage();
        if (damage == 0) {
            return 0; // Estaba sin balas y acaba de recargar en super.getDamage()
        }

        if (Math.random() < this.critProbability) {
            System.out.println(Colors.BRIGHT_YELLOW + "Critical headshot!" + Colors.RESET);
            return (int) Math.round(damage * 1.6);
        }
        return damage;
    }

    @Override
    public void applyWeaponEffect(GameCharacter attacker, GameCharacter target) {
        if (Math.random() < this.stunProbability) {
            System.out.println("Your bullet penetrates the enemy and inflicts Paralysis!");
            target.applyEffect(new Paralysis(1));
        }
    }

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tCrit Probability: " + Colors.CYAN + (int) Math.round(this.critProbability * 100) + "%" +
                Colors.GRAY + "\tStun Probability: " + Colors.GREEN + (int) Math.round(this.stunProbability * 100) + "%" + Colors.RESET;
    }
}