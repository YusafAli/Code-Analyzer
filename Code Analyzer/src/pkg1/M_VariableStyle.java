package pkg1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class M_VariableStyle {
	private String fileAddress = null;
	private LinkedList<String[]> variableName = new LinkedList<String[]>();
	@SuppressWarnings("unused")
	private String originalCode = new String("");
	public void setfileAddress(String fileAddr)
	{
		fileAddress = new String(fileAddr);
	}
	
	public void doProcess() throws IOException
	{
		File theFile = new File(fileAddress);
		BufferedReader br = new BufferedReader(new FileReader(theFile));
		String tempStr = new String("");
		while((tempStr = br.readLine()) != null)
		{
			originalCode += tempStr + "\n";
			if(tempStr.contains("int "))
			{
				String[] razor = tempStr.split(" ");
				System.out.println(Arrays.toString(razor));
				variableName.add(razor);
			}
		}
		br.close();
	}
	public String getResult()
	{
		ListIterator<String[]> li = variableName.listIterator();
		String tempStr = new String("");
		while(li.hasNext())
			tempStr += li.next() + "\n";
		return new String(variableName.size() + "\n" + tempStr);
	}
	public void displayAllVariable()
	{
		System.out.println(variableName.getFirst());
	}
}
