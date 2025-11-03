package com.example.Week_06;

public class Airplane implements Runnable {
    private String name;
    private Runway runway;

    public Airplane(String name, Runway runway) {
        this.name = name;
        this.runway = runway;
    }

    @Override
    public void run() {

        synchronized (this.runway) {
            System.out.println(this.name + " is requesting runaway access... ");
            System.out.println(this.name + " is taking off... ");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(this.name + " is delayed due to heavy rain. ");
                return;
            }

            System.out.println(this.name + " is leaving the runway. ");
        }

    }
}
