import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileTreatment {

	File file;
	File[] listfile;
	File[] listfileStopWords;

	ArrayList<String> arrayLinesFileDublin = new ArrayList<String>();
	ArrayList<String> arrayLinesFileCork = new ArrayList<String>();

	String Lines;
	String FolderPath = "src/austen-bronte";
	String FolderPath2 = "src/stopwords";

	void ListFiles() {
		
		File f = new File(FolderPath);
		System.out.println(f.getAbsolutePath());

		listfile = f.listFiles();

		for (int i = 0; i < listfile.length; i++) {

			if (listfile[i].isFile()) {
				System.out.println(i + ". " + listfile[i].toString());
			}
		}

	}

	

	void ReadFile(int indice) {
		file = listfile[indice];

		try {
			FileInputStream fStream = new FileInputStream(file);
			BufferedReader in = new BufferedReader(new InputStreamReader(fStream));

			while (in.ready()) {

				Lines = in.readLine().toString();
				arrayLines.add(Lines);
			}

			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void ReadFileStopWords() {
		/*
		  1. Define the file with the folder of stop words
		  2. ListfileStopWords get all the name of file in the folder (if we have multiple file of stop words)
		  3. Create an inputstream and a buffer to read the file
		  4. While buffer is ready, I add the file into the arraylist arrayLinesStopWords
		  4. When the buffer have finished, I close it
		  
		  arrayLinesStopWords will be transfer to my Questions.class for treatment
		 */

		File f = new File(FolderPath2);
		listfileStopWords = f.listFiles();
		f = listfileStopWords[0];
		System.out.println(listfileStopWords[0]);
		try {
			FileInputStream fStream = new FileInputStream(f);
			BufferedReader in = new BufferedReader(new InputStreamReader(fStream));

			while (in.ready()) {

				Lines = in.readLine().toString();
				arrayLinesStopWords.add(Lines);
				if (arrayLines.size() > 1) {

				}

			}

			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public File[] getListfile() {
		ListFiles2();
		return listfile;
	}

	public ArrayList<String> getArrayLines() {
		return arrayLines;
	}
	public ArrayList<String> getarrayLinesStopWords() {
		return arrayLinesStopWords;
	}
	
}
