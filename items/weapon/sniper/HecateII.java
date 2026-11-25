package items.weapon.sniper;

import characters.GameCharacter;
import effect.Bleed;
import ornaments.Colors;

public class HecateII extends SniperRifle{

    private double headshootProbability;

    public HecateII(){
        super("PGM Ultima Ratio Hecate II", 30, 8);
        this.headshootProbability = 0.3;
    }

    @Override
    public int getDamage(){

        if(this.currentAmmo  == 0) {
            super.getDamage();
        }
        int damage = super.getDamage();

        if(Math.random() < this.headshootProbability){
            int headshotDamage = (int) Math.round(damage * 1.8);
            System.out.println(this.name + " lands a Phantom Bullet Headshot for " + headshotDamage + " damage!");
            return headshotDamage;
        }
        return damage;
    }

    @Override
    public void applyWeaponEffect(GameCharacter attacker, GameCharacter target) {
        // Si disparó con éxito, el calibre .50 tiene un 25% de provocar hemorragia (Bleed)
        if (Math.random() < 0.25) {
            System.out.println("The .50 caliber round pierces " + target.getName() + " (Bleed)!");
            target.applyEffect(new Bleed(2, 6));
        }
    }

    public void setHeadshootProbability(double headshootProbability){this.headshootProbability = headshootProbability;}

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tHeadshot Probability: " + Colors.CYAN +
                (int) (this.headshootProbability * 100) + "%" + Colors.RESET;
    }


}
