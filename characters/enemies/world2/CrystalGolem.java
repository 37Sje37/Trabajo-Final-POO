package characters.enemies.world2;

import characters.enemies.TankEnemy;

public class CrystalGolem extends TankEnemy {

    public CrystalGolem(int level, int index) {
        // Nombre, Vida base, Daño base, Armadura base, XP base, Nivel
        super("Crystal Golem #" + index, 95, 10, 18, 28, level);
    }
}