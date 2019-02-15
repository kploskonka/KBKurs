package pl.ksoai.utils;

import java.io.File;
import java.io.IOException;

public class FileUtils {

	public static void createNewFile(String fileName) throws IOException {
		File file = new File(fileName);
		file.createNewFile();
	}

}
