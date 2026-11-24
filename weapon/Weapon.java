package weapon;

import characters.GameCharacter;

public abstract class Weapon {

    protected final String name;
    protected final int baseDamage;
    protected final double apperanceProbability; //entre 0-1

    public Weapon(String name,int baseDamage,double apperanceProbability){
        this.name = name;
        this.baseDamage = baseDamage;
        this.apperanceProbability = apperanceProbability;
    }

    public void castSpellEffect(GameCharacter attacker, GameCharacter target) {
        System.out.println(this.name + " cannot cast pure spell effects!");
    }

    public int getBaseDamage(){return this.baseDamage;}

    public int getDamage(){
        return this.baseDamage;
    }
    public String getName(){
        return this.name;
    }

    public void applyWeaponEffect(GameCharacter attacker, GameCharacter target){}

    @Override
    public String toString (){
        return super.toString() + "\t Base damage" + this.baseDamage;
    }


}
