import java.io.*;

import java.util.*;

public class QR2{
	static int counter = 0;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseNumber = in.nextInt();
        for(int i=0; i< caseNumber; i++){
            String line = in.next();
			StringBuilder result = new StringBuilder();
			line.chars()
			.map(b->b-'0')
			.forEach(b->{
				int diff = counter - b;
				counter = b;
				if(diff<0){
					
					while(diff < 0){
						result.append('(');
						diff++;
					}
				}else if(diff>0){
					while(diff>0){
						result.append(')');
						diff--;
					}
				}
				char c =(char) (b +'0');
				result.append(c);
			});
			while(counter>0){
				result.append(')');
				counter--;
			}
			System.out.printf("Case #%d: %s\n",i+1,result.toString());
        }  
    }
}
