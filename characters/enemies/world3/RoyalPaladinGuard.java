package characters.enemies.world3;

import characters.enemies.TankEnemy;

public class RoyalPaladinGuard extends TankEnemy {

    public RoyalPaladinGuard(int level, int index) {
        // Nombre, Vida base, Daño base, Armadura base, XP base, Nivel
        super("Royal Paladin Guard #" + index, 120, 14, 24, 42, level);
    }
}