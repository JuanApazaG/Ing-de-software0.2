/*Encuentra la letra que falta
Escriba un método que tome una matriz de letras consecutivas (en aumento) como entrada y que devuelva la letra que falta en la matriz.

Siempre obtendrá una matriz válida. Y siempre faltará exactamente una letra. La longitud de la matriz siempre será al menos 2.
La matriz siempre contendrá letras en un solo caso.

Ejemplo:

['a','b','c','d','f'] -> 'e'
['O','Q','R','S'] -> 'P'
(¡Utilice el alfabeto inglés con 26 letras!)

¡Diviértete codificándolo y no olvides votar y clasificar este kata! :-)

También he creado otros katas. ¡Echa un vistazo si disfrutaste este kata! */


public class Kata
{
  public static char findMissingLetter(char[] array)
  {
    char missingLetter = ' ';
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] - array[i] != 1) {
                missingLetter = (char) (array[i] + 1);
                break;
            }
        }
        return missingLetter;
  }
}
