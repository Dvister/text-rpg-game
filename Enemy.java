public class Enemy extends Character{

    boolean block = false;
    
    public void Attack(Player a){ //Метод завдає урон гравцю
        setDealtDMG(Math.round(getDamage() * 100.0) / 100.0);

        if(block == true){
            System.out.println("Атаку заблоковано! " + getName() + " наносить менший урон в цей хід!");
            setDealtDMG(dealtDMG*0.6);
            setBlock(false);
        }
        a.setHealth(Math.round((a.getHealth() - dealtDMG) * 100.0) / 100.0);
        System.out.println(getName() + " Атакували тебе на " + getDealtDMG() + ". Тепер у вас є: " + a.getHealth() + " Здоров'я");
    }

    //метод встановлювача для блоку змінних
    
    public void setBlock(boolean block) {
        this.block = block;
    }


}
