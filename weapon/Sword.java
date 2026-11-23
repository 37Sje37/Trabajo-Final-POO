package weapon;

public class Sword extends Weapon{

    int sharpness;
    public Sword(String name, int baseDamage, int sharpness){
        super(name, baseDamage);
        this.sharpness = sharpness;
    }

    public void decreaseSharpness(int amount){
        this.sharpness = Math.max(0, this.sharpness - amount);
    }

    public void sharpen(int amount) {
        this.sharpness = Math.min(100, this.sharpness + amount);
        System.out.println(this.name + " sharpened! Current sharpness: " + this.sharpness + "/100");  //Afilar la espada
    }

    public int getSharpness(){
        return this.sharpness;
    }

    @Override
    public int getDamage(){
        return (this.sharpness < 30) ? (int) (this.baseDamage * 0.8) : this.baseDamage; // si la espada baja de un 30 de sharpness hace menos daño
    }

@Override
    public String toString(){
        return "Name:" +this.name + "\tDamage:" +this.baseDamage+ "\tSharpness :" + this.sharpness;
}

}
