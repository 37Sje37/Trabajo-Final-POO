package characters.enemies.world3;

import characters.GameCharacter;
import characters.enemies.BacklineEnemy;
import effect.Paralysis;

public class SkullReaper extends BacklineEnemy {

    public SkullReaper(int level) {
        // Nombre, Vida base, Daño base, Armadura base, XP base, Probabilidad habilidad, Nivel
        super("The Skull Reaper", 75, 19, 8, 52, 0.40, level);
    }

    @Override
    protected void useRangedSkill(GameCharacter target) {
        int scytheDamage = (int) Math.round(this.baseDamage * 1.35);
        System.out.println(this.name + " lashes out with Bone Scythe Sweep from the backline for " + scytheDamage + " damage!");
        target.takeDamage(scytheDamage);
        target.applyEffect(new Paralysis(1));
    }
}