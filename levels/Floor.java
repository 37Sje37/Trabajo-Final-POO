package levels;
import ornaments.Colors;
import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNumber;
    private double difficultyMultiplier;
    private List<Stage> stages;

    public Floor(int floorNumber, int numStages) {
        this.floorNumber = floorNumber;
        this.difficultyMultiplier = 1.0 + (floorNumber - 1) * 0.25;
        this.stages = new ArrayList<>();

        for (int i = 1; i <= numStages; i++) {
            boolean isLastStage = (i == numStages);
            this.stages.add(new Stage(floorNumber, i, isLastStage));
        }
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public double getDifficultyMultiplier() {
        return difficultyMultiplier;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public Stage getStage(int stageIndex) {
        return stages.get(stageIndex);
    }



    @Override
    public String toString() {
        return Colors.GOLD + "Floor " + floorNumber +
                Colors.GRAY + " | Difficulty: " + Colors.RED + "x" + difficultyMultiplier + Colors.RESET;
    }
}