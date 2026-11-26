package items.crystals;

import characters.GameCharacter;
import ornaments.Colors;

public class HealingCrystal extends Crystal {

    private int baseHealAmount;

    public HealingCrystal(int level) {
        super("Healing Crystal", level);
        this.baseHealAmount = 30;
    }

    public HealingCrystal() {
        this(1);
    }

    public int getHealAmount() {
        return scaleValue(this.baseHealAmount);
    }

    @Override
    public boolean activate(GameCharacter target) {
        if (this.shattered || !target.isAlive()) {
            return false;
        }

        int heal = getHealAmount();
        target.heal(heal);
        this.shattered = true;

        System.out.println(target.getName() + " uses a " + this.name + " (Lv." + this.level +
                ") and recovers " + heal + " HP!");
        return true;
    }

    public void setHealAmount(int baseHealAmount) {
        this.baseHealAmount = baseHealAmount;
    }

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tHeal: " + Colors.BRIGHT_GREEN + getHealAmount() + " HP" + Colors.RESET;
    }
}