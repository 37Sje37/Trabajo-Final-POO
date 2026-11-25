package crystals;

import characters.GameCharacter;

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
}
