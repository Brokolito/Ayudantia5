import java.util.Random;
import java.util.Scanner;

public class ayudantia {
    public static void main(String[] args) {
        Introduccion();
    }
    public static void Introduccion(){
        String [] base_de_palabras={"Mate Dulce","Alfajor","Huesillo","Cueca", "Vino"};
        String palabra=elegir_palabra(base_de_palabras);
        char [] juego=new char[palabra.length()];
        juego(palabra);
    }
    public static String elegir_palabra(String [] base_de_palabras){
        Random ran=new Random();
        String palabra=base_de_palabras[ran.nextInt(0,base_de_palabras.length)];
        System.out.println(palabra);
        return palabra;
    }
    public static void juego(String palabra){
        palabra=reemplazarPalabra(palabra);
        System.out.println(palabra);
        char letra;
        char[] letras_palabras=palabra.toCharArray();
        mostrar_tablero(letras_palabras);
        char [] ahogado=new char[letras_palabras.length];
        boolean muerte , seguir=true;
        int vidas=palabra.length()+2;
        do {
            letra = ingreso();
            muerte=revisar_palabra(letra,letras_palabras,ahogado);
            if(muerte){
                vidas--;
            }
            if(vidas==0){
                System.out.println("Perdiste");
                seguir=false;
            }
            mostrar_vidas(vidas);
            seguir=ganar(vidas,letras_palabras);
        }while(seguir);
        System.out.println("Ganaste!");
    }
    public static Boolean ganar(int vidas, char [] letras_palabra){
        int letras_menos=0;
        for(int i=0;i<letras_palabra.length;i++){
            if(letras_palabra[i]=='\0'){
             letras_menos++;
            }
        }
        System.out.println(letras_menos);
        if(letras_menos==letras_palabra.length && vidas>0){
            return false;
        }
        else {
            return true;
        }
    }
    public static char ingreso (){
        Scanner intro=new Scanner(System.in);
        char letra;
        try {
            do {
                System.out.println("Ingrese una letra");
                letra = intro.next().charAt(0);
            } while (!(letra >= 'a' && letra <= 'z' || letra >= 'á' && letra <= 'ú'|| letra >= 'A' && letra <= 'Z' ));
        }
        catch(Exception e){
            System.out.println("Ingrese una letra valida");
            letra=ingreso();
        }
       letra=reemplazar(letra).charAt(0);
        return letra;
    }
    public static String reemplazar(char letra){
        letra=Character.toLowerCase(letra);
        String letra_cambiada= String.valueOf(letra);
          letra_cambiada=letra_cambiada.replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u").replace(" ", "").replace(".", "").replace(",", "");
        return letra_cambiada;
    }
    public static boolean revisar_palabra(char letra,char [] letras_palabra, char [] ahogado) {
        int letraIgual = 0;
        for (int i = 0; i < letras_palabra.length; i++) {
            System.out.println(letras_palabra[i]);
            if (letras_palabra[i]==letra) {
                ahogado[i] = letra;
                letras_palabra[i]='\0';
                letraIgual++;
            }
        }
        mostrar_tablero(ahogado);
        if (letraIgual > 0) {
            return false;
        } else {
            return false;
        }
    }
    public static void mostrar_vidas(int vidas){
        System.out.print("Vidas :  ");
        for (int i=0;i<vidas;i++) {
            System.out.print("♥");
        }
    }
public static void mostrar_tablero(char [] juego){
        for(int i=0;i<juego.length;i++){
                System.out.print(juego[i]);
        }
}
    public static String reemplazarPalabra(String palabra){
        palabra=palabra.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
                .replace("ú", "u").replace(" ", "").replace(".", "").replace(",", "");
        return palabra;
    }
}
