import java.util.concurrent.*; 

public class Terre {
    private static Terre terre = null;
    private  int weight;
    private  int population ; 
    private static Semaphore sem  = new Semaphore(1);
    private Terre(int weight , int population){
        this.weight = weight;
        this.population = population;
    }
    public static Terre getTerre(){
    try{
        System.out.println("aquiring semaphore ....... \n");
        sem.acquire();
        if (terre == null){
            System.out.println("Construction du Singleton au premier appel");
            terre = new Terre(150 , 7);
            }
        }
        catch (InterruptedException exc) { 
            System.out.println(exc); 
        } 
        System.out.println("releasing semaphore ....... \n");
        sem.release();
        return terre ;
    };
    public int getWeight(){return this.weight;};
    public int getPopulation(){return this.population;};

}
