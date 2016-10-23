package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class M_VariableStyle {
	private String fileAddress = null;
	@SuppressWarnings("unused")
	private String originalCode = new String("");
	private ArrayList<String> allVariables = new ArrayList<String>();
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
				returnVariableNames(tempStr);
			}
		}
		br.close();
	}
	public String getResult()
	{
		String tempStr = new String("");
		for(int i = 0; i < allVariables.size(); i++)
		{
			tempStr += allVariables.get(i) + '\n';
		}
		return tempStr;
	}
	public void displayAllVariable()
	{
		System.out.println("Nothing");
	}
	public void returnVariableNames(String variableCollection)
	{
		String[] arrayOfVar = variableCollection.split(" ");
		for(int i = 0; i < arrayOfVar.length; i++)
		{
			if(arrayOfVar[i].contains("int"))
			{
				try{
				allVariables.add(arrayOfVar[i+1].toString());}catch(Exception e){}
			}
		}
	}
}
