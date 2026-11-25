package ornaments;

public class Colors {
    public static final String RESET = "\u001B[0m";

    // 1. Básicos (8)
    public static final String BLACK  = "\u001B[30m";
    public static final String RED    = "\u001B[31m";
    public static final String GREEN  = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE   = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN   = "\u001B[36m";
    public static final String WHITE  = "\u001B[37m";
    public static final String CRIMSON = "\u001B[38;2;220;20;60m";

    // 2. Brillantes (8)
    public static final String GRAY = "\u001B[38;5;245m";
    public static final String BRIGHT_RED    = "\u001B[91m";
    public static final String BRIGHT_GREEN  = "\u001B[92m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String BRIGHT_BLUE   = "\u001B[94m";
    public static final String BRIGHT_PURPLE = "\u001B[95m";
    public static final String BRIGHT_CYAN   = "\u001B[96m";
    public static final String BRIGHT_WHITE  = "\u001B[97m";

    // 3. Extendidos 256 colores (8 extra para ítems/rarezas)
    public static final String ORANGE    = "\u001B[38;5;208m";
    public static final String GOLD      = "\u001B[38;5;220m";
    public static final String PINK      = "\u001B[38;5;213m";
    public static final String MAGENTA   = "\u001B[38;5;198m";
    public static final String TURQUOISE = "\u001B[38;5;45m";
    public static final String LIME      = "\u001B[38;5;118m";
    public static final String VIOLET    = "\u001B[38;5;135m";
    public static final String BROWN     = "\u001B[38;5;130m";

    @Override
    public String toString() {
        return "--- BÁSICOS ---\n" +
                BLACK  + "BLACK "  + RESET +
                RED    + "RED "    + RESET +
                GREEN  + "GREEN "  + RESET +
                YELLOW + "YELLOW " + RESET +
                BLUE   + "BLUE "   + RESET +
                PURPLE + "PURPLE " + RESET +
                CYAN   + "CYAN "   + RESET +
                WHITE  + "WHITE\n" + RESET +

                "--- BRILLANTES ---\n" +
                GRAY          + "GRAY "          + RESET +
                BRIGHT_RED    + "BRIGHT_RED "    + RESET +
                BRIGHT_GREEN  + "BRIGHT_GREEN "  + RESET +
                BRIGHT_YELLOW + "BRIGHT_YELLOW " + RESET +
                BRIGHT_BLUE   + "BRIGHT_BLUE "   + RESET +
                BRIGHT_PURPLE + "BRIGHT_PURPLE " + RESET +
                BRIGHT_CYAN   + "BRIGHT_CYAN "   + RESET +
                BRIGHT_WHITE  + "BRIGHT_WHITE\n" + RESET +

                "--- EXTENDIDOS ---\n" +
                ORANGE    + "ORANGE "    + RESET +
                GOLD      + "GOLD "      + RESET +
                PINK      + "PINK "      + RESET +
                MAGENTA   + "MAGENTA "   + RESET +
                TURQUOISE + "TURQUOISE " + RESET +
                LIME      + "LIME "      + RESET +
                VIOLET    + "VIOLET "    + RESET +
                BROWN     + "BROWN"      + RESET;
    }
}