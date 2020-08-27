import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame {
	
	private JPanel panel;
	private JButton button;
	private JTextField textField;
	private JLabel label; //������ �� �������� ��� ���������
	
	public MyFrame() {
				
		panel = new JPanel();				
		label = new JLabel("���� ����� �������:");
		button = new JButton("��");
		textField = new JTextField(10);//��������� �� �������� ��� ���������.
				
		panel.add(label);
		panel.add(textField);
		panel.add(button);//�������� �� �������� ��� ����������� ��� Panel
		
		ButtonListener listener = new ButtonListener();
		button.addActionListener(listener); //�� button listener ��� �� ������ �� 
		
		this.setContentPane(panel);		
	    this.setVisible(true);
	    this.setSize(300,200);
	    this.setTitle("CT - Project");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��������� ��� ������� �� ��������
	}
	class ButtonListener implements ActionListener {//� listener ��� ��
		 public void actionPerformed(ActionEvent e) {
			 String file;
			 file = textField.getText();//������ �� ����� ��� �������
			 FileHandler x = new FileHandler(file);//�� ������ ��� �� ����� ������������ ��� ����������
			 x.excecute();//��� ������� ��� filehandler
			 
		 }
		} 

}
