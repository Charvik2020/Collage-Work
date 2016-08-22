/*
*Name:charvik patel
*Rollno:1401079
*Assingment 5_2
*/
/*Design a class in C++ called Polynomial that would store two dynamic arrays. The first array
* would represent the co-efficient of the terms and the second array would represent the degree (or
* exponent) of the terms. Create appropriate constructor(s) and destructor for the class. Overload the
* + operator to add two polynomials and store the result in the third polynomial. Overload the *
* operator to multiply a polynomial with a scalar value and store in another polynomial. Overload the
* unary  that would assign negative of a polynomial to another polynomial. Overload the << and
* >> operators to read and display a polynomial.
 */
#include<iostream>
#include<stdlib.h>
using namespace std;
class Polynomial
{
private:
int sz;
int *coeffecient;
int *power;
public:

int get_sz()
{
    return sz;
}
Polynomial(int a)
{
    int i;
sz=a;
coeffecient = new int[sz+1];
power = new int[sz+1];
for(i=0;i<sz+1;i++)
{
    power[i]=i;
}
}
Polynomial operator + (Polynomial& a)
{
int i;
if(sz+1>=a.sz+1)
{
    Polynomial P(sz);
    for(i=0;i<a.sz+1;i++)
{
P.coeffecient[i]=coeffecient[i]+a.coeffecient[i];
}
for(i=a.sz+1;i<sz+1;i++)
{
    P.coeffecient[i]=coeffecient[i];
}
return P;
}
else

{
    Polynomial P(a.sz);
    for(i=0;i<sz+1;i++)
{
P.coeffecient[i]=coeffecient[i]+a.coeffecient[i];
}
for(i=sz+1;i<a.sz+1;i++)
{
    P.coeffecient[i]=a.coeffecient[i];
}
return P;
}

}

Polynomial operator*(int a)
{
    int i;
Polynomial P(sz);
for(i=0;i<sz+1;i++)
{
P.coeffecient[i]=coeffecient[i]*a;
}
return P;
}

Polynomial operator-()
{
    int i;
Polynomial P(sz);
for(i=0;i<sz+1;i++)
{
P.coeffecient[i]=coeffecient[i]*-1;
}
return P;
}
friend ostream& operator<<(ostream& out,  Polynomial &P)
{
  int i;
  out<<"RESULT POLYNOMIAL:\n";
for(i=0;i<P.sz+1;i++)
{
out<<P.coeffecient[i]<<"*X^"<<P.power[i]<<"+";
}
  return out;
}

friend istream& operator>>(istream &in, Polynomial &P)
{
    int i;
for(i=0;i<P.sz+1;i++)
{
cout<<"Enter Coefficent of for Degree "<<i<<":";
in>>P.coeffecient[i];
P.power[i]=i;
}
return in;
}

};


int main()
{
    int n,s,sca;
    cout<<"********IET-AU**********";
    cout<<"\nENTER HIGGEST DEGREE:";
    cin>>s;
    Polynomial P(s),P1(s);
    cin>>P;
    cout<<" 1.DISPLAY POLYNOMIAL\n";
    cout<<" 2.MULTIPLICATION BY SCALER\n";
    cout<<" 3.NEGATIVE OF POLYNOMIAL\n";
    cout<<" 4.ADDITION OF POLYNOMIAL\n ";
    cout<<" ENTER YOUR CHOICE:";
    cin>>n;

    switch(n)
    {
    case 1:
        cout<<P;
        break;
    case 2:
        cout<<"ENTER SCALER:";
        cin>>sca;
        P1=P*sca;
        cout<<P1;
        break;
    case 3:

        P1=-P;
        cout<<P1;
        break;
    case 4:
        int sz1;

        cout<<"ENTER HIGGEST DEGREE OF SECOND POLYNOMIAL:";
        cin>>s;
        Polynomial P2(s);
        cin>>P2;
        if(P.get_sz()>=P2.get_sz())
        {
            sz1 = P.get_sz();
        }
        else
        {
            sz1 = P2.get_sz();
        }
        Polynomial P3(sz1);
        P3=P+P2;
        cout<<P3;

    }


}
