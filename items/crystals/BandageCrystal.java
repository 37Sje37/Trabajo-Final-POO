package items.crystals;

import characters.GameCharacter;
import effect.Bleed;
import ornaments.Colors;

public class BandageCrystal extends Crystal{

    private final int healingAmount;

    public BandageCrystal(){
        super("Bandage Crystal");
        this.healingAmount=30;
    }


    @Override
    public boolean activate(GameCharacter target) {
        if (target.isAlive() && target.removeEffectByType(Bleed.class)) {
            System.out.println(target.getName() + " uses a " + this.name + " and stops the bleeding!");
            return true;
        }
        System.out.println(target.getName() + " is not bleeding right now.");
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tEffect: " + Colors.LIME + "Cures Bleed" + Colors.RESET;
    }
}
