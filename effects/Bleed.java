package effects;

import characters.GameCharacter;

public class Bleed extends Effect{

    int healthPorcentage; //este efecto quita en funcion de vida maxima

    public Bleed(String name, int remainingTurns, int healthPorcentage){
        super("Bleed",remainingTurns);
        this.healthPorcentage = healthPorcentage /100 ;
    }

    public int getHealthPorcentage(){
        return this.healthPorcentage;
    }

    @Override
    public void applyEffect(GameCharacter target) {
        System.out.println(target.getName() + " recieves " + target.getCurrentHealth()* this.getHealthPorcentage()/100 + "pts os bleeding state");
        target.setCurrentHealth(target.getCurrentHealth() - (target.getCurrentHealth()* this.getHealthPorcentage()/100));
    }

    @Override
    public String toString(){
        return super.toString() + "\t Burning Damage: " + this.healthPorcentage;
    }

}


