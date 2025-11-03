package com.example.Week_06;

public class Main {
    public static void main(String[] args) {

        Runway runway = new Runway();

        Airplane flight1 = new Airplane("Flight MAS01 EL-MARIACHI", runway);
        Thread t1 = new Thread(flight1);
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

        Airplane flight2 = new Airplane("Flight MAS02 EUDORA", runway);
        Thread t2 = new Thread(flight2);
        t2.setPriority(Thread.NORM_PRIORITY);
        t2.start();

        Airplane flight3 = new Airplane("Flight MAS03 DEJAVU", runway);
        Thread t3 = new Thread(flight3);
        t3.setPriority(Thread.NORM_PRIORITY);
        t3.start();

        Airplane flight4 = new Airplane("Flight MAS04 UTOPIA", runway);
        Thread t4 = new Thread(flight4);
        t4.setPriority(Thread.MIN_PRIORITY);
        t4.start();

        try{
            Thread.sleep(100);

        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Bad weather! Interrupting Flight MAS01 EL-MARIACHI!");
        t1.interrupt();

        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("All flights completed. Control Tower closing operations. ");
    }
}
