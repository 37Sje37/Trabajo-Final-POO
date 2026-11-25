package items.weapon.staff;

import characters.GameCharacter;
import effect.Burn;
import ornaments.Colors;

public class SalamanderStaff extends Staff {

    private double minEffectProbability;
    private int minBurnDamage;
    private int maxBurnDamage;
    private double luck;

    public SalamanderStaff(int level) {
        super("Salamander Staff", 10, 30, 100, level);
        recalculateStats();
    }

    private void recalculateStats() {
        this.minEffectProbability = Math.min(1.0, 0.15 + 0.03 * this.level);
        this.minBurnDamage = 5 + 2 * this.level;
        this.maxBurnDamage = 15 + 3 * this.level;
        this.luck = Math.min(1.0, 0.25 + 0.03 * this.level);
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

    private int calculateRandomBurnDamage() {
        double baseRandom = this.minBurnDamage + Math.random() * (this.maxBurnDamage - this.minBurnDamage);
        double luckMultiplier = 1.0 + (Math.random() * this.luck);
        return Math.max(1, (int) Math.round(baseRandom * this.getManaRatio() * luckMultiplier));
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
            int directMagicDamage = attacker.getBaseDamage() + (int) Math.round(this.getDamage() * 1.5);

            this.currentMana = Math.max(0, this.currentMana - this.manaUse);

            System.out.println(attacker.getName() + " unleashes a fireball with " + this.name + " for "
                    + directMagicDamage + " direct damage and guaranteed Burn (" + burnDamage + " dmg/turn)!");

            target.takeDamage(directMagicDamage);
            target.applyEffect(new Burn(3, burnDamage));
        } else {
            System.out.println(this.name + " does not have enough mana! (" + this.currentMana + "/" + this.manaUse + ")");
        }
    }

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tMin Burn DMG: " + Colors.BRIGHT_RED + this.minBurnDamage +
                Colors.GRAY + "\tLuck: " + Colors.YELLOW + (int) Math.round(this.luck * 100) + "%" + Colors.RESET;
    }
}