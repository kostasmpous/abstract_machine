import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class FileHandler {

	private ArrayList<String> lines;
	
	public FileHandler(String filename) {
		BufferedReader reader;//Δηλωνω τον reader για να ανοιξω το αρχειο
		ArrayList<String> lines = new ArrayList<String>();//ArrayList που περναω τις γραμμες του αρχειου
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();//διαβαζω καθε γραμμη
			while (line != null) {
				lines.add(line);//προσθετω την γραμμη στον ArrayList
				line = reader.readLine();
			}
			reader.close();//κλεινω τον reader
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.lines = lines;//περναω την ArrayList στην μεταβλητη της κλασης
	}
	
	public void excecute() {//ξεκιναει η αρχικοποποιηση των μεταβλητων την κλασης
		int katastasis;
		int arxiki;
		int arithmos_tel;
		ArrayList<Integer> telikes = new ArrayList<>();
		int metavasis;
		ArrayList<Integer> katastasiA = new ArrayList<>();
		ArrayList<String> metavasi = new ArrayList<>();
		ArrayList<Integer> katastasiB = new ArrayList<>();//δομες για την αποθηκευση των σοτιχειων του αυτοματου απο το αρχειο
		int i=0;//μετρητης για τον πινακα lines με τις γραμμες του αρχειου
		
		katastasis = Integer.parseInt(lines.get(i).replaceAll("\\s+",""));//ποσες καταστασεις εχει
		i++;
		
		arxiki = Integer.parseInt(lines.get(i).replaceAll("\\s+",""));//ποια ειναι η αρχικη
		i++;
		
		arithmos_tel = Integer.parseInt(lines.get(i).replaceAll("\\s+",""));//ποσες τελικες καταστασεις εχει
		i++;
		
		String ex = lines.get(i);
		ex = ex.replaceAll("\\s+","");//βγαζω τα κενα και τους ειδικους χαρακτηρες ενος αρχειου
		
		String[] arr = ex.split("");//χωριζω καθε χαρακτηρα της σειρας και τα βαζω σε ενα πινακα
		
		for(int y = 0; y<arithmos_tel;y++)//διαβαζω τις τελικες καταστασεις
		{
			int number = Integer.parseInt(arr[y]);//παιρνω καθε στοιχειο του πινακα και το μετατρεπω σε int
			telikes.add(number);//το προσθετω στον ArrayList που εφτιαξα
		}
		i++;
		
		metavasis = Integer.parseInt(lines.get(i).replaceAll("\\s+",""));//διαβαζω ποσες ειναι οι μεταβασεις
		i++;
		
		for(int y = i; y<i + metavasis;y++)//διαβαζω τις μεταβασεις σειρα-σειρα
		{
			String ex1 = lines.get(y);
			ex1 = ex1.replaceAll("\\s+","");//αφαιρω κενα και ειδικους χαρακτηρες
			
			String[] arr1 = ex1.split("");//και καθε γραμμη την περναω σε ενα πινακα
			
			katastasiA.add(Integer.parseInt(arr1[0]));//στο πρωτο κελι η πρωτη κατασταση
			
			metavasi.add(arr1[1]);//στο δευτερο η εισοδος που πρεπει να εχω για να γινει η μεταβαση στην 2η κατασταση
			
			katastasiB.add(Integer.parseInt(arr1[2]));//η 2η κατασταση
		}
		
		new CT(katastasis,arxiki,arithmos_tel,telikes,metavasis,katastasiA,metavasi,katastasiB);//στελνω ολες τις δομες στην κλαση CT
		    
		}  
		
		
		
		
	}
	

