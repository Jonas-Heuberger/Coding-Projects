#include <iostream>
using namespace std;

class Tier
{

public:
    int age;
    string name;
    string race;
};

class Hund : Tier
{
public:
    int age;
    string name;
    string race;

    void bark()
    {
        cout << "wuff wuff";
    }
};

class Katze : Tier
{

public:
};

int main()
{
    Hund golden;
    golden.age = 1;
    golden.name = "bello";
    golden.race = "golden";

    golden.bark();

    return 0;
}