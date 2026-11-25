package items.crystals;

import characters.GameCharacter;
import effect.Paralysis;
import ornaments.Colors;

public class CoffeeCrystal extends Crystal {

    public CoffeeCrystal(int level) {
        super("Coffee Crystal", level);
    }

    public CoffeeCrystal() {
        this(1);
    }

    @Override
    public boolean activate(GameCharacter target) {
        if (this.shattered || !target.isAlive() || target.getCanAttack()) {
            System.out.println("You can't use this right now.");
            return false;
        }

        target.removeEffectByType(Paralysis.class);
        target.setCanAttack(true);
        this.shattered = true;

        System.out.println(target.getName() + " uses a " + this.name + " (Lv." + this.level +
                ") and shakes off the Paralysis!");
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tEffect: " + Colors.BRIGHT_YELLOW + "Cures Paralysis" + Colors.RESET;
    }
}