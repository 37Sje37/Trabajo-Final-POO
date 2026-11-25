package crystals;

import characters.GameCharacter;
import effects.AttackBoost;

public class PowerCrystal extends Crystal {

    private final double boostPercentage;
    private final int durationTurns;

    public PowerCrystal(double boostPercentage, int durationTurns){
        super("Power Crystal");
        this.boostPercentage =boostPercentage;
        this.durationTurns = durationTurns;
    }

    @Override
    public boolean activate(GameCharacter target) {
        if(!target.isAlive()){
            System.out.println("The  target is not alive");
            return false;
        }

        System.out.println(target.getName() + " shatters a " + this.name + "!");
        target.applyEffect(new AttackBoost(this.durationTurns,this.boostPercentage));
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "\tBoost: +" + (int) (this.boostPercentage * 100) + "%\tDuration: " + this.durationTurns + " turns";
    }
}
