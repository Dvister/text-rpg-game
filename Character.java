import java.io.Serializable;

public abstract class Character implements Serializable{
    
    public double maxHealth = 15;
    public double health = maxHealth;
    public double damage = 3;
    public String name;
    public static double dealtDMG;

    //Методи геттера та сеттера

    public static void setDealtDMG(double dealtDMG) {
        Character.dealtDMG = dealtDMG;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public double getDamage() {
        return damage;
    }

    public double getHealth() {
        return health;
    }
    
    public double getMaxHealth() {
        return maxHealth;
    }
    
    public String getName() {
        return name;
    }

    public static double getDealtDMG() {
        return dealtDMG;
    }
}