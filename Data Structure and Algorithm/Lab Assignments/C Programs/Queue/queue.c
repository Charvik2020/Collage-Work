/* Program for implementation of FIFO data structure (queue) */

#include "queue.h"

char ch;		 /* temporary variable for getting i/p */
struct NODE *front=NULL; /* points to the FRONT (start) of the Q
			    from which item may be deleted */
struct NODE *rear =NULL; /* points to the REAR (end) of the Q
			    from which item may be inserted */

main()
{
  /* Inifinite loop for menu */
  while(1){
    system("cls");
    printf("\n --- Welcome to QUEUE implementation ---\n");
    printf("0. Exit\n");
    printf("1. Insert data\n");
    printf("2. Delete data\n");
    printf("3. List data\n");
    printf("Select the option: ");
    scanf("%1s", &ch);
    system("cls");
    
    switch(ch){
    case '0':
      exit(0);
    case '1':
      printf("\n--- INSERT operation ---");
      QInsertItem();
      break;
    case '2':
      printf("\n--- DELETE operation ---");
      QDeleteItem();
      break;
    case '3':
      printf("\n--- Listing data ---");
      QList();
      break;
    default:
      printf("\nPlease enter valid option.");
    }
    printf("\n");
    ch=getchar();
  }
}

/* Function to perform the INSERTION operation
steps...
1) allocate memory and data to temporary variable
2) check whether the queue is empty or not,
   if queue is empty then
      assign temporary variable to the rear and front the Q
   else
      assign temporary varibale to the rear of the Q 
*/
int QInsertItem()
{
  struct NODE *temp=NULL;
  
  /* allocate memory to temporary varible */
  temp = (struct NODE*) malloc(sizeof(struct NODE));
  if(temp == NULL) {
    printf("\n>> Memory can't allocated\n");
    return ;
  }
  /* get data from user */
  printf("\nEnter values");
  printf("\nId: ");
  scanf("%d", &temp->data.id);
  printf("Name: ");
  scanf("%s", temp->data.name);
  
  /* because the node to be inserted will be the last node of the Q */
  temp->next=NULL;
  
  /* check whether the Q is empty or not */
  if(front == NULL) {
    /* Q is empty and this the firt node to be inserted */
    rear  = temp;
    front = temp;
  }
  else {
    /* Q is not empty , so insert new node at the end of the queue */
    rear->next = temp;
    rear = temp;
  }
  
  printf("\nFollowing data has been pushed");
  printf("\nId  : %d", rear->data.id);
  printf("\nName: %s\n", rear->data.name);
  printf("\n");
  ch = getchar();
}

/* Function to perform the DELETION operation 
steps...
1) check whether the queue is empty or not,
   if queue is empty then
      give msg "Queue is empty"
   else
      free first element of the queue which was pointed by front and then increment the front pointer to point 
      to the next queue element      
*/
int QDeleteItem()
{ 
  struct NODE *temp;

  temp = front;
  if(temp != NULL) {
    front = front->next;
    printf("\nFollowing data has been poped-up");
    printf("\nId  : %d", temp->data.id);
    printf("\nName: %s", temp->data.name);
    free(temp);
  }
  else {
    printf("\n *** QUEUE is EMPTY ***\n");
  }
  printf("\n");
  ch = getchar();
}

/* Function for displaying the queue elements
steps...
1) point the temporary varible to the front of the queue and
    perform following steps repeatedly until it becomes NULL
2) display data 
3) increment the temporary variable to point to the next 
    available queue element
*/
int QList()
{
  struct NODE *temp;
  
  /* point the start of the Q */
  temp = front;
  if(temp == NULL) {
    printf("\n*** QUEUE is EMPTY ***\n");
  }
  /* display data till end of the Q */
  while(temp != NULL) {
    printf("\nId  : %d", temp->data.id);
    printf("\nName: %s", temp->data.name);
    temp = temp->next;
  }
  printf("\n");
  ch = getchar();
}
