package com.jerry.server;

import com.facebook.nifty.core.NettyServerConfig;
import com.facebook.nifty.core.ThriftServerDef;
import com.facebook.swift.codec.ThriftCodecManager;
import com.facebook.swift.service.ThriftEventHandler;
import com.facebook.swift.service.ThriftServer;
import com.facebook.swift.service.ThriftServiceProcessor;
import com.google.common.collect.ImmutableList;
import com.jerry.service.impl.TestServiceImpl;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newCachedThreadPool;
import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * Created by hujian on 2017/12/26
 */
public class TestServerDemo {

    private ExecutorService taskWorkerExecutor;
    private ThriftServer server;
    private ExecutorService bossExecutor;
    private ExecutorService ioWorkerExecutor;

    public ThriftServer getServer() {
        return server;
    }

    public TestServerDemo invoke() {
        ThriftServiceProcessor processor = new ThriftServiceProcessor(
                new ThriftCodecManager(),
                ImmutableList.<ThriftEventHandler>of(),
                new TestServiceImpl()
        );

  //      taskWorkerExecutor = newFixedThreadPool(1);

        ThriftServerDef serverDef = ThriftServerDef.newBuilder()
                .listen(8090)
                .withProcessor(processor)
//                .using(taskWorkerExecutor)
                .build();

//        bossExecutor = newCachedThreadPool();
//        ioWorkerExecutor = newCachedThreadPool();

        NettyServerConfig serverConfig = NettyServerConfig.newBuilder()
//                .setBossThreadExecutor(bossExecutor)
//                .setWorkerThreadExecutor(ioWorkerExecutor)
                .build();

        server = new ThriftServer(serverConfig, serverDef);
        return this;
    }

    public void stop() {
        server.close();
    }

    public static void main(String[] args) {

        TestServerDemo serverCreator = new TestServerDemo().invoke();
        ThriftServer server = serverCreator.getServer();

        server.start();
        System.out.println("服务已启动!");

        //serverCreator.stop();
        //serverCreator.checkExecutorsTerminated();

    }
}
