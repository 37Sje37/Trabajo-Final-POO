package items.weapon.sword;

import items.weapon.Weapon;
import ornaments.Colors;

public class Sword extends Weapon {

    public static final int MAXSHARPNESS = 100;

    int sharpness;

    public Sword(String name, int baseDamage, int sharpness, int level) {
        super(name, baseDamage, level);
        this.sharpness = Math.max(0, Math.min(MAXSHARPNESS, sharpness));
    }

    public void decreaseSharpness(int amount) {
        this.sharpness = Math.max(0, this.sharpness - amount);
    }

    public void sharpen(int amount) {
        this.sharpness = Math.min(MAXSHARPNESS, this.sharpness + amount);
        System.out.println(this.name + " sharpened! Current sharpness: " + this.sharpness + "/" + MAXSHARPNESS);
    }

    public int getSharpness() {
        return this.sharpness;
    }

    protected double getSharpnessRatio() {
        return this.sharpness / 100.0;
    }

    @Override
    public int getDamage() {
        int scaledDamage = super.getDamage();
        if (this.sharpness < 30) {
            return (int) Math.round(scaledDamage * 0.8);
        }
        return scaledDamage;
    }

    @Override
    public String toString() {
        return super.toString() + Colors.GRAY + "\tSharpness: " + Colors.WHITE +
                this.sharpness + "/" + MAXSHARPNESS + Colors.RESET;
    }
}