#include <iostream>
using namespace std;

double inputNumber()
{
    cout <<"Enter your Number: " << "\n";
    double number;
    cin >>  number;
    return number;
}

double inputPercentage()
{
    cout << "please enter your percentage: " << "\n";
    double percentage;
    cin >> percentage;
    return percentage;
}

double calculate(double number, double percentage)
{
    return number * percentage / 100;
}


void ausgabe(double percentage, double number, double result)
{
    cout << percentage << '%' << " of " << number << " are " << result << "\n";
}

void controller()
{
    double number = inputNumber();
    double percentage = inputPercentage();
    double result = calculate(number, percentage);

    ausgabe(percentage, number, result);
}

int main()
{
    controller();
    return 0;
}