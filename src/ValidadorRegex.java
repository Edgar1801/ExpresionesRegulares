import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidadorRegex {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java RegexValidator <tipoRegex> <cadenaEntrada>");
            System.out.println("tipoRegex: 1 para 'Hola mundo' exacto, 2 para 'Hola mundo', 3 para lenguajes de programacion |Java|Python|Go|Pascal|Perl|, 4 para correo de Unison, 5 para nombre de archivo");
            return;
        }
        String tipoRegex = args[0];
        String cadenaEntrada = args[1];
        String regex = "";
        switch (tipoRegex) {
            case "1":
                regex = "Hola mundo"; //Debe estar escrito exactamente igual//
                break;
            case "2":
                regex = "(?i)Hola mundo"; //Puede estar escrito en cualquier combinacion de mayusculas y minusculas//
                break;
            case "3":
                regex = "\\b(Java|Python|Go|Pascal|Perl)\\b";
                break;
            case "4":
                regex = "^[a-zA-Z0-9._%+-]+@(unison\\.mx|uson\\.mx)$";
                break;
            case "5":
                regex = "^ISI\\d{4}-[12]\\.(txt|csv)$";
                break;
            default:
                System.out.println("tipoRegex invalido. Usa 1, 2, 3, 4 o 5.");
                return;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cadenaEntrada);
        if (matcher.matches()) {
            System.out.println("Expresion valida.");
        } else {
            System.out.println("Expresion no valida.");
        }
    }
}