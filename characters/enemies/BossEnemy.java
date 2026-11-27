package characters.enemies;

import characters.GameCharacter;
import ornaments.Colors;

public abstract class BossEnemy extends Enemy {

    protected boolean enraged;
    protected int turnCounter;

    public BossEnemy(String name, int baseHealth, int baseDamage, int baseArmour, int baseXp, int level) {
        super(name, baseHealth, baseDamage, baseArmour, baseXp, level);
        this.enraged = false;
        this.turnCounter = 0;
    }

    @Override
    public void takeTurn(GameCharacter target) {
        if (!this.isAlive()) return;
        if (!this.canAttack) {
            System.out.println(this.name + " breaks free from stun preparations and loses a turn!");
            return;
        }

        this.turnCounter++;

        // Fase 2 al bajar del 50% de vida
        if (!this.enraged && this.currentHealth <= this.maxHealth / 2) {
            this.enraged = true;
            this.modifyBaseDamage((int) Math.round(this.baseDamage * 0.25));
            System.out.println(Colors.BRIGHT_RED + "BOSS PHASE 2: " + this.name + " enters a frenzy (+25% ATK)!" + Colors.RESET);
        }

        // Cada 3 turnos lanza su definitiva; el resto alterna habilidad o ataque básico
        if (this.turnCounter % 3 == 0) {
            useUltimateAbility(target);
        } else if (Math.random() < 0.45) {
            useSignatureSkill(target);
        } else {
            this.attack(target);
        }
    }

    protected abstract void useSignatureSkill(GameCharacter target);
    protected abstract void useUltimateAbility(GameCharacter target);

    @Override
    public String toString() {
        return Colors.GOLD + "[BOSS] " + Colors.RESET + super.toString();
    }
}
