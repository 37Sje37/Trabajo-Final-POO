package weapon.sniper;


public class AMRTiamat extends SniperRifle{

    private double megaShootProbability;

    public AMRTiamat(){
        super("AMR Tiamat", 40, 4);
        this.megaShootProbability = 0.3;
    }

    @Override
    public int getDamage() {

        if(this.currentAmmo == 0){
            super.getDamage();
        }

        int damage = this.baseDamage;

        if(Math.random() < this.megaShootProbability){
            int megaDamage = (int)Math.round(this.baseDamage*2.5);
            System.out.println(" fires a 20mm Anti-Materiel High-Velocity round! Massive damage: "
                    + megaDamage + "!");
            return megaDamage;
        }
        return damage;
    }

    @Override
    public String toString() {
        return super.toString() + "\t Mega shoot Probability:" + this.megaShootProbability;
    }
}
