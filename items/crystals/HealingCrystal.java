package items.crystals;

import characters.GameCharacter;
import ornaments.Colors;

public class HealingCrystal extends Crystal {

    private int healAmount;

    public HealingCrystal(){
        super("Healing Crystal");
        this.healAmount = 30;
    }


    @Override
    public boolean activate(GameCharacter target) {
        if(!target.isAlive()){return false;}

        target.setCurrentHealth(target.getCurrentHealth()+this.healAmount);
        return true;
    }

    public void setHealAmount(int healAmount){this.healAmount = healAmount;}

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tHeal: " + Colors.BRIGHT_GREEN + this.healAmount + " HP" + Colors.RESET;
    }
}
