import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.*;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Collections;

public class Extract {


	public static final void main(String[] args) throws FileNotFoundException{
		
		ArrayList<Attempt> attempt = new ArrayList<>();
		
		File file = new File(args[0]);
		Scanner in = new Scanner(file);


		while(in.hasNextLine()){
    			String line = in.nextLine();
        		
			// process the line.
    			Pattern valid = Pattern.compile("\\]: ([AI][a-z]+)");
			Matcher match = valid.matcher(line);
				
			Pattern add = Pattern.compile("from ((\\d+\\.){3}\\d+)");
			Matcher m = add.matcher(line);
			if(match.find() && m.find()){
				Attempt a = new Attempt(match.group(1), m.group(1),1);
				attempt.add(a);
			}

		}

		for(int i = 0; i < attempt.size(); i++){
			for(int j = i+1; j < attempt.size(); j++){
				if(attempt.get(i).getAdd().equals(attempt.get(j).getAdd())){
					attempt.get(i).addFreq();
					attempt.get(j).changeShow();
				}
			}

		}



		PrintWriter f0 = new PrintWriter(args[1]);


		for(int i = 0; i < attempt.size(); i++){
			if(attempt.get(i).getShow() == true && attempt.get(i).getFreq() >=3 && attempt.get(i).getAtt().equals("Invalid")){
				f0.println(attempt.get(i));
			}
		}
		f0.close();

	}

	
}