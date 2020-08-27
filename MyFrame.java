import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame {
	
	private JPanel panel;
	private JButton button;
	private JTextField textField;
	private JLabel label; //Δηλωνω τα στοιχεια του παραθυρου
	
	public MyFrame() {
				
		panel = new JPanel();				
		label = new JLabel("Δωσε ονομα αρχείου:");
		button = new JButton("ΟΚ");
		textField = new JTextField(10);//Δημιουργώ τα στοιχεια του παραθυρου.
				
		panel.add(label);
		panel.add(textField);
		panel.add(button);//προσθετω τα στοιχεια που δημιουργησα στο Panel
		
		ButtonListener listener = new ButtonListener();
		button.addActionListener(listener); //Το button listener για το κουμπι ΟΚ 
		
		this.setContentPane(panel);		
	    this.setVisible(true);
	    this.setSize(300,200);
	    this.setTitle("CT - Project");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Ρυθμισεις που αφορουν το παραθυρο
	}
	class ButtonListener implements ActionListener {//Ο listener του ΟΚ
		 public void actionPerformed(ActionEvent e) {
			 String file;
			 file = textField.getText();//Παιρνω το ονομα του αρχειου
			 FileHandler x = new FileHandler(file);//το ανοιγω για να γινει αρχικοποιηση των μεταβλητων
			 x.excecute();//και ξεκιναω την filehandler
			 
		 }
		} 

}
