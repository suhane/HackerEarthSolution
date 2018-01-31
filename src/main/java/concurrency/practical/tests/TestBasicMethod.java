package concurrency.practical.tests;

import concurrency.practical.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

public class TestBasicMethod {

    static int[] testArray;
    @BeforeClass
    public static void init(){

        int len=10000000;
        testArray=new int[len];
        for(int i=0;i<len;i++){
            testArray[i]=i%10;
        }

    }

    @Test
    public void test1() throws InterruptedException {
        int[] arr= {1,1,1,1,1,1,1,1,1,1,1,1};
        ArraySumBasicApproach at= new ArraySumBasicApproach(arr);
        at.calculateSumParallely(3);

    }

    @Test
    public void test2() throws InterruptedException {
        ArraySumBasicApproach at= new ArraySumBasicApproach(testArray);
        at.calculateSumParallely(10);

    }


    @Test
    public void test3() throws InterruptedException {
        ArraySumBasicApproach at= new ArraySumBasicApproach(testArray);
        at.calculateSequentially();

    }

    @Test
    public void test4() throws InterruptedException {
        ArraySumSemaphoresApproach at= new ArraySumSemaphoresApproach(testArray);
        at.calculateSumParallely(10);

    }

    @Test
    public void test5(){
        final ForkJoinPool fjPool = new ForkJoinPool();
        System.out.println(fjPool.invoke(new ArraySumForkAndJoin(testArray, 0, testArray.length)));


    }

    @Test
    public void test6(){
        ArraySumExecuterService at= new ArraySumExecuterService(testArray);
        at.sumParallely(10);


    }

    @Test
    public void test7() throws InterruptedException {
        ArraySumCallableFuture at= new ArraySumCallableFuture(testArray);
        at.calculateSumParallely(10);


    }

}
