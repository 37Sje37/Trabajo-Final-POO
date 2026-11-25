package items.crystals;

import characters.GameCharacter;
import ornaments.Colors;

public abstract class Crystal {

    protected String name;
    protected boolean shatered;

    public Crystal(String name){
        this.name = name;
        this.shatered = false; //si está en false es q está utilizable
    }


    public abstract boolean activate(GameCharacter target);

    public String getName(){return this.name;}
    public boolean isShattered(){return this.shatered;}

    @Override
    public String toString() {
        return Colors.GRAY + "Name: " + Colors.CYAN + this.name + Colors.RESET;
    }
}
