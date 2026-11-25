import characters.GameCharacter;
import items.Chest;
import items.ItemCatalog;
import items.crystals.PowerCrystal;
import items.weapon.sniper.L115A3;
import items.weapon.staff.SilveryEternity;
import items.weapon.sword.Elucidator;
import ornaments.Colors;

public class Main {
    public static void main(String[] args) {

        //ItemCatalog.printDefaultCatalog();

        Elucidator elucidator = new Elucidator(3);
        System.out.println(elucidator);

        SilveryEternity silveryEternity = new SilveryEternity();
        System.out.println(silveryEternity);

        L115A3 l115A3 = new L115A3();
        System.out.println(l115A3);

        PowerCrystal powerCrystal = new PowerCrystal();
        System.out.println(powerCrystal);

 /*
        Colors color = new Colors();

        System.out.println(color);

        ItemCatalog.printAllItems();


        // 1. Crear un personaje de prueba
        GameCharacter kirito = new GameCharacter("Kirito", 250, 20,30);

        // 2. Crear y abrir el primer cofre (ya lleva todas las armas y cristales dentro)
        Chest chest1 = new Chest();
        chest1.open(kirito);

        // 3. Comprobar lo que ha recibido el personaje
        System.out.println("\n--- ESTADO TRAS ABRIR EL COFRE 1 ---");
        System.out.println("Arma equipada: " + kirito.getEquippedWeapon());
        kirito.showCrystals();

        // 4. Intentar abrirlo otra vez (debería avisar de que ya está vacío)
        System.out.println();
        chest1.open(kirito);

        // 5. Abrir un segundo cofre para probar que saca otro botín aleatorio
        System.out.println();
        Chest chest2 = new Chest();
        chest2.open(kirito);

        System.out.println("\n--- ESTADO TRAS ABRIR EL COFRE 2 ---");
        System.out.println("Arma equipada: " + kirito.getEquippedWeapon());
        kirito.showCrystals();

*/


    }
}