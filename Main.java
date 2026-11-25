import characters.GameCharacter;
import items.Chest;
import items.ItemCatalog;
import items.crystals.Crystal;
import items.crystals.HealingCrystal;
import items.crystals.PowerCrystal;
import items.crystals.WeaponCrystal;
import items.weapon.Weapon;
import items.weapon.sniper.L115A3;
import items.weapon.staff.SalamanderStaff;
import items.weapon.staff.SilveryEternity;
import items.weapon.sword.Elucidator;
import ornaments.Colors;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. VERIFICAR TOSTRING (SIN GASTAR RECURSOS) ===");
        Weapon sword = new Elucidator(50, 1);
        SalamanderStaff staff = new SalamanderStaff(1);
        L115A3 sniper = new L115A3(1);

        System.out.println(sword);
        System.out.println(staff);
        System.out.println(sniper); // Debe seguir en 11/11 balas y sin imprimir critico

        System.out.println("\n=== 2. VERIFICAR ESCALADO AL SUBIR DE NIVEL ===");
        sword.levelUp();
        staff.levelUp();
        sniper.levelUp();

        System.out.println("Tras subir a Lv.2:");
        System.out.println(sword);
        System.out.println(staff);
        System.out.println(sniper); // Debe pasar a 12/12 balas y subir probabilidades

        System.out.println("\n=== 3. VERIFICAR COMBATE Y EFECTOS ===");
        // Ajusta los parametros del constructor de GameCharacter si tu clase pide mas o menos datos
        GameCharacter hero = new GameCharacter("Kirito", 200, 15, 10);
        GameCharacter dummy = new GameCharacter("Training Dummy", 500, 10, 5);

        hero.equipWeapon(sniper);
        hero.attack(dummy); // Debe gastar 1 bala (11/12) y hacer dano
        System.out.println("Estado del sniper tras 1 disparo: " + sniper);

        hero.equipWeapon(staff);
        ((SalamanderStaff) staff).castSpellEffect(hero, dummy); // Debe gastar mana y aplicar Burn
        System.out.println("Estado del baston tras hechizo: " + staff);

        System.out.println("\n=== 4. VERIFICAR CRISTALES ===");
        Crystal healCrystal = new HealingCrystal(2);
        Crystal weaponCrystal = new WeaponCrystal(3);

        hero.takeDamage(60);
        System.out.println("Vida antes de cristal: " + hero.getCurrentHealth());
        healCrystal.activate(hero);
        System.out.println("Vida tras HealingCrystal Lv.2: " + hero.getCurrentHealth());

        hero.equipWeapon(sniper); // Tiene 11/12 balas y Lv.2
        weaponCrystal.activate(hero); // Recarga a 12/12 y lo sube a Lv.3 (13/13)
        System.out.println("Sniper tras WeaponCrystal Lv.3: " + sniper);
    }
}