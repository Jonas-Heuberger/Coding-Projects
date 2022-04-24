#include <stdio.h>

int main() {
  int num = inputNumber();
  int cash = atm(num);
  printf("%d", cash);
  return 0;
}

// Language: c

int inputNumber() {
  int number;
  printf("Enter a number: ");
  scanf("%d", &number);
  return number;
}

int *atm(int num) {
  int cash[9];
  for (int i = 0; i <= 100; i++) {
    cash[1] = 1;
  }
  for (int i = 0; num <= 200; i++)
  {
    /* code */
     cash[2] = i;
  }

  for (int i = 0; num <= 100; i++)
  {
    /* code */
    cash[3] = i;
  }

  for (int i = 0; num <= 50; i++)
  {
    /* code */
    cash[4] = i;
  }

  for (int i = 0; num <= 20; i++)
  {
    /* code */
    cash[5] = i;
  }

  for (int i = 0; num <= 10; i++)
  {
    /* code */
    cash[6] = i;
  }

  for (int i = 0; num <= 5; i++)
  {
    /* code */
    cash[7] = i;
  }

  for (int i = 0; num <= 2; i++)
  {
    /* code */
    cash[8] = i;
  }

  for (int i = 0; num <= 1; i++)
  {
    /* code */
    cash[9] = i;
  }
  
  return cash;
}

