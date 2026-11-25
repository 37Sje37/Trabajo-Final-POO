package characters;

import effect.Effect;
import items.weapon.Weapon;
import items.crystals.Crystal;

import java.util.List;

public class GameCharacter {

    private static final int MAX_CRYSTALS = 2;


    protected String name;
    protected int currentHealth;
    protected int maxHealth = 100;
    protected int baseDamage;
    protected int armour;
    protected boolean canAttack;
    protected Weapon equippedWeapon;
    private List<Effect> activeEffects;
    private Crystal[] crystals;


    public GameCharacter(String name, int currentHealth, int damage, int armour){
        this.name = name;
        this.currentHealth = currentHealth;
        this.baseDamage = damage;
        this.maxHealth = currentHealth;
        this.armour = armour;
        this.canAttack = true;
        this.equippedWeapon = null;
        this.activeEffects = null;
        this.crystals = new Crystal[MAX_CRYSTALS];
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
        this.currentHealth = (int)Math.round(Math.max(0, this.currentHealth - (damageIncoming * (this.armour / 100.0))));
        //esto es para que si la vida baja de 0 se quede en 0 y no aparezca un numero negativo
    }

    public void applyEffect(Effect newEffect) {
        if (newEffect == null) return;

        // Si ya tiene un efecto del mismo tipo, lo renueva
        for (int i = 0; i < this.activeEffects.size(); i++) {
            if (this.activeEffects.get(i).getClass().equals(newEffect.getClass())) {
                this.activeEffects.set(i, newEffect);
                System.out.println(this.name + "'s " + newEffect.getName() + " effect has been refreshed!");
                return;
            }
        }

        this.activeEffects.add(newEffect);
        System.out.println(this.name + " is now affected by " + newEffect.getName() + "!");
    }

    public void processEffects() {
        for (int i = this.activeEffects.size() - 1; i >= 0; i--) {
            Effect effect = this.activeEffects.get(i);
            effect.applyEffect(this);

            if (effect.getRemainingTurns() <= 0) {
                this.activeEffects.remove(i);
            }
        }
    }

    public void clearEffects() {
        this.activeEffects.clear();
    }

    public List<Effect> getActiveEffects() {
        return this.activeEffects;
    }

    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
        System.out.println("Now " + this.name + " has: " + weapon.getName());
    }

    public void heal(int amount){
        this.currentHealth = Math.min(this.maxHealth, this.currentHealth + amount); //para que no se pueda curar ,as de lo que tiene de max de vida
        System.out.println(this.name + " heals and now has" + this.currentHealth +"/" + this.maxHealth+"HP");
    }

    public boolean addCrystal(Crystal crystal){
        for(int i = 0; i < 2 ; i++) {
            if (this.crystals[i] == null) {
                this.crystals[i] = crystal;
                this.crystals[i] = crystal;
                System.out.println(this.name + " stored " + crystal.getName() + " in slot " + (i + 1) + ".");
                return true;
            }
        }
            System.out.println(this.name + "'s potion belt is full! (Max " + MAX_CRYSTALS + " items.crystals)");
            return false;

    }

    public void useCrystral(int slotIndex) {
        if (!this.canAttack) {
            System.out.println(this.name + " cannot use items.crystals this turn!");
            return;
        }
        if (slotIndex < 0 || slotIndex >= this.crystals.length || this.crystals[slotIndex] == null) {
            System.out.println("No crystal in that slot!");
            return;
        }
        this.crystals[slotIndex].activate(this);
        if (this.crystals[slotIndex].isShattered()) {
            this.crystals[slotIndex] = null;
        }
    }

    public boolean removeEffectByType(Class<? extends Effect> effectClass) {
        boolean removed = false;
        for (int i = this.activeEffects.size() - 1; i >= 0; i--) {
            if (effectClass.isInstance(this.activeEffects.get(i))) {
                this.activeEffects.remove(i);
                removed = true;
            }
        }
        return removed;
    }

    public void showCrystals() {
        System.out.println(this.name + "'s Crystals:");
        for (int i = 0; i < this.crystals.length; i++) {
            if (this.crystals[i] != null) {
                System.out.println("  Slot " + (i + 1) + ": " + this.crystals[i].toString());
            } else {
                System.out.println("  Slot " + (i + 1) + ": [Empty]");
            }
        }
    }

    public void modifyBaseDamage(int amount) { this.baseDamage = Math.max(0, this.baseDamage + amount); }

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

    public void setCanAttack(boolean canAttack){this.canAttack = canAttack;}
    public boolean getCanAttack(){return this.canAttack;}

    public Effect getCurrentEffect(){return this.getCurrentEffect();}

    public Weapon getEquippedWeapon(){return this.equippedWeapon;}

    @Override
    public String toString() {
        String weaponName = (this.equippedWeapon != null) ? this.equippedWeapon.getName() : "None";
            return "Name:" + this.name + "\t Life:" + this.currentHealth + "/" + this.maxHealth + "HP" + "\t Damage:" +
                    this.baseDamage + "\tWeapon:" + weaponName ;
    }
}

