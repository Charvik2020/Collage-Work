/*the program below is of customer shoping mart bill
*NAME: "Charvik Patel"
*ROLLNO:1401079
*BRANCH:ICT*/
#include<iostream>
#include<cstdlib>
int bl=1;
using namespace std;
class Customer_detail
{
private:
    //creating node
    struct node
    {
        char c_name[20];
        char c_address[100];
        float c_phoneno;
        int bill_no;
        string p_company[20];
        int p_quantity[20];
        float p_price[20];
        int n;
        int i;
        int sum=0;


	node *next;
	}*start,*curr;

	public:
	        Customer_detail()
    {
        curr=NULL;
        start=NULL;
    }
    //methode declaration
    void input();
    void display();
    void searching();
    void delete_Customer_Detail();
    void update_Customer_Details();
    void product_detail();
    void bill();
}cd;
// method defination
    void Customer_detail::input()
    {
        int a;

    do{
    node *temp;
    temp=new (struct node);

    cout<<endl<<endl<<"Enter Customer Name : ";
	cin>>temp->c_name;

	cout<<endl<<"Enter Customer address : ";
	cin>>temp->c_address;

	cout<<endl<<"Enter Customer phone number : ";
	//cin>>temp->c_phoneno[temp->i];
	cin>>temp->c_phoneno;



	temp->next=NULL;

	if(start==NULL)
    {
        start=curr=temp;
    }
    else
    {
        curr->next=temp;
        curr=temp;
    }

    temp->bill_no=bl;

    cout<<endl<<"Your bill No. is : "<<temp->bill_no<<endl;
    bl++;

    cout<<endl<<"Do you want to create an new account? : "<<endl;
    cin>>a;
}while(a==1);

    }
    void Customer_detail::display()
    {

        node *ptr;
    for(ptr=start;ptr!=NULL;ptr=ptr->next)
    {
        cout<<endl<<"\n____________________________________\n";
        cout<<endl<<"Customer Name : "<<ptr->c_name;
        cout<<endl<<"Customer Address : "<<ptr->c_address;
        cout<<endl<<"Customer Phone no. : "<<ptr->c_phoneno;

    }

    }
    void Customer_detail::searching()
    {
        int ac_no;
            node *temp;
            temp=start;

            cout<<endl<<endl<<"Enter bill no. you want to search : "<<endl;
            cin>>ac_no;

            do{

                if(temp->bill_no==ac_no)
                {
                    cout<<endl<<"Customer Name : "<<temp->c_name;
                    cout<<endl<<"Customer Address : "<<temp->c_address;
                    cout<<endl<<"Customer Phone no. : "<<temp->c_phoneno;


                    break;
                }
                temp=temp->next;


            }while(temp!=NULL);


    }
    void Customer_detail::delete_Customer_Detail()
    {
                    int bill_to_be_delete;
            node *temp,*t;
            temp=start;

            cout<<endl<<endl<<"Enter bill no. you want to delete : "<<endl;
            cin>>bill_to_be_delete;

            if(temp->bill_no==bill_to_be_delete)
            {
                t=start;
                start=NULL;
                temp=t->next;
                return;
            }

            while(temp->next!=NULL && (temp->next)->bill_no != bill_to_be_delete)
        {
           temp=temp->next;
        }
           if(temp->next==NULL)
           {
               cout<<endl<<"Doesn't exist";
               return;
           }

        t=temp->next;
        temp->next=NULL;
        temp=t->next;

        free(t);
        return;

    }
    void Customer_detail::update_Customer_Details()
    {
         int bill_to_be_delete;
    node *temp;
    temp=start;

    cout<<endl<<endl<<"Enter bill no. you want to search : "<<endl;
    cin>>bill_to_be_delete;

    do{

        if(temp->bill_no==bill_to_be_delete)
        {
            cout<<"You can update only Address, Phone no."<<endl;

            cout<<endl<<"Enter Customer address : ";
            cin>>temp->c_address;

            cout<<endl<<"Enter Customer phone number : ";
            cin>>temp->c_phoneno;


            break;
        }
        temp=temp->next;


    }while(temp!=NULL);

    }
    void Customer_detail::product_detail()
    {

    int bill_to_be_delete,d,b;
    node *temp;
    temp=start;

    cout<<endl<<endl<<"Enter bill no. you want to search : "<<endl;
    cin>>bill_to_be_delete;
    do{

        if(temp->bill_no==bill_to_be_delete)
        {

                cout<<"\nhow many item do you want to buy? \n";
        cin>>temp->n;

               for(temp->i=0;temp->i<temp->n;temp->i++)
        {
            cout<<"\n\nEnter your product coumpny: ";
            cin>>temp->p_company[temp->i];
            cout<<"\nEnter your quantity: ";
            cin>>temp->p_quantity[temp->i];
            cout<<"\nEnter price of product: ";
            cin>>temp->p_price[temp->i];
       }
       break;


            }
                        temp=temp->next;


        }while(temp!=NULL);

    }



    void Customer_detail::bill()
    {
        int bill_to_be_delete;
        node *temp;
    temp=start;

    cout<<endl<<endl<<"Enter bill no. you want to search : "<<endl;
    cin>>bill_to_be_delete;

    do{

        if(temp->bill_no==bill_to_be_delete)
        {
         cout<<"\n                         **BILL**                              ";
        cout<<"\n***************************************************************";
        cout<<"\nbill no:"<<bl--;
        cout<<"\nname : "<<(*temp).c_name;
        cout<<"\naddress: "<<(*temp).c_address;
        cout<<"\nphone number: "<<(*temp).c_phoneno;
         cout<<"\n_______________________________________________________________";
        cout<<"\nP_Company       P_quantity          P_price             Cost\n\n";
        for(temp->i=0;temp->i<temp->n;temp->i++)                  /*this for loop is for the no of product customer have buy are going to display in
                                                                    in bill*/
        {

            cout<<"      "<<((*temp).p_company[temp->i]);
            cout<<"            "<<((*temp).p_quantity[temp->i]);
            cout<<"                "<<((*temp).p_price[temp->i]);
            cout<<"                    "<<(((*temp).p_quantity[temp->i])*((*temp).p_price[temp->i]))<<endl<<endl;
        }
        for(temp->i=0;temp->i<temp->n;temp->i++)          /*this for loop is for geting the total(rupess) bill customer is going to pay*/
        {

            temp->sum+=(((*temp).p_quantity[temp->i])*((*temp).p_price[temp->i]));

        }
        cout<<"\n_____________________________________________________Total=";
        cout<<temp->sum;
break;
        }
        temp=temp->next;
        }while(temp!=NULL);
    }
    //main method
int main()
{
    int no;
    do
    {
        cout<<"\n\n\n**********************IET-AU***********************************\n";
         cout<<"\n1. create new customer \n";
         cout<<"2. custumer detail \n";
         cout<<"3. search customer \n";
         cout<<"4. delete customer \n";
         cout<<"5. update customer \n";
         cout<<"6. product detail \n";
         cout<<"7. bill \n ";
         cout<<"8. Exit \n";
         cout<<"\nenter your choice: ";
        cin>>no;
        switch(no)
        {
        case 1:
            {
                cd.input();
            break;

            }
            continue;
        case 2:
            {
                cd.display();
            break;
            }
            continue;
        case 3:
            {
                cd.searching();
            break;
            }
            continue;
        case 4:
            {
                cd.delete_Customer_Detail();
            break;
            }
            continue;
        case 5:
            {
                cd.update_Customer_Details();
            break;
            }
            continue;
        case 6:
            {
                cd.product_detail();
                break;
            }
            continue;

        case 7:
            {
                cd.bill();
                break;
            }
            continue;
        case 8:
            {
                exit(0);
                break;
            }


        }

    }while(no<8 && no>0);
return 0;
}
