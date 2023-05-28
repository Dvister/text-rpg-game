public class Orc extends Enemy{
    Orc(int level){ 
        setName("ОРК");
        setDamage(getDamage() + Math.round(level * 0.5 * 100.0) / 100.0);
        setHealth(getMaxHealth() + Math.round(level * 1.5 * 100.0) / 100.0);
        setMaxHealth(getHealth());
    }

    public void Attack(Player a){ //Метод завдає шкоди гравцю, орк менше страждає від блоку, але завдає найменшої шкоди
        setDealtDMG(getDamage());

        if(block == true){
            setDealtDMG(Math.round((getDealtDMG() * 0.8) * 100.0) / 100.0);
            block = false;
        }
        a.setHealth(Math.round((a.getHealth() - dealtDMG) * 100.0) / 100.0);
    }
    
}
