#include<iostream>
#include<stdlib.h>

  using namespace std;
  class Polynomial
   {
    private:
    int a;
    int *Co;
    int *expo;
    public:

    int geta()
    {
        return a;
    }
    Polynomial(int a)
    {
        int i;
    a=a;
    Co = new int[a+1];
    expo = new int[a+1];
        for(i=0;i<a+1;i++)
        {
            expo[i]=i;
            }
        }


    Polynomial operator+(Polynomial&a)
    {
        int i;
        if(a+1>=a.(a+1))
        {
            Polynomial P(a);
            for(i=0;i<a.a+1;i++)
        {
        P.Co[i]=Co[i]+a.Co[i];
        }
        for(i=a.a+1;i<a+1;i++)
        {
            P.Co[i]=Co[i];
        }
        return P;
    }
    else

    {
            Polynomial P(a.a);
            for(i=0;i<a+1;i++)
        {
        P.Co[i]=Co[i]+a.Co[i];
        }
        for(i=a+1;i<a.a+1;i++)
        {
            P.Co[i]=a.Co[i];
        }
        return P;
        }

    }

    Polynomial operator*(int a)
    {
            int i;
        Polynomial P(a);
        for(i=0;i<a+1;i++)
        {
        P.Co[i]=Co[i]*a;
        }
        return P;
    }

    Polynomial operator-()
    {
            int i;
        Polynomial P(a);
        for(i=0;i<a+1;i++)
        {
        P.Co[i]=Co[i]*-1;
        }
        return P;
    }

    friend ostream& operator<<(ostream& out,  Polynomial &P)
    {
          int i;
          cout<<"RESULT POLYNOMIAL:\n";
        for(i=0;i<P.a+1;i++)
        {
        cout<<P.Co[i]<<"*X^"<<P.expo[i]<<"+";
        }
          return out;
    }

    friend istream& operator>>(istream &in, Polynomial &P)
    {
            int i;
        for(i=0;i<P.a+1;i++)
        {
        cout<<"Enter Coicent of for Degree "<<i<<":";
        cin>>P.Co[i];
        P.expo[i]=i;
        }
        return in;
        }

};


int main()
{
    int n,s,sca;
    cout<<"Enter Highest Degree:";
    cin>>s;
    Polynomial P(s),P1(s);
    cin>>P;
    cout<<"1.DISPLAY POLYNOMIAL\n 2.MULTIPLICATION BY SCALER\n 3.NEGATIVE OF POLYNOMIAL\n 4.ADDITION OF POLYNOMIAL\n ENTER YOUR CHOICE:";
    cin>>n;

    switch(n)
    {
    case 1:
        cout<<P;
        break;
    case 2:
        cout<<"Enter Scaler:";
        cin>>sca;
        P1=P*sca;
        cout<<P1;
        break;
    case 3:

        P1=-P;
        cout<<P1;
        break;
    case 4:
        int a1;

        cout<<"Enter Highest Degree Of Second Polynomial:";
        cin>>s;
        Polynomial P2(s);
        cin>>P2;
        if(P.geta()>=P2.geta())
        {
            a1 = P.geta();
        }
        else
        {
            a1 = P2.geta();
        }
        Polynomial P3(a1);
        P3=P+P2;
        cout<<P3;

    }


}
