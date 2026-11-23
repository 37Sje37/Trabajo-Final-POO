package effects;

import characters.GameCharacter;

public class Burn extends Effect{

    int damageBurning;  //este efecto quita un daño concreto

    public Burn(String name, int remainingTurns, int damageBurning) {
        super("Burn",remainingTurns);
        this.damageBurning = damageBurning;
    }

     public int getDamageBurning(){
        return this.damageBurning;
     }

    @Override
    public void applyEffect(GameCharacter target) {
        System.out.println(target.getName() + " recieves " + getDamageBurning() +"pts os burning state");
        target.setCurrentHealth(target.getCurrentHealth() - getDamageBurning());
        this.decreaseTurn();
    }

    @Override
    public String toString(){
        return super.toString() + "\t Burning Damage: " + this.damageBurning;
     }


}
