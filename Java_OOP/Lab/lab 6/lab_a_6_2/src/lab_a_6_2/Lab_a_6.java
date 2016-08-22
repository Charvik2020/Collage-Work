package lab_a_6_2;
import java.util.Scanner;
class Media
{
    private String title;
    private int YearOfPublication;
    private int price;
    public Media()                                              //defult constructor
    {
        title=null;
        YearOfPublication=0;
        price=0;
    }
    public Media(String t,int yop,int p)                        //parameter constructor
    {
        title=t;
        YearOfPublication=yop;
        price=p;
    }
    void Display_C()                                            //display function of CD of media detail
    {
                System.out.println("\n_______IET-AU________"+"\nTITLE:"+title+"\nYEAR OF PUBLICATION:"+YearOfPublication+"\nPRICE OF CD:"+price+" RS");
    }
    void Display_B()                                            //display function of BOOK
    {
                System.out.println("\n_______IET-AU________"+"\nTITLE:"+title+"\nYEAR OF PUBLICATION:"+YearOfPublication+"\nPRICE OF BOOK:"+price+" RS");
    }
}
class Cd extends Media                                          //child class of Media
{
    private float SizeMB;
    private float PlayTym;
    public Cd(String t,int yop,int p,float sMB,float pTym)      //parameter constructor of child class with parent class member variable
    {
        super(t,yop,p);                                         //super keyword for member of parent class with private data type
        SizeMB=sMB;
        PlayTym=pTym;
    }
    void Display_Cd()                                            //display function for CD 
    {
        System.out.println("CD SIZE:="+SizeMB+" MB"+"\nCD PLAY TIME:"+PlayTym+" MINUTES"+"\n_______END___________");
    }
}
class Book extends Media
{
    private String Author;
    private int total_Page;
    public Book(String t,int yop,int p,String Atr,int tP)        //parameter constructor of Book class with parent class member variable
    {
        super(t,yop,p);                                          //super keyword for member of parent class with private data type
        Author=Atr;
        total_Page= tP;
    }
         void Display_Book()                                     //display function of BOOK
    {
       System.out.println("AUTHOR NAME:"+Author+"\nTOTAL PAGES:"+total_Page+"\n_______END___________");
    }
}
public class Lab_a_6 {
    public static void main(String[] args) {
        int n,y=0,z=0;
        String x=null;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("\n1) ENTER MEDIA DETAIL \n2) ENTER CD DETAIL \n3) ENTER BOOK DETAIL \n0) EXIT");
            System.out.println("ENTER YOUR CHOICE :");
            n=sc.nextInt();
            switch(n)
            {
                case 1:
                System.out.println("ENTER TITLE :");
                x=sc.next();
                System.out.println("ENTER YEAR OF PUBLICATION :");
                y=sc.nextInt();
                System.out.println("ENTER PRICE :  ");
                z=sc.nextInt();
                break;
                case 2:
                System.out.println("ENTER SIZE OF CD(IN MB):  ");
                int sCD=0;
                sCD=sc.nextInt();
                System.out.println("ENTER PLAY TIME(IN MINUTE):  ");
                int pTym=0;
                pTym=sc.nextInt();
                Cd m=new Cd(x, y, z, sCD, pTym);
                m.Display_C();
                m.Display_Cd();break;
                case 3:
                System.out.println("ENTER AUTHOR NAME:  ");
                String Atr=null;
                Atr=sc.next();
                System.out.println("ENTER TOTAL PAGE:  ");
                int tP=0;
                tP=sc.nextInt();
                Book b=new Book(x, y, z, Atr, tP);
                b.Display_B();
                b.Display_Book();break;
            }
        }while(n!=0);
    }
        }