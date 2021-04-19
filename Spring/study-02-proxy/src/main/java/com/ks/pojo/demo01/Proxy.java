package com.ks.pojo.demo01;

public class Proxy implements Rent {


    private Host host;


    public Proxy(Host host) {
        this.host = host;
    }

    public void rent() {
        host.rent();
        sign();
    }
    // proxy do more things
    public void sign(){
        System.out.println("proxy can sign something.");
    }
}
