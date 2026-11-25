package effect;

import characters.GameCharacter;

public class AttackBoost extends Effect {

    private final double boostPercentage; // Ej: 0.25 para +25%
    private int addedDamage;
    private boolean applied;

    public AttackBoost(int turns, double boostPercentage) {
        super("AttackBoost", turns);
        this.boostPercentage = boostPercentage;
        this.addedDamage = 0;
        this.applied = false;
    }


    @Override
    public void applyEffect(GameCharacter target) {
        if (!this.applied) {
            this.addedDamage = (int) Math.round(target.getBaseDamage() * this.boostPercentage);
            target.modifyBaseDamage(this.addedDamage);
            System.out.println(target.getName() + "'s attack power increases by "
                    + (int) (this.boostPercentage * 100) + "% (+" + this.addedDamage + " damage)!");
            this.applied = true;
        }

        this.remainingTurns--;

        if (this.remainingTurns <= 0) {
            target.modifyBaseDamage(-this.addedDamage);
            System.out.println(target.getName() + "'s Attack Boost wears off.");
        }
    }
}
