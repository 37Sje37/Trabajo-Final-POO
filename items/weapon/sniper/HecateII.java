package items.weapon.sniper;

import characters.GameCharacter;
import effect.Bleed;
import ornaments.Colors;

public class HecateII extends SniperRifle {

    private double headshootProbability;

    public HecateII(int level) {
        super("PGM Ultima Ratio Hecate II", 30, 8, level);
        recalculateStats();
    }

    private void recalculateStats() {
        this.headshootProbability = Math.min(1.0, 0.30 + 0.03 * this.level);
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
            return 0; // Recargó en este turno
        }

        if (Math.random() < this.headshootProbability) {
            int headshotDamage = (int) Math.round(damage * 1.8);
            System.out.println(this.name + " lands a Phantom Bullet Headshot for " + headshotDamage + " damage!");
            return headshotDamage;
        }
        return damage;
    }

    @Override
    public void applyWeaponEffect(GameCharacter attacker, GameCharacter target) {
        if (Math.random() < 0.25) {
            System.out.println("The .50 caliber round pierces " + target.getName() + " (Bleed)!");
            target.applyEffect(new Bleed(2, 5 + this.level));
        }
    }

    public void setHeadshootProbability(double headshootProbability) {
        this.headshootProbability = headshootProbability;
    }

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tHeadshot Probability: " + Colors.CYAN +
                (int) Math.round(this.headshootProbability * 100) + "%" + Colors.RESET;
    }
}