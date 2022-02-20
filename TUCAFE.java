import java.util.Scanner;

public class TUCAFE {
    public static void main(String[] args) {

        MaquinaCafe maquinaDelSuper = new MaquinaCafe();

        maquinaDelSuper.main();
    }
}

class MaquinaCafe {
 
    private Scanner sc = new Scanner(System.in);  
    private int montoDisponible = 25;
    
    private Cafe cafe1 = new Cafe("Café Regular", 10);
    private Cafe cafe2 = new Cafe("Café Expresso", 15);
    private Cafe cafe3 = new Cafe("Capuccino", 25);
    private Cafe cafe4 = new Cafe("Mocaccino", 25);

    public void main() {         
        menu();
    }


    public void menu(){
        limpiarPantalla();
        System.out.println("¡Bienvenido a la expendedora de bebidas TUCAFE!");
        boolean continuar = true;

        while (continuar) {
            System.out.println("Introduce una moneda [solo aceptamos monedas de 1, 5, 10 y 25 pesos]:");
            int moneda = sc.nextInt();
            aumentarMontoDisponible(moneda);
            mostrarMontoDisponible();
            
            System.out.println("¿Desea introducir otra móneda? true/false");
            Boolean introducirOtraMoneda = sc.nextBoolean();
            
            if( !introducirOtraMoneda ){                                
                continuar = false;
            }
            
            limpiarPantalla();
            
        }
        
        mostrarBebidas();

        comprarBebida();

        System.out.println("¡Distrute sus bebidas, feliz día!");

    }
    
    public void aumentarMontoDisponible(int cantidad){
        if( cantidad == 1 || cantidad == 5 || cantidad == 10 || cantidad == 25 ){
            montoDisponible = montoDisponible + cantidad;
        }else {
            System.out.println("Móneda no válida!");
        }
    }

    public void mostrarMontoDisponible(){
        System.out.println("Monto disponible: " + montoDisponible);
    } 

    public void mostrarBebidas(){
        mostrarMontoDisponible();
        System.out.println("Seleccione el número de su bebida:");
        System.out.println("Tipo de Bebida -- Precio");
        System.out.println("1 - " + cafe1.infoCafe());        
        System.out.println("2 - " + cafe2.infoCafe());        
        System.out.println("3 - " + cafe3.infoCafe());        
        System.out.println("4 - " + cafe4.infoCafe());        
    }

    public void comprarBebida(){

        boolean deseaComprarBebida = true;
        
        while (deseaComprarBebida) {

            int seleccion = sc.nextInt();
            
            switch (seleccion) {
                case 1:
                    if( montoDisponible < cafe1.precio() ){
                        System.out.println("Monto insuficiente");
                        return;     
                    }
                    montoDisponible -= cafe1.precio();  
                    cafe1.cafeComprado();          
                    mostrarMontoDisponible();    
                    break;
                case 2:
                    if( montoDisponible < cafe2.precio() ){
                        System.out.println("Monto insuficiente");
                        return;     
                    }
                    montoDisponible -= cafe2.precio();
                    cafe2.cafeComprado();
                    mostrarMontoDisponible();
                break;
                case 3:
                    if( montoDisponible < cafe3.precio() ){
                        System.out.println("Monto insuficiente");
                        return;     
                    }
                    montoDisponible -= cafe3.precio();
                    cafe3.cafeComprado();
                    mostrarMontoDisponible();
                    break;
                case 4:
                    if( montoDisponible < cafe4.precio() ){
                        System.out.println("Monto insuficiente");
                        return;     
                    }
                    montoDisponible -= cafe4.precio();
                    cafe4.cafeComprado();
                    mostrarMontoDisponible();
                break;
    
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

            System.out.println("¿Desea comprar otra bebida? true/false");
            boolean respuestaContinuar = sc.nextBoolean();
            if( !respuestaContinuar ){
                deseaComprarBebida = false;
            }
            limpiarPantalla();
            mostrarBebidas();

        }

    }

    public void limpiarPantalla(){
        System.out.print("\033[H\033[2J");
    }

}

class Cafe {
    private String nombre;
    private int precio;

    public Cafe(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String nombre(){
        return nombre;
    }

    public int precio(){
        return precio;
    }

    public String infoCafe(){
        return nombre + " -- RD$" + precio + ".00";
    }

    public void cafeComprado(){
        System.out.println("Gracias por preferirnos, distrute su " + nombre());
    }
}