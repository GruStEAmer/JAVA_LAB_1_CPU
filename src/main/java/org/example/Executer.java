package org.example;

public class Executer{
    ICPU cpu;
    Executer(ICPU i){
        cpu = i;
    }

    void run(Program c)
    {
        for(Command com : c)
            cpu.exec(com);
    }
}
