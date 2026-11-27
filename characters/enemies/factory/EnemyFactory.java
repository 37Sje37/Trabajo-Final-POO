package characters.enemies.factory;

import characters.enemies.Enemy;
import java.util.ArrayList;
import java.util.List;

public abstract class EnemyFactory {

    public enum EnemyRole {
        TANK,
        BACKLINE,
        BOSS
    }

    // FACTORY METHOD: Cada fábrica de mundo decidirá qué clase concreta instanciar
    protected abstract Enemy createEnemy(EnemyRole role, int level, int index);

    // Método plantilla que genera la oleada completa de una fase (ej. 1-1, 1-2, 1-3)
    public List<Enemy> createStageEncounter(int world, int stage) {
        List<Enemy> encounter = new ArrayList<>();
        int effectiveLevel = (world - 1) * 3 + stage;

        // En las fases X-3 (1-3, 2-3, 3-3) aparece el Boss final del mundo
        if (stage == 3) {
            encounter.add(createEnemy(EnemyRole.BOSS, effectiveLevel, 1));
            return encounter;
        }

        // En fases X-1 y X-2: 1 o 2 Tanques en vanguardia + 1 Retaguardia detrás
        int tankCount = (Math.random() < 0.5) ? 1 : 2;
        for (int i = 1; i <= tankCount; i++) {
            encounter.add(createEnemy(EnemyRole.TANK, effectiveLevel, i));
        }
        encounter.add(createEnemy(EnemyRole.BACKLINE, effectiveLevel, 1));

        return encounter;
    }

    // Método estático auxiliar para obtener la fábrica correspondiente al mundo
    public static EnemyFactory getFactoryForWorld(int world) {
        return switch (world) {
            case 1 -> new World1EnemyFactory();
            case 2 -> new World2EnemyFactory();
            case 3 -> new World3EnemyFactory();
            default -> throw new IllegalArgumentException("Mundo no válido: " + world);
        };
    }
}