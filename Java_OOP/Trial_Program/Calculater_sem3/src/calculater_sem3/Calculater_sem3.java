package calculater_sem3;
import java.util.*;
import java.math.*;
class Calculater
{
   float Add(float num1,float num2)
	{
		return num1+num2;
	}
	float Sub(float num1,float num2)
	{
		return num1-num2;
	}
	float multi(float num1,float num2)
	{
		return num1*num2;
	}
	float div(float num1,float num2)
	{
		return num1/num2;
	}
	float Modulo(float num1,float num2)
	{
		return num1%num2;
	}
	double Sq(double num1)
	{
            double x= Math.sqrt(num1);
		return x;
	}
	float inverse(float num1)
	{
		return 1/num1;
	}
}
public class Calculater_sem3 {
    public static void main(String[] args) {
        		Calculater cal=new Calculater();
		int sign;
		for(;;)
		{
			float n1,n2;
			Scanner sc=new Scanner(System.in);
			System.out.println("****IET-AU****");
			System.out.println("1.ADD");
			System.out.println("2.SUBTRACT");
			System.out.println("3.MULTIPLICATION");
			System.out.println("4.DIVISION");
			System.out.println("5.MODULO");
			System.out.println("6.SQUARE ROOT");
			System.out.println("7.INVERSE");
                        System.out.println("8.EXIT");
			System.out.println("ENTER YOUR CHOICE:");
			sign=sc.nextInt();
			switch(sign)
			{
			
			case 1:
				System.out.println("ENTER NUMBER 1:");
				n1=sc.nextFloat();
				System.out.println("ENTER NUMBER 2:");
				n2=sc.nextFloat();
				System.err.println("ADD:"+cal.Add(n1, n2));
                            break;
			case 2:
				System.out.println("ENTER NUMBER 1:");
				n1=sc.nextFloat();
				System.out.println("ENTER NUMBER 2:");
				n2=sc.nextFloat();
				System.err.println("SUBTRACTION:"+cal.Sub(n1, n2));
                            break;
			case 3:

				System.out.println("ENTER NUMBER 1:");
				n1=sc.nextFloat();
				System.out.println("ENTER NUMBER 2:");
				n2=sc.nextFloat();
				System.err.println("MULTIPLICATION:"+cal.multi(n1, n2));
                            break;
			case 4:

				System.out.println("ENTER NUMBER 1:");
				n1=sc.nextFloat();
				System.out.println("ENTER NUMBER 2:");
				n2=sc.nextFloat();
				System.err.println("DIVISION:"+cal.div(n1, n2));
                            break;
			case 5:

				System.out.println("ENTER NUMBER 1:");
				n1=sc.nextFloat();
				System.out.println("ENTER NUMBER 2:");
				n2=sc.nextFloat();
				System.err.println("MODULO:"+cal.Modulo(n1, n2));
                            break;
			case 6:

				System.out.println("ENTER NUMBER 1:");
				double n=sc.nextDouble();
				System.err.println("SQUARE ROOT:"+cal.Sq(n));
                            break;
			case 7:

				System.out.println("ENTER NUMBER 1:");
				n1=sc.nextFloat();
				System.err.println("INVERSE:"+cal.inverse(n1));
                            break;
			case 8:
                            System.exit(0);
                            break;
                            default:
                                System.err.println("wrrong choice!");
			}
		}
        }
}
