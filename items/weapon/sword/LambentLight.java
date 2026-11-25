package items.weapon.sword;

import ornaments.Colors;

public class LambentLight extends Sword {

    private final int maxComboHits;
    private final double comboProbability;

    public LambentLight(int sharpness, int level) {
        super("Lambent Light", 30, sharpness, level);
        this.maxComboHits = 4 + level; // Máximo de golpes con filo al 100%
        this.comboProbability = 0.65;  // 65% de probabilidad base de activar combo
    }

    public int getMaxComboHits() {
        return Math.max(1, (int) Math.round(this.maxComboHits * this.getSharpnessRatio()));
    }

    @Override
    public int getDamage() {
        int singleHitDamage = super.getDamage();
        double currentComboProb = this.comboProbability * this.getSharpnessRatio();

        int hits = 1;
        if (this.sharpness > 0 && Math.random() < currentComboProb) {
            int effectiveMaxHits = this.getMaxComboHits();
            hits = (int) (Math.random() * effectiveMaxHits) + 1;
            System.out.println(this.name + " unleashes a rapid combo of " + hits + " thrust(s)!");
        }

        return singleHitDamage * hits;
    }

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tCombo Probability: " + Colors.CYAN + (int) (this.comboProbability * 100) + "%" +
                Colors.GRAY + "\tMax Combo Hits: " + Colors.GOLD + this.maxComboHits + Colors.RESET;
    }
}