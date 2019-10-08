

//TO SIMULATION OF DFSM 
/*INPUT: FILE NAME (PATH ) THAT CONTAINS A TRANSITION TABLE 
         and a STRING 
 OUTPUT: YES IF STRING IS ACCEPTED 
         NO IF STRING IS REJECTED */




package fltprogrammingassignment1;

import java.util.ArrayList;//IMPORTING ALL THE PACKAGES 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader; 
import java.io.InputStreamReader;

public class SimDFSM 
{
	private static BufferedReader bufferLine;
	public static void main(String[]arguments)
	{
		/*if(arguments.length<2)// CAN BE USED IF NUMBER OF ARGUMENTS ENTERED IS CORRECT 
		{

			System.err.println("error");
			System.exit(0);
		}*/
		/*BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter file name: ");
        String s = fileName.readLine();
        System.out.println(s);
        BufferedReader br = new BufferedReader(new FileReader(s));*/
		
        
		ArrayList<String>fileLinesList=new ArrayList<String>(); //CREATING A ARRAY LIST
		
		String fileLine;// DECLARING ALL THE VARIABLES 
		String statusOnParsing;
		int line=0;
		
		try
		{// INPUT THE FILE NAME AND READING IT 
			BufferedReader fileName1 = new BufferedReader(new InputStreamReader(System.in));
	        System.out.print("Enter file name: ");
	        String s1 = fileName1.readLine();
	        System.out.println(s1);
	        //BufferedReader bt = new BufferedReader(new FileReader(s1));
			bufferLine=new BufferedReader(new FileReader(s1));
			while((fileLine=bufferLine.readLine())!=null)
			{
				line=line+1;
				fileLinesList.add(fileLine);
			}
			String splitFirstLine[]=fileLinesList.get(0).split(" ");	
					int columns=splitFirstLine.length;
			char data[][]=new char[line][columns+1];
			for(int i=0;i<=line;i++)
			{
				if(i==0)
				{
					for(int j=0;j<splitFirstLine.length;j++)
					{
						data[i][j+1]=splitFirstLine[j].charAt(0);
					}
				}
				else
					if(i!=0 && i<line-1)
					{
						String splitCurrentLine[]=fileLinesList.get(i).split(" ");
								for(int j=0;j<splitCurrentLine.length+1;j++)
								{
									if(j==0)
									{
										data[i][j]=Character.forDigit(i, 10);
									}
									else
									{
										data[i][j]=splitCurrentLine[j-1].charAt(0);
									}
								}
					}
				if(i==line-1)
				{
					data[i][0]=fileLinesList.get(i).charAt(0);
				}
			}
			int line1=1;
			char searchCharacter=' ';
			 System.out.println("Enter String of ur choice: ");// inputting the string
             BufferedReader inputString = new BufferedReader(new InputStreamReader(System.in));
             String input = inputString.readLine();
			for(int i=0;i<input.length();i++)// parsing the transition table 
			{
				char alpha=input.charAt(i);
				if(!input.contains(Character.toString(alpha)))
				{
					System.out.println("invalid input");// if string is invalid 
					System.exit(-1);
			
				}
				for(int j=0;j<=columns;j++)
				{
					if(alpha==data[0][j])
					{
						searchCharacter=data[line1][j];
						if(searchCharacter==data[line1-1][0])
						{
							System.out.println("yes");
							System.exit(-1);
						}
				
					}
				}
				for(int k=1;k<line1;k++)
				{
					if(data[k][0]==searchCharacter)
					{
						line1=k;
					}
				}
			}
			if(searchCharacter==data[line1-1][0])
			{
				statusOnParsing="ÿes";
			}
			else
			{ 
				statusOnParsing="No";
			}
			System.out.println(statusOnParsing);// printing whether string is accepted or not 
					}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			
				}
		catch(IOException e)
		{
			e.printStackTrace();
			
				}
		
			}
		}
	


