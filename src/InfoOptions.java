import java.util.ArrayList;

/**
 * Info Options Class
 * <p>
 * In this class it create's and gives values to all options that the Infoff
 * needs.
 * </p>
 * 
 * @param HelpOpt
 *            It's a ArrayList<String> that contains help options.
 * @param DisplayOpt
 *            It's a ArrayList<String> that contains display options.
 * @param NoteOpt
 *            It's a ArrayList<String> that contains notes display options.
 * @param DelOpt
 *            It's a ArrayList<String> that contains delete options.
 * @param ChangeNameOpt
 *            It's a ArrayList<String> that contains change name options.
 * @see ArrayList
 *
 * @author Theologos Tsolovikos
 * @version 1.0
 * @since March 24-2018
 */

public class InfoOptions {

	ArrayList<String> HelpOpt;
	ArrayList<String> DisplayOpt;
	ArrayList<String> NoteOpt;
	ArrayList<String> DelOpt;
	ArrayList<String> ChangeNameOpt;

	/**
	 * Constructor
	 * <p>
	 * It creates & initialize all options with the proper values.
	 * </p>
	 */
	public InfoOptions() {
		HelpOpt = new ArrayList<String>();
		DisplayOpt = new ArrayList<String>();
		NoteOpt = new ArrayList<String>();
		DelOpt = new ArrayList<String>();
		ChangeNameOpt = new ArrayList<String>();
		setDisplay();
		setHelp();
		setNote();
		setDel();
		setChangeName();
	}

	/**
	 * private void setDisplay() Method
	 * <p>
	 * A private method that add the proper values to DisplayOpt ArrayList.
	 * </p>
	 * 
	 * @return Nothing.
	 */
	private void setDisplay() {
		DisplayOpt.add("-sd");
		DisplayOpt.add("/sd");
		DisplayOpt.add("showdetails");

	}

	/**
	 * private void setHelp() Method
	 * <p>
	 * A private method that add the proper values to HelpOpt ArrayList.
	 * </p>
	 * 
	 * @return Nothing.
	 */
	private void setHelp() {
		HelpOpt.add("-h");
		HelpOpt.add("/h");
		HelpOpt.add("help");
	}

	/**
	 * private void setNote() Method
	 * <p>
	 * A private method that add the proper values to NoteOpt ArrayList.
	 * </p>
	 * 
	 * @return Nothing.
	 */
	private void setNote() {
		NoteOpt.add("-nd");
		NoteOpt.add("/nd");
		NoteOpt.add("notedetails");

	}

	/**
	 * private void setDel() Method
	 * <p>
	 * A private method that add the proper values to DelOpt ArrayList.
	 * </p>
	 * 
	 * @return Nothing.
	 */
	private void setDel() {
		DelOpt.add("-d");
		DelOpt.add("/d");
		DelOpt.add("delete");

	}

	/**
	 * private void setChangeName() Method
	 * <p>
	 * A private method that add the proper values to ChangeNameOpt ArrayList.
	 * </p>
	 * 
	 * @return Nothing.
	 */
	private void setChangeName() {
		ChangeNameOpt.add("-cn");
		ChangeNameOpt.add("/cn");
		ChangeNameOpt.add("changename");

	}

	/**
	 * public boolean DisplayOptExist(String arg) Method
	 * 
	 * @param arg
	 *            It takes as arg the second parameter and check if exist in
	 *            options.
	 * @return true/false
	 */
	public boolean DisplayOptExist(String arg) {
		boolean val = false;
		for (String s : DisplayOpt) {
			if (arg.equalsIgnoreCase(s)) {
				val = true;
				return val;

			}
		}
		return val;
	}

	/**
	 * public boolean NoteOptExist(String arg) Method
	 * 
	 * @param arg
	 *            It takes as arg the second parameter and check if exist in
	 *            options.
	 * @return true/false
	 */
	public boolean NoteOptExist(String arg) {
		boolean val = false;
		for (String s : NoteOpt) {
			if (arg.equalsIgnoreCase(s)) {
				val = true;
				return val;

			}
		}
		return val;
	}

	/**
	 * public boolean HelpOptExist(String arg) Method
	 * 
	 * @param arg
	 *            It takes as arg the second parameter and check if exist in
	 *            options.
	 * @return true/false
	 */
	public boolean HelpOptExist(String arg) {
		boolean val = false;
		for (String s : HelpOpt) {
			if (arg.equalsIgnoreCase(s)) {
				val = true;
				return val;

			}
		}
		return val;
	}

	/**
	 * public boolean DeleteOptExist(String arg) Method
	 *
	 * @param arg
	 *            It takes as arg the second parameter and check if exist in
	 *            options.
	 * @return true/false
	 */
	public boolean DeleteOptExist(String arg) {
		boolean val = false;
		for (String s : DelOpt) {
			if (arg.equalsIgnoreCase(s)) {
				val = true;
				return val;

			}
		}
		return val;
	}

	/**
	 * public boolean ChangeNameOptExist(String arg) Method
	 * 
	 * @param arg
	 *            It takes as arg the second parameter and check if exist in
	 *            options.
	 * @return true/false
	 */
	public boolean ChangeNameOptExist(String arg) {
		boolean val = false;
		for (String s : ChangeNameOpt) {
			if (arg.equalsIgnoreCase(s)) {
				val = true;
				return val;

			}
		}
		return val;
	}

}
