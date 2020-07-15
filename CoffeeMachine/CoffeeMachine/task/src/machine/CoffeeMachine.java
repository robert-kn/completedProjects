package machine;

import java.util.Scanner;
import java.util.Arrays;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;
    
    enum machineState {
        buy, fill, take, remaining, exit
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String answer = sc.next();
        System.out.println();
        while (!answer.equals("exit")) {
            display(answer);
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            answer = sc.next();
            System.out.println();
        }
        
    }
    
    public static void display(String answer) {
        
        if (answer.equals(machineState.take.name())) {
            take();
        } else if (answer.equals(machineState.fill.name())) {
            fill();
        } else if (answer.equals(machineState.buy.name())) {
            buy();
        } else if (answer.equals(machineState.remaining.name())) {
            remaining();
        }
            
    }

    
    
    public static void take() {
        System.out.printf("I gave you $%d \n", money);
        CoffeeMachine.money = 0;
        System.out.println();
    }
    
    
    public static void fill() {
        int moreWater, moreMilk, moreBeans, moreCups;
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        moreWater = sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        moreMilk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        moreBeans = sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        moreCups = sc.nextInt();
        
        CoffeeMachine.water += moreWater;
        CoffeeMachine.milk += moreMilk;
        CoffeeMachine.beans += moreBeans;
        CoffeeMachine.cups += moreCups;
    }
    
    
     public static void buy() {
        
        if (CoffeeMachine.cups < 1) {
            System.out.println("Sorry, not enough cups!\n");
        } else {
            int answer;
            String goBack;
            Scanner sc = new Scanner(System.in);
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            if (sc.hasNext("back")) {
                goBack = sc.next();
            } else {
                answer = sc.nextInt();
                
                switch (answer) {
                    case 1:
                        espresso();
                        break;
                    case 2:
                        latte();
                        break;
                    case 3:
                        cappuccino();
                        break;
                    default:
                        break;
                }
            } 
        }   
    }
    
    
    public static void remaining() {
        System.out.println();
        System.out.printf("The coffee machine has:\n%d of water\n%d of milk\n%d of coffee beans\n%d of disposable cups\n%d of money\n"
        , water, milk, beans, cups, money);
        System.out.println();
    }
    
    public static void canMake(int num) {
        
        if (num == 1) {
            System.out.println("I have enough resources, making you a coffee!\n");
        } 
    }
    
    public static void canMake(String answer) {
        if (answer.equals("espresso")) {
            if (CoffeeMachine.water < 250) {
                System.out.println("Sorry, not enough water!\n");
            } else {
                System.out.println("Sorry, not enough beans!\n");
            }
        }
        
        else if (answer.equals("latte")) {
            if (CoffeeMachine.water < 350) {
                System.out.println("Sorry, not enough water!\n");
            } else if (CoffeeMachine.beans < 20) {
                System.out.println("Sorry, not enough beans!\n");
            } else {
                System.out.println("Sorry, not enough milk!\n");
            }
        }
        
        else {
            if (CoffeeMachine.water < 200) {
                System.out.println("Sorry, not enough water!\n");
            } else if (CoffeeMachine.beans < 12) {
                System.out.println("Sorry, not enough beans!\n");
            } else {
                System.out.println("Sorry, not enough milk!\n");
            }
        }
    }
    
    
    public static void espresso() {
        if (CoffeeMachine.water >= 250 && CoffeeMachine.beans >= 16) {
            CoffeeMachine.money += 4;
            CoffeeMachine.water -= 250;
            CoffeeMachine.beans -= 16;
            CoffeeMachine.cups -= 1;
            canMake(1);
        } else {
            canMake("espresso");
        }
        
    
    }
    
    public static void latte() {
        
        if (CoffeeMachine.water >= 350 && CoffeeMachine.beans >= 20 && CoffeeMachine.milk >= 75) {
            CoffeeMachine.money += 7;
            CoffeeMachine.water -= 350;
            CoffeeMachine.beans -= 20;
            CoffeeMachine.milk -= 75;
            CoffeeMachine.cups -= 1;
            canMake(1);
        } else {
            canMake("latte");
        }
    }
    
    public static void cappuccino() {
        if (CoffeeMachine.water >= 200 && CoffeeMachine.beans >= 12 && CoffeeMachine.milk >= 100) {
            CoffeeMachine.money += 6;
            CoffeeMachine.water -= 200;
            CoffeeMachine.beans -= 12;
            CoffeeMachine.milk -= 100;
            CoffeeMachine.cups -= 1;
            canMake(1);
        } else {
            canMake("cappuccino");
        }
    }
    
    
}
