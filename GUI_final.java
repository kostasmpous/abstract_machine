import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GUI_final extends JFrame{
	
	private JPanel panel;
	private JButton button;
	private JButton button1;
	private JLabel label;
	private JLabel label1;
	
	public GUI_final(int i) {//Εχουμε δυοι διαφορετικες περιπτωσεις ή θα ανηκει στο αυτοματο ή οχι
			panel = new JPanel();
			if(i==0) //δεν ανηκει στο αυτοματο αρα καταλληλο μηνυμα
			{
				label = new JLabel("Δεν ανηκει στο αυτοματο!!!");
			}
			else//ανηκει στο αυτοματο αρα καταλληλο μηνυμα
			{
				label = new JLabel("Ανηκει στο αυτοματο!!!");
			}
			label1 = new JLabel("θελετε να ξαναδοκιμασετε?");
			button = new JButton("Ναι");
			button1 = new JButton("Εξοδος");
					
			panel.add(label);
			panel.add(label1);
			panel.add(button1);
			panel.add(button);//δημιουργια γραφικων
			
			ButtonListener listener = new ButtonListener();
			button.addActionListener(listener);
			
			ButtonListener1 listener1 = new ButtonListener1();
			button1.addActionListener(listener1);//2 button listeners για τα κουμπια οκ και εξοδος
			
			this.setContentPane(panel);
			
		    this.setVisible(true);
		    this.setSize(300,200);
		    this.setTitle("CT - Project");
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	class ButtonListener implements ActionListener {

		 public void actionPerformed(ActionEvent e) {
			 GUI_final.this.dispose();//κλεινει το παραθυρο για να εισαγει ο χρηστης αλλη λεξη
		 }
		} 
	
	class ButtonListener1 implements ActionListener {

		 public void actionPerformed(ActionEvent e) {
			 System.exit(0);//κλεινει το προγραμμα
		 }
		} 
	
	

}
