package assignment_ds;

import java.util.Scanner;

/**
 *
 * @author User
 */


public class MainPanel {

    public static void main(String[] args){

        // Initialization of class
        WuKingdomHierarchy kingdom = new WuKingdomHierarchy();
        SoldierArrangement generals = new SoldierArrangement();
        BorrowingArrow arrow = new BorrowingArrow();
        EncryptedText secret = new EncryptedText();
        FoodHarvesting food = new FoodHarvesting();
        EngagingCaoCao caoCao = new EngagingCaoCao();
        AttackSimulation attack = new AttackSimulation();
        RedCliffOnFire redCliff = new RedCliffOnFire();

        System.out.println("Welcome to the Wu Kingdom War Strategy System!\n");
        Scanner select = new Scanner(System.in);
        while (true) {
            System.out.println("=".repeat(40));
            System.out.printf("%-15s%-24s%s%n", "|", "Main Panel", "|");
            System.out.println("=".repeat(40));
            System.out.printf("%-39s%s%n", "| 1 Wu Kingdom's Hierarchy", "|");
            System.out.printf("%-39s%s%n", "| 2 Soldier's Arrangement", "|");
            System.out.printf("%-39s%s%n", "| 3 Borrowing Arrows with Straw Boats", "|");
            System.out.printf("%-39s%s%n", "| 4 Enemy Fortress Attack Simulation", "|");
            System.out.printf("%-39s%s%n", "| 5 Food Harvesting", "|");
            System.out.printf("%-39s%s%n", "| 6 Encrypted Text", "|");
            System.out.printf("%-39s%s%n", "| 7 Red Cliff on Fire", "|");
            System.out.printf("%-39s%s%n", "| 8 Engaging Cao Cao at Hua Rong Road", "|");
            System.out.printf("%-39s%s%n", "| -1 Exit Interface", "|");
            System.out.println("=".repeat(40));

            System.out.print("\nPlease select: ");
            String selection = select.nextLine();
            System.out.println("\n--------------------------------------------------------\n");
            if (selection.equals("1")) {
                kingdom.wkhSelection();
            } else if (selection.equals("2")) {
                generals.soldierArrangementSelection();
            } else if (selection.equals("3")) {
                arrow.borrowingArrowSelection();
            }else if (selection.equals("4")) {
                attack.attackSelection();
            } else if (selection.equals("5")) {
                food.foodHarvestingSelection();
            } else if (selection.equals("6")) {
                secret.encryptedTextSelection();
            } else if (selection.equals("7")) {
                redCliff.redCliffOnFireSelection();
            } else if (selection.equals("8")) {
                caoCao.engagingCCSelection();
            } else if (selection.equals("-1")) {
                break;
            } else {
                System.out.println("Unrecognized selection. Please key in again.\n");
            }
        }
        System.out.println("Thanks for visiting Wu Kingdom War Strategy System\n");

    }

}
