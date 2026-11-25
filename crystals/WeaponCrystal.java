package crystals;


import characters.GameCharacter;
import weapon.*;
import weapon.sniper.SniperRifle;
import weapon.staff.Staff;
import weapon.sword.Sword;

import static weapon.sword.Sword.MAXSHARPNESS;

public class WeaponCrystal extends Crystal {

    public WeaponCrystal(){
        super("Restore Weapon Crystal");
    }

    @Override
    public boolean activate(GameCharacter target) {
        if(!target.isAlive()){return false;}

        Weapon weapon = target.getWeapon();

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
        return super.toString() + "\t Recharge your Sharpness/Mana/Ammo to max without using a turn";
    }
}
