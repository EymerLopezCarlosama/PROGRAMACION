#include <iostream>

int main () {

    const double PI = 3.1416; 
    // PI es  una constante, no se puede cambiar su valor

    double radio = 10;
    double circunferencia = 2 * PI *  radio;

    std::cout << "La circunferencia es de: " << circunferencia <<" centimetros" << std::endl;

    return 0;   

}
