 

//PROGRAM 2: DFSMBuilder - TO BUILD A TRANSITION TABLE ON THE INPUT PROVIDED 
//INPUT: FILE NAME (PATH) and  PATTERN 
//OUTPUT: transition table on the file (the file that was  specified)







package fltprogrammingassignment1;

 import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
 
public class DFMSBuilder {
  
public static void main(String args[])

{
	if(args.length<2)//to check if two arguments are entered 
	{
		System.err.println("ERROR:::: ENTER TWO ARGUMENTS");
		System.exit(0);
	}
	try 
	{
		String fileNamepath1=args[0];//enter the path like "C:/FLT_project/tt.txt"
		String string=args[1];//accbc
		String line1="";
		int num;
		line1=line1+string.charAt(0);//reading the first character and storing it in row1 of the output file 
		for(int i=1;i<string.length();i++)
		{
			if(line1.contains(Character.toString(string.charAt(i))))//adding characters from the input string  to the output file 
			{	
				
		}
			else
			{
				line1=line1+string.charAt(i);
				
			}
	}
		File output=new File(fileNamepath1);//reading the entire path and creating a new output file
		output.createNewFile();//creating a new output file
		FileWriter write=new FileWriter(fileNamepath1);
		BufferedWriter dataWriter=new BufferedWriter(write);
		for(int i=0;i<line1.length();i++)
		{
			char state=line1.charAt(i);
			dataWriter.write(state+" ");
			
		}
		dataWriter.newLine();
		int rows=line1.length()+1;
		int cols=line1.length();
		for(int i=1;i<rows;i++)
		{
			ArrayList<Integer> addtheNumber=new ArrayList<Integer>();//to create array list 
			for(int j=1;j<=cols;j++)
			{
				if(1!=j && j!=1)
				{
					do
					{
						Random r=new Random();
						num=r.nextInt(rows);//creating rows randomly based on the input
					}
					while(num==0 || addtheNumber.contains(num));//to check if it is the number 
					dataWriter.write(Integer.toString(num));//integer to string conversion
					dataWriter.write(" ");//to create a space
					}
				else
				{
					int val=i+1;
					addtheNumber.add(val);
					dataWriter.write(Integer.toString(val));//integer to string conversion 
					dataWriter.write(" ");//to create space in the file
				}
			}
			dataWriter.newLine();
		}
		for(int i=0;i<2;i++)
		{
			if(i==0)
			{
				for(int j=0;j<cols;j++)
				{
					dataWriter.write(Integer.toString(cols+1));
					dataWriter.write(" ");
					
				}
				dataWriter.newLine();
				
				}
			else
			{
				dataWriter.write(Integer.toString(cols+1));
			}
			}
		dataWriter.close();
	}
	catch(IOException e)
	{
		e.printStackTrace();
		}
		finally
		{
        }
	
}
}
