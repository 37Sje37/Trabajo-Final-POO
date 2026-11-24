package characters;

import effects.Effect;
import weapon.Weapon;

public abstract class GameCharacter {


    protected String name;
    protected int currentHealth;
    protected int maxHealth = 100;
    protected int baseDamage;
    protected int armour;
    protected boolean canAttack;
    protected Weapon equippedWeapon;
    protected Effect currentEffect;

    public GameCharacter(String name, int currentHealth, int damage, int armour){
        this.name = name;
        this.currentHealth = currentHealth;
        this.baseDamage = damage;
        this.maxHealth = currentHealth;
        this.armour = armour;
        this.canAttack = true;
        this.equippedWeapon = null;
        this.currentEffect = null;
    }

    public void attack(GameCharacter target) {
        if (!this.canAttack) {
            System.out.println(this.name + " cannot attack this turn!");
            return;
        }

        int totalDamage = this.baseDamage;
        if (this.equippedWeapon != null) {
            totalDamage += this.equippedWeapon.getDamage();
        }

        System.out.println(this.name + " attacks " + target.getName() + " for " + totalDamage + " damage!");
        target.takeDamage(totalDamage);

        // Fase 2: Probabilidad de activar el efecto especial del arma equipada
        if (this.equippedWeapon != null) {
            this.equippedWeapon.applyWeaponEffect(this, target);
        }
    }

    public void takeDamage(int damageIncoming){
        System.out.println("Recives " + damageIncoming + "of damage" );
        this.currentHealth = Math.max(0, this.currentHealth - damageIncoming);  //esto es para que si la vida baja de 0 se quede en 0 y no aparezca un numero negativo
    }

    public void applyEffect(Effect newEffect){
        this.currentEffect = newEffect;
        System.out.println(this.name + " is now under the effect of " + this.currentEffect.getName());
    }

    public void processEffect(){
        if(this.currentEffect == null){
            return;
        }

        this.currentEffect.applyEffect(this);

        if(this.currentEffect.isExpired()){
            System.out.println(this.name + " has being recovered from " + this.currentEffect.getName());
            this.currentEffect = null;
        }
    }
    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
        System.out.println("Now " + this.name + " has: " + weapon.getName());
    }

    public void heal(int amount){
        this.currentHealth = Math.min(this.maxHealth, this.currentHealth + amount); //para que no se pueda curar ,as de lo que tiene de max de vida
        System.out.println(this.name + " heals and now has" + this.currentHealth +"/" + this.maxHealth+"HP");
    }

    public boolean isAlive(){
        return this.currentHealth > 0;
    }


    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}

    public int getCurrentHealth(){return this.currentHealth;}
    public void setCurrentHealth(int currentHealth){this.currentHealth = currentHealth;}

    public int getBaseDamage(){return this.baseDamage;}
    public void setBaseDamage(int baseDamage){this.baseDamage = baseDamage;}

    public void setArmour(int armour){this.armour = armour;}
    public int getArmour(){return this.armour;}

    public void setCurrentEffect(Effect effect){this.currentEffect = effect;}


    public void setCanAttack(boolean canAttack){this.canAttack = canAttack;}


    @Override
    public String toString() {
        String weaponName = (this.equippedWeapon != null) ? this.equippedWeapon.getName() : "None";
            return "Name:" + this.name + "\t Life:" + this.currentHealth + "/" + this.maxHealth + "HP" + "\t Damage:" +
                    this.baseDamage + "\tWeapon:" + weaponName ;
    }
}

