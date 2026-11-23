package weapon.staff;

import characters.GameCharacter;
import effects.Effect;
import weapon.Weapon;

public abstract class Staff extends Weapon {

    protected int manaUse;
    protected int manaMax;
    protected int currentMana;

    public Staff(String name, int baseDamage, double apperanceProbability, int manaUse, int manaMax) {
        super(name, baseDamage, apperanceProbability);
        this.manaUse = manaUse;
        this.manaMax = manaMax;
        this.currentMana = manaMax;
    }

    public void rechargeMana(int amount){
        this.currentMana = Math.min(this.manaMax, this.currentMana + amount);
        System.out.println(this.name + " starts to make strange moves and now have " + this.currentMana);
    }

    @Override
    public int getDamage() {
        if (this.currentMana >= this.manaUse) {
            this.currentMana = Math.max(0, this.currentMana - this.manaUse);
            return this.baseDamage;
        } else {
            System.out.println(this.name + " is out of mana! Weak physical hit.");
            return (int) (this.baseDamage * 0.25);
        }
    }

    @Override
    public abstract void castSpellEffect(GameCharacter attacker, GameCharacter target);

    protected double getManaRatio() {
        return (double) this.currentMana / this.manaMax;
    }

    public int getManaUse(){return this.manaUse;}
    public void setManaUse(int manaUse){this.manaUse = manaUse;}
    public int getManaMax(){return this.manaMax;}

    @Override
    public String toString(){return super.toString() + "\tMana to Use:" + this.manaUse +
            "\t Current Mana: " + this.currentMana + "/" + this.manaMax ;}
}
