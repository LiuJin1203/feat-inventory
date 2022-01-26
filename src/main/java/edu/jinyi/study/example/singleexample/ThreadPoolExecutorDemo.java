package edu.jinyi.study.example.singleexample;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;


/**
 * @author liujin
 * @since JDK8
 */
public class ThreadPoolExecutorDemo {
    private  volatile static boolean  flag = false;
    private static int num = 3;
    private static boolean running = true;
    private static BlockingQueue taskQueue;
    static ExecutorService fixedThreadPool;
    private static Map taskRunnerSchedulerMap = new HashMap();;
    public static void main(String[] args) {
        Object obj = new Object();
//		fixedTreadPool(num);
        TaskRunnerScheduler1 taskRunnerScheduler = new TaskRunnerScheduler1("one",3);
        TaskRunnerScheduler1 taskRunnerScheduler1 = new TaskRunnerScheduler1("two",4);
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
        TaskRunnerScheduler1 taskRunnerScheduler2 = new TaskRunnerScheduler1("three",3);
        taskRunnerScheduler2.start();

        taskRunnerScheduler2.stopAll();

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

class TaskRunnerScheduler1{
    private BlockingQueue taskQueue;
    private TaskRunner1[] runners;
    private ExecutorService executorService;
    private String taskSchedulerName;

    public TaskRunnerScheduler1(String taskSchedulerName,int runnerCount)
    {
        this.taskSchedulerName = taskSchedulerName;
        executorService = Executors.newFixedThreadPool(runnerCount);
        int queueCount = runnerCount*10;
        taskQueue = new ArrayBlockingQueue(queueCount);
        for (int i = 0; i < queueCount; i++) {
            taskQueue.add(String.valueOf(i));
        }
        runners = new TaskRunner1[runnerCount];
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
                runners[i] = new TaskRunner1("Thread "+i+" of pool " + taskSchedulerName, taskQueue );
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
        System.out.println(this.taskSchedulerName+" shutdown All!");
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


class TaskRunner1 implements Callable{
    private boolean running = true;
    private String name ;
    private BlockingQueue queue;
    public TaskRunner1(String name, BlockingQueue taskQueue){
        this.name = name;
        this.queue = taskQueue;
    }
    public Object call() throws Exception {
        while(running){
            try {
                String count = (String)queue.poll();
                System.out.println(name+" @exepoll-"+count);
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
