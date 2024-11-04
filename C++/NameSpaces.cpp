#include <iostream>

namespace primero{
     int x = 1;
}

namespace segundo{
     int x = 2;
}

namespace tercero {
     int x = 3;
}

int main(){

     using namespace tercero; 
     // Las variables que no tienen asignado un namespace solo son visibles en el scope actual
     // Si se descomenta int x = 0, ocultará la x del namespace tercero
     //int x = 0;  

     std::cout << "x = " << x << std::endl;

     using namespace std;
     // Con esto ya no es necesario  poner std:: al  principio de cada función o variable
     // Tambein podemos usar "using std::cout;"
     // O "using std::string" para definir variables String sin  tener que poner std::


     cout << "x = " << primero::x << std::endl;
     cout << "x = " << segundo::x << std::endl;
          
     return 0;

}