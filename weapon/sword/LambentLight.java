package weapon.sword;

public class LambentLight extends Sword{

    private final int maxComboHits;
    private final double comboProbability;

    public LambentLight(int sharpness) {
        super("Lambent Light", 30, sharpness);
        this.maxComboHits = 4;        // Máximo de golpes con filo al 100%
        this.comboProbability = 0.65; // 65% de probabilidad base de activar combo
    }

    public int getMaxComboHits() {
        return Math.max(1, (int) Math.round(this.maxComboHits * this.getSharpnessRatio()));
    }

    @Override
    public int getDamage() {
        int singleHitDamage = super.getDamage();
        double currentComboProb = this.comboProbability * this.getSharpnessRatio();

        int hits = 1;
        if (this.sharpness > 0 && Math.random() < currentComboProb) {
            int effectiveMaxHits = this.getMaxComboHits();
            hits = (int) (Math.random() * effectiveMaxHits) + 1;
            System.out.println(this.name + " unleashes a rapid combo of " + hits + " thrust(s)!");
        }

        this.decreaseSharpness(hits * 3);
        return singleHitDamage * hits;
    }

    @Override
    public String toString(){
        return super.toString() + "\tCombo Probability: " + this.comboProbability +
                "\t Max combo Hits: " + this.maxComboHits;
    }
}
