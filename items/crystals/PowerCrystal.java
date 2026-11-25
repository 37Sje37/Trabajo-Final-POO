package items.crystals;

import characters.GameCharacter;
import effect.AttackBoost;
import ornaments.Colors;

public class PowerCrystal extends Crystal {

    private final double boostPercentage;
    private final int durationTurns;

    public PowerCrystal(){
        super("Power Crystal");
        this.boostPercentage =0.25;
        this.durationTurns = 2;
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
        return super.toString() + Colors.GRAY + "\tBoost: " + Colors.PINK + "+" + (int) (this.boostPercentage * 100) + "%" +
                Colors.GRAY + "\tDuration: " + Colors.BRIGHT_PURPLE + this.durationTurns + " turns" + Colors.RESET;
    }
}
