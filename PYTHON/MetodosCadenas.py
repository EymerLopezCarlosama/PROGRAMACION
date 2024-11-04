
nombre = "eymer lopez"
apellido = "CARLOSAMA"
edad = "19"

print("La longitud de la cadena es de: " + str(len(nombre))) # Longitud de la cadena

print("La letra |y| esta en la pocision: " + str(nombre.find("y"))) # Busca la posicion algun caracter

print(nombre.capitalize()) # Pone la primera letra en mayuscula

print(nombre.upper()) # Pone la cadena en mayuscula   

print(apellido.lower()) # Pone la cadena en minuscula

print("Son todos numero en la cadena |nombre|?? " + str(nombre.isdigit())) # Dice si la cadena es un numero
print("Son todos numero en la cadena |edad|?? " + str(edad.isdigit()))

print("Son todos caracteres en la cadena |nombre|?? " + str(nombre.isalpha())) # Dice si la cadena es un caracter
print("Son todos caracteres en la cedena |apellido|?? " + str(apellido.isalpha()))

print("Hay: " + str(nombre.count("e")) + " |e| en el nombre") # Cuenta cuantas veces aparece el caracter

print(nombre.replace("e", "E")) # Reemplaza un caracter por otro