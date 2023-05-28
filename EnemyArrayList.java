
import java.util.ArrayList;

public class EnemyArrayList {
    
    public static ArrayList <Enemy> EnemyList = new ArrayList<>();
      
    public static ArrayList<Enemy> CreateList(int num){ //Створює arraylist ворожих об'єктів
        
        ArrayList<Enemy> newList = new ArrayList<>();
        newList.add(new Orc(num));
        newList.add(new Elf(num));
        newList.add(new Gremlin(num));

        return newList;
    }
    

    
    public Enemy pickEnemy(int stage){ //Випадково вибирає об'єкт Enemy з arraylist і повертає його
        
        EnemyList = CreateList(stage);
        CreateList(stage);
        int random = (int)(Math.random()*3);

        return EnemyList.get(random);
    }
}
