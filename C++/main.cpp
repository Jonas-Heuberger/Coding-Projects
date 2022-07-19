#include <iostream>
using namespace std;
using namespace car;
void ausgabe(int c){
    cout << c;
}

int eingabe() {
    int a;
    std::cin >> a;
    return a;
}


int vearbeitung(int a, int b) {
    return a + b;
}

void controller(){
     int a = eingabe();
    int b = eingabe();
    int c = vearbeitung(a, b);

    ausgabe(c);
}

int main()
{
    cout << "Hello World";

    controller();
    return 0;

}