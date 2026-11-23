package effects;

import characters.GameCharacter;

public class Bleed extends Effect{

    private double healthPorcentage; //este efecto quita en funcion de vida maxima

    public Bleed(int remainingTurns, int healthPorcentage){
        super("Bleed",remainingTurns);
        this.healthPorcentage = healthPorcentage /100 ;
    }

    public double getHealthPorcentage(){
        return this.healthPorcentage;
    }

    @Override
    public void applyEffect(GameCharacter target) {
        System.out.println(target.getName() + " recieves " + target.getCurrentHealth()* this.getHealthPorcentage()/100 + "pts os bleeding state");
        target.setCurrentHealth((int)(target.getCurrentHealth() - (target.getCurrentHealth()* this.getHealthPorcentage())));
    }

    @Override
    public String toString(){
        return super.toString() + "\t Burning Damage: " + this.healthPorcentage;
    }

    public void setHealthPorcentage(double healthPorcentage){this.healthPorcentage = healthPorcentage;}

}


