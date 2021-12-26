
import java.io.*;
import java.nio.file.*;

import java.util.*;
import java.math.BigInteger;
public class Solution {
	static final String TEMPLATE = "Case #%d: %s %s";
	static final BigInteger TEN = new BigInteger("10");
	static final BigInteger TWO = new BigInteger("2");
    public static void main(String[] args) throws FileNotFoundException, IOException {
		
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int caseNumber = in.nextInt();

        for (int i = 1; i <= caseNumber; i++) {			
			final String input = in.next();
			BigInteger a = BigInteger.ZERO;
			BigInteger b = BigInteger.ZERO;
			char c = '4';
			for(int k = input.length()-1,e=0; k >=0; k--,e++){
				char currentChar = input.charAt(k);
				BigInteger current = new BigInteger(""+currentChar);
				if(currentChar == c){
					current = TWO.multiply(TEN.pow(e));
					a = a.add(current);
					b = b.add(current);
				}else{
					
					current = current.multiply(TEN.pow(e));
					a = a.add(current);
				}
			}
			String output = String.format(TEMPLATE, i,a,b);
            System.out.println(output);
			
        }
		in.close();
    }
}
