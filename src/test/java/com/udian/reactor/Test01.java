package com.udian.reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * Created by Administrator on 2018/6/20.
 */
public class Test01 {

    public static String alphabet(int letterNumber) {
        if (letterNumber < 1 || letterNumber > 26) {
            return null;
        }
        int letterIndexAscii = 'A' + letterNumber - 1;
        return "" + (char) letterIndexAscii;
    }

    public static void main(String[] args) throws InterruptedException {
        Flux.range(1, 10000)
                .publishOn(Schedulers.parallel())
                .subscribe(System.out::println);
        Thread.sleep(1000);
    }
}
