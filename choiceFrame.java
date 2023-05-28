import javax.swing.*;
import java.awt.event.*;  
import java.awt.*;
import java.io.*;

public class choiceFrame extends main{

    JFrame choice = new JFrame();
    JPanel top = new JPanel(new BorderLayout());
    JPanel options = new JPanel(new FlowLayout());

    JButton exp = new JButton("Отримати 40 досвіду");
    JButton heal = new JButton("Зцілитися повністю");
    JButton save = new JButton("Зберегти/Вийти");

    JLabel level = new JLabel("Здоров'я: " + getPlayer().getHealth() + "/" + getPlayer().getMaxHealth() + "   Рівень: " + getPlayer().getLevel() + " Досвід: " + getPlayer().getExp() + "/100"  );
    JLabel title = new JLabel("Ти переміг ворога!\n Обирайте винагороду!");
    
    choiceFrame(){ //Конструктор формує кадр, який показується після кожного етапу і дає гравцю вибір перед проходженням етапу

        level.setHorizontalAlignment(JLabel.CENTER);
        
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        top.add(title,BorderLayout.NORTH);
        top.add(level,BorderLayout.SOUTH);
        top.setBorder(BorderFactory.createEmptyBorder(70, 0, 0, 0));

        options.add(exp);
        options.add(heal);
        options.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                choice.dispose();
                new menuFrame();
                save();
            }
        });

        exp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                EXP();
            }
        });

        heal.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                HEAL();
            }
        });

        options.setBackground(new Color(0,0,0));
        level.setForeground(new Color(255,255,255));
        title.setForeground(new Color(255,255,255));
        top.setBackground(new Color(0,0,0));
        
        exp.setForeground(new Color(255,255,255));
        exp.setBackground(new Color(59, 61, 64));

        heal.setForeground(new Color(255,255,255));
        heal.setBackground(new Color(59, 61, 64));

        save.setForeground(new Color(255,255,255));
        save.setBackground(new Color(59, 61, 64));

        choice.setLayout(new BorderLayout());
        choice.add(top,BorderLayout.NORTH);
        choice.add(options,BorderLayout.CENTER);
        choice.add(save,BorderLayout.SOUTH);

        CreateWindow(choice);
    }

    public void EXP(){ //Метод викликається при натисканні кнопки "Отримати досвід", збільшує досвід гравця і переносить гру на наступний етап.
        getPlayer().gainEXP(40);

        getPlayer().setStage((Player.getStage())+1);
        setCurrentEnemy(List.pickEnemy(getPlayer().getStage()));
        choice.dispose();
        new gameFrame();
    }

    public void HEAL(){ //Метод викликається при натисканні кнопки "зцілення", зцілює гравця до максимального рівня здоров'я і переносить гру на наступний етап.
        getPlayer().setHealth(getPlayer().getMaxHealth());
        getPlayer().setStage(getPlayer().getStage()+1);
        setCurrentEnemy(List.pickEnemy(getPlayer().getStage()));
        choice.dispose();
        new gameFrame();
    }

    public void save(){
        
        try{ 
            
            FileOutputStream saveGame = new FileOutputStream("./saves/saveGame");
            ObjectOutputStream savedPlayer = new ObjectOutputStream(saveGame);
            savedPlayer.writeObject(getPlayer());
            savedPlayer.close();

        }
        catch (Exception e) {
            
            e.printStackTrace();
        
        }
    }
    
}

