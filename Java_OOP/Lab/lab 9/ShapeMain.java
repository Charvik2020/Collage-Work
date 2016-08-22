
import java.util.*;
import java.io.*;
import java.lang.*;
/**********************************************************************
 * CLASS SHAPE CONTAIN STRING COLOUR AND GET COLOUR FUNCTION
 * AND SET COLOUR FUNCTION
 * AND SHAPE IS AN PARENT CLASS OF 1. SHAPE2D 2. SHAPE 3D WHICH 
 * ARE ABSTRACT CLASS.
 ***********************************************************************/
class Shape
{
    Scanner S = new Scanner(System.in);
    String colour;
    
    Shape()//DEFULT CONSTRUCTER
    {
        colour = null;
    }
    
    public void get_colour()//MEMBER FUNCTION OF GET COLOUR
    {
    	System.out.println("Enter colour:");
    	colour=S.next();
        try
        {
            FileOutputStream Fout = new FileOutputStream("filename");
            ObjectOutputStream Oout = new ObjectOutputStream(Fout);
            String co = " The Colour Is :" +colour;
            byte[] c = co.getBytes();
            Oout.writeObject(c);
         }
        
        catch(Exception e)
        {
            System.out.println("Error...");
        }
    }
    
    protected String getValueOf(double hight_r) {
        return null;
    }

    public void set_colour()//MEMBER FUNCTION OF SET COLOUR
    {
        try
        {
            FileInputStream Fin = new FileInputStream("filename");
            ObjectInputStream Oin = new ObjectInputStream(Fin);
            
            int value = 0;
            
            while(Fin.read() != -1)
            {
                System.out.println((char)value);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error...");
        }
    }
}
/******************************************************************************************************************
 * SHAPE 2D IS AN ABSTRACT CLASS AND AN CHILD CLASS OF 
 * SHAPE THE MEMBER FUNCTION OF THIS CLASS IS ALSO ABSTRACT BECOUSE THEY ARE OVERRIDE AFTER BY THERE CHILD CLASS
 * ***************************************************************************************************************/
abstract class Shape_2D extends Shape
{
    double area;
    
    Shape_2D()//DEFULT CONSTRUCTER
    {
        area = 0;
    }
    //ABSTRACT MEMBER FUNCTION
    abstract void  find_area();
    abstract void get_vertex();
}
/******************************************************************************************************************
 * SHAPE 3D IS AN ABSTRACT CLASS AND AN CHILD CLASS OF 
 * SHAPE THE MEMBER FUNCTION OF THIS CLASS IS ALSO ABSTRACT BECOUSE THEY ARE OVERRIDE AFTER BY THERE CHILD CLASS
 * ***************************************************************************************************************/

abstract class Shape_3D extends Shape
{
    double volume;
    double surfacearea;
    
    Shape_3D()//DEFULT CONSTRUCTER
    {
        volume = 0;
        surfacearea = 0;
    }
    //ABSTACT MEMBER FUNCTION
    abstract void find_surface();
    abstract void find_volume();
}

class Rectangle extends Shape_2D
{
    Scanner S = new Scanner(System.in);
    double a,b,c,d,a1,b1,a2,b2,a3,b3,a4,b4;
    double hight_r;
    double width_r;
    
    Rectangle()//DEFULT CONSTRUCTER
    {
        a = 0;b = 0;
        c = 0;d = 0;
    }
    
    public void create_file_r()//CREATING OF FILE
    {
        try
        {
            FileOutputStream Fout = new FileOutputStream("filename");
            ObjectOutputStream Oout = new ObjectOutputStream(Fout);
            
            String a1 = " The Value Of Length Of Rectangle Is  : "+getValueOf(hight_r);
            byte[] A = a1.getBytes();
            Oout.writeObject(A);

            String b1 = " The Value Of Width Of Rectangle Is  :" +getValueOf(width_r);
            byte[] B = b1.getBytes();
            Oout.writeObject(B);
            
            String c1 = " The Area Of Rectangle Is  :" +getValueOf(area);
            byte[] C= c1.getBytes();
            Oout.writeObject(C);

        }
        
        catch(Exception e)
        {
            System.out.println("Error..."+e);
        }
    }
    
    public void set_rectangle()// MEMBER FUNCTION SET RECTANGLE
    {
        try
        {
            FileInputStream Fin = new FileInputStream("filename");
            ObjectInputStream Oin = new ObjectInputStream(Fin);
            
            int value = 0;
            
            while( Fin.read() != -1)
            {
                System.out.println((char)value);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error...");
        }
    }
    
        public void get_vertices_r() //MEMBER FUNCTION OF GETING VERTEX
        {
            System.out.println("This Program Will Take the Co-ordinates Of Vertices Of The Rectangle...");
            
            System.out.println("Enter Co-ordinates Of First Vertices :");
            a1 = S.nextInt();
            b1 = S.nextInt();
            
            System.out.println("Enter Co-ordinates Of Second Vertices(Hight) :");
            a2 = S.nextInt();
            b2 = S.nextInt();
            
            System.out.println("Enter Co-ordinates Of Third Vertices(Width) :");
            a3 = S.nextInt();
            b3 = S.nextInt();
            
            System.out.println("Enter Co-ordinates Of Fourth Vertices(Other) :");
            a4 = S.nextInt();
            b4 = S.nextInt();
            
            a = a2 - a1; // First Co-ordinate Of The Hight Of The Rectangle
            b = b2 - b1; // Second Co-ordinate Of The Hight Of The Rectangle
            c = a3 - a1; // First Co-ordinate Of The Width Of The Rectangle
            d = b3 - b1; // Second Co-ordinate Of The Width Of The Rectangle
            
        }
        
        public void find_area()//MEMBER FUNCTION OF FIND AREA
        {
            hight_r = Math.sqrt(a*a + b*b);
            width_r = Math.sqrt(c*c + d*d);
            
            area = (hight_r * width_r);
            
            System.out.println("The Area Of Rectangle Is :" +area);            
        }

        private double sqrt(int i) {
        
            return 0;
        }

		void get_vertex() {
			
			
		}
}
/********************************************
 * CLASS CIRCLE IS AN CILD CLASS OF SHAPE 2D
 * MEMBER FUNCTION:X,Y,X1,X2,Y1,Y2
 * MEMBER:RADIUS_CI
 * ******************************************/
class Circle extends Shape_2D
{
    Scanner S = new Scanner(System.in);
    double x,y,x1,x2,y1,y2;
    double radius_ci;
    Circle()
    {
        x1 = 0;x2 = 0;
        y1 = 0;y2 = 0;
    }
    
    public void create_file_ci()//CREATING AN FILE
    {
        try
        {
            FileOutputStream Fout = new FileOutputStream("filename");
            ObjectOutputStream Oout = new ObjectOutputStream(Fout);
            
            String a1 = " The Value Of Length Of Circle Is  :" +getValueOf(radius_ci);
            byte[] A = a1.getBytes();
            Oout.writeObject(A);

            String c1 = " The Area Of Rectangle Is  :" +getValueOf(area);
            byte[] C= c1.getBytes();
            Oout.writeObject(C);

        }
        catch(Exception e)
        {
            System.out.println("Error...");
        }
    }
    
    public void set_circle()//MEMBER FUNCTION OF SET CIRCLE AND MAKING OF FILE
    {
        try
        {
            FileInputStream Fin = new FileInputStream("filename");
            ObjectInputStream Oin = new ObjectInputStream(Fin);
            int value=0;
            while( Fin.read() != -1)
            {
                System.out.println((char)value);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error...");
        }
    }
    
    public void get_vertices_ci()//MEMBER FUNCTION OF GETING VERTEX
    {
        System.out.println("Enter The Co-ordinates Of The Centre Of The Circle :");
        x1 = S.nextInt();
        y1 = S.nextInt();
        
        System.out.println("Enter The Co-ordinates Of The Point From The Surface Of The Circle :");
        x2 = S.nextInt();
        y2 = S.nextInt();
        
        x = x2 - x1;   // First Co-ordinate Of The Radius Of The Circle
        y = y2 - y1;   // Second Co-ordinate Of The Radius Of The Circle
     }
    
    public void find_area()//MEMBER FUNCTION OF FIND AREA
    {        
        radius_ci = Math.sqrt(x*x +y*y);
        
        area = (float) ((3.14) * (radius_ci*radius_ci));
        
        System.out.println("The Area Of The Circle Is :" +area);
    }

    private double sqrt(int i) {
        return 0;
    }

	void get_vertex() {
		
	}
}
/************************************************************************************************
 * CLASS CIRCLE IS AN CILD CLASS OF SHAPE 3D
 * MEMBER FUNCTION:get vertex,find volume,find surface
 * MEMBER:m,n,o,p,q,r,s,t,u,p1,p2,p3,p4,q1,q2,q3,q4,r1,r2,r3,r4,length_cu,width_cu,hight_cu
 * *********************************************************************************************/

class Cuboid extends Shape_3D
{
	//initalization
    double m,n,o,p,q,r,s,t,u,p1,p2,p3,p4,q1,q2,q3,q4,r1,r2,r3,r4;
    double length_cu = Math.sqrt(p*p + s*s + m*m);
    double width_cu = Math.sqrt(q*q + t*t + n*n);
    double  hight_cu = Math.sqrt(r*r + u*u + o*2);

    Cuboid()//defult constructer
    {
        p =0;q =0;t = 0;
        r = 0;s = 0;u = 0;
    }
    
    public void create_file_cu()//creating file
    {
        try
        {
            FileOutputStream Fout = new FileOutputStream("filename");
            ObjectOutputStream Oout = new ObjectOutputStream(Fout);
            
            String a1 = " The Value Of Length Of Cuboid Is  :" +getValueOf(length_cu);
            byte[] A = a1.getBytes();
            Oout.writeObject(A);

            String b1 = " The Value Of Width Of Cuboid Is  :" +getValueOf(width_cu);
            byte[] B = b1.getBytes();
            Oout.writeObject(B);
            
            String d1 = " The Value Of Hight Of Cuboid Is  :" +getValueOf(hight_cu);
            byte[] D = d1.getBytes();
            Oout.writeObject(D);
            
            String c1 = " The Surface Area Of Cuboid Is  :" +getValueOf(surfacearea);
            byte[] C= c1.getBytes();
            Oout.writeObject(C);
            
            String e1 = " The Volume Of Cuboid Is  :" +getValueOf(volume);
            byte[] E= e1.getBytes();
            Oout.writeObject(E);

        }
        
        catch(Exception e)
        {
            System.out.println("Error..."+e);
        }
    }
    
    public void set_cuboid()//MEMBER FUNCTION OF SET CUBOID
    {
        try
        {
            FileInputStream Fin = new FileInputStream("filename");
            ObjectInputStream Oin = new ObjectInputStream(Fin);
            
            int value = 0;
            
            while(Fin.read() != -1)
            {
                System.out.println((char)value);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error..."+e);
        }
    }
    
    public void get_vertices_cu() //MEMBER FUNCTION OF GET VERTEX
    {
        System.out.println("Enter The Three Co-ordinates Of First point :");
        p1 = S.nextInt();
        q1 = S.nextInt();
        r1 = S.nextInt();
        
        System.out.println("Enter The Co-ordinates of First Dimension Point(Length) :");
        p2 = S.nextInt();
        q2 = S.nextInt();
        r2 = S.nextInt();
        
        System.out.println("Enter The Co-ordinates Of Second Dimension Point(Width) :");
        p3 = S.nextInt();
        q3 = S.nextInt();
        r3 = S.nextInt();
        
        System.out.println("Enter The Co-ordinates Of Third Dimension Point(Hight) :");
        p4 = S.nextInt();
        q4 = S.nextInt();
        r4 = S.nextInt();
    }
    
    public void find_surface()//MEMBER FUNCTION OF FIND SURFACE
    {
    
        double length_cu = Math.sqrt((p2 - p1)*(p2 - p1) + (q2 - q1)*(q2 - q1) + (r2 - r1)*(r2 - r1));
        double width_cu = Math.sqrt((p3 - p1)*(p3 - p1) + (q3 - q1)*(q3 - q1) + (r3 - r1)*(r3 - r1));
        double hight_cu = Math.sqrt(( p4 - p1)*( p4 - p1) + (q4 - q1)*(q4 - q1) + (r4 - r1)*(r4 - r1));
        
        surfacearea = 2*length_cu + 2*hight_cu + 2*width_cu;
        
        System.out.println("The Surface Area Of This Cuboid Is : " +surfacearea);
    }
    private float sqrt(int i) {
        return 0;
    }

    public void find_volume()//MEMBER FUNCTION OF FIND VOLUME
    {
        double length_cu = Math.sqrt((p2 - p1)*(p2 - p1) + (q2 - q1)*(q2 - q1) + (r2 - r1)*(r2 - r1));
        double width_cu = Math.sqrt((p3 - p1)*(p3 - p1) + (q3 - q1)*(q3 - q1) + (r3 - r1)*(r3 - r1));
        double hight_cu = Math.sqrt(( p4 - p1)*( p4 - p1) + (q4 - q1)*(q4 - q1) + (r4 - r1)*(r4 - r1));
        
        double volume = (length_cu)*(width_cu)*(hight_cu);
        System.out.println("The Volume Of This Cuboid Is :" +volume);
    }
}
/***************************************************
 * CLASS SPHERE IS CHILD CLASS OF SHAPE 3D
 * MEMBER FUNCTION:set vertex,find surface,find volume
 * MEMBER VARIABLE:radius_s,x,y,z,x1,x2,z1,z2,y1,y2
 * ***************************************************/
class Sphere extends Shape_3D
{
    Scanner S = new Scanner(System.in);
    int x,y,z,x1,x2,z1,z2,y1,y2;
    double radius_s;
    Sphere()//DEFULT CONSTRUCTER
    {
        x = 0;
        y = 0;
        z = 0;
    }
    
    public void create_file_s()//CREATING FILE
    {
        try
        {
            FileOutputStream Fout = new FileOutputStream("FILENAME_SPHERE");
            ObjectOutputStream Oout = new ObjectOutputStream(Fout);
            
            String a1 = " The Value Of Radius Of Sphere Is  :" +getValueOf(radius_s);
            byte[] A = a1.getBytes();
            Oout.writeObject(A);

            String c1 = " The Surface Area Of Sphere Is  :" +getValueOf(surfacearea);
            byte[] C= c1.getBytes();
            Oout.writeObject(C);

        }
        
        catch(Exception e)
        {
            System.out.println("Error...");
        }
    }
    
    public void set_sphere()//MEMBER FUNCTION OF SET SPHERE
    {
        try
        {
            FileInputStream Fin = new FileInputStream("filename");
            ObjectInputStream Oin = new ObjectInputStream(Fin);
            
            int value = 0;
            
            while(Fin.read() != -1)
            {
                System.out.println((char)value);
                value++;
            }
            Fin.close();
        }
        catch(Exception e)
        {
            System.out.println("Error...");
        }
    }
    
    public void get_vertices_s() //MEMBER FUNCTION OF GET VERTEX
    {
        System.out.println("Enter Co-ordinates Of The Centre Of The Sphere :");
        x1 = S.nextInt();
        y1 = S.nextInt();
        z1 = S.nextInt();
        
        System.out.println("Enter The Co-ordinates Of Any Point On The Surface Of The Sphere(Radius) :");
        x2 = S.nextInt();
        y2 = S.nextInt();
        z2 = S.nextInt();
        
        x = x2 - x1;
        y = y2 - y1;
        z = z2 - z1;
    }
    
    public void find_surface()//MEMBER FUNCTION OF FIND SURFACE
    {
        radius_s = sqrt(x*x + y*y + z*z);
        
        surfacearea = (float) (4*(3.14)*(radius_s)*(radius_s));
        
        System.out.println("The Surface Area Of The Sphere Is :" +surfacearea);
    }
    
    private float sqrt(int i) {
        return 0;
    }

    public void find_volume()//MEMBER FUNCTION OF FIND VOLUME
    {
        float radius_s = sqrt(x*x + y*y + z*x);
        
        volume = (float) ((4/3)*(3.14)*(radius_s)*(radius_s));
        
        System.out.println("Volume Of The Sphere Is :" +volume);
    }
}
public class ShapeMain {
	
	public static void main(String[] args) {
		Scanner S = new Scanner(System.in);
        Shape SA = new Shape();
        Shape_3D S3D = null ;
        Shape_2D S2D = null;
        
        System.out.println("Which Dimension Do You Want To Choose ?");
        System.out.println("1. TWO DIMENSTION");
        System.out.println("2. THREE DIMENSTION");
        System.out.println("3. EXIT");
        int f = S.nextInt();
        do
        {
            if(f == 1)
            {
                SA = S2D;
                
                System.out.println("Choose Any One Shape Of Which You Want To Find Area :");
                System.out.println("1. Rectangle");
                System.out.println("2. Circle ");
                int choose = S.nextInt();
                
                if(choose == 1)
                {
                    Rectangle R = new Rectangle();
                    S2D = R;
                    R.get_vertices_r();
                    R.find_area();
                    R.set_rectangle();
                    R.get_colour();
                    R.create_file_r();
                }
                
                else if(choose == 2)
                {
                    Circle CI = new Circle();
                    S2D = CI;
                    
                    CI.get_vertices_ci();
                    CI.find_area();
                    CI.set_circle();
                    CI.get_colour();
                    CI.create_file_ci();
                }
            }
            
            else if(f == 2)
            {
                
                SA = S3D;
                
                System.out.println("Choose Any One Shape Of Which You Want To Find Surface Area And Volume :");
                System.out.println("1. Cuboid");
                System.out.println("2. Sphere ");
                int choose = S.nextInt();
                
                if(choose == 1)
                {
                    Cuboid CU = new Cuboid();
                    S3D = CU;
                    
                    CU.get_vertices_cu();
                    CU.find_surface();
                    CU.find_volume();
                    CU.set_cuboid();
                    CU.get_colour();
                    CU.create_file_cu();
                }
                
                else if(choose == 2)
                {
                    Sphere SP = new Sphere();
                    S3D = SP;
                    
                    SP.get_vertices_s();
                    SP.find_surface();
                    SP.find_volume();
                    SP.set_sphere();
                    SP.get_colour();
                    SP.create_file_s();
                }
            }
        }while(f < 3);
	}
}
/*****************
 * END OF PROGRAM
 *****************/
