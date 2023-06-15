package assignment_ds;

import assignment_ds.Queue;
import assignment_ds.Ranks;
import static assignment_ds.RedCliffOnFire.sou;
public class Node {
    static int End;
    static Node head = null;
    static Node tail = null;
    int bit;
    Node next;
    Node prev;
    static int size;
    int address;


    Node right;
    Node left;
    Node up;
    Node down;


    int m,n;

    Node() {

    }
    Node(int o){
        bit = o;
        address = 1;
        size++;
    }
    Node(int o,Node prev,Node next){
        bit = o;
        this.prev = prev;
        this.next = next;
        address = 1;
        size++;
    }

    public void set() {
        bit = 1;
    }
    public void reset() {
        bit = 0;
    }
    public void burn() {
        bit = -1;
    }
    public static boolean isamultiple(int Big,int smol) {
        boolean feed;
        if(Big % smol == 0){
            feed = true;
        }
        else{
            feed = false;
        }
        return feed;
    }
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
    public static void soutcenter(String txt,int val) {
        for(int i = 0;i<val-txt.length()/2;i++){
            System.out.print(" ");
        }
        System.out.print(txt);
        for(int i = 0;i<val-txt.length()/2;i++){
            System.out.println(" ");
        }
    }
    public static void soucenter(String txt,int val) {
        int space = val - txt.length();
        int half,halfa;
        if(space % 2 == 0){
            half = space/2;
            halfa = half;
        }else{
            half = space + 1/2;
            halfa = half-1;
        }
        for(int i = 0;i<halfa;i++){
            System.out.print(" ");
        }
        System.out.print(txt);
        for(int i = 0;i<half;i++){
            System.out.print(" ");
        }
    }
    public static void soutleft(String txt,int val) {
        int space = val - txt.length();
        int half,halfa;
        if(space % 2 == 0){
            half = space/2;
            halfa = half;
        }else{
            half = space + 1/2;
            halfa = half-1;
        }
        System.out.print(txt);
        for(int i = 0;i<space;i++){
            System.out.print(" ");
        }
    }


    public void add(int X) {
        Node rose = new Node (X,null,null);
        size --;
        if (head == null){
            head = tail = rose;
            m = 1;
            n = 1;
            size++;
        }
        else if(isamultiple(tail.address,End)){
            rose.prev = tail;
            tail.next = rose;
            rose.address = tail.address + 1;



            Node rep = rose;
            int check = 0;
            for(int k = 0;k<End;k++){
                if(rep.prev==null){
                    break;
                }
                else{
                    rep = rep.prev;
                    check++;
                }
            }
            if(check==End){
                rose.up = rep;
                rep.down = rose;
            }
            rep = rose;
            int reck = 0;
            for(int k = 0;k<End;k++){
                if(rep.next==null){
                    break;
                }
                else{
                    rep = rep.next;
                    reck++;
                }
            }
            if(reck==End){
                rose.down = rep;
                rep.up = rose;
            }



            tail = rose;
            size++;
        }
        else{
            rose.prev = tail;
            rose.left = tail;
            tail.next = rose;
            tail.right = rose;
            rose.address = tail.address + 1;



            Node rep = rose;
            int check = 0;
            for(int k = 0;k<End;k++){
                if(rep.prev==null){
                    break;
                }
                else{
                    rep = rep.prev;
                    check++;
                }
            }
            if(check==End){
                rose.up = rep;
                rep.down = rose;
            }
            rep = rose;
            int reck = 0;
            for(int k = 0;k<End;k++){
                if(rep.next==null){
                    break;
                }
                else{
                    rep = rep.next;
                    reck++;
                }
            }
            if(reck==End){
                rose.down = rep;
                rep.up = rose;
            }



            tail = rose;
            size++;
        }
    }


    public static void vend() {
        Node current = head;
        while (current != null) {
            System.out.print(current.bit+" ");
            current = current.next;
        }
    }
    public static void vendMatrix() {
        Node current = head;
        while (current != null) {
            System.out.print(current.bit+" ");
            if(current.right==null){
                System.out.println("");
                current = current.next;
            }
            else{
                current = current.right;
            }
        }
    }
    public static void vendMatrixnospace() {
        Node current = head;
        while (current != null) {
            System.out.print(current.bit);
            if(current.right==null){
                System.out.println("");
                current = current.next;
            }
            else{
                current = current.right;
            }
        }
    }
    public static void vendline() {
        Node current = head;
        while (current != null) {
            System.out.print(current.bit+" ");
            current = current.right;
        }
    }
    public static void vendmn() {
        Node current = head;
        while (current != null) {
            System.out.print("["+current.m+"|"+current.n+"]");
            if(current.right==null){
                System.out.println("");
                current = current.next;
            }
            else{
                current = current.right;
            }
        }
    }
    public static void vendaddress() {
        Node current = head;
        while (current != null) {
            soutleft("["+current.address+"]",5);
            if(current.right==null){
                System.out.println("");
                current = current.next;
            }
            else{
                current = current.right;
            }
        }
    }
    public void vendvectors() {
        Node current = head;
        while (current != null) {
            soutleft("|"+Vector(current,head)+"|",5);
            if(current.right==null){
                System.out.println("");
                current = current.next;
            }
            else{
                current = current.right;
            }
        }
    }// prints the vectors (unstable and experimental)
    public static Node fetch() {
        Node rose = head;
        Node feed = null;
        while (rose != null) {
            if (rose.bit==1){
                feed = rose;
                break;
            }
            else {
                rose = rose.next;
            }
        }
        return feed;
    }
    public static Node fetchnext(Node trost) {
        Node rose = trost.next;
        Node feed = null;
        while (rose != null) {
            if (rose.bit==1){
                feed = rose;
                break;
            }
            else{
                rose = rose.next;
            }
        }
        return feed;
    }

    public void ClusterAlgorithm(Node Tobeclustered) {
        Queue <Node> reg = new Queue();

        Node start = Tobeclustered;
        //1st cross mapping

        if(start.bit != 1){
            System.out.println("Failed fetch error");
        }
        else{
            start.reset();
            if(start.up != null)
                reg.add(start.up);
            if(start.down!= null)
                reg.add(start.down);
            if(start.right != null)
                reg.add(start.right);
            if(start.left != null)
                reg.add(start.left);
        }

        //cross mapping loop
        if(reg.QisEmpty()){
            System.out.println("End");
        }else{
            Node tuna = reg.out();

            while (tuna != null){               //loop controller
                if (tuna.bit == 1){             //cross compatibility test
                    if(tuna.up != null)         //null test
                        reg.add(tuna.up);         //add
                    if(tuna.down != null)       //null test
                        reg.add(tuna.down);   //add
                    if(tuna.right != null)      //null test
                        reg.add(tuna.right);  //add
                    if(tuna.left != null)       //null test
                        reg.add(tuna.left);   //add
                    tuna.reset();
                }
                if(!reg.QisEmpty()){
                    tuna = reg.out();
                }
                else{
                    break;
                }
            }
        }
    }
    public void CustomClusterAlgorithm(Node Tobeclustered, int x) {
        Queue <Node> reg = new Queue();

        Node start = Tobeclustered;
        //1st cross mapping

        if(start.bit != 1){
            System.out.println("Failed fetch error");
        }
        else{
            start.bit = x;
            if(start.up != null)
                reg.add(start.up);
            if(start.down!= null)
                reg.add(start.down);
            if(start.right != null)
                reg.add(start.right);
            if(start.left != null)
                reg.add(start.left);
        }

        //cross mapping loop
        if(reg.QisEmpty()){
            System.out.println("End");
        }else{
            Node tuna = reg.out();
            while (tuna != null){               //loop controller
                if (tuna.bit == 1){             //cross compatibility test
                    if(tuna.up != null)         //null test
                        reg.add(tuna.up);         //add
                    if(tuna.down != null)       //null test
                        reg.add(tuna.down);   //add
                    if(tuna.right != null)      //null test
                        reg.add(tuna.right);  //add
                    if(tuna.left != null)       //null test
                        reg.add(tuna.left);   //add
                    tuna.bit = x;
                }
                if(!reg.QisEmpty()){
                    tuna = reg.out();
                }
                else{
                    break;
                }
            }
        }
    }
    public void NewCustomClusterAlgorithm(Node Tobeclustered, int x) {
        Queue <Node> reg = new Queue();

        Node start = Tobeclustered;
        //1st cross mapping

        if(start.bit != 1){
            System.out.println("Failed fetch error");
        }
        else{
            start.bit = x;
            if(start.up != null){
                reg.add(start.up);
                if(start.up.right != null)
                    reg.add(start.up.right);
                if(start.up.left != null)
                    reg.add(start.up.left);
            }
            if(start.down!= null){
                reg.add(start.down);
                if(start.down.right != null)
                    reg.add(start.down.right);
                if(start.down.left != null)
                    reg.add(start.down.left);
            }
            if(start.right != null)
                reg.add(start.right);
            if(start.left != null)
                reg.add(start.left);
        }

        //cross mapping loop
        if(reg.QisEmpty()){

        }else{
            Node tuna = reg.out();
            while (tuna != null){               //loop controller
                if (tuna.bit == 1){             //cross compatibility test
                    if(tuna.up != null){
                        reg.add(tuna.up);
                        if(tuna.up.right != null)
                            reg.add(tuna.up.right);
                        if(tuna.up.left != null)
                            reg.add(tuna.up.left);
                    }
                    if(tuna.down!= null){
                        reg.add(tuna.down);
                        if(tuna.down.right != null)
                            reg.add(tuna.down.right);
                        if(tuna.down.left != null)
                            reg.add(tuna.down.left);
                    }
                    if(tuna.right != null)
                        reg.add(tuna.right);
                    if(tuna.left != null)
                        reg.add(tuna.left);
                    tuna.bit = x;
                }
                if(!reg.QisEmpty()){
                    tuna = reg.out();
                }
                else{
                    break;
                }
            }
        }
    }












    public void BlazingCustomClusterAlgorithm(Node Tobeclustered, int x) {
        Queue <Node> reg = new Queue();

        Node start = Tobeclustered;
        //1st cross mapping

        if(start.bit != 1){
            System.out.println("Failed fetch error");
        }
        else{
            start.bit = x;
            if(start.up != null){
                reg.add(start.up);
                if(start.up.right != null)
                    reg.add(start.up.right);
                if(start.up.left != null)
                    reg.add(start.up.left);
            }
            if(start.down!= null){
                reg.add(start.down);
                if(start.down.right != null)
                    reg.add(start.down.right);
                if(start.down.left != null)
                    reg.add(start.down.left);
            }
            if(start.right != null)
                reg.add(start.right);
            if(start.left != null)
                reg.add(start.left);
        }

        //cross mapping loop
        if(reg.QisEmpty()){

        }else{
            Node tuna = reg.out();
            while (tuna != null){               //loop controller
                if (tuna.bit == 1){             //cross compatibility test
                    if(tuna.up != null){
                        reg.add(tuna.up);
                        if(tuna.up.right != null)
                            reg.add(tuna.up.right);
                        if(tuna.up.left != null)
                            reg.add(tuna.up.left);
                    }
                    if(tuna.down!= null){
                        reg.add(tuna.down);
                        if(tuna.down.right != null)
                            reg.add(tuna.down.right);
                        if(tuna.down.left != null)
                            reg.add(tuna.down.left);
                    }
                    if(tuna.right != null)
                        reg.add(tuna.right);
                    if(tuna.left != null)
                        reg.add(tuna.left);
                    tuna.bit = x;
                }
                if(!reg.QisEmpty()){
                    tuna = reg.out();
                }
                else{
                    break;
                }
            }
        }
    }





    public static int Midloc(int i, int f) {
        return i+(f-i)/2;
    }





    public static Node roofsearch(int x) {
        Node cactus = head;
        for (int i = 1;i<x;i++){
            cactus = cactus.right;
        }
        return cactus;
    }

    public static Node pillarsearch(Node rose,int x) {
        Node cacti = rose;
        while(cacti != null){
            if(cacti.bit==x){
                break;
            }else{
                cacti = cacti.down;
            }
        }
        if (cacti == null){

        }
        return cacti;
    }

    public static Node Vrodding(int longitude, int number){            //searchs a vertical rod for an index, and returns Node
        return pillarsearch(roofsearch(longitude),number);
    }

    public static int VerticalLocalizer(int number){                  //returns the longitude of the 1st rod which has a number
        Node Ruby = null;
        int y = 0;
        while(Ruby == null){
            y++;
            Ruby = Vrodding(y, number);
        }
        return y;
    }

    public static int VerticalEndLocalizer(int number){                  //returns the longitude of the 1st rod which has a number
        Node Ruby = null;
        int y = 0;
        while(Ruby == null){
            y++;
            Ruby = Vrodding(y, number);
        }
        while(Ruby != null){
            y++;
            Ruby = Vrodding(y, number);
        }
        return y-1;
    }

    public static int Vlock(int number) {
        return Midloc(VerticalLocalizer(number), VerticalEndLocalizer(number));
    }









    public static Node sidesearch(int x) {
        Node cactus = head;
        for (int i = 1;i<x;i++){
            cactus = cactus.down;
        }
        return cactus;
    }

    public static Node rowsearch(Node rose,int x) {
        Node cacti = rose;
        while(cacti != null){
            if(cacti.bit==x){
                break;
            }else{
                cacti = cacti.right;
            }
        }
        return cacti;
    }

    public static Node Hrodding(int latitude, int number){            //searchs a vertical rod for an index, and returns Node
        return rowsearch(sidesearch(latitude),number);
    }

    public static int HorizontalLocalizer(int number){                  //returns the longitude of the 1st rod which has a number
        Node Ruby = null;
        int y = 0;
        while(Ruby == null){
            y++;
            Ruby = Hrodding(y, number);
        }
        return y;
    }

    public static int HorizontalEndLocalizer(int number){                  //returns the longitude of the 1st rod which has a number
        Node Ruby = null;
        int y = 0;
        while(Ruby == null){
            y++;
            Ruby = Hrodding(y, number);
        }
        while(Ruby != null){
            y++;
            Ruby = Hrodding(y, number);
        }
        return y-1;
    }

    public static int Hlock(int number) {
        return Midloc(HorizontalLocalizer(number), HorizontalEndLocalizer(number));
    }








    public static int square(int x) {
        return x*x;
    }

    public static int NodeCoordinatorrow(Node node) {
        Node ai = node;
        int y = 0;
        while (ai != null){
            y++;
            ai = ai.up;
        }
        return y;
    }
    public static int NodeCoordinatorcol(Node node) {
        Node ai = node;
        int y = 0;
        while (ai != null){
            y++;
            ai = ai.left;
        }
        return y;
    }
    public static void NodeCoordinateprinter(Node node) {
        int row = NodeCoordinatorrow(node)-1;
        int col = NodeCoordinatorcol(node)-1;
        draw("["+row+","+col+"]");
    }

    public static int Vector(Node A, Node B) {
        int xa = NodeCoordinatorcol(A);
        int xb = NodeCoordinatorcol(B);
        int ya = NodeCoordinatorrow(A);
        int yb = NodeCoordinatorrow(B);
        return square(xa-xb) + square(ya-yb);
    }//The distance between 2 nodes


    public static void lockprinter(int number) {
        System.out.println("Coords: ("+Vlock(number)+","+Hlock(number)+")");
    }

    public static int Coordinateaddressing(int x,int y) {
        return End*(y-1)+x;
    }

    public static int lockaddress(int number) {
        return Coordinateaddressing(Vlock(number),Hlock(number));
    }

    public static Node fetch(int address) {
        Node Q = head;
        while (Q!=null){
            if(Q.address == address){
                return Q;
            }
            else{
                Q = Q.next;
            }
        }
        return null;
    }

    public static Node lockNode(int number) {
        return fetch(lockaddress(number));
    } //Algorithm 2 special tool. Gives the node at the optimum striking point (includes zeroes)

    public static Ranks Nodespiral(Node node) {
        Ranks Q = new Ranks(node);
        Node Rock = head;
        while(Rock != null){
            Q.rank(Rock);
            Rock = Rock.next;
        }
        return Q;
    }//Algorithm 2 special tool 2. Retuns the Priority Queue of the other nodes based on distance



    public static Ranks ClusterBucket(Node node) {
        Ranks Q = new Ranks(node);
        Node frost = head;
        while(frost==null==false){
            if(frost.bit == node.bit){
                Q.addLast(node);
                frost = frost.next;
            }
        }
        return Q;
    }//New algorithm tool. Takes a node and returns the cluster surrounding it.

    /*
    public static int burn(Node node) {
        JudgeQueue reg = new JudgeQueue();
        JudgeQueue regsupprime = new JudgeQueue();
        Node start = node;
        int index = start.bit;
        int ticks;
        ticks = 0;
        start.burn();
            //neighbor collecting
            if(start.up != null){
                reg.add(start.up);
            if(start.up.right != null)
                reg.add(start.up.right);
            if(start.up.left != null)
                reg.add(start.up.left);
            }
            if(start.down!= null){
                reg.add(start.down);
            if(start.down.right != null)
                reg.add(start.down.right);
            if(start.down.left != null)
                reg.add(start.down.left);
            }
            if(start.right != null)
                reg.add(start.right);
            if(start.left != null)
                reg.add(start.left);
            //------------------------------
            ticks++;
            //------------------------------
            while(reg.isEmpty()==false){
                start = reg.removeLast();
            }
        return 0;

    }*/

    public static Node Intercept(Ranks Q,int n) {
        while(Q != null){
            Node judge = Q.removeFirst();
            if(judge.bit == n){
                return judge;
            }
        }
        return null;
    }


}