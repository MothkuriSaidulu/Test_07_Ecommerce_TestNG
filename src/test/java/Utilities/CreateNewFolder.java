package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreateNewFolder {

	public static File outputFile;

	public static void screenshot_TimeStamp_Language_Folder(String language) {

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		outputFile = new File(timeStamp + "./L" + "_" + language);
		outputFile.mkdir();

	}

	// This is for first time folder creation
	public static void screenshot_TestCaseFolder(String testCaseFolderName) {

		String st = outputFile.getAbsolutePath();
		outputFile = new File(st + "./ANMM_" + testCaseFolderName);
		outputFile.mkdirs();

	}

	// This is for second time folder creation
	public static void screenshot_TestCaseFolder1(String sample) {

		String st = outputFile.getAbsolutePath();
		System.out.println("The first path is" + st);
		String str = outputFile.getParent();
		System.out.println("The second path is" + str);
		outputFile = new File(str + "/" + "/" + sample);
		// outputFile = new File(st+"./ANMM_" + "/" +testCaseFolderName);
		outputFile.mkdirs();

	}
}
