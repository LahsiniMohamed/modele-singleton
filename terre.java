package singleton;
import java.util.concurrent.Semaphore;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;

public class terre{
    final static Semaphore semaphore = new Semaphore(1,true);
    private static int instance = 0;
    int age;
    int population;
    static terre ter;
    private terre(int age, int population){
        this.age = age;
        this.population = population;
    }
    public static terre create(int age, int population){
        ter = null;
        class Local implements Callable<terre>{
        public terre call() throws Exception{
                Thread.sleep(2000);
                if (instance==0){
                    ter = new terre(age, population);
                    instance+=1;
                    return ter;       
                }
                else {
                    ter = null;
                    return ter;
                }
        }   
    }
    terre result;
    try{
        
    semaphore.acquire(1);

    ExecutorService executor = Executors.newFixedThreadPool(1);
    Callable<terre> callable = new Local();
    Future<terre> future = executor.submit(callable);
    try {
        //print the return value of Future, notice the output delay in console
        // because Future.get() wai,ts for task to get completed
        result = future.get();
        executor.shutdown();

    } catch (InterruptedException | ExecutionException e) {
        result= null;
    }
    semaphore.release(1);
    return result;
}
catch(final InterruptedException ie){
    System.out.println("there is an error occured");
    return null;
}
    
}

}

