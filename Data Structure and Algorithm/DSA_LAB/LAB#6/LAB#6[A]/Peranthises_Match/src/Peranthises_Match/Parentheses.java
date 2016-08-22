package Peranthises_Match;
import java.io.*;
import java.util.*;

//import Infix.Link;

//import Infix.Link;
class Link
{
	public  char info;
	public Link link;
}

class Stack
{
	public Link Top=null;
	public void push(char pushed_item) // put item on top of stack
	{ 
		Scanner sc =new Scanner(System.in);
		Link tmp=new Link();
		tmp.info=pushed_item;
		tmp.link=Top;
		Top=tmp;
		//System.out.println("Pushed item :"+(char)Top.info);
		  

	}
	

	public char pop() // take item from top of stack
	{
		Link tmp=Top;
		if(Top==null)
		{
			System.out.println("Stack is empty\n Peran not Match!!\n");
			return '`';
		}
		else
		{
			tmp=Top;
			//System.out.print("poped item " +tmp.info+" ");
			Top=Top.link;
			
		}
		char tmp1=tmp.info;

		return tmp1;

	}
	public String isEmpty() // true if stack is empty
	{
		if(Top==null)
		{
			String TmpResp="Peran Matched!!";
			return TmpResp;
		}
		else
		{
			String TmpResp="Peran Not Matched!!";
			return TmpResp;
		}
	}
}

class Peran
{
	private  char L_PAREN    = '(';
	private  char R_PAREN    = ')';
	private  char L_BRACE    = '{';
	private  char R_BRACE    = '}';
	private  char L_BRACKET  = '[';
	private  char R_BRACKET  = ']';
	private String Key_File;
	public String isBalanced(String Key) {
		Stack stack=new Stack();
		String response="Peran Not Match!!";
		for (int i = 0; i < Key.length(); i++) {

			if(Key.charAt(i) == L_PAREN)
				stack.push(L_PAREN);

			else if (Key.charAt(i) == L_BRACE)
				stack.push(L_BRACE);

			else if (Key.charAt(i) == L_BRACKET)
				stack.push(L_BRACKET);

			else if (Key.charAt(i) == R_PAREN) {
				if (stack.isEmpty()==null)       
				{
					System.out.println(" Don't Matched "+R_PAREN);
					return response;
				}
				if (stack.pop() != L_PAREN) {
					System.out.println(" Don't Matched "+L_PAREN);
					return response;
				}
			}

			else if (Key.charAt(i) == R_BRACE) {
				if (stack.isEmpty()==null) {
					System.out.println(" Don't Matched "+R_BRACE);

					return response;
				}
				if (stack.pop() != L_BRACE){
					System.out.println(" Don't Matched "+L_BRACE);

					return response;
				}
			}

			else if (Key.charAt(i) == R_BRACKET) {
				if (stack.isEmpty()==null) {
					System.out.println(" Don't Matched "+R_BRACKET);

					return response;
				}
				if (stack.pop() != L_BRACKET){
					System.out.println(" Don't Matched "+L_BRACKET);

					return response;
				}
			}
		}
		return stack.isEmpty();
	}
	public void  open_file(String Filename_open) throws IOException
	{
		BufferedReader br=new BufferedReader(new FileReader(Filename_open));
		try{
			StringBuilder sb=new StringBuilder();
			String Line=br.readLine();

			while(Line!=null)
			{
				sb.append(Line);
				sb.append("\n");
				Line=br.readLine();
			}
			Key_File=sb.toString();
			System.out.println(Key_File);
			System.out.println(isBalanced(Key_File));
		}catch(IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			br.close();
		}


	}

}
public class Parentheses {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		Peran per=new Peran();
		int choice;
		File f=null;
		do{
			System.out.println("**Perantheses Matching**");
			System.out.println("Enter Perantheses or expression:");
			String s = sc.next();
			System.out.println(per.isBalanced(s));
			per.open_file("temp");
			System.out.println("Do you want to continue?(1/0)");
			choice=sc.nextInt();
		}while(choice!=0);
	}
}