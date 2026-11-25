package items;
import items.crystals.*;
import items.weapon.Weapon;
import items.weapon.sniper.*;
import items.weapon.staff.*;
import items.weapon.sword.*;
import ornaments.Colors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chest {
    private boolean isBossChest;
    private List<Object> rewards;

    public Chest(int floorNumber, boolean isBossStage) {
        this.isBossChest = isBossStage;
        this.rewards = new ArrayList<>();
        generateRewards(floorNumber);
    }

    private void generateRewards(int floorNumber) {
        Random rand = new Random();

        if (isBossChest) {
            // Cofre de Boss: 1 arma escalada a (floorNumber + 1) + 1 cristal aleatorio
            Weapon bossWeapon = getRandomWeapon(rand);
            bossWeapon.setLevel(floorNumber + 1);
            rewards.add(bossWeapon);
            rewards.add(getRandomCrystal(rand));
        } else {
            // Cofre normal de Stage: 50% cristal, 50% arma del nivel del piso actual
            if (rand.nextBoolean()) {
                rewards.add(getRandomCrystal(rand));
            } else {
                Weapon stageWeapon = getRandomWeapon(rand);
                stageWeapon.setLevel(floorNumber);
                rewards.add(stageWeapon);
            }
        }
    }

    private Weapon getRandomWeapon(Random rand) {
        Weapon[] pool = {
                new AMRTiamat(1), new HecateII(1), new L115A3(1),
                new AbyssalStaff(1), new SalamanderStaff(1), new SilveryEternity(1),
                new AnnealBlade(1,1), new Elucidator(1,1), new LambentLight(1,1)
        };
        return pool[rand.nextInt(pool.length)];
    }

    private Crystal getRandomCrystal(Random rand) {
        Crystal[] pool = {
                new BandageCrystal(), new CoffeeCrystal(), new FrostCrystal(),
                new HealingCrystal(), new PowerCrystal(), new WeaponCrystal()
        };
        return pool[rand.nextInt(pool.length)];
    }

    public List<Object> open() {
        String title = isBossChest
                ? Colors.GOLD + " [ BOSS TREASURE CHEST OPENED! ] " + Colors.RESET
                : Colors.YELLOW + " [ STAGE CHEST OPENED! ]" + Colors.RESET;

        System.out.println("\n  " + title);
        for (Object item : rewards) {
            System.out.println("    -> Obtienes: " + item.toString());
        }
        System.out.println();
        return rewards;
    }
}