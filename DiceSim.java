import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Dice {
    private int numfaces;

    public Dice(int numfaces) {
        this.numfaces = numfaces;
    }

    public int rollDice() {
        Random random = new Random();
        return random.nextInt(numfaces) + 1;
    }

    public List<Integer> numRoll(int numberDice) {
        List<Integer> numDices = new ArrayList<>();
        
        for (int i = 0; i < numberDice; i++) {
            numDices.add(rollDice());
        }

        return numDices;
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
        Dice dice = new Dice(6); // Default number of faces
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\n--- DiceSim ---");
            System.out.println("1. Roll dice");
            System.out.println("2. Edit dice");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("How many dice do you want to roll? ");
                    int numberDice = scanner.nextInt();
                    List<Integer> results = dice.numRoll(numberDice);
                    System.out.println("You rolled the dice and got: " + results);
                    break;
                case 2:
                    System.out.print("Input the number of faces the dice has: ");
                    int numfaces = scanner.nextInt();
                    dice.setNumfaces(numfaces);
                    System.out.println("The dice has " + dice.getNumfaces() + " faces.");
                    break;
                case 3:
                    keepGoing = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Not valid option. Please try again");
            }
        }

        scanner.close();
    }
}