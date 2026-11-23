package weapon.sword;

public class LambentLight extends Sword{

    private int maxComboHits;
    private int comoProbability;

    public LambentLight(String name, int baseDamage,double apperanceProbability, int sharpness){
        super("Lambent Light",30,apperanceProbability,sharpness);
    }

    public int getMaxComboHits(){
        return this.maxComboHits;
    }
    @Override
    public int getDamage() {
        int singleHitDamage = super.getDamage();
        int effectiveMaxHits = Math.max(1, (int) Math.round(this.maxComboHits * this.getSharpnessRatio()));
        int hits = (int) (Math.random() * effectiveMaxHits) + 1;

        this.decreaseSharpness(hits * 3);

        System.out.println(this.name + " unleashes a rapid combo of " + hits + " thrust(s)!");
        return singleHitDamage * hits;
    }

    @Override
    public String toString(){
        return super.toString() + "\tCombo Probability: " + this.comoProbability +
                "\t Max combo Hits: " + this.maxComboHits;
    }
}
