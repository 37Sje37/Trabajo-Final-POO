package characters.enemies;

import characters.GameCharacter;
import ornaments.Colors;

public abstract class Enemy extends GameCharacter {

    protected int level;
    protected int xpReward;

    public Enemy(String name, int baseHealth, int baseDamage, int baseArmour, int baseXp, int level) {
        super(
                name,
                scaleStat(baseHealth, level),
                scaleStat(baseDamage, level),
                Math.min(70, baseArmour + (level - 1) * 2)
        );
        this.level = Math.max(1, level);
        this.xpReward = scaleStat(baseXp, this.level);
    }

    protected static int scaleStat(int baseValue, int level) {
        int validLevel = Math.max(1, level);
        double multiplier = 1.0 + (validLevel - 1) * 0.15;
        return (int) Math.round(baseValue * multiplier);
    }

    public abstract void takeTurn(GameCharacter target);

    public int getLevel() {
        return this.level;
    }

    public int getXpReward() {
        return this.xpReward;
    }

    @Override
    public String toString() {
        return Colors.CRIMSON + "[Lv." + this.level + "] " + Colors.RESET + super.toString() +
                Colors.GRAY + "\tXP: " + Colors.GOLD + this.xpReward + Colors.RESET;
    }
}

