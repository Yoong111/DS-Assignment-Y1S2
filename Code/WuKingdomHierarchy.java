/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class WuKingdomHierarchy {

    WuKingdomHierarchy a;
    TreeNode root;
    String FILENAME = "Characters.txt";

    //Main panel must implement this method to access all the methods in this class
    public void WKHselection() {

        //Initialization of WHK
        a = new WuKingdomHierarchy();
        root = getHierarchy_Tree();

        while (true) {
            Scanner option = new Scanner(System.in);
            System.out.println("1 Display Tree");
            System.out.println("2 Display Member's Ability Table");
            System.out.println("3 Add General");
            System.out.println("4 Remove General");
            System.out.println("-1 Exit Page");
            System.out.print("\nPlease Select: ");
            int opt = option.nextInt();
            option.nextLine(); //avoid Scanner skipping next line problem
            System.out.println("\n--------------------------------------------------------\n");

            switch (opt) {
                //display 2D tree
                case 1:
                    System.out.println("<<<< Wu Kingdom Hierarchy >>>>\n");
                    a.printHierarchy_Tree(root, "", true);
                    System.out.println("Enter to go back to Wu Kingdom Hierarchy Main page");
                    option.nextLine();
                    break;

                //display Member Info
                case 2:
                    System.out.print("Enter Member Name: ");
                    String member = option.nextLine();
                    displayCharacterBio(root, member);
                    System.out.println("Enter to go back to Wu Kingdom Hierarchy Main page");
                    option.nextLine();
                    break;

                //Add General
                case 3:
                    a.addGeneral(root);
                    System.out.println("Enter to go back to Wu Kingdom Hierarchy Main page");
                    option.nextLine();
                    break;

                //Remove General 
                case 4:
                    a.removeGeneral(root);
                    System.out.println("Enter to go back to Wu Kingdom Hierarchy Main page");
                    option.nextLine();
                    break;

                //Exit interface
                case -1:
                    return;

                default:
                    System.out.println("Unrecognized selection. Please key in again.");
            }

        }
    }

    public TreeNode getHierarchy_Tree() {
        ArrayList<TreeNode> generals = new ArrayList<>();
        TreeNode sunQuan = new TreeNode("", "", "", 0, 0, 0, 0, 0);
        TreeNode chiefOfManagement = new TreeNode("", "", "", 0, 0, 0, 0, 0);
        TreeNode chiefOfMilitary = new TreeNode("", "", "", 0, 0, 0, 0, 0);

        try {
            Scanner read = new Scanner(new FileInputStream(FILENAME));
            String name = "", position = "", armyType = "";
            int strength = 0, leadership = 0, intelligence = 0, politic = 0, hitPoint = 0;
            boolean isGeneral = true;

            while (read.hasNextLine()) {
                String line = read.nextLine().trim();

                if (line.isEmpty()) {
                    continue;
                }

                if (!line.isEmpty()) {
                    String[] parts = line.split(": ");
                    String key = parts[0];
                    String value = parts[1];

                    switch (key) {
                        case "Name":
                            name = value;
                            if (value.equals("Sun Quan") || value.equals("Zhang Zhao") || value.equals("Zhou Yu")) {
                                isGeneral = false;
                            } else {
                                isGeneral = true;
                            }
                            break;
                        case "Position":
                            position = value;
                            break;
                        case "Army Type":
                            armyType = value;
                            break;
                        case "Strength":
                            strength = Integer.parseInt(value);
                            break;
                        case "Leadership":
                            leadership = Integer.parseInt(value);
                            break;
                        case "Intelligence":
                            intelligence = Integer.parseInt(value);
                            break;
                        case "Politic":
                            politic = Integer.parseInt(value);
                            break;
                        case "Hit Point":
                            hitPoint = Integer.parseInt(value);

                            //After reaching the last attribute"Hit Point" of the character, store the character into tree node
                            if (isGeneral) {
                                TreeNode general = new TreeNode(name, position, armyType, strength, leadership, intelligence, politic, hitPoint);
                                generals.add(general);
                            } else {
                                switch (name) {
                                    case "Sun Quan":
                                        sunQuan = new TreeNode(name, position, armyType, strength, leadership, intelligence, politic, hitPoint);
                                        break;
                                    case "Zhang Zhao":
                                        chiefOfManagement = new TreeNode(name, position, armyType, strength, leadership, intelligence, politic, hitPoint);
                                        break;
                                    case "Zhou Yu":
                                        chiefOfMilitary = new TreeNode(name, position, armyType, strength, leadership, intelligence, politic, hitPoint);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            break;
                        default:
                            System.out.println("Invalid key");
                            break;
                    }
                }
            }

            read.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        sunQuan.addChild(chiefOfManagement);
        sunQuan.addChild(chiefOfMilitary);

        for (TreeNode general : generals) {
            if (general.getIntelligence() > general.getStrength()) {
                chiefOfManagement.addChild(general);
            } else {
                chiefOfMilitary.addChild(general);
            }
        }

        return sunQuan;
    }

    //This method will be used in "removeGeneral" method
    public void removeGeneral_InTree(ArrayList<TreeNode> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            if (name.equalsIgnoreCase(node.getName())) {
                list.remove(node);
                break;
            }
        }
    }

    //Remove General
    public void removeGeneral(TreeNode root) {

        Scanner sc = new Scanner(System.in);
        int strength, intelligence;
        String[] rem;

        while (true) {

            try {
                //Enter the general to be removed
                System.out.println("Please enter the general to be removed in this format");
                System.out.print("[name,strength,intelligence] or 0 to quit: ");
                String remGeneral = sc.nextLine();

                //to exit interface
                if (remGeneral.equalsIgnoreCase("0")) {
                    return;
                }

                rem = remGeneral.split(",");

                strength = Integer.parseInt(rem[1]);
                intelligence = Integer.parseInt(rem[2]);

                break;

            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Wrong input format");
            } catch (NumberFormatException ex) {
                System.out.println("Wrong input format");
            }

        }

        //to find the which divisoin is that general in
        if (strength >= intelligence) {
            ArrayList<TreeNode> childrenList = root.getChild(1).getChildrenList();

            //remove that general in tree
            removeGeneral_InTree(childrenList, rem[0]);

            //save the arraylist
            root.getChild(1).setChildrenList(childrenList);
        } else if (strength < intelligence) {
            ArrayList<TreeNode> childrenList = root.getChild(0).getChildrenList();

            //remove the general in tree
            removeGeneral_InTree(childrenList, rem[0]);

            //save the array list
            root.getChild(0).setChildrenList(childrenList);
        }

        //Remove general in Characters.txt file
        try {
            File inputFile = new File(FILENAME);
            File tempFile = new File("temp.txt");

            BufferedReader read = new BufferedReader(new FileReader(inputFile));
            BufferedWriter write = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            boolean isRemovingGeneral = false;

            while ((currentLine = read.readLine()) != null) {

                // If the line contains the name of the general to be removed, start removing the block of text
                if (currentLine.equals("Name: " + rem[0])) {
                    isRemovingGeneral = true;
                    continue;
                }

                // If we are currently removing the block of text, skip over this line
                if (isRemovingGeneral) {
                    // If the line contains the end of the block of text, stop removing the block of text
                    if (currentLine.contains("Hit Point")) {
                        isRemovingGeneral = false;
                    }
                    continue;
                }

                write.write(currentLine + System.getProperty("line.separator"));

            }

            write.close();
            read.close();

            //Delete the original file
            if (!inputFile.delete()) {
                System.out.println("Failed to delete the original file.");
                return;
            }

            //Rename the temp file to the original file
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Failed to rename the temp file.");
                return;
            }

            System.out.println("General removed successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while removing the general bio.");
            e.printStackTrace();
        }

    }

    //Add general
    public void addGeneral(TreeNode root) {

        Scanner sc = new Scanner(System.in);
        String[] temp;
        String newGeneral;
        TreeNode newGeneralNode;

        while (true) {
            try {
                //Enter the new general you want to add
                System.out.println("Please enter the new general's details in this format: ");
                System.out.println("[name,position,army type,strength,leadership,intelligence,politic,hit point] or 0 to exit");
                newGeneral = sc.nextLine();

                //to exit interface
                if (newGeneral.equalsIgnoreCase("0")) {
                    return;
                }

                temp = newGeneral.split(",");

                newGeneralNode = new TreeNode(temp);
                break;

            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Wrong Input Format");
            } catch (NumberFormatException ex) {
                System.out.println("Wrong Input Format");
            }
        }

        //Assign to the respective division
        int strength = Integer.parseInt(temp[3]);
        int intelligence = Integer.parseInt(temp[5]);

        //if strength>=intelligence Enter millitary
        if (strength >= intelligence) {
            root.getChild(1).addChild(newGeneralNode);
        } //if intelligence >strength Enter Management
        else if (strength < intelligence) {
            root.getChild(0).addChild(newGeneralNode);
        }

        //Write the txt file
        try {
            //Open file in append mode
            FileWriter writer = new FileWriter(FILENAME, true);

            //Write the bio of the new general in the file
            writer.write("\n\nName: " + temp[0] + "\n");
            writer.write("Position: " + temp[1] + "\n");
            writer.write("Army Type: " + temp[2] + "\n");
            writer.write("Strength: " + temp[3] + "\n");
            writer.write("Leadership: " + temp[4] + "\n");
            writer.write("Intelligence: " + temp[5] + "\n");
            writer.write("Politic: " + temp[6] + "\n");
            writer.write("Hit Point: " + temp[7]);

            writer.close();
        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    // print tree
    public void printHierarchy_Tree(TreeNode root, String prefix, boolean isTail) {

        System.out.println(prefix + (isTail ? "└── " : "├── ") + root.getPosition() + "(" + root.getName() + "[" + root.getArmyType() + "])\n");
        ArrayList<TreeNode> children = root.getChildrenList();

        //for loop will be skipped, if the node doesn't have children
        //iterate and print until the last two children
        for (int i = 0; i < children.size() - 1; i++) {
            //isTail in ternary operator is "isTail" of previous node
            printHierarchy_Tree(children.get(i), prefix + (isTail ? "    " : "│   "), false);
        }

        // if statement will be skipped, if the node doesn't have children
        // print last children of a node
        if (children.size() > 0) {
            //isTail in ternary operator is "isTail" of previous node
            printHierarchy_Tree(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true);
        }

    }

    //to display bio of the character
    public static void displayBio(TreeNode i) {
        //get the specific character
        TreeNode character = i;

        System.out.println("------------------------------------------------");
        System.out.println("Name: " + character.getName());
        System.out.println("Position: " + character.getPosition());
        System.out.println("Army Type: " + character.getArmyType());
        System.out.println("\nAbility Table:");
        System.out.println("Strength: " + character.getStrength());
        System.out.println("Leadership: " + character.getLeadership());
        System.out.println("Intelligence: " + character.getLeadership());
        System.out.println("Politic: " + character.getPolitic());
        System.out.println("Hit Point: " + character.getHitPoint());
        System.out.println("------------------------------------------------\n");

    }

    public void displayCharacterBio(TreeNode root, String name) {
        //if you chosed the emperor
        if (name.equalsIgnoreCase("Sun Quan")) {
            displayBio(root);
        } //if you chosed the chiefs
        else if (name.equalsIgnoreCase("Zhang Zhao")) {
            displayBio(root.getChild(0));
        } else if (name.equalsIgnoreCase("Zhou Yu")) {
            displayBio(root.getChild(1));
        } //if you choose general 
        else {
            for (int i = 0; i < root.getChildSize(); i++) {
                TreeNode temp = root.getChild(i);
                for (int j = 0; j < temp.getChildSize(); j++) {
                    TreeNode tempL2 = temp.getChild(j);
                    if (tempL2.getName().equalsIgnoreCase(name)) {
                        displayBio(tempL2);
                        return;
                    }
                }

                if (i == root.getChildSize() - 1) {
                    System.out.println("Person Not Identified");
                }
            }
        }
    }

}
