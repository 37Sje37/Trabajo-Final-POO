import characters.GameCharacter;
import characters.enemies.Enemy;
import characters.enemies.factory.EnemyFactory;
import characters.enemies.Enemy;
import characters.enemies.factory.EnemyFactory;
import java.util.List;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Creamos al jugador (revisa que currentHealth se inicialice en GameCharacter)
        GameCharacter player = new GameCharacter("Kirito", 250, 28, 12) {
        };

        // 2. Elegimos el mundo y la fase (1-1: Tanques + Retaguardia; pon stage = 3 para Illfang)
        int world = 1;
        int stage = 1;

        EnemyFactory factory = EnemyFactory.getFactoryForWorld(world);
        List<Enemy> enemies = factory.createStageEncounter(world, stage);

        System.out.println("=== COMIENZA EL COMBATE: PISO " + world + "-" + stage + " ===");
        pause(1000);
        int turn = 1;

        // 3. Bucle de combate
        while (player.isAlive() && enemies.stream().anyMatch(Enemy::isAlive)) {
            System.out.println("\n--- TURNO " + turn + " ---");
            pause(600);

            System.out.println("JUGADOR: " + player);
            pause(600);

            System.out.println("ENEMIGOS:");
            for (int i = 0; i < enemies.size(); i++) {
                Enemy e = enemies.get(i);
                String estado = e.isAlive() ? e.toString() : "[DERROTADO] " + e.getName();
                System.out.println("  [" + i + "] " + estado);
                pause(400);
            }

            // --- TURNO DEL JUGADOR ---
            System.out.print("\nElige el número del enemigo al que quieres atacar: ");
            int targetIndex = -1;
            try {
                targetIndex = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Entrada no válida. Pierdes el turno por dudar.");
                pause(800);
            }

            if (targetIndex >= 0 && targetIndex < enemies.size() && enemies.get(targetIndex).isAlive()) {
                Enemy target = enemies.get(targetIndex);
                player.attack(target);
                pause(900);

                if (!target.isAlive()) {
                    System.out.println("¡Has derrotado a " + target.getName() + "!");
                    pause(900);
                }
            } else if (targetIndex != -1) {
                System.out.println("Objetivo no válido o ya derrotado.");
                pause(800);
            }

            // --- TURNO DE LOS ENEMIGOS ---
            if (enemies.stream().anyMatch(Enemy::isAlive)) {
                System.out.println("\nTurno de los enemigos...");
                pause(800);

                for (Enemy enemy : enemies) {
                    if (enemy.isAlive() && player.isAlive()) {
                        enemy.takeTurn(player);
                        pause(1000);
                    }
                }
            }

            turn++;
        }

        // 4. Resultado final de la fase
        pause(1000);
        System.out.println("\n=== FIN DEL COMBATE ===");
        pause(1200);

        if (player.isAlive()) {
            int totalXp = enemies.stream().mapToInt(Enemy::getXpReward).sum();
            System.out.println("¡VICTORIA! Has superado el nivel " + world + "-" + stage + ".");
            pause(700);
            System.out.println("Experiencia total obtenida: +" + totalXp + " XP");
        } else {
            System.out.println("GAME OVER. Has caído en Aincrad...");
        }

        scanner.close();
    }
}
