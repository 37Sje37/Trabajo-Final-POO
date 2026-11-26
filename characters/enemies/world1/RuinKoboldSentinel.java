package characters.enemies.world1;

import characters.enemies.TankEnemy;

public class RuinKoboldSentinel extends TankEnemy {

    public RuinKoboldSentinel(int level, int index) {
        // Nombre, Vida base, Daño base, Armadura base, XP base, Nivel
        super("Ruin Kobold Sentinel #" + index, 75, 7, 12, 18, level);
    }
}