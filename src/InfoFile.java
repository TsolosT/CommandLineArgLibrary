import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Info File Class
 * <p>
 * This class contains all method that correspond to the proper option from
 * {@link InfoOption}. All method are executed at {@link Infoff} main.
 * </p>
 * 
 * @param file
 *            It's the File arg that the user gives as input.
 * @param name
 *            It's a String arg that will take as value the name of file.
 * @param creationDate
 *            It's a FileTime arg that will take as value the creation date of
 *            file.
 * @param path
 *            It's a String arg that will take as value the path of file.
 * @param type
 *            It's a String arg that will take as value the extension of file.
 * @param LAtime
 *            It's a FileTime arg that will take as value the last access time
 *            of file.
 * @param LMTime
 *            It's a FileTime arg that will take as value the last modified time
 *            of file.
 * @param fsize
 *            It's a String arg that will take as value the file size.
 * @param attr
 *            It's a BasicFileAttributes object that will be used to return some
 *            basic file attributes of the file.
 * @param notes
 *            It's a ArrayList<String> arg[] that will be used to store the info
 *            of the file for export into .txt method.
 * 
 * @author Theologos Tsolovikos
 * @version 1.0
 * @since March 24-2018
 *
 * @see java.io.File
 * @see java.io.FileWriter
 * @see java.io.IOException
 * @see java.io.Writer
 * @see java.nio.file.Files
 * @see java.nio.file.Paths
 * @see java.nio.file.attribute.BasicFileAttributes
 * @see java.nio.file.attribute.FileTime
 * @see java.util.ArrayList
 * @see java.util.Scanner
 */
public class InfoFile {

	File file;
	String name;
	FileTime creationDate;
	String path;
	String type;
	FileTime LAtime;
	FileTime LMtime;
	String fsize;
	BasicFileAttributes attr;
	ArrayList<String> notes;

	/**
	 * Constructor
	 * <p>
	 * It check if the filename is exist as file/folder then creates & initialize
	 * all variable that needs. Otherwise it catch an exception
	 * {@link InfoMessages.fileError()}.
	 * </p>
	 * 
	 * @param filename
	 *            It's the name or the path of the file that user gave as input.
	 */
	public InfoFile(String filename) {
		try {

			file = new File(filename);
			if (file.isFile()) {
				System.out.println("It's a file");
				setFile(filename);
			} else if (file.isDirectory()) {
				System.out.println("It's a Directory");
				setFolder(filename);
			}
			SetNotes();
		} catch (Exception e) {
			InfoMessages.fileError(filename);
		}

	}

	/**
	 * public void details() Method
	 * <p>
	 * It print out in console the file's info
	 * </p>
	 * 
	 * @return Nothing.
	 */
	public void details() {
		System.out.println("File Name: " + name);
		System.out.println("Full Path: " + path);
		System.out.println("Extension: ." + type);
		System.out.println("Creation Date: " + creationDate);
		System.out.println("Last Access Date: " + LAtime);
		System.out.println("Last Modified Date: " + LMtime);
		System.out.println("File Size: " + fsize + " bytes");
	}

	/**
	 * public void deleteFile() Method
	 * <p>
	 * It delete the file that user gave as input.but first it ask for confirmation.
	 * </p>
	 * 
	 * @return Nothing.
	 */
	public void deleteFile() {
		Scanner ans = new Scanner(System.in);
		System.out.println("Are you sure you want to delete " + name + " file ?");
		String answer = ans.nextLine();
		ans.close();
		if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
			try {
				System.out.println("Trying delete the file..");
				file.delete();
				System.out.println("The " + name + " file has been deleted!");
			} catch (Exception e) {
				System.out.println("Something went wrong!Cound't  delete " + name);
			}
		} else
			System.out.println("Smart choice or not?bye");
	}

	/**
	 * public void notedetails() Method
	 * <p>
	 * It will store all details from the given file into new text file and ask user
	 * for a name for new file.
	 * </p>
	 * 
	 * @return Nothing.
	 * @throws IOException
	 */
	public void noteDetails() throws IOException {

		Writer fileWriter = new FileWriter(setNewNoteName() + ".txt", false);
		System.out.println("Creating file....");
		System.out.println("Writting file...");
		for (String note : notes) {
			fileWriter.write(note);
		}
		System.out.println("Done..");
		fileWriter.close();

	}

	/**
	 * public void ChangeName() Method
	 * <p>
	 * It change the name of the given file.The user will be asked to give a new
	 * name.
	 * </p>
	 * 
	 * @return Nothing.
	 * @throws IOException
	 */
	public void ChangeName() throws IOException {
		Scanner ans = new Scanner(System.in);
		String newname;
		String oldname = name;
		System.out.println("Enter new name: ");
		newname = ans.next() + "." + type;
		ans.close();
		// File (or directory) with new name
		File file2 = new File(newname);
		// Rename file (or directory)
		if (file2.exists()) {
			System.out.println("A file exist with name " + newname + " already try again with other name..");
		} else {
			boolean success = file.renameTo(file2);
			System.out.println("The file have been rename from " + oldname + " to " + newname + " succefully");
			if (!success) {
				// File was not successfully renamed
				System.out.println("Ops..Something went wrong..Try again!");
			}
		}
	}

	/**
	 * private void setNewNoteName() Method
	 * <p>
	 * It's ask the user for new name for the note file.
	 * </p>
	 * 
	 * @return Nothing.
	 */
	private String setNewNoteName() {
		Scanner read = new Scanner(System.in);
		String newname;
		System.out.println("Enter a name for the note txt file: ");
		newname = read.nextLine();
		read.close();
		return newname;
	}

	/**
	 * private void SeNotes() Method
	 * <p>
	 * It add the values into a ArrayList<String> that will be used in
	 * {@link noteDetails()} method.
	 * </p>
	 * 
	 * @return Nothing.
	 */
	private void SetNotes() {
		notes.add("File Name: " + name);
		notes.add("Full Path: " + path);
		notes.add("Extension: " + type);
		notes.add("Creation Date : " + creationDate);
		notes.add("Last Access Date: " + LAtime);
		notes.add("Last Modified Date: " + LMtime);
		notes.add("File Size: " + fsize + " bytes \n");
	}

	/**
	 * private void setFile(String filename) Method
	 * <p>
	 * It's set all value of file into proper variables.
	 * </p>
	 * 
	 * @param filename
	 *            It's a String filename that user gave as input.
	 * @return Nothing.
	 * @throws IOException
	 */
	private void setFile(String filename) throws IOException {
		attr = Files.readAttributes(Paths.get(filename), BasicFileAttributes.class);
		name = file.getName();
		path = file.getAbsolutePath();
		type = getFileExtension(file);
		LAtime = attr.lastAccessTime();
		LMtime = attr.lastModifiedTime();
		fsize = Long.toString(file.length());
		creationDate = attr.creationTime();
		notes = new ArrayList<String>();
	}

	/**
	 * private void setFolder(String filename) Method
	 * <p>
	 * It's set all value of folder into proper variables.
	 * </p>
	 * 
	 * @param filename
	 *            It's a String filename that user gave as input.
	 * @return Nothing.
	 * @throws IOException
	 */
	private void setFolder(String filename) throws IOException {
		attr = Files.readAttributes(Paths.get(filename), BasicFileAttributes.class);
		name = file.getName();
		path = file.getAbsolutePath();
		LAtime = attr.lastAccessTime();
		LMtime = attr.lastModifiedTime();
		fsize = Long.toString(getFolderSize(file));
		creationDate = attr.creationTime();
		notes = new ArrayList<String>();
	}

	/**
	 * private long getFolderSize(File folder) Method
	 * <p>
	 * It's gets the size of the given folder.
	 * </p>
	 * 
	 * @param folder
	 *            It's a File object that user gave.
	 * @return the length of folder.
	 */
	private long getFolderSize(File folder) {
		long length = 0;
		File[] files = folder.listFiles();

		int count = files.length;

		for (int i = 0; i < count; i++) {
			if (files[i].isFile()) {
				length += files[i].length();
			} else {
				length += getFolderSize(files[i]);
			}
		}
		return length;
	}

	/**
	 * private static String getFileExtension(File file) Method
	 * <p>
	 * It gets the extension of the given file.
	 * </p>
	 * 
	 * @param file
	 *            It's a File object that user gave.
	 * @return The extension of file.
	 */
	private static String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}
}
