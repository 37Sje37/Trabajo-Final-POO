
package game;

import characters.GameCharacter;
import items.weapon.sniper.RustedRifle;
import items.weapon.staff.OakStaff;
import items.weapon.sword.BronzeSword;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static ornaments.Colors.*;
import static staticMethods.staticMethods.pause;
import static staticMethods.staticMethods.readOption;

public class CharacterCreator {

    private static final int BASIC_HEALTH = 30;
    private static final int BASIC_DAMAGE = 10;
    private static final int BASIC_ARMOUR = 12;

    private final Scanner scanner;

    public CharacterCreator(Scanner scanner) {
        this.scanner = scanner;
    }

    public GameCharacter create() {
        String playerName = askName();
        GameCharacter player = new GameCharacter(playerName, BASIC_HEALTH, BASIC_DAMAGE, BASIC_ARMOUR);
        chooseStats(player);
        chooseWeapon(player);
        return player;
    }

    private String askName() {
        System.out.print(TURQUOISE + "[CARDINAL SYSTEM] " + BRIGHT_WHITE + "Introduce your name: " + RESET);
        String playerName = scanner.nextLine().trim();

        if (playerName.isEmpty()) {
            playerName = "Player:" + ThreadLocalRandom.current().nextInt(1_000_000);
            System.out.println(GOLD + "[SYSTEM NOTICE] Name not detected, default name assigned: " + BRIGHT_YELLOW + playerName + RESET);
        } else {
            System.out.println(BRIGHT_GREEN + "[SYSTEM NOTICE] Welcome to Aincrad, " + BRIGHT_WHITE + playerName + BRIGHT_GREEN + "." + RESET);
        }
        return playerName;
    }

    private void chooseStats(GameCharacter player) {
        int remainingPoints = 10;
        int damage = 0;
        int armour = 0;
        int maxHealth = 0;

        System.out.println(TURQUOISE + "\n------------------------------------------------------" + RESET);
        System.out.println(BRIGHT_CYAN + "[CARDINAL SYSTEM] Avatar calibration initialized." + RESET);
        System.out.println(CYAN + "You have " + GOLD + remainingPoints + CYAN + " synchronization points to allocate across your core parameters." + RESET);
        pause(1000);

        while (remainingPoints > 0) {
            System.out.println(TURQUOISE + "\n[CURRENT AVATAR PARAMETERS] " + GOLD + "Remaining Points: " + remainingPoints + RESET);
            System.out.println("  " + BRIGHT_YELLOW + "[1]" + WHITE + " Damage (Base ATK)   : " + BRIGHT_GREEN + (BASIC_DAMAGE + damage) + RESET);
            System.out.println("  " + BRIGHT_YELLOW + "[2]" + WHITE + " Armour (Defense %)  : " + BRIGHT_CYAN + (BASIC_ARMOUR + armour) + "%" + RESET);
            System.out.println("  " + BRIGHT_YELLOW + "[3]" + WHITE + " Max Health (HP)     : " + LIME + (BASIC_HEALTH + maxHealth) + GRAY + " (+10 HP per point)" + RESET);

            int option = readOption(scanner, 1, 3, TURQUOISE + "\n[CARDINAL SYSTEM] " + BRIGHT_WHITE + "Select parameter channel to enhance (1, 2, or 3): " + RESET);

            switch (option) {
                case 1 -> {
                    damage += 1;
                    System.out.println(BRIGHT_GREEN + "[PARAMETER UPDATED] Damage increased to " + (BASIC_DAMAGE + damage) + "." + RESET);
                }
                case 2 -> {
                    armour += 1;
                    System.out.println(BRIGHT_CYAN + "[PARAMETER UPDATED] Armour increased to " + (BASIC_ARMOUR + armour) + "%." + RESET);
                }
                case 3 -> {
                    maxHealth += 10;
                    System.out.println(LIME + "[PARAMETER UPDATED] Max Health increased to " + (BASIC_HEALTH + maxHealth) + " HP." + RESET);
                }
            }
            remainingPoints--;
            pause(500);
        }

        player.setBaseDamage(BASIC_DAMAGE + damage);
        player.setArmour(BASIC_ARMOUR + armour);
        // player.setMaxHealth(BASIC_HEALTH + maxHealth);
        player.setCurrentHealth(BASIC_HEALTH + maxHealth);

        System.out.println(BRIGHT_GREEN + "\n[CARDINAL SYSTEM] Calibration complete. All parameters synchronized." + RESET);
        pause(800);
    }

    private void chooseWeapon(GameCharacter player) {
        BronzeSword bronzeSword = new BronzeSword();
        OakStaff oakStaff = new OakStaff();
        RustedRifle rustedRifle = new RustedRifle();

        System.out.println(TURQUOISE + "\n------------------------------------------------------" + RESET);
        System.out.println(BRIGHT_CYAN + "[CARDINAL SYSTEM] What would be your first weapon?" + RESET);
        System.out.println(GOLD + "[1] " + BRIGHT_WHITE + "Bronze Sword" + GRAY + "\n    " + bronzeSword + RESET);
        System.out.println(GOLD + "[2] " + BRIGHT_WHITE + "Oak Staff" + GRAY + "\n    " + oakStaff + RESET);
        System.out.println(GOLD + "[3] " + BRIGHT_WHITE + "Rusted Rifle" + GRAY + "\n    " + rustedRifle + RESET);

        int option = readOption(scanner, 1, 3, TURQUOISE + "\n[CARDINAL SYSTEM] " + BRIGHT_WHITE + "Select weapon channel (0, 1, or 2): " + RESET);

        System.out.print(BRIGHT_GREEN);
        switch (option) {
            case 1 -> player.equipWeapon(bronzeSword);
            case 2 -> player.equipWeapon(oakStaff);
            case 3 -> player.equipWeapon(rustedRifle);
        }
        System.out.print(RESET);
    }
}