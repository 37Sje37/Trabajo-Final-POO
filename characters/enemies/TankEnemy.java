package characters.enemies;

import characters.GameCharacter;
import ornaments.Colors;

public class TankEnemy extends Enemy {

    protected int baseArmourValue;
    protected boolean fortified;

    public TankEnemy(String name, int baseHealth, int baseDamage, int baseArmour, int baseXp, int level) {
        super(name, baseHealth, baseDamage, baseArmour, baseXp, level);
        this.baseArmourValue = this.armour;
        this.fortified = false;
    }

    @Override
    public void takeTurn(GameCharacter target) {
        if (!this.isAlive()) return;
        if (!this.canAttack) {
            System.out.println(this.name + " cannot move this turn!");
            return;
        }

        // Si estaba fortificado del turno anterior, vuelve a su armadura normal
        if (this.fortified) {
            this.armour = this.baseArmourValue;
            this.fortified = false;
        }

        // 35% de probabilidad de subir su escudo (+15 armadura este turno); 65% de atacar
        if (Math.random() < 0.35) {
            fortify();
        } else {
            this.attack(target);
        }
    }

    protected void fortify() {
        this.fortified = true;
        this.armour = Math.min(80, this.baseArmourValue + 15);
        System.out.println(Colors.CYAN + this.name + " raises its guard! Armour increased to " + this.armour + "%." + Colors.RESET);
    }

    @Override
    public String toString() {
        return Colors.CYAN + "[TANK] " + Colors.RESET + super.toString();
    }
}