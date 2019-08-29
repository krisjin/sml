package org.datacogn.ml.sml.exam1.ml.neuralNetwork.constant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Constant {
        public static final String trainFolder = "datas/digital_recognizer_train";
        public static int digit = -1;
        public static int smallWidth = 28;
        public static int smallHeight = 28;
        
        
        public static void main(String[] args) throws IOException {
        	File file = new File("Datas/test/test.txt");
        	
        	System.out.println(new BufferedReader(new FileReader(file)).readLine());
			
		}
}
