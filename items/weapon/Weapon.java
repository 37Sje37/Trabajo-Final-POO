package items.weapon;

import characters.GameCharacter;
import ornaments.Colors;

public abstract class Weapon {
    protected String name;
    protected int baseDamage;
    protected int level;

    public Weapon(String name, int baseDamage, int level) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.level = Math.max(1, level);
    }

    public int getScaledBaseDamage() {
        double multiplier = 1.0 + (this.level - 1) * 0.15;
        return (int) Math.round(this.baseDamage * multiplier);
    }

    public int getDamage() {
        return getScaledBaseDamage();
    }

    public void levelUp() {
        ++this.level;
    }

    public void setLevel(int level) {
        this.level = Math.max(1, level);
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public void applyWeaponEffect(GameCharacter attacker, GameCharacter target) {}

    public void castSpellEffect(GameCharacter attacker, GameCharacter target) {}

    @Override
    public String toString() {
        return Colors.GRAY + "Name: " + Colors.CYAN + this.name + " (Lv." + this.level + ")" +
                Colors.GRAY + "\tDamage: " + Colors.RED + this.getScaledBaseDamage() + Colors.RESET;
    }
}