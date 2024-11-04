#include <iostream>
#include <vector>

//typedef std::vector<std::pair<std::string, int >>pair_list_t;
// A tener cuenta que con typedef el identificador termina con "_t"

//typedef std::string text_t;
//typedef int numero_t;

using text_t = std::string;
using numero_t = int;

// Normalmente se  usa typedef para hacer alias de tipos de datos
// pero se puede usar el using para hacer lo mismo


int main(){

     using  namespace std;


     // pair_list_t pair_list;

     text_t nombre = "Eymer";
     numero_t edad = 24;


     cout<<nombre<<std::endl;
     cout<<edad<<std::endl;



return 0;

}