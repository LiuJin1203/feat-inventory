package edu.jinyi.study.example.singleexample;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author liujin
 * @date 2019/11/4
 * @since JDK8
 */
public class ParallelStream {

  static long summedInParallel() throws ExecutionException, InterruptedException {
    long firstNum = 1;
    long lastNum = 1_000_000;
    List<Long> aList = LongStream.rangeClosed(firstNum, lastNum).boxed().collect(Collectors.toList());
    ForkJoinPool customThreadPool = new ForkJoinPool(4);
    ForkJoinTask<Long> forkJoinTask =  customThreadPool.submit(
        () -> aList.parallelStream().reduce(0L, Long::sum));
    long actualTotal = forkJoinTask.get();
    return actualTotal;
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    long r = summedInParallel();
    System.out.println(r);
  }
}
