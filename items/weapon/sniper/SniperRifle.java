package items.weapon.sniper;

import items.weapon.Weapon;
import ornaments.Colors;

public abstract class SniperRifle extends Weapon {

    protected final int baseMaxAmmo;
    protected int maxAmmo;
    protected int currentAmmo;

    public SniperRifle(String name, int baseDamage, int maxAmmo, int level) {
        super(name, baseDamage, level);
        this.baseMaxAmmo = maxAmmo;
        this.maxAmmo = maxAmmo + this.level;
        this.currentAmmo = this.maxAmmo;
    }

    public void reload() {
        setCurrentAmmo(this.maxAmmo);
        System.out.println(this.name + " reloaded! Current ammo: " + this.currentAmmo + "/" + this.maxAmmo);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.maxAmmo = this.baseMaxAmmo + this.level;
        this.currentAmmo++;
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
        this.maxAmmo = this.baseMaxAmmo + this.level;
        this.currentAmmo = Math.min(this.currentAmmo, this.maxAmmo);
    }

    @Override
    public int getDamage() {
        if (this.currentAmmo == 0) {
            System.out.println("Out of ammo! Reloading " + this.name + "...");
            this.reload();
            return 0;
        }
        this.currentAmmo--;
        return super.getDamage();
    }

    public void setMaxAmmo(int maxAmmo) {
        this.maxAmmo = maxAmmo;
    }

    public void setCurrentAmmo(int currentAmmo) {
        this.currentAmmo = Math.max(0, Math.min(this.maxAmmo, currentAmmo));
    }

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tAmmo: " + Colors.YELLOW +
                this.currentAmmo + "/" + this.maxAmmo + Colors.RESET;
    }
}