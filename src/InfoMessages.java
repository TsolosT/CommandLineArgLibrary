
/**
 * Info Message Class
 * <p>
 * This Class has the all message methods.
 * </p>
 * 
 * @author Theologos Tsolovikos
 * @version 1.0
 * @since March 24-2018
 */

public class InfoMessages {

	/**
	 * public static void helpDisplay() Method
	 * <p>
	 * This method displays a manual guide for the use of Infoff
	 * </p>
	 * 
	 * @return Nothing
	 */
	public static void helpDisplay()

	{
		System.out.println("\n===================================================================");
		System.out.println("InfoFF Manual \nInfo File-Folder program.\n");
		System.out.println("A program for access faster and easy the info of a file or folder.");
		System.out.println("Basic syntax : java Infoff <file/folder name/path>+<.extension> <option> .");
		System.out.println("Extension: .html(HTML file) .txt(Text file)  .odt(OpenDocument file)\n "
				+ " .docx (MsWord file) .pdf(PDF file) .xlsx(MS Excel file) \n"
				+ " .zip(WinRar file) ..\n And all other files extensions");
		System.out.println("Options (Ingores Case): \n\t 1)For Details about file/folder : -sd , /sd , showdetails .");
		System.out.println(
				"\t 2)For taking notes about details into new txt file: -nd , /nd , notesdetails \n(this option is asking for new filename about .txt ).");
		System.out.println(
				"\t 3)For delete file/folder : -d , /d , delete \n(this option asking for verifying if you are sure)");
		System.out.println(
				"\t 4)For changing name of file/folder: -cn , /cn , changename \n(this option asking for new name afterwards)");
		System.out.println(
				"Thats a early version of Infoff that why has only few options \n Coming more options and details next version!");
		System.out.println("========================================================================");

	}

	/**
	 * public static void wrongParameter() Method
	 * <p>
	 * It's a method that is used when the user insert wrong input
	 * </p>
	 * 
	 * @return nothing.
	 */
	public static void wrongParameter() {
		System.out.println("You typed wrong the parameter.Try again");
		System.exit(0);
	}

	/**
	 * public static void nullParameter() Method
	 * <p>
	 * It's a method that is used when the user doesn't insert any input
	 * </p>
	 * 
	 * @return nothing.
	 */
	public static void nullParameter() {
		System.out.println(
				"Error.Give an argument with Infoff \nExample : java Infoff <file/folder Name> <parameter>\nOtherwise type:java Infoff -h (or help) for more details about Infoff ");
		System.exit(0);
	}

	/**
	 * public static void fileError() Method
	 * <p>
	 * It's a method that is used when the user insert wrong file name
	 * </p>
	 * 
	 * @param filename
	 *            Its String argument that it use to display the name of the file in
	 *            the message.
	 * @return nothing.
	 */
	public static void fileError(String filename) {
		System.out.println("Something went wrong with " + filename
				+ "!\nCheck again if the file name is correct.\nAnd check if the path is the right one.\nElse try again!");
		System.exit(0);
	}

	/**
	 * public static void emptyParameter() Method
	 * <p>
	 * It's a method that is used when the user doesn't insert any option
	 * </p>
	 * 
	 * @return nothing.
	 */
	public static void emptyParameter() {
		System.out.println(
				"Error.You typed a file without parameter!\nPlease  type it again with a parameter.. \n For more info about parameter"
						+ "run as: java Infoff help");
		System.exit(0);
	}
}
