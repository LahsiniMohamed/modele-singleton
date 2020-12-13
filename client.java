public class Clients extends Thread{
    public static void main(String[] args) {
        Clients1 request1 = new Clients1();
        Clients2 request2 = new Clients2();
        Clients3 request3 = new Clients3();
    
       request1.start();
       System.out.print("Clients 1 request is running \n");
       request2.start();
       System.out.print("Clients 2 request is running\n");
       request3.start();
       System.out.print("Clients 3 request is running\n");    
    }
}

class Clients2 extends Thread{
    Terre terre2;
    public void run(){
        terre2 = Terre.getTerre();
        System.out.println("Clients 2 / Terre = " + terre2);
    }
}
class Clients1 extends Thread{
        Terre Terre1;
        public void run(){
            Terre1 = Terre.getTerre();
            System.out.println("Clients 1 / Terre = " + Terre1);
        }  
    }  
class Clients3 extends Thread{
        Terre Terre3;
        public void run(){
            Terre3 = Terre.getTerre();
            System.out.println("Clients 3 / Terre = " + Terre3);
        }  
    }     
