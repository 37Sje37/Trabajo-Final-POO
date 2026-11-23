package weapon;

public class AnnealBlade extends Sword{
    int bleedProbability;

    public AnnealBlade(String name, int baseDamage, double criticProbability){
        super("Anneal Blade",20, 40);
        this.bleedProbability = 30;
    }

    public void setBleedProbability(int bleedProbability) {
        this.bleedProbability = bleedProbability;
    }

    @Override
    public int getDamage(){

    }
}
