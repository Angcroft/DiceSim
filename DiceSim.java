import java.util.Random;
import java.util.Scanner;

class Dice {
    private int numfaces;

    public Dice(int numfaces) {
        this.numfaces = numfaces;
    }

    public int lanzarDado() {
        Random random = new Random();
        return random.nextInt(numfaces) + 1;
    }

    public void setNumfaces(int numfaces) {
        if (numfaces > 0) {
            this.numfaces = numfaces;
        } else {
            System.out.println("The number of faces has to be more than 0.");
        }
    }

    public int getNumfaces() {
        return numfaces;
    }
}

public class DiceSim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dice dado = new Dice(6); // Default number of faces
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- DiceSim ---");
            System.out.println("1. Roll dice");
            System.out.println("2. Edit dice");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    int resultado = dado.lanzarDado();
                    System.out.println("You rolled the dice and got: " + resultado);
                    break;
                case 2:
                    System.out.print("Input the number of faces the dice has: ");
                    int numCaras = scanner.nextInt();
                    dado.setNumfaces(numCaras);
                    System.out.println("The dice has " + dado.getNumfaces() + " faces.");
                    break;
                case 3:
                    continuar = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Not valid option. Please try again");
            }
        }

        scanner.close();
    }
}