package com.mycompany.qround;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 *
 * @author bilal
 */
public class QRound {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        InputStream resourceAsStream = QRound.class.getClassLoader().getResourceAsStream("input.txt");
        InputStreamReader inputReader = new InputStreamReader(resourceAsStream,Charset.forName("UTF-8"));
        Reader bReader = new BufferedReader(inputReader);
        LineNumberReader reader =  new LineNumberReader(bReader);
        int caseNumber = getInt(reader);
        for(int i=0; i< caseNumber; i++){
            int n = getInt(reader);
            byte [][] ints =new byte[n][n];
			int sum = 0;
            int row = 0;
			int column = 0;
            for(int j=0; j<n; j++){
                String line = reader.readLine();
                int counter = 0;
                String[] numbers = line.split(" ");
				byte [] tracers = new byte [n];
				boolean rowFlag = false;
                for(int k=0; k<n; k++){
                    ints[j][k]= Byte.valueOf(numbers[k]);
					int index  = ints[j][k];
					if(tracers[index-1]==1){
						rowFlag=true;
					}else{
						tracers[index-1]=1;
					}
					if(k==j){
						sum+=ints[j][k];
					}
                }
				if(rowFlag){
					row++;
				}
            }
			for(int j=0; j<n; j++){
				boolean columnFlag = false;
				byte [] tracers = new byte [n];
				for(int k=0; k<n; k++){
					int index = ints[k][j];
					if(tracers[index-1]==1){
						columnFlag=true;
					}else{
						tracers[index-1]=1;
					}
				}
				if(columnFlag){
					column++;
				}
			}
			
			String s = "Case #%d: %d %d %d";
			s=String.format(s,i+1,sum,row,column);
			System.out.println(s);
			sum=0;
			row =0;
			column=0;
        }  
    }

    private static int getInt(LineNumberReader reader) throws IOException {
        String caseNumberLine = reader.readLine();
        return Integer.valueOf(caseNumberLine);
    }
}
