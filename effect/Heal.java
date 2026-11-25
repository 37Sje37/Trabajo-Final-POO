package effect;

import characters.GameCharacter;

public class Heal extends Effect{

    private int heal;

    public Heal(){
        super("Heal", 1);
        this.heal = 50;
    }

    @Override
    public void applyEffect(GameCharacter target) {
        target.setCurrentHealth((int) (target.getCurrentHealth() +this.heal));
    }

    @Override
    public String toString() {
        return super.toString() + "\tHeals:" + this.heal ;
    }
}
