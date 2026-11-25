package items.weapon.sniper;

import ornaments.Colors;
import items.weapon.Weapon;

public abstract class SniperRifle extends Weapon {


    protected int maxAmmo;
    protected int currentAmmo;

    public SniperRifle(String name,int baseDamage, int maxAmmo){
        super(name,baseDamage);
        this.maxAmmo = maxAmmo;
        this.currentAmmo = maxAmmo;
    }


    public void reload(){
        System.out.println(this.name +  " has recharge, now u have " + this.maxAmmo);
        setCurrentAmmo(this.maxAmmo);
    }

    @Override
    public int getDamage(){
        if(this.currentAmmo == 0){
            System.out.println("You can't shoot, you are going to recharge");
            this.reload();
            System.out.println("Current ammo:" + this.currentAmmo + "/" + this.maxAmmo);
            return 0;

        }
        this.currentAmmo--;
        return this.baseDamage;
    }


    public void setMaxAmmo(int maxAmmo){this.maxAmmo = maxAmmo;};
    public void setCurrentAmmo(int currentAmmo){this.currentAmmo = currentAmmo;}


    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tAmmo: " + Colors.YELLOW +
                this.currentAmmo + "/" + this.maxAmmo + Colors.RESET;
    }
}
