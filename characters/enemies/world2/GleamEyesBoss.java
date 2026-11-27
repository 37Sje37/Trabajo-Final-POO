package characters.enemies.world2;

import characters.GameCharacter;
import characters.enemies.BossEnemy;
import effect.Burn;

public class GleamEyesBoss extends BossEnemy {

    public GleamEyesBoss(int level) {
        // Nombre, Vida base, Daño base, Armadura base, XP base, Nivel
        super("The Gleam Eyes", 220, 20, 14, 180, level);
    }

    @Override
    protected void useSignatureSkill(GameCharacter target) {
        int slashDamage = (int) Math.round(this.baseDamage * 1.45);
        System.out.println(this.name + " swings its Demonic Cleaver with Hellfire Slash for " + slashDamage + " damage!");
        target.takeDamage(slashDamage);
        target.applyEffect(new Burn(3, 5 + this.level));
    }

    @Override
    protected void useUltimateAbility(GameCharacter target) {
        int ultDamage = (int) Math.round(this.baseDamage * 2.1);
        System.out.println(this.name + " unleashes Abyssal Roar and Blue-Eyed Frenzy for " + ultDamage + " devastating damage!");
        target.takeDamage(ultDamage);
        target.applyEffect(new Burn(2, 7 + this.level));
    }
}