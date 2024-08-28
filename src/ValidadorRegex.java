import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidadorRegex {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java ValidadorRegex <cadenaEntrada>");
            return;
        }
        String cadenaEntrada = args[0];

        //Expresiones Regulares
        String[] regexes = {
                "Hola mundo", // Caso 1: Escrito exactamente igual
                "(?i)Hola mundo", // Caso 2: Escrito en cualquier combinacion de mayusculas y minusculas
                "\\b(Java|Python|Go|Pascal|Perl)\\b", // Caso 3: Lenguajes de programacion
                "^[a-zA-Z0-9._%+-]+@(unison\\.mx|uson\\.mx)$", // Caso 4: Correo de Unison
                "^ISI\\d{4}-[12]\\.(txt|csv)$" // Caso 5: Nombre de archivo
        };

        //Comparacion de expresiones
        String[] descripciones = {
                "Caso 1: 'Hola mundo' exacto",
                "Caso 2: 'Hola mundo' (cualquier combinacion de mayusculas y minusculas)",
                "Caso 3: Lenguajes de programacion (Java, Python, Go, Pascal, Perl)",
                "Caso 4: Correo de Unison",
                "Caso 5: Nombre de archivo"
        };

        //Mensaje de salida
        boolean encontrado = false;
        for (int i = 0; i < regexes.length; i++) {
            Pattern pattern = Pattern.compile(regexes[i]);
            Matcher matcher = pattern.matcher(cadenaEntrada);
            if (matcher.matches()) {
                System.out.println("Expresión válida para " + descripciones[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Expresión no válida .");
        }
    }
}


