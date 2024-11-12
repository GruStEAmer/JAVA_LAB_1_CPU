package org.example;

import java.util.HashMap;

public class CPU implements ICPU{
    private final int[] RAM = new int[4096];
    private HashMap<String, Integer> R = new HashMap<>();

    CPU(){
        R.put("a",0);
        R.put("b",0);
        R.put("c",0);
        R.put("d",0);
    }

    @Override
    public void exec(Command c)
    {
        switch(c.info[0]){
            case "init":
                init(c);
                break;
            case "st":
                st(c);
                break;
            case "ld":
                ld(c);
                break;
            case "print":
                print();
                break;
            case "add":
                add();
                break;
            case "mult":
                mult();
                break;
            case "sub":
                sub();
                break;
            case "div":
                div();
                break;
        };
    }
    public void init(Command c) {
        RAM[Integer.parseInt(c.info[1])] = Integer.parseInt(c.info[2]);
    }
    public void st(Command c){
        RAM[Integer.parseInt(c.info[1])] = R.get(c.info[2]);
    }
    public void ld(Command c){
        R.put(c.info[1],RAM[Integer.parseInt(c.info[2])]);
    }
    public void print(){
        R.forEach((s, integer) ->
                System.out.print(integer + " ")
        );
        System.out.println("\n");
    }
    public void add(){
        R.put("d", R.get("a") + R.get("b"));
    }
    public void sub(){
        R.put("d", R.get("a") - R.get("b"));
    }
    public void mult(){
        R.put("d", R.get("a") * R.get("b"));
    }
    public void div() {
        R.put("d", R.get("a") / R.get("b"));
    }
}