package ss;

import java.io.*;
import java.util.*;
public class SecretSanta {

	public static void main(String[] args) throws IOException {
		List <String> people = new LinkedList<>();
		String name = new String();
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0].toString()));
			try {
				while((name = br.readLine())!=null) {
					people.add(new String(name));
				}
			br.close();	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List <String> list = new LinkedList<>();
		while(!people.isEmpty()) {
			Random rand = new Random();
			int indx;
			indx = Math.abs(rand.nextInt()%people.size());
			list.add(people.get(indx));
			people.remove(indx);
		}
		for(int i=0;i<list.size();i++) {			
			BufferedWriter bw = new BufferedWriter(new FileWriter(new String(("Messaggio per " + list.get(i) +".txt"))));
			bw.write(("Lei è stata/o estratta/o per fare un magnifico dono a: " + list.get((i+1)%list.size())));
			bw.close();
		}
		
		
	}

}
