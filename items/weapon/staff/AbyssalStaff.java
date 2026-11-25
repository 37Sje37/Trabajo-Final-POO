package items.weapon.staff;

import characters.GameCharacter;
import effect.Drain;
import ornaments.Colors;

public class AbyssalStaff extends Staff {

    private double minEffectProbability;
    private double drainPercentage;

    public AbyssalStaff(int level) {
        super("Abyssal Staff", 30, 30, 100, level);
        recalculateStats();
    }

    private void recalculateStats() {
        this.minEffectProbability = Math.min(1.0, 0.14 + 0.02 * this.level);
        this.drainPercentage = Math.min(1.0, 0.55 + 0.02 * (this.level - 1));
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
    public void applyWeaponEffect(GameCharacter attacker, GameCharacter target) {
        if (Math.random() < this.minEffectProbability) {
            int damageDealt = attacker.getBaseDamage() + this.getDamage();
            System.out.println(this.name + " activates minor Drain!");

            Drain drainEffect = new Drain(attacker, damageDealt, this.drainPercentage);
            drainEffect.applyEffect(target);
        }
    }

    @Override
    public void castSpellEffect(GameCharacter attacker, GameCharacter target) {
        if (this.currentMana >= this.manaUse) {
            int directDarkDamage = attacker.getBaseDamage() + (int) Math.round(this.getDamage() * 1.3);

            this.currentMana = Math.max(0, this.currentMana - this.manaUse);

            System.out.println(attacker.getName() + " casts Abyssal Siphon with " + this.name
                    + " for " + directDarkDamage + " direct damage!");

            target.takeDamage(directDarkDamage);

            Drain drainEffect = new Drain(attacker, directDarkDamage, this.drainPercentage);
            drainEffect.applyEffect(target);
        } else {
            System.out.println(this.name + " does not have enough mana! (" + this.currentMana + "/" + this.manaUse + ")");
        }
    }

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tDrain: " + Colors.ORANGE + (int) Math.round(this.drainPercentage * 100) + "%" +
                Colors.GRAY + "\tProb to Drain: " + Colors.RED + (int) Math.round(this.minEffectProbability * 100) + "%" + Colors.RESET;
    }
}