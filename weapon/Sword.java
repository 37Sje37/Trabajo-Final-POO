package weapon;

public class Sword extends Weapon{

    double criticProbability;
    public Sword(String name, int baseDamage, double criticProbability){
        super(name, baseDamage);
        this.criticProbability = criticProbability;
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
        return "Name:" +this.name + "\tDamage:" +this.baseDamage+ "\tCritic Probability :" + this.criticProbability;
}

}
