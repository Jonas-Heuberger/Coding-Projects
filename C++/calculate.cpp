#include <iostream>
using namespace std;

int eingabe()
{
    int a;
    cin >> a;
    return a;
}

int vearbeitung(int a, int b)
{
    return a + b;
}

void ausgabe(int c)
{
    cout << c;
}

void controller()
{
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