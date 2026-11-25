package items.crystals;

import characters.GameCharacter;
import effect.Burn;
import ornaments.Colors;

public class FrostCrystal extends Crystal{


    public FrostCrystal(){
        super("Frost Crystal");
    }


    @Override
    public boolean activate(GameCharacter target) {
        if (target.isAlive() && target.removeEffectByType(Burn.class)) {
            System.out.println(target.getName() + " shatters a " + this.name + " and extinguishes the flames!");
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
