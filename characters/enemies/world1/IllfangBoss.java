package characters.enemies.world1;

import characters.GameCharacter;
import characters.enemies.BossEnemy;
import effect.Bleed;

public class IllfangBoss extends BossEnemy {

    public IllfangBoss(int level) {
        // Nombre, Vida base, Daño base, Armadura base, XP base, Nivel
        super("Illfang the Kobold Lord", 160, 15, 10, 100, level);
    }

    @Override
    protected void useSignatureSkill(GameCharacter target) {
        int cleaveDamage = (int) Math.round(this.baseDamage * 1.4);
        System.out.println(this.name + " swings his Bone Axe with Crimson Cleave for " + cleaveDamage + " damage!");
        target.takeDamage(cleaveDamage);
        target.applyEffect(new Bleed(2, 4 + this.level));
    }

    @Override
    protected void useUltimateAbility(GameCharacter target) {
        int ultDamage = (int) Math.round(this.baseDamage * 2.0);
        System.out.println(this.name + " draws his Talwar and unleashes Tyrant's Execution for " + ultDamage + " massive damage!");
        target.takeDamage(ultDamage);
    }
}