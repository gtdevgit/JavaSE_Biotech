package com.biotech.process;

import com.biotech.process.model.ListeSymptome;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		ListeSymptome listeSymptome = new ListeSymptome();

		while (line != null) {
			listeSymptome.ajouter(line);
			line = reader.readLine();	// get another symptom
		}

		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write(listeSymptome.toString());
		writer.close();

		System.out.println(listeSymptome.toString());
	}
}
