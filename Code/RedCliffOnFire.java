package assignment_ds;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
public class RedCliffOnFire extends Node{

    public static String SAT(String o,int x) {
        char junk = o.charAt(x);
        return Character.toString(junk);
    }//find the string at an index in a string
    public static String SATplus(String o,int x) {
        x--;
        char junk = o.charAt(x);
        return Character.toString(junk);
    }//find the string at an index in a string without a zeroth index
    public static int sint(String t) {
        return Integer.parseInt(t);
    }//change String to int
    public static <E> void sout(E x) {
        System.out.println(x);
    }//println
    public static <E> void sou(E x) {
        System.out.print(x);
    }//print
    public static int count(String X) {
        return X.length();
    }
    public static boolean isint(String t) {
        if(t.equals("0") || t.equals("1") || t.equals("2") || t.equals("3") || t.equals("4") || t.equals("5") || t.equals("6") || t.equals("7") || t.equals("8") || t.equals("9"))
            return true;
        else
            return false;
    }
    public static boolean intSheriff(String H) {
        if(H.length()==0){
            return false;
        }
        if(isint(SAT(H,0))==false){
            return false;
        }
        return true;
    }

    public static String [] gastonintSheriff(String [] array) {
        String [] gaston = new String [0];
        for(int i = 0;i<array.length;i++){
            if(intSheriff(array[i])){
                gaston = add(gaston,array[i]);
            }
        }
        return gaston;
    }


    public static String Ars(String [] gaston) {  //compile array into one string
        String A = "";
        for(int i = 0;i<gaston.length;i++){
            A = A + gaston[i];
        }
        return A;
    }//compile array into one string
    public static String AntiArrayer(String [] gaston) {  //compile array into one string
        String A = "";
        for(int i = 0;i<gaston.length;i++){
            A = A + gaston[i];
        }
        return A;
    }//compile array into one string
    public static String [] Arrayer(String T) {
        String [] tau = new String [T.length()];
        for(int i = 0;i<T.length();i++){
            tau[i]=SAT(T,i);
        }
        return tau;
    }




    public static int Find3(String A,String a) {
        String spoon;
        String fork;
        String [] aye = new String [3];
        String [] bye = new String [3];
        int flint = 1;
        for(int y = 0;y<A.length()-2;y++){
            aye[0] = SAT(A,y);
            aye[1] = SAT(A,y+1);
            aye[2] = SAT(A,y+2);
            spoon = Ars(aye);

            bye[0] = SAT(a,0);
            bye[1] = SAT(a,1);
            bye[2] = SAT(a,2);

            fork = Ars(bye);

            if (fork.equalsIgnoreCase(spoon))
                break;
            else{
                flint++;
            }
        }
        return flint;
    }//locate 3 letter string in bigger string
    public static int Find3locstar(String A,String a) {  //gives number after 3 found
        String spoon;
        String fork;
        String [] aye = new String [3];
        String [] bye = new String [3];
        int flint = 1;
        for(int y = 0;y<A.length()-2;y++){
            aye[0] = SAT(A,y);
            aye[1] = SAT(A,y+1);
            aye[2] = SAT(A,y+2);
            spoon = Ars(aye);

            bye[0] = SAT(a,0);
            bye[1] = SAT(a,1);
            bye[2] = SAT(a,2);

            fork = Ars(bye);

            if (fork.equalsIgnoreCase(spoon))
                break;
            else{
                flint++;
            }
        }
        return flint+3;
    }//locate 3 letter string in bigger string, and gives the address after
    public static String Snatch(String boss,String a,String b) {   //get between a&b | a.length = b.length = 3
        int start = Find3locstar(boss,a)-1;
        int end = Find3(boss,b)-1;
        String oa = "";
        for(int j = start;j<end;j++){
            oa = oa + SAT(boss,j);
        }
        return oa;
    }//Level 3 String Snatcher
    public static String Erase(String S,int x) {
        String [] gaston = new String[S.length()];
        for(int i = 0;i<S.length();i++){
            gaston[i]=SAT(S,i);
        }
        x--;
        gaston[x]="";
        String trost = "";
        for(int i = 0;i<S.length();i++){
            trost = trost + gaston[i];
        }
        return trost;
    }//Erases an element in a String



    public static void pen (String Filename, String Text,boolean append) throws FileNotFoundException{ //writes a text file
        PrintWriter name = new PrintWriter(new FileOutputStream(Filename,append));
        name.println(Text);
        name.close();
    }//Write into txt file
    public static String read (String Filename) throws FileNotFoundException{  //1st ln reader (kinda useless)
        Scanner bruh = new Scanner(new FileInputStream(Filename));
        return bruh.nextLine();
    }//Read 1st line From txt file ()kinda useless
    public static String [] readshelf (String Filename) throws FileNotFoundException, IOException{  //arrays a text file
        BufferedReader bruh = new BufferedReader(new FileReader(Filename));
        BufferedReader breh = new BufferedReader(new FileReader(Filename));
        String line = "notnull";
        int y = -1;
        int k = 0;
        while(line != null){
            k++;
            line = breh.readLine();
        }
        String [] gaston = new String [k-1];
        for(int p = 0;p<k-1;p++){
            y++;
            gaston [y] = bruh.readLine();
            line = gaston [y];
        }
        return gaston;
    }//Arrays a text file line by line
    public static String reader (String Filename) throws FileNotFoundException, IOException{  //Put all text in 1 string
        String Wy = "";
        String [] shelf = readshelf (Filename);
        for (int i = 0;i<shelf.length;i++){
            Wy = Wy + shelf[i];
            Wy = Wy + " ";
        }
        return Wy;
    }//Reads text file int o one string
    public static String [] Desktopreadshelf(String Filename) throws IOException {
        return readshelf("C:\\Users\\aviat\\Desktop\\"+Filename+".txt");
    }




    public static void gastonprinter(Object [] array) {
        for (int i = 0;i<array.length;i++){
            System.out.print(array[i]);
        }
    }//print array
    public static void gastonprinterln(Object [] array) {
        for (int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }

    public static void gastonprinter(Object [][] Matrix) {
        for (int j = 0;j<Matrix.length;j++){
            for (int k = 0;k<Matrix[j].length;k++){
                System.out.print(Matrix[j][k]+" ");
            }
            System.out.println("");
        }
    }
    public static void gastonprinterint(int [][] Matrix) {
        for (int j = 0;j<Matrix.length;j++){
            for (int k = 0;k<Matrix.length;k++){
                System.out.print(Matrix[j][k]+" ");
            }
            System.out.println("");
        }
    }
    public static void gastonprinternospace(Object [][] Matrix) {
        for (int j = 0;j<Matrix.length;j++){
            for (int k = 0;k<Matrix.length;k++){
                System.out.print(Matrix[j][k]);
            }
            System.out.println("");
        }
    }

    public static int [][] gastoninter(String [][] W) {
        int [][] mirror = new int [W.length][W[0].length];
        for (int j = 0;j<W.length;j++){
            for (int k = 0;k<W[j].length;k++){
                mirror[j][k] = sint(W[j][k]);
            }
        }
        return mirror;
    }//Change string array to int
    public static String [][] gastonmultiplexer(String [] T) {
        String [][] Joke = new String[T.length][T[0].length()];
        int s = 0;
        for(int l = 0;l<T.length;l++){
            for(int m = 0;m<T[l].length();m++){
                Joke [l][m] = SAT(T[l],m);
            }
        }
        return Joke;
    }//Matrixize an array

    public static String [] add(String [] Matrix,String addition) {
        String [] mirror = new String [Matrix.length+1];
        for(int i = 0;i<Matrix.length;i++){
            mirror[i] = Matrix[i];
        }
        mirror[Matrix.length] = addition;
        return mirror;
    }
    public static int x2(int x) {
        return x*x;
    }
    public static int Max(int x, int y) {
        if(x>y)
            return x;
        else
            return y;
    }


    public static int [][] man(int [][] gaston) {
        int yend = gaston.length;
        int xend = gaston[0].length;
        int [][] mirror = new int [yend][xend];
        int xmid = xend/2;
        int ymid = yend/2;
        return null;
    } //under construction



    public static void draw(String x) {
        int s = x.length();
        int half = x.length()/2;
        int space = 100 - x.length();
        int halfspace = space/2;
        if(s%2==0){
            sou("|");
            for(int y = 0;y<halfspace;y++){
                sou(" ");
            }
            sou(x);
            for(int y = 0;y<halfspace;y++){
                sou(" ");
            }
            sou("|");
        }
        else{
            sou("| ");
            for(int y = 0;y<halfspace;y++){
                sou(" ");
            }
            sou(x);
            for(int y = 0;y<halfspace;y++){
                sou(" ");
            }
            sou("|");
        }
        System.out.println("");
    }
    public static String take() {
        Scanner keyboard = new Scanner(System.in);
        sou("|");
        String moo = keyboard.nextLine();
        return moo;
    }
    public static void title() {
        System.out.println("+----------------------------------------------------------------------------------------------------+");
        draw("Welcome to the tactician's tablet!");
        draw("Here you should find the tools you need to develop military strategy!");
        draw("This section can be used to count the number of clusters of boats on a map,");
        draw("and helps to find the best coordinates for catapulting fireballs!");
        System.out.println("+----------------------------------------------------------------------------------------------------+");
    }




    public static String [] csvcleaner(String [] T) {
        int spaces = 0;
        for(int i = 0;i<T.length;i++){
            if (T[i].equals(" ")){
                spaces++;
            }
        }
        String [] mirror = new String [T.length-spaces];
        int isupprime = 0;
        for(int i = 0;i<T.length;i++){
            if (T[i].equals(" ")){

            }
            else{
                mirror[isupprime] = T[i];
                isupprime++;
            }
        }
        return mirror;
    }    //remoes space slots in array

    public static String [][] csvcleanervar2(String [] gaston){
        return gastonmultiplexer(csvremove(gaston));
    }//variant 2 comes with it's own multiplexer

    public static String [] csvremove(String [] args) {
        String [] OK = new String [args.length];
        for (int i = 0;i<OK.length;i++){
            OK[i] = AntiArrayer(csvcleaner(Arrayer(args[i])));
        }
        return OK;
    }// removes spaces in each string in array [True csv cleaner]

    public static boolean ifif(String S, String m) {
        boolean c = false;
        int y = 0;
        for(int i = 0;i<S.length();i++){
            if(SAT(S,i).equals(m)){
                c = true;
                y = i;
                break;
            }else
                c = false;
        }
        if(c == true){
            if (SAT(S,y+1).equals("\\")){
                return true;
            }
        }
        return false;
    }
    public static String Replace(String text,String what,String with) {
        String mirror = "";
        for(int i = 0;i<text.length();i++){
            if(SAT(text,i).equals(what)==false){
                mirror = mirror + SAT(text,i);
            }else{
                mirror = mirror + with;
            }
        }
        return mirror;
    }
    public static String link(String link) {
        String S = link;
        S = Replace(link,"\"","");

        if(ifif(link,"\\")){

        }else{
            S = Replace(S,"\\","\\\\");
        }
        return S;
    }



    public static Object [] amp(Object [] pot) {
        Object [] mirror = new Object [pot.length + 10];
        for(int i = 0;i<pot.length;i++){
            mirror[i]=pot[i];
        }
        return mirror;
    } //array expansion

    public static Ranks ClusterBucket(Node node) {
        Ranks Q = new Ranks(node);
        Node frost = head;
        while(frost==null==false){
            if(frost.bit == node.bit){
                Q.addLast(frost);
            }
            frost = frost.next;
        }
        return Q;
    }//New algorithm tool. Takes a node and returns the cluster surrounding it.


    public static Node Wormhole(int [][] gaston) {

        Node tau = new Node(gaston[0][0],null,null);
        head = tail = tau;

        End = gaston[0].length;

        for(int j = 0;j<gaston.length;j++){
            for(int k = 0;k<gaston[j].length;k++){
                if(j + k == 0 == false){
                    tau.add(gaston[j][k]);
                }
            }
        }
        return tau;
    } //returns head Node

    public static Node Wormhole(String [] graston) {
        int [][] gaston = gastoninter(gastonmultiplexer(graston));
        Node tau = new Node(gaston[0][0],null,null);
        head = tail = tau;

        End = gaston[0].length;

        for(int j = 0;j<gaston.length;j++){
            for(int k = 0;k<gaston[j].length;k++){
                if(j + k == 0 == false){
                    tau.add(gaston[j][k]);
                }
            }
        }
        return tau;
    } //returns head Node


    public static void OldRedCliffOnFireSelection() {
        title();
        draw("First, you need to input a matrix.");
        draw("Would you like to input a text file, or use line by line input? [Choose option 1 or 2(-1 to exit)]");
        Scanner keypad = new Scanner(System.in);
        Scanner keyword = new Scanner(System.in);
        for(;;){
            String choice = keypad.nextLine();
            if(choice.equals("1")){
                draw("Please input the directory:");
                draw("PS. Please end the text file on the last line");
                String link = link(keyword.nextLine());
                int Σ = 0;
                Node A = null;
                try {
                    A = Wormhole(gastoninter(gastonmultiplexer(csvremove(readshelf(link)))));
                } catch (IOException ex) {
                    Logger.getLogger(RedCliffOnFire.class.getName()).log(Level.SEVERE, null, ex);
                }
                int x = 2;
                while(A.fetch()==null==false){
                    A.NewCustomClusterAlgorithm(A.fetch(),x);
                    Σ++;
                    x++;
                }
                A.vendMatrix();
                draw("There are "+Integer.toString(Σ)+" clusters in this map, so we need "+Integer.toString(Σ)+" fireballs");
                draw("Optimum coordinates:");
                Node click = A;
                int  count = 0;
                while (click != null){
                    count = Max(count,click.bit);
                    click = click.next;
                }
                for(int i = 2;i<=count;i++){
                    Ranks star = Nodespiral(lockNode(i));
                    NodeCoordinateprinter(Intercept(star,i));
                }
            }else if(choice.equals("2")){
                draw("Please enter the matrix line by line. Type - to end the matrix writing and get your results:");
                String [] array = new String [0];
                String floppy;
                for(;;){
                    floppy = keyword.nextLine();
                    if(floppy.equals("-")==false){
                        array = add(array,floppy);
                    }
                    else
                        break;
                }
                int Σ = 0;
                Node A = Wormhole(gastoninter(gastonmultiplexer(csvremove(array))));
                int x = 2;
                while(A.fetch()==null==false){
                    A.NewCustomClusterAlgorithm(A.fetch(),x);
                    Σ++;
                    x++;
                }
                draw("There are "+Integer.toString(Σ)+" clusters in this map, so we need "+Integer.toString(Σ)+" fireballs");
                draw("Optimum coordinates:");
                Node click = A;
                int  count = 0;
                while (click != null){
                    count = Max(count,click.bit);
                    click = click.next;
                }
                for(int i = 2;i<=count;i++){
                    Ranks star = Nodespiral(lockNode(i));
                    NodeCoordinateprinter(Intercept(star,i));
                }
            }else if(choice.equals("exit")){
                break;
            }else if(choice.equals("end")){
                break;
            }else if(choice.equals("esc")){
                break;
            }else if(choice.equals("-1")){
                break;
            }else{
                draw("Wrong input, Please try again.");
            }
            draw("Would you like to input a text file, or use line by line input? (Choose option 1 or 2)");
        }



    }
    public void redCliffOnFireSelection() {
        title();
        draw("First, you need to input a matrix.");
        draw("Would you like to input a text file, or use line by line input? [Choose option 1 or 2(-1 to exit)]");
        Scanner keypad = new Scanner(System.in);
        Scanner keyword = new Scanner(System.in);
        for(;;){
            String choice = keypad.nextLine();
            if(choice.equals("1")){
                draw("Please input the directory: (Use -1 to exit)");
                String link = link(keyword.nextLine());
                File inspector = new File(link);
                if(link.equals("-1"))
                    break;
                while(inspector.exists()==false){
                    draw("This file doesn't exist");
                    link = link(keyword.nextLine());
                    inspector = new File(link);
                }
                int Σ = 0;
                Node A = null;
                try {
                    A = Wormhole(gastoninter(gastonmultiplexer(csvremove(gastonintSheriff(readshelf(link))))));
                } catch (IOException ex) {
                    Logger.getLogger(RedCliffOnFire.class.getName()).log(Level.SEVERE, null, ex);
                }
                int x = 2;
                while(A.fetch()==null==false){
                    A.NewCustomClusterAlgorithm(A.fetch(),x);
                    Σ++;
                    x++;
                }
                draw("There are "+Integer.toString(Σ)+" clusters in this map, so we need "+Integer.toString(Σ)+" fireballs");
                draw("Optimum coordinates:");
                Node click = A;
                int  count = 0;
                while (click != null){
                    count = Max(count,click.bit);
                    click = click.next;
                }
                for(int i = 2;i<=count;i++){
                    Ranks star = Nodespiral(lockNode(i));
                    NodeCoordinateprinter(Intercept(star,i));
                }
            }else if(choice.equals("2")){
                draw("Please enter the matrix line by line. Type - to end the matrix writing and get your results: (Use -1 to exit)");
                String [] array = new String [0];
                String floppy;
                int trafficPolice = 0;
                floppy = keyword.nextLine();

                if(intSheriff(floppy)==false && floppy.equals("-")==false && floppy.equals("-1")==false){
                    draw("NUMBERS ONLY!");
                    draw("Conntinue...");
                }
                if(floppy.equals("-1")){
                    return;
                }
                if(floppy.equals("-")==false){
                    if(intSheriff(floppy)){
                        array = add(array,floppy);
                        trafficPolice = floppy.length();
                    }
                }

                if(floppy.equals("-")==false){
                    for(;;){
                        floppy = keyword.nextLine();
                        if(intSheriff(floppy)==false && floppy.equals("-")==false && floppy.equals("-1")==false){
                            draw("NUMBERS ONLY!");
                            draw("Conntinue...");
                        }
                        if(floppy.equals("-1")){
                            return;
                        }
                        if(floppy.equals("-")==false){
                            if(intSheriff(floppy) && floppy.length()==trafficPolice)
                                array = add(array,floppy);
                            if(floppy.length()==trafficPolice==false){
                                draw("The number of digits in each row should be consistent. Rewrite row:");
                            }
                        }
                        else
                            break;
                    }
                }
                int Σ = 0;
                Node A = Wormhole(gastoninter(gastonmultiplexer(csvremove(array))));
                int x = 2;
                while(A.fetch()==null==false){
                    A.NewCustomClusterAlgorithm(A.fetch(),x);
                    Σ++;
                    x++;
                }
                draw("There are "+Integer.toString(Σ)+" clusters in this map, so we need "+Integer.toString(Σ)+" fireballs");
                draw("Optimum coordinates:");
                Node click = A;
                int  count = 0;
                while (click != null){
                    count = Max(count,click.bit);
                    click = click.next;
                }
                for(int i = 2;i<=count;i++){
                    Ranks star = Nodespiral(lockNode(i));
                    NodeCoordinateprinter(Intercept(star,i));
                }
            }else if(choice.equals("exit")){
                break;
            }else if(choice.equals("end")){
                break;
            }else if(choice.equals("esc")){
                break;
            }else if(choice.equals("-1")){
                break;
            }else{
                draw("Wrong input, Please try again.");
            }
            draw("Would you like to input a text file, or use line by line input? [Choose option 1 or 2(-1 to exit)]");
        }



    }
    public static void test() throws IOException {
        Node A = Wormhole(gastoninter(gastonmultiplexer(csvremove(Desktopreadshelf("Boston")))));
        Ranks tau = ClusterBucket(A);
        tau.vent();
    }


}