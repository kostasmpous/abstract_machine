import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class FileHandler {

	private ArrayList<String> lines;
	
	public FileHandler(String filename) {
		BufferedReader reader;//������ ��� reader ��� �� ������ �� ������
		ArrayList<String> lines = new ArrayList<String>();//ArrayList ��� ������ ��� ������� ��� �������
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();//������� ���� ������
			while (line != null) {
				lines.add(line);//�������� ��� ������ ���� ArrayList
				line = reader.readLine();
			}
			reader.close();//������ ��� reader
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.lines = lines;//������ ��� ArrayList ���� ��������� ��� ������
	}
	
	public void excecute() {//�������� � �������������� ��� ���������� ��� ������
		int katastasis;
		int arxiki;
		int arithmos_tel;
		ArrayList<Integer> telikes = new ArrayList<>();
		int metavasis;
		ArrayList<Integer> katastasiA = new ArrayList<>();
		ArrayList<String> metavasi = new ArrayList<>();
		ArrayList<Integer> katastasiB = new ArrayList<>();//����� ��� ��� ���������� ��� ��������� ��� ��������� ��� �� ������
		int i=0;//�������� ��� ��� ������ lines �� ��� ������� ��� �������
		
		katastasis = Integer.parseInt(lines.get(i).replaceAll("\\s+",""));//����� ����������� ����
		i++;
		
		arxiki = Integer.parseInt(lines.get(i).replaceAll("\\s+",""));//���� ����� � ������
		i++;
		
		arithmos_tel = Integer.parseInt(lines.get(i).replaceAll("\\s+",""));//����� ������� ����������� ����
		i++;
		
		String ex = lines.get(i);
		ex = ex.replaceAll("\\s+","");//����� �� ���� ��� ���� �������� ���������� ���� �������
		
		String[] arr = ex.split("");//������ ���� ��������� ��� ������ ��� �� ���� �� ��� ������
		
		for(int y = 0; y<arithmos_tel;y++)//������� ��� ������� �����������
		{
			int number = Integer.parseInt(arr[y]);//������ ���� �������� ��� ������ ��� �� ��������� �� int
			telikes.add(number);//�� �������� ���� ArrayList ��� �������
		}
		i++;
		
		metavasis = Integer.parseInt(lines.get(i).replaceAll("\\s+",""));//������� ����� ����� �� ����������
		i++;
		
		for(int y = i; y<i + metavasis;y++)//������� ��� ���������� �����-�����
		{
			String ex1 = lines.get(y);
			ex1 = ex1.replaceAll("\\s+","");//������ ���� ��� �������� ����������
			
			String[] arr1 = ex1.split("");//��� ���� ������ ��� ������ �� ��� ������
			
			katastasiA.add(Integer.parseInt(arr1[0]));//��� ����� ���� � ����� ���������
			
			metavasi.add(arr1[1]);//��� ������� � ������� ��� ������ �� ��� ��� �� ����� � �������� ���� 2� ���������
			
			katastasiB.add(Integer.parseInt(arr1[2]));//� 2� ���������
		}
		
		new CT(katastasis,arxiki,arithmos_tel,telikes,metavasis,katastasiA,metavasi,katastasiB);//������ ���� ��� ����� ���� ����� CT
		    
		}  
		
		
		
		
	}
	

