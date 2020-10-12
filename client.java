package singleton;
public class client extends Thread{
    public static void main(String[] args) {
        client1 request1 = new client1();
        client2 request2 = new client2();
        client3 request3 = new client3();
    
       request1.start();
       System.out.print("client 1 request is running \n");
       request2.start();
       System.out.print("client 2 request is running\n");
       request3.start();
       System.out.print("client 3 request is running\n");    
    }
}

class client2 extends Thread{
    terre terre2;
    public void run(){
        terre2 = terre.create(2,2);
        System.out.println("client 2 / terre = " + terre2);
    }
}
class client1 extends Thread{
        terre terre1;
        public void run(){
            terre1 = terre.create(1,1);
            System.out.println("client 1 / terre = " + terre1);
        }  
    }  
class client3 extends Thread{
        terre terre3;
        public void run(){
            terre3 = terre.create(1,3);
            System.out.println("client 3 / terre = " + terre3);
        }  
    }     