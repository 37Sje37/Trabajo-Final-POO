import characters.GameCharacter;
import items.Chest;
import weapon.Weapon;
import weapon.sniper.*;
import weapon.staff.*;
import weapon.sword.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Crear el catálogo con tus 9 armas concretas
        List<Weapon> weaponPool = new ArrayList<>();

        weaponPool.add(new AMRTiamat());
        weaponPool.add(new HecateII());
        weaponPool.add(new L115A3());

        weaponPool.add(new AbyssalStaff());
        weaponPool.add(new SalamanderStaff());
        weaponPool.add(new SilveryEternity());

        weaponPool.add(new AnnealBlade((int)(0.5 + (Math.random() * 0.5))));
        weaponPool.add(new Elucidator((int)(0.5 + (Math.random() * 0.5))));
        weaponPool.add(new LambentLight((int)(0.5 + (Math.random() * 0.5))));

        // 2. Crear un personaje de prueba
        GameCharacter usuario = new GameCharacter("Kirito", 250, 20,4);

        // 3. Crear y abrir el cofre
        Chest chest = new Chest(weaponPool);
        chest.open(usuario);

        // 4. Comprobar lo que ha recibido el personaje
        System.out.println("\n--- ESTADO TRAS ABRIR EL COFRE ---");
        System.out.println("Arma equipada: " + usuario.getWeapon());
        usuario.showCrystals();

        // 5. Intentar abrirlo otra vez (debería avisar de que ya está vacío)
        System.out.println();
        chest.open(usuario);
    }
}