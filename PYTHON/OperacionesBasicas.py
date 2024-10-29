
# Operaciones básicas en Python

# Operaciones aritméticas
def operaciones_aritmeticas():
    a = 10
    b = 5
    print("Suma:", a + b)
    print("Resta:", a - b)
    print("Multiplicación:", a * b)
    print("División:", a / b)
    print("División entera:", a // b)
    print("Módulo:", a % b)
    print("Potencia:", a ** b)

# Operaciones con strings
def operaciones_strings():
    texto1 = "Hola"
    texto2 = "Mundo"
    print("Concatenación:", texto1 + " " + texto2)
    print("Repetición:", texto1 * 3)
    print("Longitud:", len(texto1))
    print("Mayúsculas:", texto1.upper())
    print("Minúsculas:", texto2.lower())

# Operaciones con listas
def operaciones_listas():
    lista = [1, 2, 3, 4, 5]
    print("Lista original:", lista)
    lista.append(6)
    print("Append:", lista)
    lista.pop()
    print("Pop:", lista)
    print("Índice de 3:", lista.index(3))
    print("Cantidad de elementos:", len(lista))

# Operaciones con diccionarios
def operaciones_diccionarios():
    diccionario = {"nombre": "Juan", "edad": 25}
    print("Diccionario:", diccionario)
    print("Valor de nombre:", diccionario["nombre"])
    diccionario["ciudad"] = "Madrid"
    print("Agregar elemento:", diccionario)
    print("Llaves:", diccionario.keys())
    print("Valores:", diccionario.values())

# Operaciones con conjuntos
def operaciones_conjuntos():
    conjunto1 = {1, 2, 3, 4}
    conjunto2 = {3, 4, 5, 6}
    print("Unión:", conjunto1 | conjunto2)
    print("Intersección:", conjunto1 & conjunto2)
    print("Diferencia:", conjunto1 - conjunto2)

# Ejecución de funciones
if __name__ == "__main__":
    print("\n=== Operaciones Aritméticas ===")
    operaciones_aritmeticas()
    
    print("\n=== Operaciones con Strings ===")
    operaciones_strings()
    
    print("\n=== Operaciones con Listas ===")
    operaciones_listas()
    
    print("\n=== Operaciones con Diccionarios ===")
    operaciones_diccionarios()
    
    print("\n=== Operaciones con Conjuntos ===")
    operaciones_conjuntos()
