package game;

import characters.GameCharacter;
import java.util.Scanner;
import static ornaments.Colors.*;

public class Game {

    private final Scanner scanner;
    private GameCharacter player;

    public Game() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        // 1. Fase de creación de avatar
        CharacterCreator creator = new CharacterCreator(scanner);
        this.player = creator.create();

        System.out.println(TURQUOISE + "\n======================================================" + RESET);
        System.out.println(BRIGHT_GREEN + "[AVATAR INITIALIZED] " + BRIGHT_WHITE + player + RESET);
        System.out.println(TURQUOISE + "======================================================\n" + RESET);

        // 2. Bucle principal del juego (pisos/combates)
        runCampaign();

        scanner.close();
    }

    private void runCampaign() {

    }
}