package characters.enemies;

import characters.GameCharacter;
import ornaments.Colors;

public abstract class BacklineEnemy extends Enemy {

    protected double skillProbability;

    public BacklineEnemy(String name, int baseHealth, int baseDamage, int baseArmour, int baseXp, double skillProbability, int level) {
        super(name, baseHealth, baseDamage, baseArmour, baseXp, level);
        this.skillProbability = skillProbability;
    }

    @Override
    public void takeTurn(GameCharacter target) {
        if (!this.isAlive()) return;
        if (!this.canAttack) {
            System.out.println(this.name + " cannot act from the backline this turn!");
            return;
        }

        if (Math.random() < this.skillProbability) {
            useRangedSkill(target);
        } else {
            this.attack(target);
        }
    }

    protected abstract void useRangedSkill(GameCharacter target);

    @Override
    public String toString() {
        return Colors.PURPLE + "[BACKLINE] " + Colors.RESET + super.toString();
    }
}