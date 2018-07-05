package com.udian.jgroup;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestHandler;
import org.jgroups.blocks.RequestOptions;
import org.jgroups.util.RspList;
import org.jgroups.util.Util;

/**
 * Created by Administrator on 2018/6/19.
 */
public class MessageDispatcherTest implements RequestHandler {
    JChannel channel;
    MessageDispatcher disp;
    RspList rsp_list;
    String            props; // to be set by application programmer

    public void start() throws Exception {
        channel=new JChannel(props);
        disp=new MessageDispatcher(channel, this);
        channel.connect("MessageDispatcherTestGroup");

        for(int i=0; i < 11; i++) {
            Util.sleep(100);
            System.out.println("Casting message #" + i);
            byte[] payload=("Number #" + i).getBytes();
            rsp_list=disp.castMessage(null,
                    payload, 0, payload.length,
                    RequestOptions.SYNC());
            System.out.println("Responses:\n" +rsp_list);
        }
        Util.close(disp,channel);
    }

    public Object handle(Message msg) throws Exception {
        System.out.println("handle(): " + new String(msg.getBuffer()));
        return "Success!";
    }

    public static void main(String[] args) {
        try {
            new MessageDispatcherTest().start();
        }
        catch(Exception e) {
            System.err.println(e);
        }
    }
}
