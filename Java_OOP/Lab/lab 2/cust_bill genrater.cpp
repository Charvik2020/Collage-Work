/*the program below is of customer shoping mart bill
*NAME: "Charvik Patel"
*ROLLNO:1401079
*BRANCH:ICT*/
#include<iostream>
#include<stdlib.h>     /*this is include for using exit(); function */

using namespace std;
class Customer_Details     /*i have created only 1 class becouse there is an error created in variable inialization*/
{
    private:
    char c_name[20];       /*private: is kept becouse programer cant use an declaration of private to the other class*/
    char c_address[100];
    double c_phoneno;

    string p_company[20];
    int p_quantity[20];
    float p_price[20];
    int no;
    int i;
    int sum=0;
    public:

    void bill();

    void input();

    void display();

    void item();

   void total();

}cd;
void Customer_Details::bill()            /* method bill() is created for formal chose of detail for further progress*/
        {


        cout<<"\n\n\n**********************IET-AU***********************************\n";
         cout<<"\n1. create new customer \n";
         cout<<"2. custumer detail \n";
         cout<<"3. product detail \n";
         cout<<"4. bill \n";
         cout<<"5. Exit \n";
         cout<<"\nenter your choice: ";
        }

    void Customer_Details::input()               /*this method is created for taking input of customer */
    {
        cout<<"customer name : \n";
        cin>>c_name;
        cout<<"customer address: \n";
        cin>>c_address;
        cout<<"customer phone number: \n";
        cin>>c_phoneno;

    }

void Customer_Details::display()     /* this method display is created for displaying Customer Detail*/
    {
        cout<<"\n****************************************";
        cout<<"\n         Customer detail           ";
        cout<<"\n________________________________________";
        cout<<"\n          name : "<<c_name;
        cout<<"\n          address: "<<c_address;
        cout<<"\n          phone number: "<<c_phoneno<<"\n\n";

    }

    void Customer_Details::item()       /*this method item() is for product detail*/
    {
        cout<<"\nhow many item do you want to buy? \n";
        cin>>no;             /*here no mean how many item do customer want to buy?*/
       for(i=0;i<no;i++)    /*here for loop is use for how many product does customer need ? thus for example
                              if no=2 thus system will ask product detail for twice */
       {
            cout<<"\n\nEnter your product coumpny: ";
            cin>>p_company[i];
            cout<<"\nEnter your quantity: ";
            cin>>p_quantity[i];
            cout<<"\nEnter price of product: ";
            cin>>p_price[i];
       }
    }
 void Customer_Details::total()              /*this method total is final an most inmportant becouse bill is genrated by this
                                                method*/
    {
        int j=0;
        cout<<"\n                         **BILL**                              ";
        cout<<"\n***************************************************************";
        j++;
        cout<<"\nbill no:"<<j;
        cout<<"\nname : "<<c_name;
        cout<<"\naddress: "<<c_address;
        cout<<"\nphone number: "<<c_phoneno;
         cout<<"\n_______________________________________________________________";
        cout<<"\nP_Company       P_quantity          P_price             Cost\n\n";
        for(i=0;i<no;i++)                  /*this for loop is for the no of product customer have buy are going to display in
                                             in bill*/
        {

            cout<<"      "<<(p_company[i]);
            cout<<"            "<<(p_quantity[i]);
            cout<<"                "<<(p_price[i]);
            cout<<"                    "<<((p_quantity[i])*(p_price[i]))<<endl<<endl;
        }
        for(i=0;i<no;i++)          /*this for loop is for geting the total(rupess) bill customer is going to pay*/
        {

            sum+=((p_quantity[i])*(p_price[i]));

        }
        cout<<"\n_____________________________________________________Total=";
        cout<<sum;
    }
int main()
{
    int i,x;
    for(;;)        /*this for loop is for the choice asking for further process*/
{
     cd.bill();
    cin>>x;
    switch(x)      /*switch case is use for the seller/customer choice purpus */
    {
    case 1:         /*case 1*/
        {
            cd.input();  /*input method is call */

     break;              /*break*/
        }
    case 2:             /*case 2*/
        {
            cd.display();   /* display method is call*/

        break;
        }
   case 3:
       {
             cd.item();

        break;
       }
   case 4:
    {

      cd.total();

    break;
    }
   case 5:
        {
            cout<<"\nVISIT AGAIN ! THANK YOU\n";
        exit(0);
        }
    }

}
 return 0;
}





