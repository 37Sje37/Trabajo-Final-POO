package items.weapon.sword;

import characters.GameCharacter;
import effect.Bleed;
import ornaments.Colors;

public class AnnealBlade extends Sword {

    private double bleedProbability;

    public AnnealBlade(int sharpness, int level) {
        super("Anneal Blade", 20, sharpness, level);
        recalculateBleedProbability();
    }

    private void recalculateBleedProbability() {
        double baseProb = 0.25 + (0.03 * this.level);
        this.bleedProbability = Math.min(1.0, baseProb);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        recalculateBleedProbability();
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
        recalculateBleedProbability();
    }

    public void applyEffectWeapon(GameCharacter attacker, GameCharacter target) {
        double currentBleedProb = this.bleedProbability * this.getSharpnessRatio();

        if (this.sharpness > 0 && Math.random() < currentBleedProb) {
            double bleedPercentage = 0.08 * this.getSharpnessRatio(); // De 8% a 0% según filo
            System.out.println(this.name + " slices deeply and inflicts Bleed on " + target.getName() + "!");
            target.applyEffect(new Bleed(3, Math.max(1, (int) Math.round(bleedPercentage * 100))));
        }

        this.decreaseSharpness(30);
    }

    @Override
    public String toString() {
        return Colors.GRAY + "Name: " + Colors.CYAN + this.name + " (Lv." + this.level + ")" +
                Colors.GRAY + "\tDamage: " + Colors.RED + this.getScaledBaseDamage() +
                Colors.GRAY + "\tBleed Probability: " + Colors.CRIMSON + (int) Math.round(this.bleedProbability * 100) + "%" + Colors.RESET;
    }
}