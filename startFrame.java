import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import java.awt.event.*;  
import java.awt.*;

public class startFrame extends main{
    
    JFrame window = new JFrame();
        
    JPanel panel = new JPanel(new BorderLayout(2,0));
    JTextField input = new JTextField();
    JLabel label = new JLabel("Будь ласка, введіть своє ім'я:");
    JButton button=new JButton("Відправити");

    startFrame(){ //Конструктор, який використовується для запуску програми, приймає вхідні дані від користувача і використовує їх для створення нового об'єкта Player, після чого переводить програму до головного меню.
                   
        button.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            setPlayer(new Player(input.getText()));
            setCurrentEnemy(List.pickEnemy(Player.getStage()));
            window.dispose(); 
            new menuFrame();
             
        }});

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(new Color(255,255,255));

        button.setForeground(new Color(255,255,255));
        button.setBackground(new Color(59, 61, 64));
        
        input.setSize(10,10);
        input.setForeground(new Color(255,255,255));
        input.setBackground(new Color(0, 0, 0));

        panel.add(label, BorderLayout.NORTH);
        panel.add(button,BorderLayout.SOUTH);
        panel.add(input,BorderLayout.CENTER);
        panel.setBackground(new Color(0,0,0));
            
        panel.setBorder(BorderFactory.createEmptyBorder(150, 200, 150, 200));
        window.add(panel);
        CreateWindow(window);
    }
}
