/* Program for implementation of LIFO data structure (stack) */

#include "stack.h"

/* variables */
char ch; /* temporary variable for getting i/p */
struct NODE *base=NULL; /* ptr which points to the base of the stack*/
struct NODE *top=NULL; /* ptr which points to the TOS (top of the stack) */

/* functions */
int Push();
int Pop();
int StackList();

main()
{
  /* Infinite loop for menu */
  while(1){
    //system("clear");
    printf("\n --- Welcome to STACK implementation ---\n");
    printf("0. Exit\n");
    printf("1. Push data\n");
    printf("2. Pop  data\n");
    printf("3. List data\n");
    printf("Select the option: ");
    scanf("%1s", &ch);
    //system("clear");

    switch(ch){
    case '0':
      exit(0);
    case '1':
      printf("\n--- PUSH operation ---");
      Push();
      break;
    case '2':
      printf("\n--- POP operation ---");
      Pop();
      break;
    case '3':
      printf("\n--- Listing data ---");
      StackList();
      break;
    default:
      printf("\nPlease enter valid option.");
    }
    ch=getchar();
  }
}

/* Function to perform the PUSH operation
steps...
1) allocate memory and data to temporary variable
2) check whether the stack is empty or not,
   if stack is empty then
      assign temporary variable to the TOS and to the baseof the stack
   else
      assign temporary variable to the top of the TOS
*/
int Push()
{
  struct NODE *temp=NULL;

  /* allocate memory to temporary variable */
  temp = (struct NODE*) malloc(sizeof(struct NODE));
  if(temp == NULL) {
    printf("\n*** STACK OVERFLOW ***\n");
    return ;
  }
  /* get data from user */
  printf("\nEnter values");
  printf("\nId: ");
  scanf("%d", &temp->data.id);
  printf("Name: ");
  scanf("%s", temp->data.name);

  /* ckeck whether the stack is empty or not */
  if(base == NULL) {
    /* if it is then it is the first element in stack */
    temp->next=NULL;
    base = temp;
    top = base;
  }
  else {
    /* stack is not empty and accordingly point the TOS to the
       last element entered */
    temp->next = top;
    top = temp;
  }

  printf("\nFollowing data has been pushed");
  printf("\nId  : %d", top->data.id);
  printf("\nName: %s\n", top->data.name);
  printf("\n");
  ch = getchar();
}

/* Function to perform the POP operation
steps...
1) check whether the stack is empty or not,
   if stack is empty then
      give msg "STACK UNDERFLOW"
   else
      pop (ie. delete) the TOS of the stack element and free it
*/
int Pop()
{
  struct NODE *temp;

  temp = top;
  /* stack if not empty then */
  if(temp != NULL) {
    /* point the TOS to the next element in the stack */
    top = top->next;
    printf("\nFollowing data has been poped-up");
    printf("\nId  : %d", temp->data.id);
    printf("\nName: %s", temp->data.name);
    free(temp);
  }
  else {
    /* stack is empty so */
    printf("\n *** STACK UNDERFLOW ***");
  }
  printf("\n");
  ch = getchar();
}

/* Function for displaying the stack elements
steps...
1) point the temporary variable to the TOS and
    perform following steps repeatedly until it becomes NULL
2) display data
3) increment the temporary variable to point to the next
    available stack element
*/
int StackList()
{
  struct NODE *temp;

  temp = top;
  if(temp == NULL) {
    printf("\n*** STACK is EMPTY ***\n");
  }
  while(temp != NULL) {
    printf("\nId  : %d", temp->data.id);
    printf("\nName: %s", temp->data.name);
    temp = temp->next;
  }
  printf("\n");
  ch = getchar();
}
