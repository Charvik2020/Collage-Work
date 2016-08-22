<<<<<<< HEAD
=======
/*
 * NAME:CHARVIK PATEL
 * ROLLNO:1401079
 * ASSIGNMENT:8 Q-3
 * Ensure to implement the concept of containership for the relationship between Vehicle and Engine class. Make Vehicle and FourWheeler classes
 * as abstract. Create a menu driven program to implement the classes for allowing the user toper form various operations including creation, updation,
 * and deletion of records. Use file handling mechanism to store and retrieve object so fvarious classes in appropriate binaryfiles.
 */
>>>>>>> 318efa1f7a4eb870946798b1912a13970b6e7fca
import java.io.*;
import java.util.*;
class Engine
{
    //initialization
   static float h_power;
   static  String engine_type;
   static float torque;
   public boolean transmition_type;
    Engine()//defult constructer
    {
        h_power=0;
        engine_type="";
        torque=0;
        transmition_type=false;
    }
    public Engine(float h_p,String eng_type,float tor,boolean tra_type)//parameter constructer
    {
        h_power=h_p;
        engine_type=eng_type;
        torque=tor;
        transmition_type=tra_type;
    }
   static float h_power_m()//horse power method for return of value
    {
        return h_power;
    }
   static String engine_type_m()//engine type method for return of value
    {
        return engine_type;
    }
   static float torque_m()// torque method for return of value
    {
        return torque;
    }
    boolean transmition_type_m()//transmition type method for return of value
    {
        return transmition_type;
    }
    void Engine_show()//engine show method for return of value
    {
        System.out.println("HORSE POWER:"+Engine.h_power_m());
        System.out.println("ENGINE TYPE:"+Engine.engine_type_m());
        System.out.println("TORQUE:"+Engine.torque_m());
        System.out.println("TRANSMITION TYPE:"+transmition_type_m());
    }
    
}
abstract class vehicle
{
    Scanner Sc=new Scanner(System.in);
    Engine en =new Engine();//making an engine class containership in vehical class
    //initalization of variable
    public String V_com_name;
    public String V_name;
    public String V_colour;
    
    public void Data_vehicle()//data geting of vehicle method
    {
        System.out.println("VEHICLE COMPANY NAME:");
        V_com_name=Sc.next();
        System.out.println("VEHICLE NAME:");
        V_name=Sc.next();
        System.out.println("VEHICLE COLOUR:");
        V_colour=Sc.next();
    }
    public void Show_Data_Vehicle()//shaw data of get  vecicle data method
    {
        System.out.println("VEHICLE COMPANY NAME:"+V_com_name);
        System.out.println("VEHICLE NAME:"+V_name);
        System.out.println("VEHICLE COLOUR:"+V_colour);
        en.Engine_show();
        
    }
    
    
}
/***************************************************************
 * here two wheeler vehicle is an child class of vehicle class
 * data member: two wheeler vehicle name(T_name),two wheeler compony name(T_C_name),average(Avg)
 * member function:Data_two_wheeler,Show_Data_Vehicle_t
 ***************************************************************/
class wheeler_two extends vehicle
{
    String T_name,T_C_name;
    float Avg;
    public void Data_two_wheeler()
    {
        System.out.println("ENTER TWO WHEELER COMPANY NAME:");
        T_C_name=Sc.next();
        System.out.println("ENTER TWO WHEELER:");
        T_name=Sc.next();
        System.out.println("ENTER AVREGE:");
        Avg=Sc.nextFloat();
    }
    public void Show_Data_Vehicle_t()
    {
        System.out.println("VEHICLE COMPANY NAME:"+T_C_name);
        System.out.println("VEHICLE NAME:"+T_name);
        System.out.println("VEHICLE AVREAGE:"+Avg);
        
    }
    /***************************************************************
     * creating an file of the detail up now such as horse power
     * ,engine type,torque,tranmition type,vehicle company name,etc..
     ****************************************************************/
    void createFile()
    {
        try
        {
        FileOutputStream outs = new FileOutputStream("IET");
   	ObjectOutputStream oos =new ObjectOutputStream(outs);
        String hp="\n HORSE POWER: "+Engine.h_power_m();
        byte[] a = hp.getBytes();
        oos.writeObject(a);
        String et="\n ENGINE TYPE: "+Engine.engine_type_m();
        byte[] b=et.getBytes();
        oos.writeObject(b);
        String tq="\n TORQUE:"+Engine.torque_m();
        byte[] t=tq.getBytes();
        oos.writeObject(t);
        String tt="\n TRANSMITION TYPE:"+en.transmition_type_m();
        byte[] t2=tt.getBytes();
        oos.writeObject(t2);
        String vcn="\n VEHICAL COMPANY NAME:"+V_com_name;
        byte[] vc_n=vcn.getBytes();
        oos.writeObject(vc_n);
        String Vn="VEHICLE NAME:"+V_name;
        byte[] V_N=Vn.getBytes();
        oos.writeObject(V_N);
        String Vc="VEHICLE COLOUR:"+V_colour;
        byte[] v_c=Vc.getBytes();
        oos.writeObject(v_c);
        String Tcn="VEHICLE COMPANY NAME (TWO WHEELER):"+T_C_name;
        byte[] T_cn=Tcn.getBytes();
        oos.writeObject(T_cn);
        String Tn="VEHICLE NAME (TWO WHEELER):"+T_name;
        byte[] T_n=Tn.getBytes();
        oos.writeObject(T_n);
        String AV="VEHICLE AVREGE(TWO WHEELER):"+Avg;
        byte[] AV_G=AV.getBytes();
        oos.writeObject(AV_G);
        
        oos.close();
        }
        catch(Exception e)
        {
            System.out.println("error");
        }
    }
    void readFile()//reading file
    {
        try
        {
        FileInputStream inp = new FileInputStream("IET");
		ObjectInputStream ois =new ObjectInputStream(inp);
        String hp="\n HORSE POWER: "+Engine.h_power_m();
        byte[] a = hp.getBytes();
        System.out.println("HORSE POWER: "+a);
        String et="\n ENGINE TYPE: "+Engine.engine_type_m();
        byte[] b=et.getBytes();
<<<<<<< HEAD
        System.out.println("ENGINE TYPE: "+UnicodeFormatter.bytetohex(b));
=======
        System.out.println("ENGINE TYPE: "+(b));
>>>>>>> 318efa1f7a4eb870946798b1912a13970b6e7fca
        String tq="\n TORQUE:"+Engine.torque_m();
        byte[] t=tq.getBytes();
        System.out.println((t));
        String tt="\n TRANSMITION TYPE:"+en.transmition_type_m();
        byte[] t2=tt.getBytes();
        System.out.println("TRANSMITION TYPE:"+(t2));
        String vcn="\n VEHICAL COMPANY NAME:"+V_com_name;
        byte[] vc_n=vcn.getBytes();
        System.out.println("VEHICAL COMPANY NAME:"+(vc_n));
        String Vn="VEHICLE NAME:"+V_name;
        byte[] V_N=Vn.getBytes();
        System.out.println("VEHICLE NAME:"+(V_N));
        String Vc="VEHICLE COLOUR:"+V_colour;
        byte[] v_c=Vc.getBytes();
        System.out.println("VEHICLE COLOUR:"+(v_c));
        String Tcn="VEHICLE COMPANY NAME (TWO WHEELER):"+T_C_name;
        byte[] T_cn=Tcn.getBytes();
        System.out.println("VEHICLE COMPANY NAME (TWO WHEELER):"+(T_cn));
        String Tn="VEHICLE NAME (TWO WHEELER):"+T_name;
        byte[] T_n=Tn.getBytes();
        System.out.println("VEHICLE NAME (TWO WHEELER):"+(T_n));
        String AV="VEHICLE AVREGE(TWO WHEELER):"+Avg;
        byte[] AV_G=AV.getBytes();
        System.out.println("VEHICLE AVREGE(TWO WHEELER):"+(AV_G));
        ois.close();
        }
        catch(Exception e)
        {
            System.out.println("error");
        }
    }
    
        void delete_data()
        {
            
    	
		File file = new File("IET");
		try
		{
			if(file.delete())
			{
				System.out.println("Data deleted successfully");	
			}
			else
			{
				System.out.println("delete operation unsuccessful");
			}
		
		}
		
		catch(Exception e) 
		{
		    	System.out.println("delete operation unsuccessful");
		}
	}
}
/***************************************************************
 * here four wheeler vehicle is an child class of vehicle class
 * data member: two wheeler vehicle name(F_name),two wheeler compony name(F_C_name),average(Avg_F)
 * member function:Data_four_wheeler,Show_Data_Vehicle_f
 ***************************************************************/

 class wheeler_four extends vehicle
{
    String F_name,F_C_name;
    float Avg_F;
    public void Data_four_wheeler()
    {
        System.out.println("ENTER FOUR WHEELER COMPANY NAME(STRING):");
        F_C_name=Sc.next();
        System.out.println("ENTER FOUR WHEELER NAME(STRING):");
        F_name=Sc.next();
        System.out.println("ENTER AVREGE(FLOAT):");
        Avg_F=Sc.nextFloat();
    }
    public void Show_Data_Vehicle_f()
    {
        System.out.println("VEHICLE COMPANY NAME(STRING):"+F_C_name);
        System.out.println("VEHICLE NAME(STRING):"+F_name);
        System.out.println("VEHICLE AVREAGE(FLOAT):"+Avg_F);
        
    }
    }
/*******************************************************************
 *comercial four wheeler is an child class of four wheeler class
 * member variable:no of sheets(no_sheets),extra_wheel=2
 * member function:Data_com_four_wheeler,Show_Data_com_four_wheeler
 ********************************************************************/
class comercial_four_wheeler extends wheeler_four
{
    int no_sheets;
    float extra_wheel=2;
    public void Data_com_four_wheeler()
    {
        System.out.println("ENTER NO OF SHEETS(INT):");
        no_sheets=Sc.nextInt();
    }
    public void Show_Data_com_four_wheeler()
    {
        System.out.println("NO OF SHEETS(INT):"+no_sheets);
        System.out.println("NO OF EXTRA WHEEL:"+extra_wheel);
    }
    /***************************************************************
     * creating an file of the detail up now such as horse power
     * ,engine type,torque,tranmition type,vehicle company name,etc..
     * (including comarcial vehicle detail)
     ****************************************************************/
    
    void createFile()
    {
        try
        {
        FileOutputStream outs = new FileOutputStream("IET");
		ObjectOutputStream oos =new ObjectOutputStream(outs);
        String hp="\n HORSE POWER: "+Engine.h_power_m();
        byte[] a = hp.getBytes();
        oos.writeObject(a);
        String et="\n ENGINE TYPE: "+Engine.engine_type_m();
        byte[] b=et.getBytes();
        oos.writeObject(b);
        String tq="\n TORQUE:"+Engine.torque_m();
        byte[] t=tq.getBytes();
        oos.writeObject(t);
        String tt="\n TRANSMITION TYPE:"+en.transmition_type_m();
        byte[] t2=tt.getBytes();
        oos.writeObject(t2);
        String vcn="\n VEHICAL COMPANY NAME:"+V_com_name;
        byte[] vc_n=vcn.getBytes();
        oos.writeObject(vc_n);
        String Vn="\nVEHICLE NAME:"+V_name;
        byte[] V_N=Vn.getBytes();
        oos.writeObject(V_N);
        String Vc="\nVEHICLE COLOUR:"+V_colour;
        byte[] v_c=Vc.getBytes();
        oos.writeObject(v_c);
        String Fcn="\nVEHICLE COMPANY NAME (FOUR WHEELER):"+F_C_name;
        byte[] F_cn=Fcn.getBytes();
        oos.writeObject(F_cn);
        String Fn="\nVEHICLE NAME (FOUR WHEELER):"+F_name;
        byte[] F_n=Fn.getBytes();
        oos.writeObject(F_n);
        String AV="\nVEHICLE AVREGE(FOUR WHEELER):"+Avg_F;
        byte[] AV_G=AV.getBytes();
        oos.writeObject(AV_G);
        String NOS="\nNO OF SHEETS(FOUR WHEELER):"+no_sheets;
        byte[] N_O_S=NOS.getBytes();
        oos.writeObject(N_O_S);
        String EW="\nNO OF EXTRA WHEEL(FOUR WHEELER):"+extra_wheel;
        byte[] E_W=EW.getBytes();
        oos.writeObject(E_W);
        oos.close();
        }
        catch(Exception e)
        {
            System.out.println("error");
        }
    }
    void readFile()//read file method
    {
        try
        {
        FileInputStream inp = new FileInputStream("IET");
		ObjectInputStream ois =new ObjectInputStream(inp);
        String hp="\n HORSE POWER: "+Engine.h_power_m();
        byte[] a = hp.getBytes();
<<<<<<< HEAD
        System.out.println(ois.read(a));
        String et="\n ENGINE TYPE: "+Engine.engine_type_m();
        byte[] b=et.getBytes();
        System.out.println(ois.read(b));
        String tq="\n TORQUE:"+Engine.torque_m();
        byte[] t=tq.getBytes();
        System.out.println(ois.read(t));
        String tt="\n TRANSMITION TYPE:"+en.transmition_type_m();
        byte[] t2=tt.getBytes();
        System.out.println(ois.read(t2));
        String vcn="\n VEHICAL COMPANY NAME:"+V_com_name;
        byte[] vc_n=vcn.getBytes();
        System.out.println(ois.read(vc_n));
        String Vn="VEHICLE NAME:"+V_name;
        byte[] V_N=Vn.getBytes();
        System.out.println(ois.read(V_N));
        String Vc="VEHICLE COLOUR:"+V_colour;
        byte[] v_c=Vc.getBytes();
        System.out.println(ois.read(v_c));
        String Fcn="VEHICLE COMPANY NAME (FOUR WHEELER):"+F_C_name;
        byte[] F_cn=Fcn.getBytes();
        System.out.println(ois.read(F_cn));
        String Fn="VEHICLE NAME (FOUR WHEELER):"+F_name;
        byte[] F_n=Fn.getBytes();
        System.out.println(ois.read(F_n));
        String AV="VEHICLE AVREGE(FOUR WHEELER):"+Avg_F;
        byte[] AV_G=AV.getBytes();
        System.out.println(ois.read(AV_G));
        String NOS="NO OF SHEETS(FOUR WHEELER):"+no_sheets;
        byte[] N_O_S=NOS.getBytes();
        System.out.println(ois.read(N_O_S));
        String EW="NO OF EXTRA WHEEL(FOUR WHEELER):"+extra_wheel;
        byte[] E_W=EW.getBytes();
        System.out.println(ois.read(E_W));
=======
        System.out.println((a));
        String et="\n ENGINE TYPE: "+Engine.engine_type_m();
        byte[] b=et.getBytes();
        System.out.println((b));
        String tq="\n TORQUE:"+Engine.torque_m();
        byte[] t=tq.getBytes();
        System.out.println((t));
        String tt="\n TRANSMITION TYPE:"+en.transmition_type_m();
        byte[] t2=tt.getBytes();
        System.out.println((t2));
        String vcn="\n VEHICAL COMPANY NAME:"+V_com_name;
        byte[] vc_n=vcn.getBytes();
        System.out.println((vc_n));
        String Vn="VEHICLE NAME:"+V_name;
        byte[] V_N=Vn.getBytes();
        System.out.println((V_N));
        String Vc="VEHICLE COLOUR:"+V_colour;
        byte[] v_c=Vc.getBytes();
        System.out.println((v_c));
        String Fcn="VEHICLE COMPANY NAME (FOUR WHEELER):"+F_C_name;
        byte[] F_cn=Fcn.getBytes();
        System.out.println((F_cn));
        String Fn="VEHICLE NAME (FOUR WHEELER):"+F_name;
        byte[] F_n=Fn.getBytes();
        System.out.println((F_n));
        String AV="VEHICLE AVREGE(FOUR WHEELER):"+Avg_F;
        byte[] AV_G=AV.getBytes();
        System.out.println((AV_G));
        String NOS="NO OF SHEETS(FOUR WHEELER):"+no_sheets;
        byte[] N_O_S=NOS.getBytes();
        System.out.println((N_O_S));
        String EW="NO OF EXTRA WHEEL(FOUR WHEELER):"+extra_wheel;
        byte[] E_W=EW.getBytes();
        System.out.println((E_W));
>>>>>>> 318efa1f7a4eb870946798b1912a13970b6e7fca
        ois.close();
        }
        catch(Exception e)
        {
            System.out.println("error");
        }
    }
    void delete_data()
    {
        	File file = new File("IET");
		try
		{
			if(file.delete())
			{
				System.out.println("Data deleted successfully");	
			}
			else
			{
				System.out.println("delete operation unsuccessful");
			}
		}
		
		catch(Exception e) 
		{
		    	System.out.println("delete operation unsuccessful");
		}
	}
}

/*******************************************************************
 *private four wheeler is an child class of four wheeler class
 * member variable:no of sheets(no_sheets_p),extra_wheel_p=1
 * member function:Data_PRI_four_wheeler,Show_Data_PRI_four_wheeler
 ********************************************************************/
class private_four_wheeler extends wheeler_four
{
    int no_sheets_p;
    float extra_wheel_p=1;
    public void Data_PRI_four_wheeler()
    {
        System.out.println("ENTER NO OF SHEETS(INT):");
        no_sheets_p=Sc.nextInt();
    }
    public void Show_Data_PRI_four_wheeler()
    {
        System.out.println("NO OF SHEETS:"+no_sheets_p);
        System.out.println("NO OF EXTRA WHEEL:"+extra_wheel_p);
    }
    /***************************************************************
     * creating an file of the detail up now such as horse power
     * ,engine type,torque,tranmition type,vehicle company name,etc..
     * (including comarcial vehicle detail)
     ****************************************************************/
    
    void createFile()
    {
        try
        {
        FileOutputStream outs = new FileOutputStream("IET");
		ObjectOutputStream oos =new ObjectOutputStream(outs);
        String hp="\n HORSE POWER: "+Engine.h_power_m();
        byte[] a = hp.getBytes();
        oos.writeObject(a);
        String et="\n ENGINE TYPE: "+Engine.engine_type_m();
        byte[] b=et.getBytes();
        oos.writeObject(b);
        String tq="\n TORQUE:"+Engine.torque_m();
        byte[] t=tq.getBytes();
        oos.writeObject(t);
        String tt="\n TRANSMITION TYPE:"+en.transmition_type_m();
        byte[] t2=tt.getBytes();
        oos.writeObject(t2);
        String vcn="\n VEHICAL COMPANY NAME:"+V_com_name;
        byte[] vc_n=vcn.getBytes();
        oos.writeObject(vc_n);
        String Vn="VEHICLE NAME:"+V_name;
        byte[] V_N=Vn.getBytes();
        oos.writeObject(V_N);
        String Vc="VEHICLE COLOUR:"+V_colour;
        byte[] v_c=Vc.getBytes();
        oos.writeObject(v_c);
        String Fcn="VEHICLE COMPANY NAME (FOUR WHEELER PRIVATE):"+F_C_name;
        byte[] F_cn=Fcn.getBytes();
        oos.writeObject(F_cn);
        String Fn="VEHICLE NAME (FOUR WHEELER PRIVATE):"+F_name;
        byte[] F_n=Fn.getBytes();
        oos.writeObject(F_n);
        String AV="VEHICLE AVREGE(FOUR WHEELER PRIVATE):"+Avg_F;
        byte[] AV_G=AV.getBytes();
        oos.writeObject(AV_G);
        String NOS="NO OF SHEETS(FOUR WHEELER PRIVATE):"+no_sheets_p;
        byte[] N_O_S=NOS.getBytes();
        oos.writeObject(N_O_S);
        String EW="NO OF EXTRA WHEEL(FOUR WHEELER PRIVATE):"+extra_wheel_p;
        byte[] E_W=EW.getBytes();
        oos.writeObject(E_W);
        oos.flush();
        oos.close();
        }
        catch(Exception e)
        {
            System.out.println("error");
        }
    }
        void readFile()//read file
        {
            try
        {
        FileInputStream inp = new FileInputStream("IET");
		ObjectInputStream ois =new ObjectInputStream(inp);
        String hp="\n HORSE POWER: "+Engine.h_power_m();
        byte[] a = hp.getBytes();
<<<<<<< HEAD
        System.out.println(ois.read(a));
        String et="\n ENGINE TYPE: "+Engine.engine_type_m();
        byte[] b=et.getBytes();
        System.out.println(ois.read(b));
        String tq="\n TORQUE:"+Engine.torque_m();
        byte[] t=tq.getBytes();
        System.out.println(ois.read(t));
        String tt="\n TRANSMITION TYPE:"+en.transmition_type_m();
        byte[] t2=tt.getBytes();
        System.out.println(ois.read(t2));
        String vcn="\n VEHICAL COMPANY NAME:"+V_com_name;
        byte[] vc_n=vcn.getBytes();
        System.out.println(ois.read(vc_n));
        String Vn="VEHICLE NAME:"+V_name;
        byte[] V_N=Vn.getBytes();
        System.out.println(ois.read(V_N));
        String Vc="VEHICLE COLOUR:"+V_colour;
        byte[] v_c=Vc.getBytes();
        System.out.println(ois.read(v_c));
        String Fcn="VEHICLE COMPANY NAME (FOUR WHEELER PRIVATE):"+F_C_name;
        byte[] F_cn=Fcn.getBytes();
        System.out.println(ois.read(F_cn));
        String Fn="VEHICLE NAME (FOUR WHEELER PRIVATE):"+F_name;
        byte[] F_n=Fn.getBytes();
        System.out.println(ois.read(F_n));
        String AV="VEHICLE AVREGE(FOUR WHEELER PRIVATE):"+Avg_F;
        byte[] AV_G=AV.getBytes();
        System.out.println(ois.read(AV_G));
        String NOS="NO OF SHEETS(FOUR WHEELER PRIVATE):"+no_sheets_p;
        byte[] N_O_S=NOS.getBytes();
        System.out.println(ois.read(N_O_S));
        String EW="NO OF EXTRA WHEEL(FOUR WHEELER PRIVATE):"+extra_wheel_p;
        byte[] E_W=EW.getBytes();
        System.out.println(ois.read(E_W));
=======
        System.out.println((a));
        String et="\n ENGINE TYPE: "+Engine.engine_type_m();
        byte[] b=et.getBytes();
        System.out.println((b));
        String tq="\n TORQUE:"+Engine.torque_m();
        byte[] t=tq.getBytes();
        System.out.println((t));
        String tt="\n TRANSMITION TYPE:"+en.transmition_type_m();
        byte[] t2=tt.getBytes();
        System.out.println((t2));
        String vcn="\n VEHICAL COMPANY NAME:"+V_com_name;
        byte[] vc_n=vcn.getBytes();
        System.out.println((vc_n));
        String Vn="VEHICLE NAME:"+V_name;
        byte[] V_N=Vn.getBytes();
        System.out.println((V_N));
        String Vc="VEHICLE COLOUR:"+V_colour;
        byte[] v_c=Vc.getBytes();
        System.out.println((v_c));
        String Fcn="VEHICLE COMPANY NAME (FOUR WHEELER PRIVATE):"+F_C_name;
        byte[] F_cn=Fcn.getBytes();
        System.out.println((F_cn));
        String Fn="VEHICLE NAME (FOUR WHEELER PRIVATE):"+F_name;
        byte[] F_n=Fn.getBytes();
        System.out.println((F_n));
        String AV="VEHICLE AVREGE(FOUR WHEELER PRIVATE):"+Avg_F;
        byte[] AV_G=AV.getBytes();
        System.out.println((AV_G));
        String NOS="NO OF SHEETS(FOUR WHEELER PRIVATE):"+no_sheets_p;
        byte[] N_O_S=NOS.getBytes();
        System.out.println((N_O_S));
        String EW="NO OF EXTRA WHEEL(FOUR WHEELER PRIVATE):"+extra_wheel_p;
        byte[] E_W=EW.getBytes();
        System.out.println((E_W));
>>>>>>> 318efa1f7a4eb870946798b1912a13970b6e7fca
        
        ois.close();
        }
        catch(Exception e)
        {
            System.out.println("error");
        }
      }
        void delete_data()
        {
            File file = new File("IET");
		try
		{
			if(file.delete())
			{
				System.out.println("Data deleted successfully");	
			}
			else
			{
				System.out.println("delete operation unsuccessful");
			}
		}
		
		catch(Exception e) 
		{
		    	System.out.println("delete operation unsuccessful");
		}
	}
    }
public class LAB_A_8_Q_3 {
  public static void main(String[] args) {
        Scanner Sc=new Scanner(System.in);
        for(;;){//infinete loop for continue the process unteel we want to exit
			int f;
            wheeler_two w_t=new wheeler_two();//making object of two wheeler class
            wheeler_four w_f=new wheeler_four();//making object of four wheeler class
            vehicle v;
            int d;
        System.out.println("\n>>>>>>>>IET<<<<<<<<<<\n1>TWO WHEELER\n2>FOUR WHEELER\n3>EXIT\nENTER CHOICE:");
        int z=Sc.nextInt();
        switch(z)
        {
            case 1:
            {
                
                System.out.println("VEHICLE horse power:");
                float x=Sc.nextFloat();
                System.out.println("VEHICLE engine type:");
                String y=Sc.next();
                System.out.println("torque:");
                float p=Sc.nextFloat();
                System.out.println("TRANSMITION TYPE(gearless(FALSE) or with gear(TRUE))(BOOLEAN):");
                boolean x1=Sc.nextBoolean();
                Engine en=new Engine(x, y, p, x1);
                v=w_t;//dynamic polymorphism
                do
                {
                    
                System.out.println("\n>>>>>>>>IET<<<<<<<<<<\n1>input data\n2>show data\n3>delete data\n4>update data\n0>back\nENTER YOUR CHOICE:");
                d=Sc.nextInt();
                switch(d)
                {
                    case 1:
                        v.Data_vehicle();//calling function of vehicle class to fetch data from user
                        w_t.Data_two_wheeler();//calling function of two wheeler class to fetch data from user
                        w_t.createFile();//calling function of two wheeeler class to create file
                        //w_t.readFile();//calling function of two wheeler class to read file
                        System.out.println("\nFILE CREATED\n");
                        break;
                    case 2:
						int j;
                        System.out.println("\n");
						do{
<<<<<<< HEAD
						System.out.println("<<<<<IET>>>>>>>>\n1>BY METHOD\n2>BY READING DATA FROM FILE");
=======
						System.out.println("<<<<<IET>>>>>>>>\n1>BY METHOD\n2>BY READING DATA FROM FILE(binary)\n0>back\nENTER YOUR CHOICE:");
>>>>>>> 318efa1f7a4eb870946798b1912a13970b6e7fca
						j=Sc.nextInt();
						switch(j)
						{
							case 1:
							v.Show_Data_Vehicle();//calling function of two wheeler class to show data from user
							w_t.Show_Data_Vehicle_t();//calling function of two wheeler class to show data from user
							break;
						case 2:
							w_t.readFile();
							break;
						}
						}while(j!=0);
						break;
                    case 3:
                        w_t.delete_data();
                        break;
                    case 4:
                        v.Data_vehicle();//calling function of vehicle class to fetch data from user
                        w_t.Data_two_wheeler();//calling function of two wheeler class to fetch data from user
                        w_t.createFile();//calling function of two wheeeler class to create file
<<<<<<< HEAD
                        w_t.readFile();//calling function of two wheeler class to read file
=======
>>>>>>> 318efa1f7a4eb870946798b1912a13970b6e7fca
                        System.out.println("\nFILE CREATED AND UPDATED\n");
                        break;
                }
                }while(d!=0);
                break;
            }
            case 2:
            {
				
                do
                {
<<<<<<< HEAD
					int f;
                    System.out.println("\n>>>>>>>>IET<<<<<<<<<<\n1>COMMERCIAL FOUR WHEELER\n2>PRIVATE FOUR WHEELER\nENTER YOUR CHOICE:");
=======
					
                    System.out.println("\n>>>>>>>>IET<<<<<<<<<<\n1>COMMERCIAL FOUR WHEELER\n2>PRIVATE FOUR WHEELER\n3>EXIT\nENTER YOUR CHOICE:");
>>>>>>> 318efa1f7a4eb870946798b1912a13970b6e7fca
                    int o=Sc.nextInt();
                    switch(o){
					case 1:
                    {
                        System.out.println("VEHICLE HORSE POWER(FLOAT):");
                        float x=Sc.nextFloat();
                        System.out.println("VEHICLE ENGINE TYPE(STRING):");
                        String y=Sc.next();
                        System.out.println("TORQUE(FLOAT):");
                        float p=Sc.nextFloat();
                        System.out.println("TRANSMITION TYPE(gearless(FALSE) or with gear(TRUE))(BOOLEAN):");
                        boolean x1=Sc.nextBoolean();
                        Engine en=new Engine(x, y, p, x1);
						do{
<<<<<<< HEAD
						System.out.println("\n>>>>>>>>IET<<<<<<<<<<\n1>input data\n2>show data\n3>delete data\n4>update data\nENTER YOUR CHOICE:");
						f=Sc.nextInt();
						comercial_four_wheeler cfw=new comercial_four_wheeler();//creating object of commertial whee
=======
						System.out.println("\n>>>>>>>>IET<<<<<<<<<<\n1>input data\n2>show data\n3>delete data\n4>update data\n0>back\nENTER YOUR CHOICE:");
						f=Sc.nextInt();
						comercial_four_wheeler cfw=new comercial_four_wheeler();//creating object of commertial four wheeler
>>>>>>> 318efa1f7a4eb870946798b1912a13970b6e7fca
						v=w_f;//dynamic polymorphism
						switch(f)
						{
							case 1:
							w_f.Data_four_wheeler();//calling function of four wheeler class to fetch data from user
							v.Data_vehicle();
							cfw.Data_com_four_wheeler();//calling function of commercial four wheeler class to fetch data from user
							cfw.createFile();//calling function of commecial four wheeeler class to create file
							System.out.println("\nFILE CREATED\n");
							break;
						case 2:
							int e;
                        System.out.println("\n");
							do{
<<<<<<< HEAD
								System.out.println("<<<<<IET>>>>>>>>\n1>BY METHOD\n2>BY READING DATA FROM FILE");
=======
								System.out.println("<<<<<IET>>>>>>>>\n1>BY METHOD\n2>BY READING DATA FROM FILE(binary)\n0>BACK\nENTER YOUR CHOICE:");
>>>>>>> 318efa1f7a4eb870946798b1912a13970b6e7fca
								e=Sc.nextInt();
								switch(e)
								{
								case 1:
								v.Show_Data_Vehicle();//calling function of two wheeler class to show data 
								w_f.Show_Data_Vehicle_f();//calling function of two wheeler class to show data
								cfw.Show_Data_com_four_wheeler();//calling function of commersial four wheeler class to show data from user
								break;
								case 2:
								cfw.readFile();//calling function of comercial four wheeler class to read file
								break;
								}
								}while(e!=0);	
								break;
						case 3:
							cfw.delete_data();
							break;
						case 4:
							w_f.Data_four_wheeler();//calling function of four wheeler class to fetch data from user
							cfw.Data_com_four_wheeler();//calling function of commercial four wheeler class to fetch data from user
							cfw.createFile();//calling function of commecial four wheeeler class to create file
<<<<<<< HEAD
							cfw.readFile();//calling function of comercial four wheeler class to read file
=======
>>>>>>> 318efa1f7a4eb870946798b1912a13970b6e7fca
							System.out.println("\nFILE CREATED AND UPDATED\n");
							break;
						
                        }
						}while(f!=0);
                        break;
                    
                    }
                    case 2:
                    {
						int l;
                        System.out.println("VEHICLE HORSE POWER(FLOAT):");
                        float x=Sc.nextFloat();
                        System.out.println("VEHICLE ENGINE TYPE(STRING):");
                        String y=Sc.nextLine();
                        System.out.println("TORQUE(FLOAT):");
                        float p=Sc.nextFloat();
                        System.out.println("TRANSMITION TYPE(gearless(FALSE) or with gear(TRUE))(BOOLEAN):");
                        boolean x1=Sc.nextBoolean();
                        Engine en=new Engine(x, y, p, x1);
                        v=w_f;
						private_four_wheeler pfw=new private_four_wheeler();//creating an object of private four wheeler
						do{
<<<<<<< HEAD
						System.out.println("\n>>>>>>>>IET<<<<<<<<<<\n1>input data\n2>show data\n3>delete data\n4>update data\nENTER YOUR CHOICE:");
=======
						System.out.println("\n>>>>>>>>IET<<<<<<<<<<\n1>input data\n2>show data\n3>delete data\n4>update data\n0>back\nENTER YOUR CHOICE:");
>>>>>>> 318efa1f7a4eb870946798b1912a13970b6e7fca
						f=Sc.nextInt();
						switch(f)
						{
							case 1:
							v.Data_vehicle();
							w_f.Data_four_wheeler();//calling function of four wheeler class to fetch data from user
							pfw.Data_PRI_four_wheeler();//calling function of private four wheeler class to fetch data from user
							pfw.createFile();//calling function of private four wheeeler class to create file
							System.out.println("\nFILE CREATED\n");
							break;
							case 2:
							int r;
							System.out.println("\n");
							do{
<<<<<<< HEAD
							System.out.println("<<<<<IET>>>>>>>>\n1>BY METHOD\n2>BY READING DATA FROM FILE");
=======
							System.out.println("<<<<<IET>>>>>>>>\n1>BY METHOD\n2>BY READING DATA FROM FILE(binary)\n0>BACK\nENTER YOUR CHOICE:");
>>>>>>> 318efa1f7a4eb870946798b1912a13970b6e7fca
							r=Sc.nextInt();
							switch(r)
								{
								case 1:
								v.Show_Data_Vehicle();//calling function of vehicle class to show data
								w_f.Show_Data_Vehicle_f();//calling function of four wheeler class to show data
								pfw.Show_Data_PRI_four_wheeler();//calling function of private four wheeler class to show data
								break;
								case 2:
								pfw.readFile();//calling function of private four wheeeler class to read file
								break;
								}
								}while(r!=0);
								break;
							case 3:
							pfw.delete_data();
							break;
							case 4:
							w_f.Data_four_wheeler();//calling function of four wheeler class to fetch data from user
							pfw.Data_PRI_four_wheeler();//calling function of private four wheeler class to fetch data from user
							pfw.createFile();//calling function of private four wheeeler class to create file
<<<<<<< HEAD
							pfw.readFile();//calling function of private four wheeeler class to read file
=======
>>>>>>> 318efa1f7a4eb870946798b1912a13970b6e7fca
							System.out.println("\nFILE CREATED AND UPDATED\n");
							break;
						}
						}while(f!=0);
                        break;
                    }
                    case 3:
                    {
                        return ;
                    }
                    }
                }while(z!=0);
                
            }
            case 3:
            {
                return;
            }
                
        }
        }
    }
<<<<<<< HEAD
}
=======
}
/*****************
*END OF PROGRAM
******************/
>>>>>>> 318efa1f7a4eb870946798b1912a13970b6e7fca
