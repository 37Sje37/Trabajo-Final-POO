package items.crystals;

import characters.GameCharacter;
import effect.Bleed;
import ornaments.Colors;

public class BandageCrystal extends Crystal {

    private final int baseHealingAmount;

    public BandageCrystal(int level) {
        super("Bandage Crystal", level);
        this.baseHealingAmount = 30;
    }

    public BandageCrystal() {
        this(1);
    }

    public int getHealingAmount() {
        return scaleValue(this.baseHealingAmount);
    }

    @Override
    public boolean activate(GameCharacter target) {
        if (!this.shattered && target.isAlive() && target.removeEffectByType(Bleed.class)) {
            int heal = getHealingAmount();
            target.heal(heal); // o el método de curación de GameCharacter
            this.shattered = true;
            System.out.println(target.getName() + " uses a " + this.name + " (Lv." + this.level +
                    "), stops the bleeding and recovers " + heal + " HP!");
            return true;
        }
        System.out.println(target.getName() + " is not bleeding right now.");
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tEffect: " + Colors.LIME +
                "Cures Bleed & +" + getHealingAmount() + " HP" + Colors.RESET;
    }
}