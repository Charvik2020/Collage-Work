//package Infix;

import java.io.*;
import java.util.*;
class Link
{
	public  double info;
	public Link link;
}

class Stack
{
	public Link Top=null;
	public double size=0;
	public void push(double pushed_item) // put item on top of stack
	{
		Scanner sc =new Scanner(System.in);
		Link tmp=new Link();
		tmp.info=pushed_item;
		tmp.link=Top;
		Top=tmp;
		System.out.println("Pushed item :"+(char)Top.info);
		size++;

	}
	public void post_push(double pushed_item) // put item on top of stack
	{
		Scanner sc =new Scanner(System.in);
		Link tmp=new Link();
		tmp.info=pushed_item;
		tmp.link=Top;
		Top=tmp;
		System.out.println("Answer :"+pushed_item);
		size++;

	}
	public double post_pop()
	{
		Link tmp=Top;
		if(Top==null)
		{
			System.out.println("Stack is empty\n");
		}
		else
		{
			tmp=Top;
			System.out.println("poped item is "+tmp.info);
			Top=Top.link;
			size--;
		}

		return tmp.info;

	}

	public char pop() // take item from top of stack
	{
		Link tmp=Top;
		if(Top==null)
		{
			System.out.println("Stack is empty\n");
		}
		else
		{
			tmp=Top;
			System.out.println("poped item is "+(char)tmp.info);
			Top=Top.link;
			size--;
		}
		char tmp1=(char)tmp.info;

		return tmp1;

	}
	public char peek() // peek at top of stack
	{
		if(Top==null)
		{
			System.out.println("Stack is empty\n");
		}
		else
		{

			System.out.println("Top of the Stack:"+Top.info);
		}
		char tmp1=(char)Top.info;
		return tmp1;
	}
	public boolean isEmpty() // true if stack is empty
	{
		if(Top==null)
			return true;
		else
			return false;
	}
	public double size() // return size
	{
		return size;
	}
	public char peek_n_element(double pos1) // return item at index n
	{
		Link current = Top;//intalization of current pointer as Top
		double i;

		for(i=pos1;i>0;i--)//loop for geting upto position
		{
			current=current.link;//incrementing pointer
			if(current==null)//if  statement for if some one enter position out of index then it will return
			{
				System.out.println("There are less then "+pos1+" elements");
				return 0 ;
			}
		}

		char tmp1=(char)current.info;
		return tmp1;
	}
	public void display(String s)
	{
		System.out.print(s);
		System.out.print("Stack (top <--- bottom): ");
		for(double j=0; j<size(); j++)
		{
			System.out.print((char) peek_n_element(j) );
			//display();
			System.out.print(' ');
		}
		System.out.println("");
	}
	public void display_post(String s)
	{
		System.out.print(s);
		System.out.print("Stack (top <--- bottom): ");
		for(double j=0; j<size(); j++)
		{
			System.out.print( (double)peek_n_element(j) );
			//display();
			System.out.print(' ');
		}
		System.out.println("");

	}
}
class In_To_Post // infix to postfix conversion
{
	private Stack ts;
	private String input;
	private String output = "";
	public In_To_Post(String in) // constructor
	{
		input = in;
		double stack_Size = input.length();
		ts = new Stack();
	}
	public String do_Translate() // do translation to postfix
	{
		for(int j=0; j<input.length(); j++)
		{
			char ch = input.charAt(j);
			ts.display("For "+ch+" ");
			switch(ch)
			{
			case '+':
			case '-':
				gotOper(ch, 0);
				break; // (precedence 1)
			case '*':
			case '/':
				gotOper(ch, 1);
				break; // (precedence 2)
			case '(':
				ts.push(ch); // push it
				break;
			case ')':
				Parenthises(ch); // go pop operators
				break;
			default:
				output = output + ch; // write it to output
				break;
			}
		}
		while( !ts.isEmpty() ) // pop remaining opers
		{
			ts.display("While ");
			output = output + ts.pop(); // write to output
		}
		ts.display("End");
		return output; // return postfix
	}
	public void gotOper(char operation, double prec1)
	{ // got operator from input
		while( !ts.isEmpty() )
		{
			char opTop = ts.pop();
			if( opTop == '(' ) // if it’s a ‘(‘
			{
				ts.push(opTop); // restore ‘(‘
				break;
			}
			else // it’s an operator
			{
				double prec2;
				if(opTop=='+' || opTop=='-') // find new op prec
					prec2 = 1;
				else
					prec2 = 2;
				if(prec2 <= prec1) // if prec of new op less
				{
					ts.push(opTop); // save newly-popped op
					break;
				}
				else
					output = output + opTop; // than prec of old
			}
		}
		ts.push(operation); // push new operator
	}
	public void Parenthises(char ch)
	{
		while( !ts.isEmpty() )
		{
			char charc = ts.pop();
			if( charc == '(' )
				break;
			else
				output = output + charc;
		}
	}
}
class Post_To_Result
{
	private Stack ts1;
	private String input;
	public Post_To_Result(String InfixToPostfixAns)
	{
		input = InfixToPostfixAns;
	}
	public double do_Parse()
	{
		ts1 = new Stack(); // making new stack
		char ch;
		int j;
		double a, b, Result;
		for(j=0; j<input.length(); j++) // for each char,
		{
			ch = input.charAt(j); // read from input
			ts1.display_post("for ' "+ch+" '"+ " ");
			if(ch >= '0' && ch <= '9') // if it’s a number
				ts1.push( (double)(ch-'0') ); // push it
			else
			{
				// pop operands
				b = ts1.post_pop();
				a = ts1.post_pop();
				switch(ch) // do arithmetic
				{
				case '+':
					Result = a + b;
					break;
				case '-':
					Result = a - b;
					break;
				case '*':
					Result = a * b;
					break;
				case '/':
					Result = a / b;
					break;
				default:
					Result = 0;
				}
				ts1.post_push(Result);
			}
		}
		Result = ts1.post_pop();
		return Result;
	}
}

class infix_postfix1
{
	public static void main(String[] args) throws IOException
	{
		String input;
		String output;
		double output1;
		while(true)
		{
			System.out.print("Enter infix or mathematical equation: ");
			System.out.flush();
			input = getString(); //using bufferReader
			if( input.equals("") ) // quit if [Enter]
				break;
			In_To_Post theTrans = new In_To_Post(input);
			output = theTrans.do_Translate(); // do the translation
			System.out.println("\n-->Postfix of " + input + " is " +output+ '\n');
			System.out.println("____________________________________");
			Post_To_Result aParser = new Post_To_Result(output);
			output1 = aParser.do_Parse(); // do the evaluation
			System.out.println("\n-->Answer to " + output + " question is "+output1);
			System.out.println("______________________________________________");
		}
	}
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

}
