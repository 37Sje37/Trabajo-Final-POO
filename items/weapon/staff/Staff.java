package items.weapon.staff;

import characters.GameCharacter;
import items.weapon.Weapon;
import ornaments.Colors;

public abstract class Staff extends Weapon {
    protected final int manaUse;
    protected final int manaMax;
    protected int currentMana;

    public Staff(String name, int baseDamage, int manaUse, int manaMax, int level) {
        super(name, baseDamage, level);
        this.manaUse = manaUse;
        this.manaMax = Math.max(1, manaMax);
        this.currentMana = this.manaMax;
    }

    @Override
    public int getDamage() {
        return super.getDamage();
    }

    protected double getManaRatio() {
        return (double) this.currentMana / this.manaMax;
    }

    public void rechargeMana(int amount) {
        this.currentMana = Math.min(this.manaMax, Math.max(0, this.currentMana + amount));
    }

    @Override
    public abstract void applyWeaponEffect(GameCharacter attacker, GameCharacter target);

    @Override
    public abstract void castSpellEffect(GameCharacter attacker, GameCharacter target);

    public int getManaMax() {
        return this.manaMax;
    }

    public int getCurrentMana() {
        return this.currentMana;
    }

    @Override
    public String toString() {
        return Colors.GRAY + "Name: " + Colors.CYAN + this.name + " (Lv." + this.level + ")" +
                Colors.GRAY + "\tDamage: " + Colors.RED + this.getScaledBaseDamage() +
                Colors.GRAY + "\tMana: " + Colors.BLUE + this.currentMana + "/" + this.manaMax +
                Colors.GRAY + "\tMana Cost: " + Colors.TURQUOISE + this.manaUse + Colors.RESET;
    }
}