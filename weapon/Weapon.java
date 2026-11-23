package weapon;

public abstract class Weapon {

    protected String name;
    protected int baseDamage;

    public Weapon(String name, int baseDamage){
        this.name = name;
        this.baseDamage = baseDamage;
    }

    public int getDamage(){
        return this.baseDamage;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public String toString (){
        return super.toString() + "\t Base damage" + this.baseDamage;
    }


}
