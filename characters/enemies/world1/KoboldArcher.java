package characters.enemies.world1;

import characters.GameCharacter;
import characters.enemies.BacklineEnemy;
import effect.Bleed;

public class KoboldArcher extends BacklineEnemy {

    public KoboldArcher(int level) {
        // Nombre, Vida base, Daño base, Armadura base, XP base, Probabilidad habilidad, Nivel
        super("Kobold Archer", 45, 11, 2, 22, 0.40, level);
    }

    @Override
    protected void useRangedSkill(GameCharacter target) {
        int shotDamage = (int) Math.round(this.baseDamage * 1.25);
        System.out.println(this.name + " fires a Jagged Arrow from the backline for " + shotDamage + " damage!");
        target.takeDamage(shotDamage);
        target.applyEffect(new Bleed(2, 3 + this.level));
    }
}