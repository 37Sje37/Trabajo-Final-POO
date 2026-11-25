package weapon.sword;

public class Elucidator extends Sword{

    private final double skillProbability;


    public Elucidator(int sharpness){
        super("Eclucidator", 70, sharpness);
        this.skillProbability = 0.30;
    }


    @Override
    public int getDamage() {
        int damage = super.getDamage();
        double currentSkillProb = this.skillProbability * this.getSharpnessRatio();

        this.decreaseSharpness(4);

        if (Math.random() < currentSkillProb) {
            System.out.println("Sword Skill activated: Vorpal Strike!");
            return damage * 2;
        }
        return damage;
    }

    @Override
    public String toString(){
        return super.toString() + "\t Skill Probability:" + this.skillProbability;
    }


}
