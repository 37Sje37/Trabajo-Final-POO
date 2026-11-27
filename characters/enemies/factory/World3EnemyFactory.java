package characters.enemies.factory;

import characters.enemies.Enemy;
import characters.enemies.world3.HeathcliffBoss;
import characters.enemies.world3.RoyalPaladinGuard;
import characters.enemies.world3.SkullReaper;

public class World3EnemyFactory extends EnemyFactory {

    @Override
    protected Enemy createEnemy(EnemyRole role, int level, int index) {
        return switch (role) {
            case TANK     -> new RoyalPaladinGuard(level, index);
            case BACKLINE -> new SkullReaper(level);
            case BOSS     -> new HeathcliffBoss(level);
        };
    }
}