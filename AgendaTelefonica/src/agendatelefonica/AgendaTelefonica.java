package agendatelefonica;

import java.util.Scanner;

public class AgendaTelefonica {

    static Contactos misContactos[] = new Contactos[15];
    static int contador = 0;

    public static void main(String[] args) {
        int op = 0;
        Scanner teclado = new Scanner(System.in);
        while (op != 4) {

            System.out.println("---------------------Menu principal---------------------");
            System.out.println("1. Guardar Contacto");
            System.out.println("2. Ver Contactos");
            System.out.println("3. Buscar Contacto");
            System.out.println("4. Salir");
            System.out.println("Ingrese el numero de opcion");
            op = teclado.nextInt();
            if (op == 1) {
                GuardarContacto();
            } else if (op == 2) {
                System.out.println("--Los datos del profesor son--");
                verTodos();
            } else if (op == 3) {
                System.out.println("--Buscar Contacto--");
                System.out.println("Ingrese el nombre: ");
                Scanner entrada = new Scanner(System.in);
                String nombre = entrada.nextLine();
                System.out.println(verContacto(nombre));
            } else if (op == 4) {
                System.out.println("--Programa finalizado--");
                break;
            } else {
                System.out.println("Opcion incorrecta");
            }
        }
    }

    static public void verTodos() {
        for (int i = 0; i < contador; i++) {
            System.out.println("nombre: " + misContactos[i].verNombre());
            System.out.println("materia: " + misContactos[i].verNumero());
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
        }
    }

    static public String verContacto(String nombre) {
        int posicion = -1;
        for (int i = 0; i < 15; i++) {
            if (misContactos[i].verNombre().equals(nombre) && misContactos) {
                posicion = i;
                break;
            }
        }
        if (posicion != -1) {
            return "Materia " + misContactos[posicion].verNumero();
        } else {
            return "Profesor no encontrado";
        }
    }
}

