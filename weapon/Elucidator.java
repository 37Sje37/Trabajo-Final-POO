package weapon;

import characters.GameCharacter;

public class Elucidator extends Sword{

    protected int heavyBlowProbability;


    public Elucidator(String name, int baseDamage, double sharpness, int heavyBlowProbability){
        super(name, baseDamage, sharpness);
        this.heavyBlowProbability = heavyBlowProbability;
    }

    @Override
    public int getDamage(){
        if(Math.random() < sharpness){
            return this.baseDamage;
        }else{
            return  (int)(1.5 *this.baseDamage);
        }
    }

    public void applyEffectWeapon(GameCharacter target){
        if(Math.random() < this.heavyBlowProbability);

    }

    @Override
    public String toString(){
        return super.toString() + "\t Heavy Blow Probability:" + this.heavyBlowProbability ;
    }


}
