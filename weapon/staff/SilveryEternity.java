package weapon.staff;

import characters.GameCharacter;
import effects.Paralysis;

public class SilveryEternity extends Staff{

    private final double minEffectProbability;
    private final double luck;


    public SilveryEternity(){
        super("Silvery Eternity", 20,0.05,40,300 );
        this.minEffectProbability = 0.10; // Mínima probabilidad sin gastar maná (10%)
        this.luck = 0.20;
    }

    private int calculateParalysisTurns(){
        double potency =  this.getManaRatio() + (Math.random() * this.luck);
        return (potency >= 0.85) ? 2 : 1; // si es mayor q 85 -> 2 si no 1
    }

    public void applyWeaponEffect(GameCharacter attacker, GameCharacter target) {
        if (Math.random() < this.minEffectProbability) {
            System.out.println(this.name + " emits a freezing chill! " + target.getName() + " is paralyzed for 1 turn!");
            target.applyEffect(new Paralysis(1));
        }
    }

    @Override
    public void castSpellEffect(GameCharacter attacker, GameCharacter target) {
        if (this.currentMana >= this.manaUse) {
            int paralysisTurns = calculateParalysisTurns();
            int directIceDamage = attacker.getBaseDamage() + (int) Math.round(this.baseDamage * 1.4);

            // Descontamos el maná tras calcular la potencia del hechizo
            this.currentMana = Math.max(0, this.currentMana - this.manaUse);

            System.out.println(attacker.getName() + " casts Cryogenic Blast with " + this.name + " for "
                    + directIceDamage + " direct damage and guaranteed Paralysis (" + paralysisTurns + " turn(s))!");

            target.takeDamage(directIceDamage);
            target.applyEffect(new Paralysis(paralysisTurns));
        } else {
            System.out.println(this.name + " does not have enough mana! (" + this.currentMana + "/" + this.manaUse + ")");
        }
    }

    @Override
    public String toString(){
        return super.toString() + "\tMin Freeze Prob: " + this.minEffectProbability + "\tLuck: " + this.luck;
    }

}
