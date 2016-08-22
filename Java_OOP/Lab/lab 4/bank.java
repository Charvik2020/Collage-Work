/*
 * NAME: CHARVIK PATEL
 * ROLLNO:1401079
 * PROGRAM:WRITE AN PROGRAM USING STATIC MEMBER FUNCTION 
 */

import java.util.Scanner;
class Transfer{
static int sum;
int dbt;
int crt;
static int cnt = 0;
Transfer()             //creating construcer
{
	cnt++;
}
public static void get_cnt()       //counting custructer 
{
	System.out.print("count is:"+cnt);
}
//member function start
static void insert_Rs()
{
Scanner S = new Scanner(System.in);
System.out.println("Enter amount of the account");
sum=S.nextInt();
System.out.println("Amount in the account is:" +sum);
}
void debit()
{
Scanner S = new Scanner(System.in);
System.out.println("Amount to be debited");
dbt=S.nextInt();
sum=sum-dbt;
System.out.println("Debited amount is:" +sum);
}
void credit()
{
Scanner S = new Scanner(System.in);
System.out.println("Amount to be credited");
crt=S.nextInt();
sum=sum+crt;
System.out.println("Credited Amount is:" +sum);
}//member function end
}
class Bank
{
public static void main(String[] args)
{
 int n;
  System.out.println("1. ENTER AMMOUNT :");
   Transfer.insert_Rs();
 do{

 System.out.println("1. DEBIT");
 System.out.println("2. CREDIT ");
 System.out.println("3. EXIT");
 Scanner S = new Scanner(System.in);
 System.out.println("Enter options:");
Transfer a=new Transfer(); //creating an object of class 
 n=S.nextInt();
 switch(n)
 {
 case 1:
 {
a.debit();
break;
}
case 2:
{
a.credit();
break;

}
case 3: 
 {

 break;
 }
}
}while(n!=3);
System.out.println("Your final amount is:" +Transfer.sum);
Transfer.get_cnt();
}
}