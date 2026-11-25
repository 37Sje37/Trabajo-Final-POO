package items.crystals;

import characters.GameCharacter;
import ornaments.Colors;

public abstract class Crystal {

    protected String name;
    protected boolean shattered;
    protected int level;

    public Crystal(String name, int level) {
        this.name = name;
        this.shattered = false; // false = utilizable
        this.level = Math.max(1, level);
    }

    // Constructor por defecto a nivel 1 por compatibilidad
    public Crystal(String name) {
        this(name, 1);
    }

    public abstract boolean activate(GameCharacter target);

    protected int scaleValue(int baseValue) {
        double multiplier = 1.0 + (this.level - 1) * 0.15;
        return (int) Math.round(baseValue * multiplier);
    }

    public String getName() {
        return this.name;
    }

    public boolean isShattered() {
        return this.shattered;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = Math.max(1, level);
    }

    public void levelUp() {
        ++this.level;
    }

    @Override
    public String toString() {
        return Colors.GRAY + "Name: " + Colors.CYAN + this.name + " (Lv." + this.level + ")" + Colors.RESET;
    }
}