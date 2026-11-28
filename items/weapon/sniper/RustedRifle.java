package items.weapon.sniper;

import ornaments.Colors;

public class RustedRifle extends SniperRifle{

    public RustedRifle(){
        super("Rusted Rifle", 15, 4,1);
    }

    @Override
    public int getDamage() {
        int damage = super.getDamage();
        if (damage == 0) {
            return 0;
        }

        if (Math.random() < 0.1) {
            System.out.println(Colors.BRIGHT_YELLOW + "Give tetanus!!" + Colors.RESET);
            return (int) Math.round(damage * 1.3);
        }
        return damage;
    }

    @Override
    public String toString() {
        return "[Sniper] " + super.toString() + " | Efecto: Ninguno (Arma inicial)";
    }


}
