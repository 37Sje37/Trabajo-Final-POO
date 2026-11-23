package weapon.staff;

import characters.GameCharacter;
import effects.Burn;
import effects.Effect;

public class SalamanderStaff extends Staff{

    private double burnProbability;
    private int minBurnDamage;
    private int maxBurnDamage;
    private double luck;

    public SalamanderStaff() {
        super("Salamander Staff", 18, 0.3, 20,200);
        this.burnProbability = 0.50;
        this.minBurnDamage = 5;
        this.maxBurnDamage = 15;
        this.luck = 0.25;
    }

    private int calculateRandomBurnDamage() {
        double baseRandom = this.minBurnDamage + Math.random() * (this.maxBurnDamage - this.minBurnDamage);
        double luckMultiplier = 1.0 + (Math.random() * this.luck);
        return Math.max(1, (int) Math.round(baseRandom * this.getManaRatio() * luckMultiplier)); //[cite: 1]
    }

    @Override
    public void applyWeaponEffect(GameCharacter attacker, GameCharacter target){
        if(manaUse < currentMana && Math.random() < this.burnProbability){
            int burnDamage = calculateRandomBurnDamage();
            System.out.println(this.name + " grazes " + target.getName() + " and inflicts Burn (" + burnDamage + " dmg/turn)!");
            target.applyEffect(new Burn(3,burnDamage));
        }
    }

@Override
    public void castSpellEffect(GameCharacter attacker, GameCharacter target) {

}
    }


}

