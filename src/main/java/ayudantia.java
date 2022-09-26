import java.util.Random;
import java.util.Scanner;

public class ayudantia {
    public static void main(String[] args) {
        Introduccion();
    }
    public static void Introduccion(){
        String [] base_de_palabras={"Mate Dulce","Alfajor","Huesillo","Cueca", "Vino"};
        String palabra=elegir_palabra(base_de_palabras);
        juego(palabra);
    }
    public static String elegir_palabra(String [] base_de_palabras){
        Random ran=new Random();
        String palabra=base_de_palabras[ran.nextInt(0,base_de_palabras.length)];
        return palabra;
    }
    public static void juego(String palabra){
        char letra;
        char[] letras_palabras=palabra.toCharArray();
        char [] ahogado=new char[letras_palabras.length];
        boolean muerte , seguir=true;
        int vidas=5;
        do {
            letra = ingreso();
            muerte=revisar_palabra(letra,letras_palabras,ahogado);
            if(muerte=true){
                vidas--;
            }
            if(vidas==0){
                System.out.println("Perdiste");
                seguir=false;
            }
            mostrar_vidas(vidas);
        }while(!seguir);
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
    public static boolean revisar_palabra(char letra,char [] letras_palabra, char [] ahogado){
    for(int i=0; i<letras_palabra.length;i++){
        if(letra==letras_palabra[i]){
            ahogado[i]=letra;
            return true;
        }
    }
    return false;
    }
    public static void mostrar_vidas(int vidas){
        System.out.print("Vidas :  ");
        for (int i=0;i<vidas;i++) {
            System.out.print(".");
        }
    }

}
