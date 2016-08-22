#include<stdio.h>
struct Customer_Details{
    char name[100];
    char address[100];
    long int phone;                               //last sem ppt help me to progress
}C;


struct Order_Details{
    char company[100];
    int quantity;
    float price;
}O[2];


int main(){

    int a,i;

//this all thing that are taken bellow are custmer detail
    printf("Enter Your Name : ");
    scanf("%s",C.name);

    printf("\nEnter Your Address : ");
    scanf("%s",C.address);

    printf("\nEnter Your Phone : ");
    scanf("%ld",&C.phone);

    printf("How many product you buy???");
    scanf("\n%d",&a);
//for loop is for how many product are you going to buy  and detail such as produuct coumpny ,price and quentity
    for(i=0;i<a;i++)
    {
        printf("\nEnter Your Product Company : ");
        scanf("%s",O[i].company);

        printf("\nEnter Your product Quantity: ");
        scanf("%d",&O[i].quantity);

        printf("\nEnter Your Product Price : ");
        scanf("%f",&O[i].price);
    }
//this will bassically see the name of the customer
printf("\n___________________________bill______________________________________");
printf("\n_____________________________________________________________________");
    printf("\nSr no.      C_name               Address                 Phone       \n");
    printf("   1          %s                   %s                      %ld          \n\n",C.name,C.address,C.phone);
    printf("P_Company       P_quantity          P_price(rs)             Cost(rs)\n");

    for(i=0;i<a;i++)
    {

    printf("%s              %d                 %.1f                  %.1f\n",O[i].company,O[i].quantity,O[i].price,(O[i].quantity)*(O[i].price));
    }



    return 0;
}
