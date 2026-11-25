package weapon.staff;

import characters.GameCharacter;
import effect.Drain;


public class AbyssalStaff extends Staff{


    private final double minEffectProbability;
    private final double drainPercentage;

    public AbyssalStaff(){
        super("Abysal Staff",30,30,100);
        this.minEffectProbability = 0.14; // 14% de probabilidad en ataque normal (0 maná)
        this.drainPercentage = 0.55;      // 55% de robo de vida

    }

    @Override
    public void applyWeaponEffect(GameCharacter attacker, GameCharacter target) {
        if (Math.random() < this.minEffectProbability) {
            int damageDealt = attacker.getBaseDamage() + this.baseDamage;
            System.out.println(this.name + " activates minor Drain!");

            // Instanciamos Drain y lo aplicamos al instante
            Drain drainEffect = new Drain(attacker, damageDealt, this.drainPercentage);
            drainEffect.applyEffect(target);
        }
    }

    // MODO 2: Ataque mágico (Gasta maná, hace daño directo y aplica Drain del 55% al 100%)
    @Override
    public void castSpellEffect(GameCharacter attacker, GameCharacter target) {
        if (this.currentMana >= this.manaUse) {
            int directDarkDamage = attacker.getBaseDamage() + (int) Math.round(this.baseDamage * 1.3);

            // Descontamos el maná
            this.currentMana = Math.max(0, this.currentMana - this.manaUse);

            System.out.println(attacker.getName() + " casts Abyssal Siphon with " + this.name
                    + " for " + directDarkDamage + " direct damage!");

            target.takeDamage(directDarkDamage);

            // Instanciamos Drain con el daño directo recién hecho y lo ejecutamos al momento
            Drain drainEffect = new Drain(attacker, directDarkDamage, this.drainPercentage);
            drainEffect.applyEffect(target);
        } else {
            System.out.println(this.name + " does not have enough mana! (" + this.currentMana + "/" + this.manaUse + ")");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\tDrain Percentage: " + (int) (this.drainPercentage * 100) + "%";
    }

}
