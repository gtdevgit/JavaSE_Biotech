package com.biotech.process;

import com.biotech.process.model.ListeSymptome;

import java.io.*;
import java.util.Scanner;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0

	private static String getDefaultInputFile(){
		return "symptoms.txt";
	}

	private static String getDefaultOutputFile(){
		return "result.out";
	}

	public static void main(String args[]) throws Exception {

		String inputFile, outputFile;

		try (Scanner scanner = new Scanner(System.in)) {

			String inputMessage = "Entrez le chemin et le nom du fichier à analyser";
			ConsoleFile consoleInput = new ConsoleFile(scanner, inputMessage, getDefaultInputFile());
			inputFile = consoleInput.getFileName();

			if (inputFile.isEmpty()) {
				// default file path
				inputFile = getDefaultInputFile();
			}

			File file = new File(inputFile);
			if (!file.exists()) {
				System.err.println(String.format("Fichier d'input introuvable : %s", file.getAbsolutePath()));
				return;
			}

			String outputMessage = "Entrez le chemin et le nom du fichier à générer";
			ConsoleFile consoleOutput = new ConsoleFile(scanner, outputMessage, getDefaultOutputFile());
			outputFile = consoleOutput.getFileName();

			if (outputFile.isEmpty()) {
				// default file path
				outputFile = getDefaultOutputFile();
			}
		}
		ListeSymptome listeSymptome = new ListeSymptome();

		// first get input
		try (BufferedReader reader = new BufferedReader (new FileReader(inputFile))) {
			String line = reader.readLine();
			while (line != null) {
				listeSymptome.ajouter(line);
				line = reader.readLine();    // get another symptom
			}
		}

		// next generate output
		try (FileWriter writer = new FileWriter (outputFile)){
			writer.write(listeSymptome.toString());
		}

		System.out.println(listeSymptome.toString());
	}
}
