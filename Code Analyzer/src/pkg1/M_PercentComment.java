package pkg1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class M_PercentComment {
	private String fileAddress = new String("");
	private String originalCode = new String("");
	private int LOC = 0;
	private int t_LOC = 0;
	private int n_LOC = 0;
	public void setfileAddress(String fileAddr)
	{
		fileAddress = new String(fileAddr);
	}
	public void doProcess() throws IOException
	{
		originalCode = new String("");
		File theFile = new File(fileAddress);
		BufferedReader br = new BufferedReader(new FileReader(theFile));
		String tempStr = new String("");
		while((tempStr = br.readLine()) != null)
		{
			t_LOC++;
			if(tempStr.endsWith(";"))
			{
				LOC++;
				originalCode += tempStr + "\n";
			}
			else
			{
				n_LOC++;
			}
		}
		//System.out.println(originalCode);
		//System.out.println(LOC);
		br.close();
	}
	public String getOriginalCode()
	{
		return originalCode;
	}
	public int getResult()
	{
		return LOC;
	}
	public String displayAllLoc()
	{
		return "Total Lines = " + t_LOC + "\n" + "LOC = " + LOC + "\n" + "none-LOC = " + n_LOC;
	}
}
