package machine;

import java.util.Scanner;

enum MachineState {
    CHOOSING_ACTION,
    CHOOSING_COFFEE,
    FILL,
    SHOOT_DOWN
}

enum Resource {
    WATER, MILK, COFFEE_BEANS, CUPS
}

public class CoffeeMachine {
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        while (cm.state != MachineState.SHOOT_DOWN) {
            System.out.print(cm.userInputs(in.nextLine()));
        }
    }

    MachineState state = MachineState.CHOOSING_ACTION;
    private Resource currentInputResource = null;

    private int waterAmount = 400;
    private int milkAmount = 540;
    private int coffeeBeansAmount = 120;
    private int disposableCups = 9;
    private int moneyAmount = 550;

    private final String chooseActionPrompt = "\nWrite action (buy, fill, take, remaining, exit):\n> ";

    public String userInputs(String inputLine) {
        String result = null;
        switch (state) {
            case CHOOSING_ACTION:
                result = action(inputLine);
                break;
            case CHOOSING_COFFEE:
                result = chooseCoffee(inputLine) + chooseActionPrompt;
                state = MachineState.CHOOSING_ACTION;
                break;
            case FILL:
                result = fill(inputLine);
                break;
        }
        return result;
    }

    private String action(String line) {
        switch (line) {
            case "buy":
                return buy();
            case "fill":
                state = MachineState.FILL;
                return fill(line);
            case "take":
                return take();
            case "remaining":
                return remaining();
            case "exit":
                state = MachineState.SHOOT_DOWN;
                return "";
            default:
                return "";
        }
    }

    private String remaining() {
        return "\nThe coffee machine has:\n"
                + waterAmount + " of water\n"
                + milkAmount + " of milk\n"
                + coffeeBeansAmount + " of coffee beans\n"
                + disposableCups + " of disposable cups\n"
                + "$" + moneyAmount + " of money\n\n";
    }

    private String buy() {
        state = MachineState.CHOOSING_COFFEE;
        return "\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:\n> ";
    }

    private String chooseCoffee(String choose) {
        switch (choose) {
            case "1":
                return coffeeRequest(250, 0, 16, 4);
            case "2":
                return coffeeRequest(350, 75, 20, 7);
            case "3":
                return coffeeRequest(200, 100, 12, 6);
            default:
                return "";
        }
    }

    private String coffeeRequest(int water, int milk, int coffeeBeans, int money) {
        String sorryPrefix = "Sorry, not enough ";
        if (waterAmount < water) {
            return sorryPrefix + "water!";
        } else if (milkAmount < milk) {
            return sorryPrefix + "milk!";
        } else if (coffeeBeansAmount < coffeeBeans) {
            return sorryPrefix + "coffee beans!";
        } else if (disposableCups == 0) {
            return sorryPrefix + "disposable cups!";
        } else {
            waterAmount -= water;
            milkAmount -= milk;
            coffeeBeansAmount -= coffeeBeans;
            disposableCups--;
            moneyAmount += money;
            return "I have enough resources, making you a coffee!";
        }
    }

    private String fill(String input) {
        if (currentInputResource == null) {
            currentInputResource = Resource.WATER;
            return "\nWrite how many ml of water do you want to add:\n> ";
        } else {
            switch (currentInputResource) {
                case WATER:
                    waterAmount += Integer.parseInt(input);
                    currentInputResource = Resource.MILK;
                    return "Write how many ml of milk do you want to add:\n> ";
                case MILK:
                    milkAmount += Integer.parseInt(input);
                    currentInputResource = Resource.COFFEE_BEANS;
                    return "Write how many grams of coffee beans do you want to add:\n> ";
                case COFFEE_BEANS:
                    coffeeBeansAmount += Integer.parseInt(input);
                    currentInputResource = Resource.CUPS;
                    return "Write how many disposable cups of coffee do you want to add:\n> ";
                case CUPS:
                    disposableCups += Integer.parseInt(input);
                    currentInputResource = null;
                    state = MachineState.CHOOSING_ACTION;
                    return chooseActionPrompt;
                default:
                    return "";
            }
        }
    }

    private String take() {
        moneyAmount = 0;
        return "I gave you $" + moneyAmount + "\n";
    }
}
