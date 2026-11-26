package characters.enemies.factory;

import characters.enemies.Enemy;
import characters.enemies.world1.IllfangBoss;
import characters.enemies.world1.KoboldArcher;
import characters.enemies.world1.RuinKoboldSentinel;

public class World1EnemyFactory extends EnemyFactory {

    @Override
    protected Enemy createEnemy(EnemyRole role, int level, int index) {
        return switch (role) {
            case TANK     -> new RuinKoboldSentinel(level, index);
            case BACKLINE -> new KoboldArcher(level);
            case BOSS     -> new IllfangBoss(level);
        };
    }
}