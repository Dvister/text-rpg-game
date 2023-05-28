import javax.swing.*;
import java.awt.event.*;  
import java.awt.*;

public class retryFrame extends main{ //Конструктор, який використовується, коли здоров'я гравця досягає 0, дає гравцю можливість почати гру знову чи ні (що закриває гру)
    
    JFrame retry = new JFrame();
        
    JPanel buttons = new JPanel(new FlowLayout());
    JPanel panel = new JPanel(new BorderLayout());
    JPanel top = new JPanel();

    JButton yes = new JButton("Так");
    JButton no = new JButton("Ні");
    
    JTextArea ta = new JTextArea();
    JLabel title = new JLabel("Ти загинув! Ти дійшов до стадії: " + getPlayer().getStage() +"!");
    JLabel again = new JLabel("Хочете зіграти ще раз?");
    
    retryFrame(){
        
        ta.setText("Ваша статистика за цей етап :\nІм'я:" + getPlayer().getName() + "\nРівень:" + getPlayer().getLevel() + "\nМаксЗдоров'я:" + getPlayer().getMaxHealth() + "\nЕтап: " + getPlayer().getStage() );
        ta.setEditable(false);

        buttons.add(yes);
        buttons.add(no);
        
        title.setHorizontalAlignment(JLabel.CENTER);
        again.setHorizontalAlignment(JLabel.CENTER);

        top.add(title);

        panel.add(again,BorderLayout.CENTER);
        panel.add(buttons,BorderLayout.SOUTH);

        retry.setLayout(new BorderLayout());
        retry.add(top,BorderLayout.NORTH);
        retry.add(ta,BorderLayout.CENTER);
        retry.add(panel,BorderLayout.SOUTH);

        ta.setBorder(BorderFactory.createEmptyBorder(50, 200, 0, 0));
        title.setBorder(BorderFactory.createEmptyBorder(25, 0, 25, 0));
        buttons.setBorder(BorderFactory.createEmptyBorder(10, 0, 23, 0));
        again.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        yes.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                retry.dispose();
                reset();
            }
        });

        no.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        buttons.setBackground(new Color(0,0,0));
        panel.setBackground(new Color(0,0,0));
        top.setBackground(new Color(0,0,0));

        title.setForeground(new Color(255,255,255));
    
        again.setForeground(new Color(255,255,255));

        ta.setBackground(new Color(59, 61, 64));
        ta.setForeground(new Color(255,255,255));
        
        yes.setBackground(new Color(59, 61, 64));
        yes.setForeground(new Color(255,255,255));
        
        no.setBackground(new Color(59, 61, 64));
        no.setForeground(new Color(255,255,255));
        
        CreateWindow(retry);
    }

    public void reset(){ //Метод перезавантажує всю статистику, повертає гравця в головне меню
        
        setPlayer(new Player(getPlayer().getName()));
        getPlayer().setStage(1);
        System.out.println(getPlayer().getStage());
        setCurrentEnemy(List.pickEnemy(getPlayer().getStage()));
        
        new menuFrame();
    }
}

