import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class menuFrame extends main{

    JFrame window = new JFrame();
        
    JLabel title = new JLabel("===Меню===");
    
    JButton Start = new JButton("Почати");
    JButton Tutorial = new JButton("Посібник");
    JButton Exit = new JButton("Вихід.");
    JButton Continue = new JButton("Продовжити");
    
    JPanel buttons = new JPanel(new FlowLayout(20,95,0));
    JPanel panel = new JPanel(new BorderLayout());
        
    menuFrame(){ //Конструктор формує головне меню програми, дає можливість запустити гру, показати підручник або вийти з програми
        
        buttons.add(Start);
        buttons.add(Tutorial);
        buttons.add(Exit);
        
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(100, 0, 70, 0));

        panel.add(title,BorderLayout.NORTH);
        panel.add(buttons,BorderLayout.CENTER);
        panel.add(Continue,BorderLayout.SOUTH);

        Continue.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                window.dispose();
                load();
            }   
        });

        Exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        Tutorial.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new PopUp();
            }
        });

        Start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Player = new Player(Player.getName());
    
                setCurrentEnemy(List.pickEnemy(getPlayer().getStage()));
                window.dispose();
                new gameFrame();
            }
        });

        title.setForeground(new Color(255,255,255));

        Continue.setForeground(new Color(255,255,255));
        Continue.setBackground(new Color(59, 61, 64));

        Start.setForeground(new Color(255,255,255));
        Start.setBackground(new Color(59, 61, 64));

        Tutorial.setForeground(new Color(255,255,255));
        Tutorial.setBackground(new Color(59, 61, 64));

        Exit.setForeground(new Color(255,255,255));
        Exit.setBackground(new Color(59, 61, 64));

        buttons.setBackground(new Color(0,0,0));
        
        panel.setBackground(new Color(0,0,0));
        
        window.add(panel);
        CreateWindow(window);

    }

    public Object readPlayer(){
        try {
            
            FileInputStream save = new FileInputStream("./saves/saveGame");
            ObjectInputStream player = new ObjectInputStream(save);
            
            Object one = player.readObject();
            player.close();
            
            return one;
 
        } catch (Exception e) {
            
            e.printStackTrace();
            
            return null;
        }
    }

    public void load(){
        setPlayer((Player)readPlayer());
        new choiceFrame();
    }
}

