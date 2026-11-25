package effect;

import characters.GameCharacter;

public class Bleed extends Effect{

    private final double healthPercentage; //este efecto quita en funcion de vida maxima

    public Bleed(int remainingTurns, int healthPercentage){
        super("Bleed",remainingTurns);
        this.healthPercentage = (double) healthPercentage /100 ;
    }

    public double getHealthPorcentage(){
        return this.healthPercentage;
    }

    @Override
    public void applyEffect(GameCharacter target) {
        System.out.println(target.getName() + " recieves " + target.getCurrentHealth()* this.getHealthPorcentage()/100 + "pts os bleeding state");
        target.setCurrentHealth((int)(target.getCurrentHealth() - (target.getCurrentHealth()* this.getHealthPorcentage())));
    }

    @Override
    public String toString(){
        return super.toString() + "\t Burning Damage: " + this.healthPercentage;
    }

}


