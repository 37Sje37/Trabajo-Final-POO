package weapon.sword;

import effects.Bleed;
import characters.GameCharacter;

public class AnnealBlade extends Sword{

    private double bleedProbability;

    public AnnealBlade(double apperanceProbability,int sharpness){
        super("Anneal Blade",20, apperanceProbability,sharpness);
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
    public String toString(){
        return "Name:"+ this.name + "\tDamage:" + this.baseDamage + "\tBleed Probability:" + this.bleedProbability;
    }


}
