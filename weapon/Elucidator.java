package weapon;

import characters.GameCharacter;

public class Elucidator extends Sword{

    protected double skillProbability;


    public Elucidator(){
        super("Eclucidator", 70, 100);
        this.skillProbability = 0.30;
    }

    @Override
    public int getDamage(){
        int damage = super.getDamage();
        this.decreaseSharpness(10);

        if(Math.random() < skillProbability){
            System.out.println("Sword Skill activated: Vorpal Strike!");
            damage = (int)(damage*1.5);
        }
        return damage;
    }

    @Override
    public String toString(){
        return super.toString() + "\t Skill Probability:" + this.skillProbability;
    }


}
