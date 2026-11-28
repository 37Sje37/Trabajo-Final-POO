package items.weapon.sword;

import characters.GameCharacter;

public class BronzeSword extends Sword{

    public BronzeSword(){

        super("Basic Sword",12,90,1);

    }

    @Override
    public String toString() {
        return "[Sword] " + super.toString() + " | Efecto: Ninguno (Arma inicial)";
    }

}
