package characters.enemies.factory;

import characters.enemies.Enemy;
import characters.enemies.world2.CrystalGolem;
import characters.enemies.world2.GleamEyesBoss;
import characters.enemies.world2.SalamanderMage;

public class World2EnemyFactory extends EnemyFactory {

    @Override
    protected Enemy createEnemy(EnemyRole role, int level, int index) {
        return switch (role) {
            case TANK     -> new CrystalGolem(level, index);
            case BACKLINE -> new SalamanderMage(level);
            case BOSS     -> new GleamEyesBoss(level);
        };
    }
}