package characters.enemies.world2;

import characters.GameCharacter;
import characters.enemies.BacklineEnemy;
import effect.Burn;

public class SalamanderMage extends BacklineEnemy {

    public SalamanderMage(int level) {
        // Nombre, Vida base, Daño base, Armadura base, XP base, Probabilidad habilidad, Nivel
        super("Salamander Mage", 55, 14, 4, 34, 0.45, level);
    }

    @Override
    protected void useRangedSkill(GameCharacter target) {
        int fireDamage = (int) Math.round(this.baseDamage * 1.3);
        System.out.println(this.name + " casts Flame Burst from the backline for " + fireDamage + " damage!");
        target.takeDamage(fireDamage);
        target.applyEffect(new Burn(2, 4 + this.level));
    }
}