package effect;

import characters.GameCharacter;

public class Drain extends Effect{

    private final GameCharacter caster;
    private final int damageDealt;
    private final double drainPercentage;

    public Drain(GameCharacter caster, int damageDealt, double drainPercentage) {
        super("Drain", 1);
        this.caster = caster;
        this.damageDealt = damageDealt;
        this.drainPercentage = drainPercentage;
    }

    @Override
    public void applyEffect(GameCharacter target) {
        if (this.remainingTurns > 0) {
            // Pasamos de double a int redondeando para no perder precisión antes del casting[cite: 3]
            int healAmount = Math.max(1, (int) Math.round(this.damageDealt * this.drainPercentage));

            System.out.println(this.caster.getName() + " drains " + healAmount + " HP (55% of damage) from " + target.getName() + "!");

            if (this.caster.isAlive()) {
                this.caster.heal(healAmount);
            }
            this.remainingTurns = 0;
            this.caster.applyEffect(null);
        }
    }

    public String tostring(){
        return super.toString() + "\t Drains:" + this.drainPercentage;
    }
}
