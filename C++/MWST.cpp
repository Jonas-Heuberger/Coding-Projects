#include <iostream>
using namespace std;

long double input()
{
    long double money;
    cin >> money;
    return money;
}

long double calc(long double money)
{
    // printf("LOL: %d", (int)((float)money / 107.7f));
    return (money / 107.7) * 100.0;
}

void output(long double money){
    cout << "amount without taxes: " << money << "\n";
}

void controller()
{
    long double money = input();
    money = calc(money);
    output(money);
}

int main()
{
    controller();
    return 0;
}