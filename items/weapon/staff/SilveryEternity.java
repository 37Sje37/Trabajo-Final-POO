package items.weapon.staff;

import characters.GameCharacter;
import effect.Paralysis;
import ornaments.Colors;

public class SilveryEternity extends Staff {

    private double minEffectProbability;
    private double luck;

    public SilveryEternity(int level) {
        super("Silvery Eternity", 20, 40, 300, level);
        recalculateStats();
    }

    private void recalculateStats() {
        this.minEffectProbability = Math.min(1.0, 0.10 + 0.03 * this.level);
        this.luck = Math.min(1.0, 0.20 + 0.03 * this.level);
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

    private int calculateParalysisTurns() {
        double potency = this.getManaRatio() + (Math.random() * this.luck);
        return (potency >= 0.85) ? 2 : 1;
    }

    @Override
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
            int directIceDamage = attacker.getBaseDamage() + (int) Math.round(this.getDamage() * 1.4);

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
    public String toString() {
        return super.toString() + Colors.GRAY + "\tMin Freeze Prob: " + Colors.BRIGHT_CYAN + (int) Math.round(this.minEffectProbability * 100) + "%" +
                Colors.GRAY + "\tLuck: " + Colors.YELLOW + (int) Math.round(this.luck * 100) + "%" + Colors.RESET;
    }
}