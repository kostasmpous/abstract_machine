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
	
	public GUI_final(int i) {//������ ���� ������������ ����������� � �� ������ ��� �������� � ���
			panel = new JPanel();
			if(i==0) //��� ������ ��� �������� ��� ��������� ������
			{
				label = new JLabel("��� ������ ��� ��������!!!");
			}
			else//������ ��� �������� ��� ��������� ������
			{
				label = new JLabel("������ ��� ��������!!!");
			}
			label1 = new JLabel("������ �� ��������������?");
			button = new JButton("���");
			button1 = new JButton("������");
					
			panel.add(label);
			panel.add(label1);
			panel.add(button1);
			panel.add(button);//���������� ��������
			
			ButtonListener listener = new ButtonListener();
			button.addActionListener(listener);
			
			ButtonListener1 listener1 = new ButtonListener1();
			button1.addActionListener(listener1);//2 button listeners ��� �� ������� �� ��� ������
			
			this.setContentPane(panel);
			
		    this.setVisible(true);
		    this.setSize(300,200);
		    this.setTitle("CT - Project");
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	class ButtonListener implements ActionListener {

		 public void actionPerformed(ActionEvent e) {
			 GUI_final.this.dispose();//������� �� �������� ��� �� ������� � ������� ���� ����
		 }
		} 
	
	class ButtonListener1 implements ActionListener {

		 public void actionPerformed(ActionEvent e) {
			 System.exit(0);//������� �� ���������
		 }
		} 
	
	

}
