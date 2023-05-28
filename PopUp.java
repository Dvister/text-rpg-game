import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PopUp{

    JButton submit = new JButton("Зрозумів!");
    JFrame menu = new JFrame();
	final JTextArea Tut = new JTextArea("Це пригодницька гра. Ваша мета - пройти якомога вищий рівень! \nНа кожному етапі буде новий ворог, з яким вам потрібно буде битися, щоб просунутися в грі.\nВ кожному бою у вас є можливість атакувати або блокувати (блокування зменшить отриману шкоду)\nПісля завершення етапу у вас є можливість зцілитися або отримати досвід, який ви отримаєте."); 
	JPanel panel = new JPanel(new BorderLayout());
    
	PopUp(){	//Метод відкриває спливаюче вікно, яке показує, як грати у гру.
		
		panel.add(Tut, BorderLayout.CENTER);
		panel.add(submit, BorderLayout.SOUTH);
		Tut.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		Tut.setBackground(new Color(0,0,0));
		Tut.setForeground(new Color(255,255,255));
		submit.setBackground(new Color(59, 61, 64));
		submit.setForeground(new Color(255,255,255));
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.dispose();  
			}
			});

		menu.add(panel);
		menu.setSize(500,500);
		menu.setResizable(false);
		menu.pack();
		menu.setLocationRelativeTo(null);
		menu.setVisible(true);
	
    }

}
