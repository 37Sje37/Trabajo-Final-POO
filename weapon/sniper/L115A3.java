package weapon.sniper;

import characters.GameCharacter;
import effects.Paralysis;

public class L115A3 extends SniperRifle{

    private final double critProbability;
    private final double stunProbability;

    public L115A3(){
        super("Accuracy International L115A3", 30, 10);
        this.critProbability = 0.45;
        this.stunProbability = 0.35;
    }

    @Override
    public int getDamage() {

        if(this.currentAmmo == 0) {
            super.getDamage();
        }
        int damage = this.baseDamage;

        if(Math.random() < this.critProbability){
            int critBullet = (int) Math.round(this.baseDamage*1.6);
            return critBullet;
        }
        return damage;
    }

    @Override
    public void applyWeaponEffect(GameCharacter attacker, GameCharacter target) {
        if(Math.random() < this.stunProbability){
            System.out.println("Your bullet has penetrate on the enemy and give Paralysis");
            target.setCurrentEffect(new Paralysis(1));
        }
    }

    @Override
    public String toString(){
        return super.toString() + "\tCritic Probability:" +  this.critProbability +
                "\t Strun Probability:" + this.stunProbability;
    }



}
