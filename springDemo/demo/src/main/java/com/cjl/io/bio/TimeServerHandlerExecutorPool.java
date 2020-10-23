package com.cjl.io.bio;

import java.util.concurrent.*;

/**
 * @ClassName TimeServerHandlerExecutorPool
 * @Description TODO
 * @Author chen jingling
 * @Date 2020/9/16 8:54
 */
public class TimeServerHandlerExecutorPool implements Executor {

    private ExecutorService executorService;

    public TimeServerHandlerExecutorPool(int maxPoolSize, int queueSize){
        /**
         * @param corePoolSize �����߳�����
         * @param maximumPoolSize �̴߳����������
         * @param keepAliveTime �����������̳߳��������ʱ  �೤ʱ���߳�û�д����������߳�����
         * @param unit keepAliveTimeʱ�䵥λ
         * @param workQueue ���̳߳�ʹ��ʲô����
         */
        this.executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize,
                120L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public TimeServerHandlerExecutorPool(int corePoolSize, int maxPoolSize, int queueSize){
        /**
         * @param corePoolSize �����߳�����
         * @param maximumPoolSize �̴߳����������
         * @param keepAliveTime �����������̳߳��������ʱ  �೤ʱ���߳�û�д����������߳�����
         * @param unit keepAliveTimeʱ�䵥λ
         * @param workQueue ���̳߳�ʹ��ʲô����
         */
        this.executorService = new ThreadPoolExecutor(corePoolSize, maxPoolSize,
                120L, TimeUnit.SECONDS, new LinkedBlockingDeque(queueSize));
    }

    @Override
    public void execute(Runnable command) {
        executorService.execute(command);
    }
}
