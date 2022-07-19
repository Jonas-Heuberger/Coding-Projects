#include <iostream>
using namespace std;

class Hund {
    public:
    int age;
    string name;
    string race;

    void bark(){
        cout << "wuff wuff";
    }
};

int main(){
    Hund golden;
    golden.age = 1;
    golden.name = "bello";
    golden.race = "golden";

    golden.bark();

    return 0;
}