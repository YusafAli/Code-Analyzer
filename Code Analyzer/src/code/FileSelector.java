package code;

import java.awt.Component;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FileSelector {
	private Component razor1 = null;
	private String addrOfFile = null;
	
	public FileSelector(JPanel contentPane_1) {
		razor1 = contentPane_1;
	}

	public void openAFile()
	{
		JFileChooser newFile = new JFileChooser();
		int fileVariable = newFile.showOpenDialog(razor1);
		if(fileVariable == JFileChooser.APPROVE_OPTION)
		{
			addrOfFile = newFile.getName(newFile.getSelectedFile());
			addrOfFile = newFile.getCurrentDirectory().toString() + "\\" + addrOfFile;
			//JOptionPane.showMessageDialog(razor1, "Successful");
		}
		else
		{
			addrOfFile = "None Selected";
			//JOptionPane.showMessageDialog(razor1, "Unsuccessful");
		}
	}

	public String getAddressOfFile() {
		return addrOfFile;
	}
}
