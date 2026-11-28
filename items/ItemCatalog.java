package items;
import items.crystals.BandageCrystal;
import items.crystals.CoffeeCrystal;
import items.crystals.FrostCrystal;
import items.crystals.HealingCrystal;
import items.crystals.PowerCrystal;
import items.crystals.WeaponCrystal;
import items.weapon.Weapon;
import items.weapon.sniper.AMRTiamat;
import items.weapon.sniper.HecateII;
import items.weapon.sniper.L115A3;
import items.weapon.sniper.RustedRifle;
import items.weapon.staff.AbyssalStaff;
import items.weapon.staff.OakStaff;
import items.weapon.staff.SalamanderStaff;
import items.weapon.staff.SilveryEternity;
import items.weapon.sword.AnnealBlade;
import items.weapon.sword.BronzeSword;
import items.weapon.sword.Elucidator;
import items.weapon.sword.LambentLight;
import ornaments.Colors;

import java.util.ArrayList;
import java.util.List;

public class ItemCatalog {

    private List<Object> items;

    public ItemCatalog() {
        this.items = new ArrayList<>();
    }

    public void addItem(Object item) {
        if (item != null) {
            this.items.add(item);
        }
    }

    public static void printDefaultCatalog() {
        ItemCatalog catalog = new ItemCatalog();

        // --- ARMAS (Snipers, Staffs, Swords) ---
        catalog.addItem(new BronzeSword());
        catalog.addItem(new OakStaff());
        catalog.addItem(new RustedRifle());

        catalog.addItem(new AMRTiamat(1));
        catalog.addItem(new HecateII(1));
        catalog.addItem(new L115A3(1));

        catalog.addItem(new AbyssalStaff(1));
        catalog.addItem(new SalamanderStaff(1));
        catalog.addItem(new SilveryEternity(1));

        catalog.addItem(new AnnealBlade(3,1));
        catalog.addItem(new Elucidator(3,1));
        catalog.addItem(new LambentLight(3,1));

        // --- CRISTALES ---
        catalog.addItem(new BandageCrystal());
        catalog.addItem(new CoffeeCrystal());
        catalog.addItem(new FrostCrystal());
        catalog.addItem(new HealingCrystal());
        catalog.addItem(new PowerCrystal());
        catalog.addItem(new WeaponCrystal());

        catalog.printCatalog();
    }

    public void printCatalog() {
        String line = Colors.GRAY + "==========================================================================================================" + Colors.RESET;
        String thinLine = Colors.GRAY + "----------------------------------------------------------------------------------------------------------" + Colors.RESET;

        System.out.println("\n" + line);
        System.out.println(Colors.GOLD + "                                           GAME ITEM CATALOG" + Colors.RESET);
        System.out.println(line);

        // --- SECCIÓN DE ARMAS ---
        System.out.println(Colors.CYAN + "  [ WEAPONS ]" + Colors.RESET);
        System.out.println(thinLine);
        for (Object obj : items) {
            if (obj instanceof Weapon) {
                printAlignedRow(obj.toString());
            }
        }

        System.out.println();

        // --- SECCIÓN DE CRISTALES ---
        System.out.println(Colors.BRIGHT_PURPLE + "  [ CRYSTALS ]" + Colors.RESET);
        System.out.println(thinLine);
        for (Object obj : items) {
            if (!(obj instanceof Weapon)) {
                printAlignedRow(obj.toString());
            }
        }

        System.out.println(line + "\n");
    }

    private void printAlignedRow(String rawToString) {
        String[] columns = rawToString.split("\t");
        StringBuilder row = new StringBuilder("  ");

        int[] colWidths = {28, 22, 28, 25};

        for (int i = 0; i < columns.length; i++) {
            int width = (i < colWidths.length) ? colWidths[i] : 22;
            String cleanCol = columns[i].replaceAll("^ +| +$", "");
            row.append(padRightAnsi(cleanCol, width));
            if (i < columns.length - 1) {
                row.append(Colors.GRAY).append(" | ").append(Colors.RESET);
            }
        }

        System.out.println(row.toString());
    }

    private String padRightAnsi(String text, int targetWidth) {
        String plainText = text.replaceAll("\u001B\\[[;\\d]*m", "");
        int padding = Math.max(0, targetWidth - plainText.length());
        return text + " ".repeat(padding);
    }
}