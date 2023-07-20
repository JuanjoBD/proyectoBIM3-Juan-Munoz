package agendatelefonica;

import java.util.Scanner;

public class AgendaTelefonica {
//Objetos globales
    static Contactos misContactos[] = new Contactos[15];
    static int contador = 0;
    static Scanner teclado = new Scanner(System.in);
    static int n;
    static String nombre1, domicilio1;

    public static void main(String[] args) {
        int op = 0;
        while (op != 5) {
            System.out.println("---------------------Menu principal---------------------");
            System.out.println("1. Guardar Contacto");
            System.out.println("2. Ver Contactos");
            System.out.println("3. Buscar Contacto");
            System.out.println("4. Modificar Contacto");
            System.out.println("5. Salir");
            System.out.println("Ingrese el numero de opcion");
            op = teclado.nextInt();
            if (op == 1) {
                GuardarContacto();
            } else if (op == 2) {
                System.out.println("#####################Contactos Guardados#####################");
                verTodos();
            } else if (op == 3) {
                System.out.println("--Buscar Contacto--");
                System.out.println("Ingrese el nombre: ");
                Scanner entrada = new Scanner(System.in);
                String nombre = entrada.nextLine();
                System.out.println(verContacto(nombre));
            } else if (op == 4) {
                System.out.println("--Modificar contacto--");
                System.out.println("Ingrese el numero del contacto que desea modificar: ");
                Scanner entrada = new Scanner(System.in);
                String numero = entrada.nextLine();
                System.out.println(cambiardatos(numero));
                System.out.println("nombre: " + misContactos[n].verNombre());
                System.out.println("numero: " + misContactos[n].verNumero());
                System.out.println("domicilio: " + misContactos[n].verDomicilio());
                System.out.println("#####################################################");
            } else if (op == 5) {
                System.out.println("--Programa finalizado--");
                break;
            } else {
                System.out.println("Opcion incorrecta");
            }
        }
    }

    static public void verTodos() {
        for (int i = 0; i < contador; i++) {
            System.out.println("----------Contacto: " + (i+1) + "----------");
            System.out.println("nombre: " + misContactos[i].verNombre());
            System.out.println("numero: " + misContactos[i].verNumero());
            System.out.println("domicilio: " + misContactos[i].verDomicilio());
            System.out.println("#####################################################");
        }
    }

    static public void GuardarContacto() {
        if (contador >= 15) {
            System.out.println("--Memoria llena--");
        } else {

            Scanner entrada = new Scanner(System.in);
            System.out.println("-------Nuevo Contacto-------");
            System.out.println("-Ingrese el nombre del contacto");
            String nombre = entrada.nextLine();
            System.out.println("-Ingrese el numero");
            String numero = entrada.nextLine();
            System.out.println("-Ingrese el domicilio");
            String domicilio = entrada.nextLine();
            misContactos[contador] = new Contactos(nombre, numero, domicilio);
            contador++;
            System.out.println("Contactos Guardados: " + contador);
        }
    }

    static public String verContacto(String nombre) {
        int posicion = -1;
        for (int i = 0; i < 15; i++) {
            if (misContactos [i] != null) {
                if (misContactos[i].verNombre().equals(nombre)) {
                    posicion = i;
                    break;
                }
            }
        }
        if (posicion != -1) {
            return "Contacto numero: " + (contador-1) +"\nNumero: " + misContactos[posicion].verNumero() + "\nDomicilio: " + misContactos[posicion].verDomicilio();
        } else {
            return "Contacto no encontrado";
        }
    }

    static public String cambiardatos(String numero) {
        Scanner teclado1=new Scanner (System.in);
        int posicion = -1;
        for (int i = 0; i < 15; i++) {
            if (misContactos [i] != null) {
                if (misContactos[i].verNumero().equals(numero)) {
                    posicion = i;
                    break;
                }
            }
        }
        if (posicion != -1) {
            System.out.println("----------------------------------------------");
        System.out.println("-Ingrese el nombre");
        nombre1 = teclado1.nextLine();
        System.out.println("-Ingrese el domicilio");
        domicilio1 = teclado1.nextLine();
        misContactos[n].setNombre(nombre1);
        misContactos[n].setDomicilio(domicilio1);
        return "-----Datos guardados con exito-----";
        } else {
            return "Contacto no encontrado";
        }
    }
}
