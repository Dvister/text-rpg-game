public class Elf extends Enemy{
    Elf(int level){
        setName("ЕЛЬФ");
        setDamage(getDamage() +  Math.round(level * 1.5 * 100.0) / 100.0);
        setHealth(getMaxHealth()+ Math.round(level * 0.5 * 100.0) / 100.0);
        setMaxHealth(getHealth());
    }
    
    public void Attack(Player a){ //Метод завдає шкоди гравцю, Ельф завдає найбільшої шкоди, але найбільше страждає від блоку
        dealtDMG = Math.round(getDamage() * 103.0) / 100.0;

        if(block == true){
            dealtDMG = Math.round((dealtDMG * 0.2) * 100.0) / 100.0;
            block = false;
        }
        a.setHealth(Math.round((a.getHealth() - dealtDMG) * 100.0) / 100.0);
    }
}
