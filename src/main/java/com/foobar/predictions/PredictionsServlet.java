package com.foobar.predictions;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServlet;

public class PredictionsServlet extends TServlet {

    private static final long serialVersionUID = 5846176011116134587L;

    public PredictionsServlet() {
        super(
            new PredictionsActivity.Processor<PredictionsActivity.Iface>(
                new PredictionsActivityImpl()),
            new TBinaryProtocol.Factory()
        );
    }
}
