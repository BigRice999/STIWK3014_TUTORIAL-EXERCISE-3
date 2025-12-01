package com.example.Week_08;

public class main {
    public static void main(String[] args) {
        // create instance with initial balance
        BankAccountWithLock account = new BankAccountWithLock(1000.00);

        // create Runnable for deposit and withdraw
        Runnable writer = () -> {

            account.deposit(50.0);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            account.withdraw(200.00);
        };

        // create Runnable for fetching balance
        Runnable reader = () -> {
            account.getBalance();
            try {
                Thread.sleep(50);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // start Thread
        Thread writer1 = new Thread(writer, "Writer-1");
        Thread writer2 = new Thread(writer, "Writer-2");

        Thread reader1 = new Thread(reader, "Reader-1");
        Thread reader2 = new Thread(reader, "Reader-2");
        Thread reader3 = new Thread(reader, "Reader-3");
        Thread reader4 = new Thread(reader, "Reader-4");

        writer1.start();
        reader1.start();

        writer2.start();
        reader2.start();

        reader3.start();
        reader4.start();

        try {
            writer1.join();
            writer2.join();
            reader1.join();
            reader2.join();
            reader3.join();
            reader4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- All operations complete ---");
        System.out.println("Final Balance: " + account.getBalance());
    }
}
