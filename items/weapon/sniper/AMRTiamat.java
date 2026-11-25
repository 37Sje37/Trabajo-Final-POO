package items.weapon.sniper;

import ornaments.Colors;

public class AMRTiamat extends SniperRifle {

    private double megaShootProbability;

    public AMRTiamat(int level) {
        super("AMR Tiamat", 40, 4, level);
        recalculateStats();
    }

    private void recalculateStats() {
        this.megaShootProbability = Math.min(1.0, 0.30 + 0.03 * this.level);
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

        if (Math.random() < this.megaShootProbability) {
            int megaDamage = (int) Math.round(damage * 2.5);
            System.out.println(this.name + " fires a 20mm Anti-Materiel High-Velocity round! Massive damage: "
                    + megaDamage + "!");
            return megaDamage;
        }
        return damage;
    }

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tMega Shot Probability: " + Colors.CYAN +
                (int) Math.round(this.megaShootProbability * 100) + "%" + Colors.RESET;
    }
}