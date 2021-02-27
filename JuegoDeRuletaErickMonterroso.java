/*
ERICK ESTUARDO MONTERROSO VILLATORO
090-15-9458
INGENIERIA EN SISTEMAS UMG
 */
package juego.de.ruleta.erick.monterroso;

import java.util.Random;
import java.util.Scanner;


public class JuegoDeRuletaErickMonterroso {

    public static void main(String[] args) {
       Scanner entradaDatos = new Scanner(System.in);
       Random numrandom = new Random();
       double total = 100;
       double apuesta=10;
       int seleccion, ganador = 0, perdedor = 0, vuelta = 0;
       int num;
       int numruleta;
       int resultado;
       char cons = 's';
       int arg[] = new int[10];

       while (cons == 's' || cons == 'S' && total <= 0)
       {
           System.out.println("-------Menu de inicio---------");
           System.out.print("0 - Numero negro aleatorio(pares) \n1 - Numero blanco aleatorio(impares)\n2 - Apostar a numero X \n");
           seleccion = -1;
           while (seleccion < 0 || seleccion > 2)
           {
               System.out.print("\nSelecione sobre que desea apostar ($10 apuesta por ronda fija): \n\n");
               seleccion = entradaDatos.nextInt();
           }
           num = 0;
           if (seleccion == 2)  
           {
               while (num < 1 || num > 10)
               {
                   System.out.print("Elige el numero a apostar(1-10): ");
                   num = entradaDatos.nextInt();
               }
           }
           numruleta = numrandom.nextInt(11);
           vuelta++;
           System.out.println("-----Resultados-----");
           System.out.println("Numero de la ruleta: " + numruleta);
           
           if (seleccion == 2)
           {
               if (numruleta == num)
                   resultado = 9;
               else
                   resultado = 0;
           }
           else
           {
               if (numruleta == 0 || numruleta % 2 != seleccion)
                   resultado = 0;
               else
                   resultado = 1;
           }
           
           
           //resultados
           if (resultado > 0)
           {
               System.out.println("Felicidades !! Ganaste!");
               System.out.printf("Tu apuesta $%.2f \n", resultado * apuesta);
               System.out.printf("Toma tu dinero: $%.2f \n",
                       (resultado + 1) * apuesta);
               total = (resultado + 1) * apuesta + total;
               ganador ++;
               arg[numruleta]++;
               
           }
           else
           {
               System.out.println("Perdidste! sigue intentado!");
               System.out.printf("Tu has perdido: $%.2f \n",
                       (resultado + 1) * apuesta);
               total = total - (resultado + 1) * (apuesta);
               perdedor ++;
               arg[numruleta]++;
               
               if (total <= 0) {
            	   break;
               }

           }
           //continuar
           for (int totals=1; totals<10; totals++) {
        		if( arg[totals] > 0 ) {
        			System.out.println("El numero  " + totals + " gano " + arg[totals] + " veces.");
        		}
        	}
           
           System.out.println("Tu tienes $" + total + " dinero en total." );
           System.out.println("Tu ganaste " + ganador + " juegos.");
           System.out.println("Tu perdiste la apuesta en '" + perdedor + "' juegos.");
           System.out.println("Ruleta girada " + vuelta + " veces.");          
           System.out.print("\nQuieres otro juego? (s/n) ");
           cons = entradaDatos.next().charAt(0);
            
       }
    }
    
}
