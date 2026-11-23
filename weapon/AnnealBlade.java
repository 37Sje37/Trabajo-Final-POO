package weapon;

import effects.Bleed;
import characters.GameCharacter;

public class AnnealBlade extends Sword{
    protected double bleedProbability;

    public AnnealBlade(){
        super("Anneal Blade",20, 40);
        this.bleedProbability = 30;
    }

    @Override
    public void applyEffectWeapon(GameCharacter attacker, GameCharacter target){
        if(Math.random() < this.bleedProbability){
            System.out.println(attacker.getName() + " cuts " + target.getName() + " and now is Bleeding" );
            target.applyEffect((new Bleed(3,40)));
        }
        this.decreaseSharpness(10);
    }

    @Override
    public String toString(){
        return "Name:"+ this.name + "\tDamage:" + this.baseDamage + "\tBleed Probability:" + this.bleedProbability;
    }


}
