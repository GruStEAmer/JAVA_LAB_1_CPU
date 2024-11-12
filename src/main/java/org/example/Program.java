package org.example;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Program implements Iterable<Command>{
    private ArrayList<Command> commandList = new ArrayList<>();
    private HashMap<String, Integer> counter = new HashMap<>();

    public Program(){}

    public Program(Command c){
        commandList.add(c);

        if(counter.containsKey(c.info[0])){
            counter.put(c.info[0], 1);
        }
        else
            counter.put(c.info[0], counter.get(c.info[0]) + 1);
    }
    public void add(Command c){
        commandList.add(c);

        String key = c.info[0];
        if (counter.containsKey(key)) {
            counter.put(key, counter.get(key) + 1);
        } else {
            counter.put(key, 1);
        }

    }
    public void printCommands() {
        ArrayList<HashMap.Entry<String, Integer>> sortedArrayList = new ArrayList<>(counter.entrySet());
        sortedArrayList.sort((p1, p2) -> p1.getValue().compareTo(p2.getValue()));
        sortedArrayList.forEach(
                it ->
                        System.out.println(it.getKey() + ":" + it.getValue())
        );
    }
    @Override
    public Iterator<Command> iterator() {
        return new CommandIterator();
    }

    private class CommandIterator implements Iterator<Command> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < commandList.size();
        }

        @Override
        public Command next() {
            return commandList.get(currentIndex++);
        }
    }
}
