package com.udian.jgroup;

import org.jgroups.JChannel;
import org.jgroups.blocks.MethodCall;
import org.jgroups.blocks.RequestOptions;
import org.jgroups.blocks.ResponseMode;
import org.jgroups.blocks.RpcDispatcher;
import org.jgroups.util.RspList;
import org.jgroups.util.Util;

/**
 * Created by Administrator on 2018/6/19.
 */
public class RpcDispatcherTest {
    JChannel channel;
    RpcDispatcher disp;
    RspList rsp_list;
    String             props; // set by application

    public static int print(int number) throws Exception {
        return number * 2;
    }

    public void start() throws Exception {
        MethodCall call=new MethodCall(getClass().getMethod("print", int.class));
        RequestOptions opts=new RequestOptions(ResponseMode.GET_ALL, 5000);
        channel=new JChannel(props);
        disp=new RpcDispatcher(channel, this);
        channel.connect("RpcDispatcherTestGroup");

        for(int i=0; i < 10; i++) {
            Util.sleep(100);
            call.setArgs(i);
            rsp_list=disp.callRemoteMethods(null, call, opts);
            System.out.println("Responses: " + rsp_list);
        }
        Util.close(disp, channel);
    }

    public static void main(String[] args) throws Exception {
        new RpcDispatcherTest().start();
    }
}
