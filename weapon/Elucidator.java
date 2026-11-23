package weapon;

public class Elucidator extends Sword{

    protected int heavyBlowProbability;


    public Elucidator(String name, int baseDamage, double criticProbability, int heavyBlowProbability){
        super(name, baseDamage, criticProbability);
        this.heavyBlowProbability = heavyBlowProbability;
    }

    @Override
    public int getDamage(){
        if(Math.random() < criticProbability){
            return this.baseDamage;
        }else{
            return  (int)(1.5 *this.baseDamage);
        }
    }

    @Override
    public String toString(){
        return super.toString() + "\t Heavy Blow Probability:" + this.heavyBlowProbability ;
    }


}
