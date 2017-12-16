import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Data {
	
	public static HashMap<Integer,Decument> data = data(); public static HashMap<Integer,Decument> data() {
		HashMap<Integer,Decument> data = new HashMap<Integer,Decument>();
		 
		File dir = new File("data/src");
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++)
			try {
				data.put(i+1, new Decument(files[i],i+1));
//				System.out.println((i+1)+"\t"+data.get(i+1).getName());
			} catch (FileNotFoundException e) {
				e.printStackTrace(); System.out.println("files not found");
			}
		
//		for(Map.Entry<Integer, Decument> m : data.entrySet())
//			System.out.println(m.getKey()+"\t"+m.getValue().getName());
		return data;
	}
	
}
