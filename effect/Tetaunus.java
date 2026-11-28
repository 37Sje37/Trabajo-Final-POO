package effect;

import characters.GameCharacter;

public class Tetaunus extends Effect{

    public Tetaunus(){
        super("Tetanus", 1);

    }

    @Override
    public void applyEffect(GameCharacter target) {
        int i = 0;
        while ( i != 3){

            target.takeDamage(2);
            System.out.println("Tetanus gives u 2 pts of damage");
        }
        this.decreaseTurn();
    }
}
