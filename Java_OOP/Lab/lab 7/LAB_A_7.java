/*
 * NAME:CHARVIK PATEL
 * ROLLNO:1401079
 * COLLAGE:IET-AU
 * ASSIGNEMENT NO:7
 * QUESTION:Create an abstract class called “Account�? and inherit it into two classes called “Savings�? and
 *  “Current�? in Java. Create appropriate data members with suitable visibility modes for each of the
 *  classes. Also create appropriate constructors and member functions for these classes such that they
 *  are able to implement the following business rules:
 *     An account created should either be a savings account or a current account.
 *     A savings account can only be opened with a minimum balance of `1,000/-
 *     Savings accounts need to maintain a minimum balance of `500/- at any point of time.
 *     Interest is calculated and credited in savings accounts only once in each quarter.
 *     The current accounts can have different overdraft limits ranging from `500/- to `1 Cr.
 *     No current account would be allowed to have a negative balance beyond the overdraft limit
 * Implement the above mentioned classes through a menu driven program that would allow the user
 * to select the type of account at the time of account creation as well as making any type of
 * transaction. Use run-time polymorphism to implement the classes.
 */

import java.util.*;
import java.*;

/******************************************************
 *  ACCOUNT CLASS WHICH IS ABSTRACT                   *
 ******************************************************/

abstract class account
{
    Scanner sc =new Scanner(System.in);
    //MEMBER FUNCTION OF ACCOUNT CLASS ACCESS BY SUB-CLASS 
    public double balance;int count=0;
    protected double accont_no;
    private double credit;
    account()//DEFULT CONSTRUCTER
    {
        balance=0;
        accont_no=0;
    }
    account(double bal,double acc_no)//PARAMETER CONSTRUCTER
    {
        accont_no=acc_no;
        balance=bal;
    }
    public double get_balance()//MEMBER FUNCTION OF GET BALANCE
    {
        return balance;
    }
    public double accont_no()//MEMBER FUNCTION OF ACCOUNT NO
    {
        return accont_no;
    }
    public double get_credit()//MEMBER FUNCTION OF GET CREDIT
    {
        System.out.println("HOW MUCH CREDIT DO YOU WANT TO CREDIT?");
        double credit=sc.nextDouble();
        if(credit>=0)
        {
            balance=balance+credit;
            System.out.println("BALANCE UPDATED SUCCESSFULLY"+"\nNEW BALANCE:"+balance);
        }
        else
        {
            System.out.println("BALANCE UPDATED UNSUCCESSFULLY");
        }
        
        return credit;
    }
    }

/************************************************************************
 *SAVING CLASS IS CHILD CLASS OF ACCOUNT CLASS.   
 *SAVING ACCOUNT IS FOR ONLY 1 YEAR AFTER THAT WE HAVE TO CREATE IT NEW.
 ************************************************************************/

 class saving extends account
 {  //MEMBER FUNCTION OF SAVING CLASS
     public double rateofintrest;
     public int month;
     public int year;
    public saving(double bal, double acc_no,int rate_of_intrest,int mnth,int yr) {
        super(bal, acc_no);
        rateofintrest=rate_of_intrest;
        month=mnth;
        year=yr;
     }
    
    /****************************************************************************************
     * WITHDROW FUNCION WILL DO THE WITHROW MONEY FROM SAVING ACCOUNT.
     * BUT THERE IS AN CONDITON THAT AFTER WITHDROW THERE MUST BE MINIMUM ₹ 500 IN ACCOUNT,
     * THUS I HAVE KEPT IF CONDITION IN FUNCTION
     *****************************************************************************************/
    
    public void withdrow()
    {
        System.out.println("ENTER AMOUNT TO BE WITHDROW?");
       double withdrow=sc.nextDouble();
       if(balance-withdrow>=500)
       {
           balance=balance-withdrow;
           System.out.println("***SAVING WITHDROW***"+"\nACCOUNT NO:"+accont_no+"\nNEW BALANCE"+balance+"\nBALANCE IS UPDATED");
       }
       else
       {
            System.out.println("BALANCE UPDATED UNSUCCESSFULLY");
        
       }
    }
    
    /*****************************************************************************
     * INTREST FUNCTION WILL CALCULATE INTREST EVERY 3 MONTH,
     * FOR THIS I HAVE TAKE AN DIFFRENCE OF THE TWO DATES WHICH I HAVE ASK WHILE 
     * CHOICE OF ACCOUNT 
     *****************************************************************************/
    
       public void Intrest()
    {
        double si=0;int e=1;
        System.out.println("Enter your current month:");
        int month1=sc.nextInt();
        System.out.println("ENTER CURRENT YEAR:");
        int year1=sc.nextInt();
      if(year<=year1)
       {
         int a = month1 - month;
         int b = year1 - year;
         
         int Month = a + b*12;
         int T= Month/3;
         for(int i=0;i<T;i++)
          { 
             si=(balance*rateofintrest*(0.25))/100;
             System.out.println("intrest"+balance);
             balance = si + balance;continue;
          }
          System.out.println("TOTAL INTREST IS "+ si+ "RS.");
          System.out.println("NOW YOUR CURRENT ACCOUNT BALANCE IS: " +balance);
       }
}
 }

/******************************************************
/**   CURRENT CLASS IS CHILD CLASS OF ACCOUNT CLASS  **/
/******************************************************/

class current extends account
{   //MEMBER FUNCTION OF CURRENT CLASS
    double overdraft_limit,withdrow;
    current(double bal,double acc_no,double o_draft)
    {
        super(bal,acc_no);
        overdraft_limit=o_draft;
    }
    
    /***********************************************************************************************
     * WITHDROW FUNCION WILL DO THE WITHROW MONEY FROM CURRENT ACCOUNT.
     * BUT THERE IS AN CONDITON THAT ADDITION OF BALANCE AND OVERDRAFT LIMIT MUST BE MORE THAN ₹0,
     * THUS I HAVE KEPT IF CONDITION IN FUNCTION
     ***********************************************************************************************/
    
    public void withdrow()
    {
        System.out.println("ENTER AMOUNT TO WITHDROW?");
       double withdrow=sc.nextDouble();
       balance=balance-withdrow;
       if(balance+overdraft_limit>0)
       {
           System.out.println("***SAVING WITHDROW***"+"\nACCOUNT NO:"+accont_no+"\nNEW BALANCE: "+balance+"\nBALANCE IS UPDATED");
       }
       else
       {
           System.out.println("BALANCE UPDATED UNSUCCESSFULLY");
       }
        
    }
    
    }    

public class LAB_A_7 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int q;
        account a;
        saving s;
        current c ;
        do{//DO WHILE LOOP FOR DOING THE FUNCTION MENTION IN CASE BY SWITCH CASE INSIDE DO WHILE LOOP
        System.out.println("CHOICE YOUR ACCOUNT?\n1.SAVING ACCOUNT \n2.CURRENT ACCOUNT\n3.EXIT");
        q=sc.nextInt();
        switch(q){
            case 1:
            {   //ENTER OF DETAIL SUCH AS BALANCE,ACCOUNT NO,OVERDRAFT LIMIIT.
                System.out.println("ENTER BALANCE: ");
                double x=sc.nextDouble();
           if(x>999)
             {
                System.out.println("ENTER RATE OF INTREST: ");
                int z=sc.nextInt();if(z>0){
                System.out.println("ENTER MONTH OF CREATING OF ACCOUNT: ");
                int x1=sc.nextInt();if(x1>0){
                System.out.println("ENTER YEAR OF CREATING OF ACCOUNT: ");
                int y1=sc.nextInt();if(y1>0){
                //CREATE AN OBJECT OF SAVING CLASS
                     s=new saving(x, 15025212, z,x1,y1);
                 do{//DO WHILE LOOP FOR DOING THE FUNCTION MENTION IN CASE BY SWITCH CASE INSIDE DO WHILE LOOP
         System.out.println("\n**IET-AU**"+"\n1.WITHDROW \n2.DIPOSIT\n3.INTREST\n4.EXIT\nENTER YOUR CHOICE:");
        int p=sc.nextInt();
        switch(p)
        {
            case 1://WITHDROW
                if(x>500){
                s.withdrow();//CALLING OF WITHDROW FUNCTION OF SAVING ACCOUNT
                }else
                    {
                    System.out.println("PLEASE CREDIT YOUR ACCOUNT TO WIDHROW");
                    }
                break;
            case 2://DIPOSIT
                a=s;
                a.get_credit();//CALLING OF CREDIT FUNCTION OF PARENT CLASS REFERING TO SAVING ACCOUNT
                break;
            case 3://INTREST
                s.Intrest();//CALLING OF INTREST FUNCTION OF SAVING ACCOUNT
                break;
            case 4://EXIT FOR SAVING ACCOUNT
                return;
        }
        }while(q!=0);
                }else{
                System.out.println("PLEASE ENTER AN MONTH MORE THAN 0(ZERO) TO CREATE AN SAVING ACCOUNT ");}}
                }else{
               System.out.println("PLEASE ENTER AN INTREST MORE THAN 0(ZERO) TO CREATE AN SAVING ACCOUNT");}}
                else{
               System.out.println("PLEASE ENTER AN BALANCE MORE THAN ₹ RS.1000 TO CREATE AN SAVING ACCOUNT ");}}
               break;
        
            case 2:
            {   //ENTER OF DETAIL SUCH AS BALANCE,ACCOUNT NO,OVERDRAFT LIMIIT.
                System.out.println("ENTER BALANCE: ");
                double x=sc.nextDouble();
                
                /*****************************************************************************************************************
                 * GENRALLY OVERDRAFT LIMIT IS THERE ONLY IN CURRENT ACCOUNT BECOUSE CURRENT ACCOUNT IS USE BY BUSSNESS MAN/WOMEN,
                 * THUS FOR THAT THEY REQURE SOME MONEY EXTRA FOR THERE BUSSNESS.
                 * BUT THERE IS AN CONDITION THAT OVERDRAFT LIMIT RANGING FROM ₹500 - ₹1CR.
                 * NOTE:SIR/MAM,I AM NOT ABLE TO KEEP AN CONDITION OF OVERDRAFT LIMIT AS ABOVE  
                 *****************************************************************************************************************/
                 
                System.out.println("ENTER OVERDRAFT LIMIT:");
                double e=sc.nextDouble();
        //CREATE AN OBJECT OF CURRENT CLASS        
         c=new current(x, 15025212, e);
         do{//DO WHILE LOOP FOR DOING THE FUNCTION MENTION IN CASE BY SWITCH CASE INSIDE DO WHILE LOOP
         System.out.println("\n**IET-AU**"+"\n1.WITHDROW \n2.DIPOSIT\n3.EXIT \nENTER YOUR CHOICE:");
        int w=sc.nextInt();
        switch(w)
        {
            case 1:
                c.withdrow();//CALLING OF WITHDROW FUNCTION OF CURRENT ACCOUNT
                break;
                
            case 2:
                a=c;
                a.get_credit();//CALLING OF CREDIT FUNCTION OF CURRENT ACCOUNT BY REFERING TO PARENT CLASS
                break;
            case 3:
                return;//EXIT FOR CURRENT ACCOUNT
        }
         }while(q!=0);
            
            }
            break;
            case 3:return;//EXIT FOR ACCOUNT SELECTION
        }
    }while(q!=0);

    }
}
/*********************************************************************************************************************************
 *                                               ***END PROJECT***
 * 
 *********************************************************************************************************************************/