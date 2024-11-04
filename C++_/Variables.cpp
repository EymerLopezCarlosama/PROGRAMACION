#include <iostream>

int main(){
    
    int  n;       //Declaracion
    n = 5;      //Asignacion

    std::cout<<n<<std::endl;

    int x = 5;
    int y = 10;
    int  z = x + y;


    std ::cout<<y<<std::endl;
    std ::cout<<z<<std::endl;

    double precio  = 10.52352452452;
    double precio2 = 0.25423524;
    double total = precio + precio2;

    std::cout << "El total es: " << total << std::endl;
    
    float dato  = 10.5412342345;
    float dato2 =  0.234234234;
    float total2 =  dato + dato2;

    std::cout << "El resultado de la suma es: " << total2 << std::endl;

    // Diferencia entre float y double

    // float: Es un tipo de dato que representa números reales con una precisión de 6 dígitos decimales.
    // double: Es un tipo de dato que representa números reales con una precisión de 15 dígitos decimales.
    // La consola de Visual Studio muestra 4 decimales
    // Ejemplo de uso de float y double

    float datoFloat = 10.5412342345;
    double datoDouble = 10.5412342345;

    // La diferencia se nota en la precisión de los números decimales

    std::cout << "Float: " << datoFloat << std::endl;
    std::cout << "Double: " << datoDouble << std::endl;

    //CHAR

    char letra = 'A';

    std::cout << "La letra es: " << letra << std::endl;

    //BOOLEAN

    bool estaEncendido = true; 
    bool estaApagado = false;

    std::cout << "Esta encendido: " << estaEncendido << std::endl;
    std::cout << "Esta apagado: " << estaApagado << std::endl;

    //STRING

    std::string nombre = "Juan";
    std::string apellido = "Perez";
    std::string nombreCompleto = nombre + " " + apellido;

    std::cout << "El nombre completo es: " << nombreCompleto << std::endl;

return 0;

}