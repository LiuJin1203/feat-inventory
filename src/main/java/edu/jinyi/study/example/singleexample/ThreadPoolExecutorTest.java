package edu.jinyi.study.example.singleexample;



import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



/**
 * @author liujin
 * @since JDK8
 */
public class ThreadPoolExecutorTest {
    private  volatile static boolean  flag = false;
    private static int num = 3;
    private static boolean running = true;
    private static BlockingQueue taskQueue;
    static ExecutorService fixedThreadPool;
    private static Map taskRunnerSchedulerMap = new HashMap();;
    public static void main(String[] args) {
        Object obj = new Object();
//		fixedTreadPool(num);
        TaskRunnerScheduler taskRunnerScheduler = new TaskRunnerScheduler("one",3);
        TaskRunnerScheduler taskRunnerScheduler1 = new TaskRunnerScheduler("two",4);
        taskRunnerSchedulerMap.put("one",taskRunnerScheduler);
        taskRunnerSchedulerMap.put("two",taskRunnerScheduler1);

        taskRunnerScheduler.start();
        taskRunnerScheduler1.start();
        synchronized (obj) {
            try {
                obj.wait(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        taskRunnerScheduler.stopAll();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        taskRunnerScheduler1.stopAll();
        TaskRunnerScheduler taskRunnerScheduler2 = new TaskRunnerScheduler("three",3);
        taskRunnerScheduler2.start();

//        taskRunnerScheduler2.stopAll();

    }

    private static void scheduledThreadPool() {
        // TODO Auto-generated method stub
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
    }

    private static void fixedTreadPool(int num) {
        fixedThreadPool = Executors.newFixedThreadPool(num);
        TaskRunner[] runners = new TaskRunner[num];
//		taskQueue = new SynchronousQueue(true);
        int queueCount = num*10;
        taskQueue = new ArrayBlockingQueue(queueCount);
        for (int i = 0; i < queueCount; i++) {
            taskQueue.add(String.valueOf(i));
        }
        for (int i = 0; i < num; i++)
        {
            runners[i] = new TaskRunner("pool-of-" + i, taskQueue);
            fixedThreadPool.submit(runners[i]);
        }

    }

    private static void cacheTreadPool() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 4; i++) {
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println("cacheTreadPool:"+index);
                }
            });
        }
        if(flag){
            fixedTreadPool(4);
        }
    }


}
class TaskRunnerScheduler{
    private BlockingQueue taskQueue;
    private TaskRunner[] runners;
    private ExecutorService executorService;
    private String taskName;

    public TaskRunnerScheduler(String taskName,int runnerCount)
    {
        this.taskName = taskName;
        executorService = Executors.newFixedThreadPool(runnerCount);
        int queueCount = runnerCount*10;
        taskQueue = new ArrayBlockingQueue(queueCount);
        for (int i = 0; i < queueCount; i++) {
            taskQueue.add(String.valueOf(i));
        }
        runners = new TaskRunner[runnerCount];
//		for (int i = 0; i < runners.length; i++)
//		{
//			runners[i] = new TaskRunner("Thread "+i+" of pool " + taskName, taskQueue );
//		}
    }
    public void start(){
        if (executorService != null)
        {
            for (int i = 0; i < runners.length; i++)
            {
                runners[i] = new TaskRunner("Thread "+i+" of pool " + taskName, taskQueue );
                executorService.submit(runners[i]);
            }
        }
    }
    public void stop(){
        System.out.println("shutdown!");
        executorService.shutdown();
    }
    public void stopAll(){
        boolean flag = true;
        System.out.println("shutdown All!");
        while(flag){
            if (executorService != null)
            {
                if(taskQueue.isEmpty()){
                    for (int i = 0; i < runners.length; i++)
                    {
                        this.runners[i].stop();
                    }
                    executorService.shutdown();
//					stop();
                    flag = false;
                }

            }
        }

    }
}


class TaskRunner implements Callable{
    private boolean running = true;
    private String name ;
    private BlockingQueue queue;
    public TaskRunner(String name, BlockingQueue taskQueue){
        this.name = name;
        this.queue = taskQueue;
    }
    public Object call() throws Exception {
        while(running){
            try {
                String count = (String)queue.poll();
                System.out.println(name+"@"+count);
                Thread.sleep(1000*(new Random().nextInt(2)+1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name+" call stop!");
        return null;
    }
    public void stop(){
        running = false;
    }
}
