package items;

import characters.GameCharacter;
import items.crystals.*;
import items.weapon.Weapon;
import items.weapon.sniper.*;
import items.weapon.staff.*;
import items.weapon.sword.*;

public class Chest {
    private boolean opened;

    public Chest() {
        this.opened = false;
    }

    public void open(GameCharacter player) {
        if (this.opened) {
            System.out.println("This chest is already empty!");
            return;
        }

        this.opened = true;

        Crystal rewardCrystal = generateRandomCrystal();
        Weapon rewardWeapon = generateRandomWeapon();

        System.out.println(player.getName() + " opens a Treasure Chest and finds:");
        System.out.println("  - Crystal: " + rewardCrystal.getName());
        System.out.println("  - Weapon: " + rewardWeapon.getName());

        player.addCrystal(rewardCrystal);
        player.equipWeapon(rewardWeapon);
    }

    private Weapon generateRandomWeapon() {
        Weapon[] weapons = {
                new AMRTiamat(),
                new HecateII(),
                new L115A3(),
                new AbyssalStaff(),
                new SalamanderStaff(),
                new SilveryEternity(),
                new AnnealBlade((int)((0.5 + (Math.random() * 0.5))*100)),
                new Elucidator((int)((0.5 + (Math.random() * 0.5))*100)),
                new LambentLight((int)((0.5 + (Math.random() * 0.5))*100))
        };

        int randomIndex = (int) (Math.random() * weapons.length);
        return weapons[randomIndex];
    }

    private Crystal generateRandomCrystal() {
        Crystal[] crystals = {
                new HealingCrystal(),
                new WeaponCrystal(),
                new PowerCrystal(),
                new CoffeeCrystal(),
                new BandageCrystal(),
                new FrostCrystal()
        };

        int randomIndex = (int) (Math.random() * crystals.length);
        return crystals[randomIndex];
    }

    public boolean isOpened() {
        return this.opened;
    }
}