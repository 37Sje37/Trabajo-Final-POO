package effect;

import characters.GameCharacter;

public class Paralysis extends Effect{


    public Paralysis(int remainingTurns){
        super("Paralysis",remainingTurns);
    }

     @Override
        public void applyEffect(GameCharacter target) {
         target.setCanAttack(false);
         this.decreaseTurn();
     }
}
