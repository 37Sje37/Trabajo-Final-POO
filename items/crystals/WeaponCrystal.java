package items.crystals;


import characters.GameCharacter;
import ornaments.Colors;
import items.weapon.*;
import items.weapon.sniper.SniperRifle;
import items.weapon.staff.Staff;
import items.weapon.sword.Sword;

import static items.weapon.sword.Sword.MAXSHARPNESS;

public class WeaponCrystal extends Crystal {

    public WeaponCrystal(){
        super("Restore Weapon Crystal");
    }

    @Override
    public boolean activate(GameCharacter target) {
        if(!target.isAlive()){return false;}

        Weapon weapon = target.getEquippedWeapon();

        if(weapon instanceof SniperRifle){
            System.out.println("You have reload your sniper");
            ((SniperRifle) weapon).reload();;
            return true;
        }
        if(weapon instanceof Sword){
            System.out.println("You have sharpened your sword ");
            ((Sword) weapon).sharpen(MAXSHARPNESS);
             return true;
        }
        if(weapon instanceof Staff){
            System.out.println("You have recharge your mana");
            ((Staff) weapon).rechargeMana(((Staff) weapon).getManaMax());
            return true;
        }
        System.out.println("You can't use this crystal now");
        return false;
    }

    @Override
    public String toString(){
        return super.toString() + Colors.GOLD + "\t Recharge your Sharpness/Mana/Ammo to max without using a turn"
                + Colors.RESET;
    }
}
