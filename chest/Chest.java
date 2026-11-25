package items;

import characters.GameCharacter;
import crystals.*;
import weapon.Weapon;
import java.util.List;

public class Chest {
    private boolean opened;
    private final List<Weapon> weaponPool; // Todas las armas que pueden tocar

    public Chest(List<Weapon> weaponPool) {
        this.opened = false;
        this.weaponPool = weaponPool;
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
        player.addCrystal(rewardCrystal);

        if (rewardWeapon != null) {
            System.out.println("  - Weapon: " + rewardWeapon.getName());
            player.equipWeapon(rewardWeapon);
        }
    }

    private Weapon generateRandomWeapon() {
        if (this.weaponPool == null || this.weaponPool.isEmpty()) {
            return null;
        }
        int randomIndex = (int) (Math.random() * this.weaponPool.size());
        return this.weaponPool.get(randomIndex);
    }

    private Crystal generateRandomCrystal() {
        int roll = (int) (Math.random() * 6);
        switch (roll) {
            case 0: return new HealingCrystal();
            case 1: return new WeaponCrystal();
            case 2: return new PowerCrystal();
            case 3: return new CoffeeCrystal();
            case 4: return new BandageCrystal();
            default: return new FrostCrystal();
        }
    }

    public boolean isOpened() {
        return this.opened;
    }
}