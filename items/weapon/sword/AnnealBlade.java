package items.weapon.sword;

import effect.Bleed;
import characters.GameCharacter;
import ornaments.Colors;

public class AnnealBlade extends Sword{

    private final double bleedProbability;

    public AnnealBlade(int sharpness){
        super("Anneal Blade",20,sharpness);
        this.bleedProbability = sharpness*0.9;
    }

    public void applyEffectWeapon(GameCharacter attacker, GameCharacter target) {
        double currentBleedProb = this.bleedProbability * this.getSharpnessRatio();

        if (this.sharpness > 0 && Math.random() < currentBleedProb) {
            double bleedPercentage = 0.08 * this.getSharpnessRatio(); // De 8% a 0% según filo
            System.out.println(this.name + " slices deeply and inflicts Bleed on " + target.getName() + "!");
            target.applyEffect(new Bleed(3, (int)(bleedPercentage*100)));
        }

        this.decreaseSharpness(30);
    }

    @Override
    public String toString() {
        return Colors.GRAY + "Name: " + Colors.CYAN + this.name +
                Colors.GRAY + "\tDamage: " + Colors.RED + this.baseDamage +
                Colors.GRAY + "\tBleed Probability: " + Colors.CRIMSON + (int) (this.bleedProbability * 100) + "%" + Colors.RESET;
    }


}
