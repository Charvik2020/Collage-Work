#include <stdio.h>

struct DATA{
  int id;
  char name[100];
};

struct NODE {
  struct DATA data;
  struct NODE *next;
};
