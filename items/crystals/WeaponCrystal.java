package items.crystals;

import characters.GameCharacter;
import items.weapon.Weapon;
import items.weapon.sniper.SniperRifle;
import items.weapon.staff.Staff;
import items.weapon.sword.Sword;
import ornaments.Colors;

import static items.weapon.sword.Sword.MAXSHARPNESS;

public class WeaponCrystal extends Crystal {

    public WeaponCrystal(int level) {
        super("Restore Weapon Crystal", level);
    }

    public WeaponCrystal() {
        this(1);
    }

    @Override
    public boolean activate(GameCharacter target) {
        if (this.shattered || !target.isAlive()) {
            return false;
        }

        Weapon weapon = target.getEquippedWeapon();
        boolean restored = false;

        if (weapon instanceof SniperRifle) {
            ((SniperRifle) weapon).reload();
            restored = true;
        } else if (weapon instanceof Sword) {
            ((Sword) weapon).sharpen(MAXSHARPNESS);
            restored = true;
        } else if (weapon instanceof Staff) {
            Staff staff = (Staff) weapon;
            staff.rechargeMana(staff.getManaMax());
            restored = true;
        }

        if (restored) {
            this.shattered = true;
            if (this.level > weapon.getLevel()) {
                weapon.levelUp();
                System.out.println(Colors.GOLD + "The high-level crystal also upgraded " +
                        weapon.getName() + " to Lv." + weapon.getLevel() + "!" + Colors.RESET);
            }
            return true;
        }

        System.out.println("You can't use this crystal now.");
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + Colors.GOLD + "\tRecharge Sharpness/Mana/Ammo to max (upgrades weapon if crystal Lv > weapon Lv)"
                + Colors.RESET;
    }
}