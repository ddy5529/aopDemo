package com.ddy.aop;

public class Runable implements Runnable {

    String string;

    public Runable(String string) {
        this.string = string;
    }

    @Override
    public void run() {
        System.out.println(string);
    }

    public static void main(String[] args) {
        for (int i = 0; i <10000; i++) {
            Runable runable=new Runable(i+"");
            runable.run();
        }
    }
}
