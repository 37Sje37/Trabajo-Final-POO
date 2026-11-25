package items.crystals;

import characters.GameCharacter;
import effect.AttackBoost;
import ornaments.Colors;

public class PowerCrystal extends Crystal {

    private final double baseBoostPercentage;
    private final int baseDurationTurns;

    public PowerCrystal(int level) {
        super("Power Crystal", level);
        this.baseBoostPercentage = 0.25;
        this.baseDurationTurns = 2;
    }

    public PowerCrystal() {
        this(1);
    }

    public double getBoostPercentage() {
        // +3% de ataque extra por cada nivel adicional (25% a Lv.1, 28% a Lv.2, etc.)
        return this.baseBoostPercentage + (this.level - 1) * 0.03;
    }

    public int getDurationTurns() {
        // +1 turno extra cada 3 niveles (2 turnos en Lv.1-2, 3 turnos en Lv.3-5, etc.)
        return this.baseDurationTurns + ((this.level - 1) / 3);
    }

    @Override
    public boolean activate(GameCharacter target) {
        if (this.shattered || !target.isAlive()) {
            System.out.println("The target is not alive or the crystal is already shattered.");
            return false;
        }

        double currentBoost = getBoostPercentage();
        int currentDuration = getDurationTurns();
        this.shattered = true;

        System.out.println(target.getName() + " shatters a " + this.name + " (Lv." + this.level + ")!");
        target.applyEffect(new AttackBoost(currentDuration, currentBoost));
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tBoost: " + Colors.PINK + "+" + (int) Math.round(getBoostPercentage() * 100) + "%" +
                Colors.GRAY + "\tDuration: " + Colors.BRIGHT_PURPLE + getDurationTurns() + " turns" + Colors.RESET;
    }
}