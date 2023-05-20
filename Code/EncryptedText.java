/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_ds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author h3nd8
 */
public class EncryptedText { 
    
    private int CHARMAXINT = 122; // maximum ASCII value for char
    private int CHARMININT = 97; // minimum ASCII value for char
    private int DIFFERENCEOFCASE = 32 ; // difference between lowercase and uppercase ASCII value
    
    public void encryptedTextSelection() {
        while(true) {
            Scanner input = new Scanner(System.in);
            
            System.out.println("1 [Normal version] Encrypted Text");
            System.out.println("    ~ Decrypt the secret letter from Sun Quan");
            System.out.println("    ~ Uses Caeser Cipher\n");

            System.out.println("2 [Advanced version] Text Converter with More Secured Encryption");
            System.out.println("    ~ Encryption and decryption implementation");
            System.out.println("    ~ Custom cipher algorithm\n");
            
            System.out.println("-1 Exit page");
            System.out.print("\nPlease Select: ");
            String options = input.nextLine();
            System.out.println("\n--------------------------------------------------------\n");
            if (options.matches("\\d")) {
                switch(options) {
                    case "1" : {
                        decryptText();
                    } break;
                    case "2" : {
                        customAlgorithm();
                    } break;
                    default : System.out.println("Invalid input : " + options + ", allowed inputs : [1,2,-1]");
                } 
            } else if (options.equals("-1")){
                return;
            } else {
                System.out.println("Invalid input : " + options + ", allowed inputs : [1,2,-1]");
                System.out.println("\n--------------------------------------------------------\n");
            }  
        }
    }
    
// Text : ^hkcpzl$^jhv$^jhv$av$bzl$^aol$^johpu$^zayhalnlt,$(ojpod)$pz$av$johpu$opz$(zwpozlsaahi)$dpao$zayvun$pyvu$johpuz. 
// Shift : 7
    
    private void decryptText() {
        while (true) {
            // receiving inputs
            Scanner input = new Scanner(System.in); 
            System.out.println("\nHelp Pang Tong decipher the letter sent by Sun Quan.");
            System.out.print("\nText : ");
            String text = input.nextLine();
            System.out.print("\nShift : ");
            String shift = input.nextLine();
            System.out.println("\n--------------------------------------------------------\n");
            
            if (shift.matches("\\d+")) { // if shift is an Integer value
                
                // creating empty variables
                String decryptedText = "";
                String invertText = "";
                char symbol = ' '; 
                
                for (int i = 0 ; i < text.length() ; i++) {
                    
                    char chr = text.charAt(i); // get single charater from the cipher
                    
                    if (chr >= 97 && chr <= CHARMAXINT || chr == ')') { // only accepts lowercase letters and ')'
                        if (chr == ')') symbol = chr; // set symbol as ')' 
                        
                        int intOfChr = chr - Integer.parseInt(shift); // using shift value to get the original char position in ASCII
                        int newIntOfChr = overflow(intOfChr); // parsing the original value to check for any overflow
                        
                        switch(symbol) {
                            case ')' : { 
                                // if symbol is ')' then invert the text and store the variables with empty string
                                for (int o = invertText.length() - 1 ; o >= 0 ; o--) decryptedText += invertText.charAt(o); 
                                invertText = "";
                                symbol = ' ';
                            } break;
                            case '(' : { 
                                // if symbol is '(' then save all the characters in invertText temporarily until ')' appears
                                invertText += (char) newIntOfChr;
                            } break;
                            case '^' : { 
                                // if symbol is '^' then convert the lowercase ASCII value to uppercase ASCII value by subtracting the difference
                                newIntOfChr -= DIFFERENCEOFCASE;
                                symbol = ' '; 
                            } // no break statement for this case so it can utilise the default as well without rewriting the code
                            default : decryptedText += (char) newIntOfChr;
                        }
                    } else if (chr == '$') {
                        decryptedText += ' ';
                    } else if (chr == '^') {
                        symbol = chr;
                    } else if (chr == '(') {
                        symbol = chr;
                    } else {
                        decryptedText += chr;
                    }
                }
                System.out.println("Secret from Sun Quan : " + decryptedText);
                System.out.println("\n--------------------------------------------------------\n");
                return;
            } else {
                System.out.println("\n## Error ##\nShift has to be an integer value");
                System.out.println("\n--------------------------------------------------------\n");
            }
        }
    }
  
    // overflow() maintains the ASCII value in the range of lowercase letters
    private int overflow (int n) {
        if (n < CHARMININT) { 
            n = CHARMAXINT - ( (CHARMININT - n ) - 1 ); 
            return overflow(n);
        } else {
            return n;
        }
    }
    
    public void customAlgorithm() {
        while (true) {
            Scanner options = new Scanner(System.in);
            System.out.println("M9k3 y0ur t3xt m0r3 s3cur3 w1th 0ur cu5t0m 9lg0r1thm!\n");
            System.out.println("1 <<< ENCRYPT >>>");
            System.out.println("2 <<< DECRYPT >>>");
            System.out.println("-1 Exit page");
            System.out.print("\nPlease Select: ");
            String selection = options.nextLine();
            System.out.println("\n--------------------------------------------------------\n");
            
            switch(selection) {
                case "1" : {
                    System.out.print("Text : ");
                    encrypt(options.nextLine());
                } break;
                case "2" : {
                    System.out.print("Cipher : ");
                    String cipher = options.nextLine();
                    if (cipher.matches("\\d+")) {
                        System.out.print("Key : ");
                        String key = options.nextLine();
                        System.out.println("\n--------------------------------------------------------\n");
                        try {
                            System.out.println("Text : " + decrypt(cipher, key));
                        } catch (Exception e) {
                            System.out.println("\n## Error ##\nCipher and key are not matching");
                        }
                        System.out.println("\n--------------------------------------------------------\n");
                        System.out.println("press enter to continue...");
                        try {
                            System.in.read();
                        } catch (IOException e) {
                            return;
                        }
                    } else {
                        System.out.println("\n## Error ##\nInvalid cipher");
                    }
                } break;
                case "-1" : return;
                default : System.out.println("Invalid input : " + selection + ", allowed inputs : [1,2,-1]");
            }
            System.out.println("\n--------------------------------------------------------\n");
        }
    }
    
    private void encrypt(String text) {
        // declaring all the Strings
        String key = "";
        String cipher = "";
        String zeroInfo = "";
        String charIntString = "";
        String repeatString = "";
        List<String> cipherInfoMemory = new ArrayList<>();
        
        Random random = new Random();
        int divisor = random.nextInt(550 - 150 + 1) + 150; // getting a random divisor in the range 150 to 550
        int num = random.nextInt(9) + 1; // get a random num between 1 and 9
        key += divisor; // add the divisor value in the key
        int repeat = 0;
        
        for (int i = 0 ; i < text.length() ; i++) charIntString += ((int) text.charAt(i)) + num; // converting the characters to ASCII value and adding the num
        
        while (charIntString.contains("0")) { // remove the zero(s) from the ASCII characters
            zeroInfo += "-" + charIntString.indexOf("0");
            charIntString = charIntString.replaceFirst("0", "-");
        }
        charIntString = charIntString.replaceAll("-", "");
        
        // the loops only runs when there are 5 characters available
        while (charIntString.length() > 5) {
            int bufferInt = Integer.parseInt(charIntString.substring(0, 5)); // get the 5 characters and convert it to Integers
            
            String cipherDouble = String.valueOf((double) bufferInt / (double) divisor); // divide it with the divisor and store the double value
            String cipherInfo = "["  + cipherDouble.indexOf("."); // get the position of the dot and store the index
            cipherDouble = cipherDouble.replace(".", ""); // remove the dot
            cipherInfo += "/" + cipherDouble.length() + "|"; // get the length of the double value and store it
            
            // the below implementation is to reduce the length of cipher info by adding an occurence value (repeat) and save it temporarily in cipherInfoMemory list 
            if (repeatString.equals(cipherInfo)) {
                repeat++;
                cipherInfo = cipherInfo.substring(0, cipherInfo.indexOf("|"));
                cipherInfo = cipherInfo + "|" + repeat + "]";
                cipherInfoMemory.remove(cipherInfoMemory.size() - 1);
                cipherInfoMemory.add(cipherInfo);
            } else {
                repeat = 0;
                repeatString = cipherInfo;
                cipherInfo = cipherInfo.substring(0, cipherInfo.indexOf("|"));
                cipherInfo = cipherInfo + "|" + repeat + "]";
                cipherInfoMemory.add(cipherInfo);
            }
            charIntString = charIntString.substring(5); // remove the first 5 characters which has been encrypted and make the 6th element as the first element
            cipher += cipherDouble; // store the cipher
        }
        for (String cipherInfo : cipherInfoMemory) key += cipherInfo; // saving the cipherInfoMemory in the key 
        key += "&" + num + "{" + charIntString + "}"; // adding the ramaining text in the key if exists
        key += zeroInfo + "-";
        System.out.println("\n--------------------------------------------------------\n");
        System.out.println("Cipher : " + cipher);
        System.out.println("Key : " + key);
        System.out.println("\n## Warning ##\n do not reveal the key to anyone!");
        System.out.println("\n--------------------------------------------------------\n");
        System.out.println("press enter to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            return;
        }
    }
    
    private String decrypt(String cipher, String key) throws Exception{ 
        // declaring the Strings 
        String text = "";
        String intText = "";
        
        String zeroInfo = key.substring(key.indexOf("-"));
        String remainingPiece = key.substring(key.indexOf("{") + 1, key.indexOf("}")); // extract the remaning piece
        int num = Integer.parseInt(key.substring(key.indexOf("&") + 1, key.indexOf("{")));
        int multiplier = Integer.parseInt(key.substring(0, key.indexOf("["))); // extract the divisor and use it as multiplier
        key = key.substring(key.indexOf("["), key.indexOf("&")); // filter the key
        
        while (!key.isEmpty()) {
            
            int position = Integer.parseInt(key.substring(key.indexOf("[") + 1, key.indexOf("/"))); // extract the position of the dot
            int lengthOfCipher = Integer.parseInt(key.substring(key.indexOf("/") + 1, key.indexOf("|"))); // extract the lenght of the double value
            String bufferCipher = cipher.substring(0, lengthOfCipher); // extract the double value
            bufferCipher = bufferCipher.substring(0, position) + "." + bufferCipher.substring(position); // make it double value by adding the dot 
            
            intText += Math.round(Double.parseDouble(bufferCipher) * multiplier); // multipy the double value to convert it back to the original integer value
            cipher = cipher.substring(lengthOfCipher); // remove the cipher that has been decrypted
            
            // the below implementation is to check whether the extract sections of the key is needed in the next iteration or not
            if (key.substring(key.indexOf("|") + 1, key.indexOf("]")).equals("0")) { // if no, remove the used sections
                key = key.substring(key.indexOf("]") + 1);
            } else { // otherwise keep the section but reduce the occurence by 1
                int occurence = Integer.parseInt(key.substring(key.indexOf("|") + 1, key.indexOf("]")));
                key = key.substring(0, key.indexOf("|") + 1) + (occurence - 1) + key.substring(key.indexOf("]"));
            }
        }
        intText += remainingPiece; // add the remaining piece
        while(!zeroInfo.equals("-")) { // add the zero(s) back in the ASCII characters
            zeroInfo = zeroInfo.replaceFirst("-", "");
            int index = Integer.parseInt(zeroInfo.substring(0, zeroInfo.indexOf("-")));
            intText = intText.substring(0, index) + "0" + intText.substring(index);
            zeroInfo = zeroInfo.substring(zeroInfo.indexOf("-"));
        }
        // the below implementation converts ASCII character to plain text and apply the new rule
        while (!intText.isEmpty()) {
            if (intText.charAt(0) == '1') {
                text += (char) (Integer.parseInt(intText.substring(0, 3)) - num);
                intText = intText.substring(3);
            } else {
                text += (char) (Integer.parseInt(intText.substring(0, 2)) - num);
                intText = intText.substring(2);
            }
        }
        return text;
    }
}
