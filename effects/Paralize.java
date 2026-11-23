package effects;

import characters.GameCharacter;

public class Paralize extends Effect{


    public Paralize(String name, int remainingTurns){
        super("Paralize",remainingTurns);
    }

     @Override
        public void applyEffect(GameCharacter target) {
         target.setCanAttack(false);
     }
}
