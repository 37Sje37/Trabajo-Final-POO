package effects;

import characters.GameCharacter;

public class Paralysis extends Effect{


    public Paralysis(int remainingTurns){
        super("Paralize",remainingTurns);
    }

     @Override
        public void applyEffect(GameCharacter target) {
         target.setCanAttack(false);
     }
}
