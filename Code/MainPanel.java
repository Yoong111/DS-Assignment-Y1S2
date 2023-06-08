/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_ds;

import java.util.Scanner;

/**
 *
 * @author User
 */


public class MainPanel {

    public static void main(String[] args) throws Exception {

        // Initialization of class
        WuKingdomHierarchy kingdom = new WuKingdomHierarchy();
        SoldierArrangement generals = new SoldierArrangement();
        BorrowingArrow arrow = new BorrowingArrow();
        EncryptedText secret = new EncryptedText();
        FoodHarvesting food = new FoodHarvesting();
        EngagingCaoCao caoCao = new EngagingCaoCao();
        AttackSimulationExtra attackExtra  = new AttackSimulationExtra();

        System.out.println("Welcome to the Wu Kingdom War Strategy System");
        Scanner select = new Scanner(System.in);
        while (true) {
            System.out.println("\n1 Wu Kingdom's Hierarchy");
            System.out.println("2 Soldier's Arrangement");
            System.out.println("3 Borrowing Arrows with Straw Boats");
            System.out.println("4 Enemy Fortress Attack Simulation");
            System.out.println("5 Food Harvesting");
            System.out.println("6 Encrypted Text");
            System.out.println("7 Red Cliff on Fire");
            System.out.println("8 Engaging Cao Cao at Hua Rong Road");
            System.out.println("9 Enemy Fortress Attack Simulation Extra");

            System.out.println("-1 Exit Interface");
            System.out.print("\nPlease select: ");
            String selection = select.nextLine();
            System.out.println("\n--------------------------------------------------------\n");
            if (selection.equals("1")) {
                kingdom.wkhSelection();
            } else if (selection.equals("2")) {
                generals.soldierArrangementSelection();
            } else if (selection.equals("3")) {
                arrow.borrowingArrowSelection();
            } else if (selection.equals("5")) {
                food.foodHarvestingSelection();
            } else if (selection.equals("6")) {
                secret.encryptedTextSelection();
            } else if (selection.equals("8")) {
                caoCao.engagingCCSelection();
            } else if (selection.equals("9")) {
                attackExtra.attackSelection();
            } else if (selection.equals("-1")) {
                break;
            } else {
                System.out.println("Unrecognized selection. Please key in again.\n");
            }
        }
        System.out.println("Thanks for visiting Wu Kingdom War Strategy System.\n");

    }

}
