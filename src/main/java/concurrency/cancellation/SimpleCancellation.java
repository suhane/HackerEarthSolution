package concurrency.cancellation;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SimpleCancellation {

    private class PrimeGenerator implements Runnable{

    private final List<BigInteger> primes= new ArrayList<BigInteger>();
    private volatile boolean cancelled;
        @Override
        public void run() {

            BigInteger p=BigInteger.ONE;
            while (!cancelled){

                p=p.nextProbablePrime();
                synchronized (this){
                    primes.add(p);
                }
            }
        }

        public void cancel(){
            cancelled=true;
        }

        public synchronized List<BigInteger> get(){
            return new ArrayList<BigInteger>(primes);
        }
    }

    List<BigInteger> aSecondOfPrimes() throws InterruptedException{
        PrimeGenerator generator= new PrimeGenerator();
        new Thread(generator).start();
        try {
            SECONDS.sleep(1);
        }
        finally {
            generator.cancel();
        }

        return generator.get();
    }


    @Test
    public  void test() throws InterruptedException {
        System.out.println(aSecondOfPrimes());
    }
}
