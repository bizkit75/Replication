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
	String FolderPathCork = "src/Cork";
	String FolderPathDublin = "src/Dublin";
	

	void ListFiles() {
		
		File f = new File(FolderPathCork);
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
				arrayLinesFileCork.add(Lines);
			}

			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	public File[] getListfile() {
		ListFiles();
		return listfile;
	}

	public ArrayList<String> getArrayLines() {
		return arrayLinesFileDublin;
	}
	public ArrayList<String> getarrayLinesFileCork() {
		return arrayLinesFileCork;
	}
	
}
