package weapon.staff;

import characters.GameCharacter;
import effects.Burn;

public class SalamanderStaff extends Staff{

    private final double minEffectProbability;
    private final int minBurnDamage;
    private final int maxBurnDamage;
    private final double luck;

    public SalamanderStaff() {
        super("Salamander Staff", 10, 30, 100);
        this.minEffectProbability = 0.15; // Mínima probabilidad sin gastar maná (15%)
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
    public void applyWeaponEffect(GameCharacter attacker, GameCharacter target) {
        if (Math.random() < this.minEffectProbability) {
            System.out.println(this.name + " releases a stray spark! " + target.getName() + " catches a minor Burn!");
            target.applyEffect(new Burn(2, this.minBurnDamage));
        }
    }

@Override
    public void castSpellEffect(GameCharacter attacker, GameCharacter target) {
        if (this.currentMana >= this.manaUse) {
            int burnDamage = calculateRandomBurnDamage();
            int directMagicDamage = attacker.getBaseDamage() + (int) Math.round(this.baseDamage * 1.5);

            // Descontamos el maná tras calcular la potencia del hechizo
            this.currentMana = Math.max(0, this.currentMana - this.manaUse);

            System.out.println(attacker.getName() + " unleashes a fireball with " + this.name + " for "
                    + directMagicDamage + " direct damage and guaranteed Burn (" + burnDamage + " dmg/turn)!");

            target.takeDamage(directMagicDamage);
            target.applyEffect(new Burn(3, burnDamage));
        } else {
            System.out.println(this.name + " does not have enough mana! (" + this.currentMana + "/" + this.manaUse + ")");
        }
}


}

