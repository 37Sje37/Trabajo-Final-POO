package items.crystals;

import characters.GameCharacter;
import effect.Burn;
import ornaments.Colors;

public class FrostCrystal extends Crystal {

    public FrostCrystal(int level) {
        super("Frost Crystal", level);
    }

    public FrostCrystal() {
        this(1);
    }

    @Override
    public boolean activate(GameCharacter target) {
        if (!this.shattered && target.isAlive() && target.removeEffectByType(Burn.class)) {
            this.shattered = true;
            System.out.println(target.getName() + " shatters a " + this.name + " (Lv." + this.level +
                    ") and extinguishes the flames!");
            return true;
        }
        System.out.println(target.getName() + " is not burning right now.");
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tEffect: " + Colors.BRIGHT_CYAN + "Extinguishes Burn effect" + Colors.RESET;
    }
}