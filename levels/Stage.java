package levels;

import ornaments.Colors;

public class Stage {
    private int floorNumber;
    private int stageNumber;
    private boolean isBossStage;
    private boolean completed;

    public Stage(int floorNumber, int stageNumber, boolean isBossStage) {
        this.floorNumber = floorNumber;
        this.stageNumber = stageNumber;
        this.isBossStage = isBossStage;
        this.completed = false;
    }

    public String getStageCode() {
        return floorNumber + "-" + stageNumber;
    }

    public boolean isBossStage() {
        return isBossStage;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        if (isBossStage) {
            return Colors.CRIMSON + "Stage " + getStageCode() + " [FLOOR BOSS]" + Colors.RESET;
        }
        return Colors.CYAN + "Stage " + getStageCode() + Colors.RESET;
    }
}