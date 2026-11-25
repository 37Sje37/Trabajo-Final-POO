package items.crystals;

import characters.GameCharacter;
import ornaments.Colors;

public class CoffeeCrystal extends Crystal{

    public CoffeeCrystal(){
        super("Coffee Crystal");
    }


    @Override
    public boolean activate(GameCharacter target) {
        if(!target.isAlive() || target.getCanAttack()){
            System.out.println("You can't use this right now");
            return false;
        }

        target.setCanAttack(true);
        return true;

    }

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tEffect: " + Colors.BRIGHT_YELLOW + "Cures Paralysis" + Colors.RESET;
    }
}
