package effects;

import characters.GameCharacter;

public abstract class Effect {
    protected String name;
    protected int remainingTurns;

    public Effect(String name, int remainingTurns) {
        this.name = name;
        this.remainingTurns = remainingTurns;
    }

    public abstract void applyEffect(GameCharacter target);

    public void decreaseTurn() {
        this.remainingTurns--;
    }

    public boolean isExpired() {
        return this.remainingTurns <= 0;
    }

    public String getName() {
        return name;
    }

    public int getRemainingTurns() {
        return remainingTurns;
    }

    public String toString(){
        return "Name:" + this.name + "Remaining turns:" +this.remainingTurns;
    }
}
