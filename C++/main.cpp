#include <iostream>
#include <string>
using namespace std;

int Menue(){
  cout << "1: add voc \n";
  cout << "2: start training";
  char[1] option;
  cin >> option;
  
  return option;
}

void CheckOption(int option){
  if (option == 1){
    cout << "Deutsch: ";
      char* german;
      cin >> german;

    char* flanguage;
    cin >> flanguage;
  }

  if (option == 2){
    cout << "test start";
  }
}
int main() {
int option = Menue();
CheckOption(option);
}


