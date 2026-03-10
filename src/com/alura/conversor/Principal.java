package com.alura.conversor;

import com.alura.conversor.model.ResultadoConversion;
import com.alura.conversor.service.ConsultaMoneda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        // Reemplazá esto por tu API KEY real
        String apiKey = "48bc69974aef19f53311643d";

        ConsultaMoneda consulta = new ConsultaMoneda(apiKey);

        int opcion = 0;

        while (opcion != 7) {
            System.out.println("""
                    
                    *************************************************
                    Sea bienvenido/a al Conversor de Moneda
                    
                    1) Dólar => Peso argentino
                    2) Peso argentino => Dólar
                    3) Dólar => Real brasileño
                    4) Real brasileño => Dólar
                    5) Dólar => Peso colombiano
                    6) Peso colombiano => Dólar
                    7) Salir
                    
                    Elija una opción válida:
                    *************************************************
                    """);

            try {
                opcion = lectura.nextInt();

                if (opcion >= 1 && opcion <= 6) {
                    System.out.println("Ingrese el valor que desea convertir:");
                    double cantidad = lectura.nextDouble();

                    ResultadoConversion resultado = null;

                    switch (opcion) {
                        case 1:
                            resultado = consulta.convertirMoneda("USD", "ARS", cantidad);
                            break;
                        case 2:
                            resultado = consulta.convertirMoneda("ARS", "USD", cantidad);
                            break;
                        case 3:
                            resultado = consulta.convertirMoneda("USD", "BRL", cantidad);
                            break;
                        case 4:
                            resultado = consulta.convertirMoneda("BRL", "USD", cantidad);
                            break;
                        case 5:
                            resultado = consulta.convertirMoneda("USD", "COP", cantidad);
                            break;
                        case 6:
                            resultado = consulta.convertirMoneda("COP", "USD", cantidad);
                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }

                    if (resultado != null) {
                        System.out.println();
                        System.out.println("***************************************");
                        System.out.println("El valor " + cantidad + " [" + resultado.getBaseCode() + "]"
                                + " corresponde al valor final de =>>> "
                                + resultado.getConversionResult() + " [" + resultado.getTargetCode() + "]");
                        System.out.println("Tasa utilizada: " + resultado.getConversionRate());
                        System.out.println("***************************************");
                        System.out.println();
                    }

                } else if (opcion == 7) {
                    System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                } else {
                    System.out.println("Opción inválida. Intente nuevamente.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Debe ingresar un número.");
                lectura.nextLine();
            } catch (RuntimeException e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
                lectura.nextLine();
            }
        }

        lectura.close();
    }
}