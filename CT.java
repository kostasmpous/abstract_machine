import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CT extends JFrame{
	private int katastasis;
	private int arxiki;
	private int arithmos_tel;
	private ArrayList<Integer> telikes = new ArrayList<>();
	private int metavasis;
	private ArrayList<Integer> katastasiA = new ArrayList<>();
	private ArrayList<String> metavasi = new ArrayList<>();
	private ArrayList<Integer> katastasiB = new ArrayList<>();//Οι μεταβλητες για την αποθηκευση των δομων που δημιουργηθηκαν απο το αρχειο
	
	private JPanel panel;
	private JTextField textField;
	private JLabel label; //οι μεταβλητες για τα γραφικα
	
	public CT(int katastasis, int arxiki, int arithmos_tel, ArrayList<Integer> telikes, int metavasis,
			ArrayList<Integer> katastasiA, ArrayList<String> metavasi, ArrayList<Integer> katastasiB) {
		this.katastasis = katastasis;
		this.arxiki = arxiki;
		this.arithmos_tel = arithmos_tel;
		this.telikes = telikes;
		this.metavasis = metavasis;
		this.katastasiA = katastasiA;
		this.metavasi = metavasi;
		this.katastasiB = katastasiB;//αρχικοποιηση μεταβλητων με τις πληροφοριες αποτ ο αρχειο
		
		panel = new JPanel();
		
		
		label = new JLabel("Δωσε χαρακτηρες για να γινει ελεγχος:");
		textField = new JTextField(10);
				
		panel.add(label);
		panel.add(textField);//δημιουργια γραφικων		
		textField.addActionListener( action );//χρηση ActionListener για το TextField ωστε να αντιλαμβανεται το Enter		
		this.setContentPane(panel);			
	    this.setVisible(true);
	    this.setSize(300,200);
	    this.setTitle("CT - Project");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Ρυθμισεις παραθυρου
	}
	
	Action action = new AbstractAction()//Χειρισμος του Enter
	{
	    public void actionPerformed(ActionEvent e)
	    {
	    	 String checkCT;
			 checkCT = textField.getText();//παιρνω το κειμενο απο το TextField
			 String[] ar = checkCT.split("");//Το χωριζω σε πινακα
			 
			 int current = arxiki;//η τρεχουσα κατασταση του αυτοματου οριζετραι στην αρχικη
			 for (String c : ar)//για καθε χαρακτηρα της εισοδου γινεται ελεγχος στους 3 ArrayList
			 {	
				 for(int y=0;y<katastasiA.size();y++)//χρησιμοποιω το size του Α καθως και οι τρεις εχουν το ιδιο
				 {
					 if(katastasiA.get(y).equals(current))//αν η κατασταση Α ειναι ιδια με την τρεχουσα
					 {
						 if(metavasi.get(y).equals(c))//αν ο χαρακτηρας που εδωσε ο χρηστης ισουται με αυτων του metavasis
						 {
							 current = katastasiB.get(y);//τοτε η τρεχουσα γινεται η Β
							 break;
						 }
					 }
				 }
			 }
			 int flag = 0;//μεταβλητη που αλλαζει αν οντως ηταν σε τελικη κατασταση
			 for(int r=0;r<telikes.size();r++)
			 {
				 if(telikes.get(r).equals(current))//αν ειναι σε τελικη κατασταση
				 {
					 textField.setText("");
					 flag = 1;
					 new GUI_final(1);//καταλληλη κληση
				 }	
			 }
			 if(flag == 0) {//αν δεν ειναι σε τελικη κατασταση
				 new GUI_final(0);
			 }		 
	    }
	};
	
}
