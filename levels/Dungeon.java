package levels;

import items.Chest;
import items.weapon.Weapon;
import ornaments.Colors;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private List<Floor> floors;
    private int currentFloorIndex;
    private int currentStageIndex;
    private boolean cleared;

    public Dungeon(int totalFloors, int stagesPerFloor) {
        this.floors = new ArrayList<>();
        for (int i = 1; i <= totalFloors; i++) {
            this.floors.add(new Floor(i, stagesPerFloor));
        }
        this.currentFloorIndex = 0;
        this.currentStageIndex = 0;
        this.cleared = false;
    }

    public List<Object> advance(Weapon equippedWeapon) {
        if (cleared) return List.of();

        Stage completedStage = getCurrentStage();
        completedStage.setCompleted(true);

        // 1. Recompensa por completar el Stage actual
        Chest stageChest = new Chest(getCurrentFloor().getFloorNumber(), completedStage.isBossStage());
        List<Object> loot = stageChest.open();

        Floor currentFloor = getCurrentFloor();

        // 2. Avance al siguiente Stage o Floor
        if (currentStageIndex + 1 < currentFloor.getStages().size()) {
            currentStageIndex++;
            Stage next = getCurrentStage();

            if (next.isBossStage()) {
                System.out.println(Colors.CRIMSON + " WARNING! Boss Chamber: " + next + Colors.RESET);
            } else {
                System.out.println(Colors.GREEN + "Advancing to " + next +
                        Colors.GRAY + " (Difficulty: x" + getCurrentFloor().getDifficultyMultiplier() + ")" + Colors.RESET);
            }
        } else if (currentFloorIndex + 1 < floors.size()) {
            currentFloorIndex++;
            currentStageIndex = 0;

            // Sube de nivel el arma equipada al subir de piso
            if (equippedWeapon != null) {
                equippedWeapon.levelUp();
                System.out.println(Colors.BRIGHT_CYAN + "️ ¡Your weapon has being level up! -> " + equippedWeapon + Colors.RESET);
            }

            System.out.println(Colors.GOLD + "FLOOR CLEARED! Advancing to " + getCurrentFloor() +
                    " -> " + getCurrentStage() + Colors.RESET);
        } else {
            cleared = true;
            System.out.println(Colors.BRIGHT_YELLOW + "TOTAL VICTORY! You have conquered all " + floors.size() + " floors." + Colors.RESET);
        }

        return loot;
    }
    public Stage getCurrentStage() {
        return getCurrentFloor().getStage(currentStageIndex);
    }
    public Floor getCurrentFloor() {
        return floors.get(currentFloorIndex);
    }

}