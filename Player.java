import java.io.Serializable;

public class  Player extends Character implements Serializable{
    
    
    public int exp = 0;
    public static int stage = 1;
    public static int level = 1;
    public static boolean doubleDMG = false;
    
    Player(String name){
        setName(name);

    }

    public void gainEXP(int EXP){ //Збільшує число EXP у параметрах, підвищує рівень гравця, якщо воно досягає 100.
        exp = exp + EXP;
        if(exp >= 100){
            levelUp();
        }
    }

    public void levelUp(){ //Метод збільшує урон гравця
        
        setDamage(getDamage() + Math.round((getDamage() * 0.4) * 100.0) / 100.0);
        setMaxHealth(getMaxHealth() + Math.round((getMaxHealth() * 0.3) * 100.0) / 100.0);
        setHealth(getMaxHealth());
        setLevel(level+1);
        
        setExp(exp-100);
    }

    public void Attack(Enemy a){ //Метод застосовує шкоду до ворога в параметрах
        
        dealtDMG = Math.round((Roll() * getDamage()) * 100.0) / 100.0;
        
        if(doubleDMG == true){
            dealtDMG = Math.round((4 * getDamage()) * 100.0) / 100.0;
            doubleDMG = false;
        }
        
        a.setHealth(Math.round((a.getHealth() - dealtDMG) * 100.0) / 100.0);
    }
    
    public int Roll(){  //Метод додавання випадковості до атаки, найвищий шанс завдати нормальної шкоди, трохи вищий шанс завдати подвійної шкоди і найменший шанс завдати потрійної шкоди.

        int Roll = (int)(Math.random()*10);
        
        if(Roll >= 1 && Roll <= 6){
            return 1;
        }
        else if(Roll > 6 && Roll <= 8){
            return 2;
        }

        return 3;
    }

    public void Block(Enemy a){ //Метод дозволяє гравцю блокувати, змінює змінні в класі Enemy, кидає кубик для випадкового шансу на подвійну шкоду.
        
        int special = (int)(Math.random()*3);
        
        if(special == 1){
            setDoubleDMG(true);;
        }
        a.setBlock(true);

    }

    //Методи геттерів та сеттерів

    public int getExp() {
        return exp;
    }

    public static int getLevel() {
        return level;
    }

    public static int getStage() {
        return stage;
    }


    public void setExp(int exp) {
        this.exp = exp;
    }

    public static void setLevel(int level) {
        Player.level = level;
    }

    public static void setStage(int stage) {
        Player.stage = stage;
    }

    public static void setDoubleDMG(boolean doubleDMG) {
        Player.doubleDMG = doubleDMG;
    }
}
