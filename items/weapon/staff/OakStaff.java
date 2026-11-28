package items.weapon.staff;

import characters.GameCharacter;
import effect.Burn;
import effect.Paralysis;
import items.weapon.Weapon;

public class OakStaff extends Staff {

    public OakStaff() {
        super("Oak Staff", 10,30,50,1);
    }

    @Override
    public void castSpellEffect(GameCharacter attacker, GameCharacter target) {
        if (this.currentMana >= this.manaUse) {
            int burnDamage = 10;

            this.currentMana = Math.max(0, this.currentMana - this.manaUse);

            System.out.println(attacker.getName() + " unleashes a fireball with " + this.name + " for "
                    + 10 + " direct damage and guaranteed Burn (" + burnDamage + " dmg/turn)!");

            target.takeDamage(burnDamage);
            target.applyEffect(new Burn(1, 8));
        } else {
            System.out.println(this.name + " does not have enough mana! (" + this.currentMana + "/" + this.manaUse + ")");
        }
    }

    @Override
    public void applyWeaponEffect(GameCharacter attacker, GameCharacter target) {
        if (Math.random() < 0.1) {
            System.out.println(this.name + " emits a hot chill! " + target.getName() + " burned for 1 turn!");
            target.applyEffect(new Burn(1,2));
        }
    }

    @Override
    public String toString() {
        return "[Staff] " + super.toString() + " | Efecto: Burn (Arma inicial)";
    }


}