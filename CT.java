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
	private ArrayList<Integer> katastasiB = new ArrayList<>();//�� ���������� ��� ��� ���������� ��� ����� ��� �������������� ��� �� ������
	
	private JPanel panel;
	private JTextField textField;
	private JLabel label; //�� ���������� ��� �� �������
	
	public CT(int katastasis, int arxiki, int arithmos_tel, ArrayList<Integer> telikes, int metavasis,
			ArrayList<Integer> katastasiA, ArrayList<String> metavasi, ArrayList<Integer> katastasiB) {
		this.katastasis = katastasis;
		this.arxiki = arxiki;
		this.arithmos_tel = arithmos_tel;
		this.telikes = telikes;
		this.metavasis = metavasis;
		this.katastasiA = katastasiA;
		this.metavasi = metavasi;
		this.katastasiB = katastasiB;//������������ ���������� �� ��� ����������� ���� � ������
		
		panel = new JPanel();
		
		
		label = new JLabel("���� ���������� ��� �� ����� �������:");
		textField = new JTextField(10);
				
		panel.add(label);
		panel.add(textField);//���������� ��������		
		textField.addActionListener( action );//����� ActionListener ��� �� TextField ���� �� �������������� �� Enter		
		this.setContentPane(panel);			
	    this.setVisible(true);
	    this.setSize(300,200);
	    this.setTitle("CT - Project");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��������� ���������
	}
	
	Action action = new AbstractAction()//��������� ��� Enter
	{
	    public void actionPerformed(ActionEvent e)
	    {
	    	 String checkCT;
			 checkCT = textField.getText();//������ �� ������� ��� �� TextField
			 String[] ar = checkCT.split("");//�� ������ �� ������
			 
			 int current = arxiki;//� �������� ��������� ��� ��������� ��������� ���� ������
			 for (String c : ar)//��� ���� ��������� ��� ������� ������� ������� ����� 3 ArrayList
			 {	
				 for(int y=0;y<katastasiA.size();y++)//����������� �� size ��� � ����� ��� �� ����� ����� �� ����
				 {
					 if(katastasiA.get(y).equals(current))//�� � ��������� � ����� ���� �� ��� ��������
					 {
						 if(metavasi.get(y).equals(c))//�� � ���������� ��� ����� � ������� ������� �� ����� ��� metavasis
						 {
							 current = katastasiB.get(y);//���� � �������� ������� � �
							 break;
						 }
					 }
				 }
			 }
			 int flag = 0;//��������� ��� ������� �� ����� ���� �� ������ ���������
			 for(int r=0;r<telikes.size();r++)
			 {
				 if(telikes.get(r).equals(current))//�� ����� �� ������ ���������
				 {
					 textField.setText("");
					 flag = 1;
					 new GUI_final(1);//��������� �����
				 }	
			 }
			 if(flag == 0) {//�� ��� ����� �� ������ ���������
				 new GUI_final(0);
			 }		 
	    }
	};
	
}
