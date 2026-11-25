package items.weapon.sword;

import ornaments.Colors;

public class Elucidator extends Sword {

    private double skillProbability;

    public Elucidator(int sharpness, int level) {
        super("Elucidator", 70, sharpness, level);
        recalculateSkillProbability();
    }

    private void recalculateSkillProbability() {
        this.skillProbability = Math.min(1.0, 0.30 + 0.03 * this.level);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        recalculateSkillProbability();
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
        recalculateSkillProbability();
    }

    @Override
    public int getDamage() {
        int damage = super.getDamage();
        double currentSkillProb = this.skillProbability * this.getSharpnessRatio();

        if (this.sharpness > 0 && Math.random() < currentSkillProb) {
            System.out.println(Colors.PURPLE + "Sword Skill activated: Vorpal Strike!" + Colors.RESET);
            return damage * 2;
        }
        return damage;
    }

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tSkill Probability: " + Colors.CYAN +
                (int) Math.round(this.skillProbability * 100) + "%" + Colors.RESET;
    }
}
