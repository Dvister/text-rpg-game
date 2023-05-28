import javax.swing.*;

public class main {
    
    static Player Player ;
    static EnemyArrayList List = new EnemyArrayList();
    static Enemy CurrentEnemy;
    
    public static void main(String[] args) { 
        new startFrame();

    }
    
    public void CreateWindow(JFrame window){

        window.setTitle("Текствоя RPG-гра");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);  
        window.setSize(600,400);  
        window.setVisible(true); 
        
    }

    //Методи геттера та сеттера

    public static Enemy getCurrentEnemy() {
        return CurrentEnemy;
    }

    public static EnemyArrayList getList() {
        return List;
    }
    public static Player getPlayer() {
        return Player;
    }

    public static void setCurrentEnemy(Enemy currentEnemy) {
        CurrentEnemy = currentEnemy;
    }

    public static void setPlayer(Player player) {
        Player = player;
    }

}





