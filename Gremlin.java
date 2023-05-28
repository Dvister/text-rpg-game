public class Gremlin extends Enemy{
    Gremlin(int level){
        setName("ГРЕМЛІН");
        setDamage(getDamage() + Math.round((getDamage()*(level-1)) * 100.0) / 100.0);
        setHealth(getMaxHealth() + Math.round((level*0.8) * 100.0) / 100.0);
        setMaxHealth(getHealth());
    }
    
    public void Attack(Player a){ //Метод завдає шкоди гравцю, гремлін завдає трохи більше шкоди, ніж орк, але більше страждає від блокування
        dealtDMG = Math.round(getDamage() * 102.0) / 100.0;

        if(block == true){
            dealtDMG = Math.round((dealtDMG * 0.6) * 100.0) / 100.0;
            block = false;
        }
        
        a.setHealth(Math.round((a.getHealth() - dealtDMG) * 100.0) / 100.0);
    }
}
