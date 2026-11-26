package characters.enemies.world3;

import characters.GameCharacter;
import characters.enemies.BossEnemy;
import effect.Paralysis;

public class HeathcliffBoss extends BossEnemy {

    public HeathcliffBoss(int level) {
        // Nombre, Vida base, Daño base, Armadura base, XP base, Nivel
        super("Heathcliff, The Paladin", 300, 26, 25, 300, level);
    }

    @Override
    protected void useSignatureSkill(GameCharacter target) {
        int strikeDamage = (int) Math.round(this.baseDamage * 1.45);
        System.out.println(this.name + " bashes with his Liberator Shield and casts Divine Judgement for " + strikeDamage + " damage!");
        target.takeDamage(strikeDamage);
        target.applyEffect(new Paralysis(1));
    }

    @Override
    protected void useUltimateAbility(GameCharacter target) {
        int ultDamage = (int) Math.round(this.baseDamage * 2.25);
        System.out.println(this.name + " unleashes System Command: Sacred Eclipse for " + ultDamage + " catastrophic damage!");
        target.takeDamage(ultDamage);
    }
}