package weapon.staff;

import characters.GameCharacter;
import weapon.Weapon;

public abstract class Staff extends Weapon {
    protected final int manaUse;
    protected final int manaMax;
    protected int currentMana;

    public Staff(String name, int baseDamage, int manaUse, int manaMax) {
        super(name, baseDamage);
        this.manaUse = manaUse;
        this.manaMax = manaMax;
        this.currentMana = manaMax;
    }

    // Ataque normal: NO gasta maná y hace el daño base del bastón
    @Override
    public int getDamage() {
        return this.baseDamage;
    }

    protected double getManaRatio() {
        return (double) this.currentMana / this.manaMax;
    }

    public void rechargeMana(int amount) {
        this.currentMana = Math.min(this.manaMax, this.currentMana + amount);
    }

    // Modo 1 (Gratis): Mínima probabilidad de aplicar efecto tras golpear
    @Override
    public abstract void applyWeaponEffect(GameCharacter attacker, GameCharacter target);

    // Modo 2 (Cuesta maná): Daño directo + 100% de probabilidad de efecto
    @Override
    public abstract void castSpellEffect(GameCharacter attacker, GameCharacter target);

    public int getManaMax(){return this.manaMax;}
    public int getCurrentMana(){return this.currentMana;}

    @Override
    public String toString() {
        return super.toString() + "\tMana: " + this.currentMana + "/" + this.manaMax + "\tMana Cost: " + this.manaUse;
    }
}