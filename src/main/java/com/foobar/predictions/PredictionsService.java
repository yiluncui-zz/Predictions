package com.foobar.predictions;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class PredictionsService implements Runnable {

    private static final int PORT = 8080;
    
    private final PredictionsActivity.Iface activity = new PredictionsActivityImpl();

    public final PredictionsActivity.Processor<PredictionsActivity.Iface> processor =
        new PredictionsActivity.Processor<PredictionsActivity.Iface>(activity);
   
    @Override
    public void run() {
      try {
        TServerSocket serverTransport = new TServerSocket(PORT);
        TServer server = new TThreadPoolServer(
            new TThreadPoolServer.Args(serverTransport).processor(processor));
        System.out.println("Starting server or port: " + PORT);
        server.serve();
      } catch (TTransportException e) {
        e.printStackTrace();
      }
        
    }
    
}
