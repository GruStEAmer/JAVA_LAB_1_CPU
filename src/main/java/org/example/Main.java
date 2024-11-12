package org.example;

public class Main {

    public static void main(String[] args) {
        Program p = new Program();
        p.add(new Command("init 10 20"));
        p.add(new Command("init" ,"11", "25"));
        p.add(new Command("ld", "a" ,"10"));
        p.add(new Command("ld", "b" ,"11"));
        p.add(new Command("add"));
        p.add(new Command("print"));//вывод 20 25 * 45
        p.add(new Command("sub"));
        p.add(new Command("print"));//вывод 20 25 * 45

        ICPU cpu = BCPU.build();
        Executer exec = new Executer(cpu);
        exec.run(p);
    }
}