package characters;

import effect.Effect;
import items.crystals.Crystal;
import items.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class GameCharacter {

    private static final int MAX_CRYSTALS = 2;

    protected String name;
    protected int currentHealth;
    protected int maxHealth;
    protected int baseDamage;
    protected int armour;
    protected int level;
    protected int xp;
    protected int xpToNextLevel;
    protected boolean canAttack;
    protected Weapon equippedWeapon;
    private List<Effect> activeEffects;
    private Crystal[] crystals;

    // Constructor original (por defecto empieza en nivel 1)
    public GameCharacter(String name, int maxHealth, int damage, int armour) {
        this(name, maxHealth, damage, armour, 1);
    }

    public GameCharacter(String name, int maxHealth, int damage, int armour, int level) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.baseDamage = damage;
        this.armour = armour;
        this.level = Math.max(1, level);
        this.xp = 0;
        this.xpToNextLevel = calculateXpForNextLevel(this.level);
        this.canAttack = true;
        this.equippedWeapon = null;
        this.activeEffects = new ArrayList<>();
        this.crystals = new Crystal[MAX_CRYSTALS];
    }

    private int calculateXpForNextLevel(int currentLevel) {
        return 100 * currentLevel;
    }

    public void gainXp(int amount) {
        if (amount <= 0) return;
        this.xp += amount;
        System.out.println(this.name + " gains " + amount + " XP! (" + this.xp + "/" + this.xpToNextLevel + ")");

        while (this.xp >= this.xpToNextLevel) {
            this.xp -= this.xpToNextLevel;
            levelUp();
        }
    }

    protected void levelUp() {
        this.level++;
        this.xpToNextLevel = calculateXpForNextLevel(this.level);

        // Escalado de +15% por nivel en vida y daño, y +2 en armadura
        this.maxHealth = (int) Math.round(this.maxHealth * 1.15);
        this.currentHealth = this.maxHealth; // Restaura vida al subir de nivel
        this.baseDamage = (int) Math.round(this.baseDamage * 1.15);
        this.armour = Math.min(80, this.armour + 2);

        System.out.println("LEVEL UP! " + this.name + " reached Level " + this.level + "!");
        System.out.println("  -> Max HP: " + this.maxHealth + " | Base ATK: " + this.baseDamage + " | Armour: " + this.armour + "%");
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

        if (this.equippedWeapon != null) {
            this.equippedWeapon.applyWeaponEffect(this, target);
        }
    }

    public void takeDamage(int damageIncoming) {
        double reduction = Math.min(1.0, Math.max(0.0, this.armour / 100.0));
        int finalDamage = (int) Math.round(damageIncoming * (1.0 - reduction));
        System.out.println(this.name + " receives " + finalDamage + " damage!");
        this.currentHealth = Math.max(0, this.currentHealth - finalDamage);
    }

    public void applyEffect(Effect newEffect) {
        if (newEffect == null) return;

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

    public void heal(int amount) {
        this.currentHealth = Math.min(this.maxHealth, this.currentHealth + amount);
        System.out.println(this.name + " heals and now has " + this.currentHealth + "/" + this.maxHealth + " HP");
    }

    public boolean addCrystal(Crystal crystal) {
        for (int i = 0; i < MAX_CRYSTALS; i++) {
            if (this.crystals[i] == null) {
                this.crystals[i] = crystal;
                System.out.println(this.name + " stored " + crystal.getName() + " in slot " + (i + 1) + ".");
                return true;
            }
        }
        System.out.println(this.name + "'s potion belt is full! (Max " + MAX_CRYSTALS + " crystals)");
        return false;
    }

    public void useCrystal(int slotIndex) {
        if (!this.canAttack) {
            System.out.println(this.name + " cannot use crystals this turn!");
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

    public void modifyBaseDamage(int amount) {
        this.baseDamage = Math.max(0, this.baseDamage + amount);
    }

    public boolean isAlive() {
        return this.currentHealth > 0;
    }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public int getCurrentHealth() { return this.currentHealth; }
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = Math.max(0, Math.min(this.maxHealth, currentHealth));
    }

    public int getMaxHealth() { return this.maxHealth; }
    public void setMaxHealth(int maxHealth){this.maxHealth = maxHealth;}

    public int getBaseDamage() { return this.baseDamage; }
    public void setBaseDamage(int baseDamage) { this.baseDamage = baseDamage; }

    public void setArmour(int armour) { this.armour = armour; }
    public int getArmour() { return this.armour; }

    public int getLevel() { return this.level; }
    public int getXp() { return this.xp; }
    public int getXpToNextLevel() { return this.xpToNextLevel; }

    public void setCanAttack(boolean canAttack) { this.canAttack = canAttack; }
    public boolean getCanAttack() { return this.canAttack; }

    public Effect getCurrentEffect() {
        return this.activeEffects.isEmpty() ? null : this.activeEffects.get(0);
    }

    public Weapon getEquippedWeapon() { return this.equippedWeapon; }

    @Override
    public String toString() {
        String weaponName = (this.equippedWeapon != null) ? this.equippedWeapon.getName() : "None";
        return "Lv." + this.level + " " + this.name + "\tLife: " + this.currentHealth + "/" + this.maxHealth + " HP" +
                "\tDamage: " + this.baseDamage + "\tWeapon: " + weaponName +
                "\tXP: " + this.xp + "/" + this.xpToNextLevel;
    }
}