import java.io.IOException;

/**
 * Infoff Program
 * <p>
 * The <b>Infoff</b> program is a command line application that takes one file
 * name or folder name as argument and with proportioned option option displays
 * it's info.
 * </p>
 * 
 * @see InfoFile
 * @see InfoOptions
 * @see InfoMessages
 * 
 * @author Theologos Tsolovikos
 * @version 1.0
 * @since March 24-2018
 */

public class Infoff {

	/**
	 * This is the main method which makes use of all case for the input, using the
	 * other classes.
	 * 
	 * @param args
	 *            The input parameters,only 2 arguments takes as input.
	 * @param args[0]
	 *            The first parameter or the file/folder name it should be like :
	 *            'filename'.extension .
	 * @param args[1]
	 *            The second parameter is the option that must come along the 1st
	 *            parameter with a space between them.
	 * @return nothing.
	 * @throws IOException
	 *             On input error.
	 * @see IOException
	 */
	public static void main(String[] args) throws IOException {

		if (args.length <= 2 && args.length > 0) // Make's sure that the inputs are only 1-2 parameters.
		{
			InfoOptions opt = new InfoOptions(); // Create & initialize the options parameters.

			if (opt.HelpOptExist(args[0])) // Case that the 1st parameter is help , -h , /h
			{
				InfoMessages.helpDisplay();
			} else if (args.length == 1) // Case that there is no option parameter
			{
				InfoMessages.emptyParameter();
			} else if (args.length == 2) // Case that have insert 2 parameters( filename-option)
			{
				InfoFile file = new InfoFile(args[0]); // Create & initialize the file/folder input as InfoFile object

				if (opt.DisplayOptExist(args[1])) // Case that the given option is showdisplay, /sd ,-sd
				{
					file.details();
				} else if (opt.NoteOptExist(args[1])) // Case that the given option is notedetails , /nd ,-nd
				{
					file.noteDetails();
				} else if (opt.HelpOptExist(args[1])) // Case that the given option is help , /h ,-h
				{
					InfoMessages.helpDisplay();
				} else if (opt.DeleteOptExist(args[1])) // Case that the given option is delete , /d , -d
				{
					file.deleteFile();
				} else if (opt.ChangeNameOptExist(args[1])) // Case that the given option is changename , /cn ,-cn
				{
					file.ChangeName();
				} else // Case that have correct filename but invalid option
				{
					InfoMessages.wrongParameter();
				}
			}
		} else // Case that there are none parameters or more that 2
		{
			InfoMessages.nullParameter();
		}

	}
}
