#include <iostream>
using namespace std;

class Cash
{
public:
    int Tausender;
    int Zweihunderter;
    int Hunderter;
    int Fünfziger;
    int Zwanziger;
    int Zehner;
    int Fünfer;
    int Zweier;
    int Einer;
};

void controller();

int input()
{
    int money;
    cin >> money;
    if (money <= 0)
    {
        cout << "Der Betrag darf nicht unter Null sein und es darf auch kein Text eingegeben werden \n";
        controller();
    }

    return money;
}

Cash atm(int money)
{
    Cash cash;

    for (cash.Tausender = 0; money >= 1000; cash.Tausender++)
    {
        money = money - 1000;
    }

    for (cash.Zweihunderter = 0; money >= 200; cash.Zweihunderter++)
    {
        money = money - 200;
    }

    for (cash.Hunderter = 0; money >= 100; cash.Hunderter++)
    {
        money = money - 100;
    }

    for (cash.Fünfziger = 0; money >= 50; cash.Fünfziger++)
    {
        money = money - 50;
    }

    for (cash.Zwanziger = 0; money >= 20; cash.Zwanziger++)
    {
        money = money - 20;
    }

    for (cash.Zehner = 0; money >= 10; cash.Zehner++)
    {
        money = money - 10;
    }

    for (cash.Fünfer = 0; money >= 5; cash.Fünfer++)
    {
        money = money - 5;
    }

    for (cash.Zweier = 0; money >= 2; cash.Zweier++)
    {
        money = money - 2;
    }

    for (cash.Einer = 0; money >= 1; cash.Einer++)
    {
        money = money - 1;
    }

    return cash;
}

void output(Cash cash)
{
    cout << " 1000er: " << cash.Tausender << "\n";
    cout << " 200er: " << cash.Zweihunderter << "\n";
    cout << " 100er: " << cash.Hunderter << "\n";
    cout << " 50er: " << cash.Fünfziger << "\n";
    cout << " 20er: " << cash.Zwanziger << "\n";
    cout << " 10er: " << cash.Zehner << "\n";
    cout << " 5er: " << cash.Fünfer << "\n";
    cout << " 2er: " << cash.Zweier << "\n";
    cout << " 1er: " << cash.Einer << "\n";
}

void controller()
{
    cout << "Geben Sie Ihren Betrag ein"
         << "\n";
    int money = input();
    Cash cash = atm(money);
    output(cash);
}

int main()
{
    controller();
    return 0;
}