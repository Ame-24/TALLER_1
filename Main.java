// Sofía Martínez y Amelia Yánez 

import java.util.Scanner; 

public class Main { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        AppStore tienda = new AppStore(); 

        int opcion = 0; 

        while (opcion != 6) { 
            System.out.println("\n--- Menú AppStore ---"); 
            System.out.println("1. Ver información de juegos");
            System.out.println("2. Comprar licencias de un juego");
            System.out.println("3. Vender licencias de un juego");
            System.out.println("4. Consultar juego más vendido");
            System.out.println("5. Calcular descuento por volumen");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt(); 
            sc.nextLine(); 

            switch (opcion) { 
                case 1: 
                    mostrarInfoJuego(tienda.darJuego1());
                    mostrarInfoJuego(tienda.darJuego2());
                    mostrarInfoJuego(tienda.darJuego3());
                    mostrarInfoJuego(tienda.darJuego4());
                    break;

                case 2: 
                    System.out.print("Nombre del juego: ");
                    String nombreCompra = sc.nextLine();
                    System.out.print("Cantidad de licencias a comprar: ");
                    int cantidadCompra = sc.nextInt();
                    tienda.comprarLicenciasJuego(nombreCompra, cantidadCompra);
                    System.out.println("Compra realizada.");
                    break;

                case 3: 
                    System.out.print("Nombre del juego: ");
                    String nombreVenta = sc.nextLine();
                    System.out.print("Cantidad de licencias a vender: ");
                    int cantidadVenta = sc.nextInt();
                    boolean vendido = tienda.venderLicenciasJuego(nombreVenta, cantidadVenta);
                    if (vendido) {
                        System.out.println("Venta realizada.");
                    } else {
                        System.out.println("No hay suficientes licencias.");
                    }
                    break;

                case 4: 
                    System.out.println("Juego más vendido: " + tienda.darJuegoMasVendido());
                    break;

                case 5: 
                    System.out.println("Ingrese cantidades para cada juego:");
                    System.out.print("Candy Crush: ");
                    int cant1 = sc.nextInt();
                    System.out.print("Flow: ");
                    int cant2 = sc.nextInt();
                    System.out.print("FIFA: ");
                    int cant3 = sc.nextInt();
                    System.out.print("Clash of Clans: ");
                    int cant4 = sc.nextInt();
                    System.out.println(tienda.calcularVentaPorVolumen(cant1, cant2, cant3, cant4));
                    break;

                case 6: 
                    System.out.println("Saliendo del programa...");
                    break;

                default: 
                    System.out.println("Opción no válida.");
            }
        }

        sc.close(); 
    }

    public static void mostrarInfoJuego(Juego juego) { 
        System.out.println("\nNombre: " + juego.darNombre());
        System.out.println("Categoría: " + juego.darCategoria());
        System.out.println("Precio: $" + juego.darPrecio());
        System.out.println("Tamaño: " + juego.darTamanio() + "KB");
        System.out.println("Licencias disponibles: " + juego.darCantidadLicencias());
        System.out.println("Licencias vendidas: " + juego.darCantidadVendidas());
    }
}
