package Classes;

public class CPU {
    private final int[] RAM = new int[4096];
    public int[] R = new int[4];

    public void init(int address, int value){
        RAM[address] = value;
    }
    public void store(int index_r, int address){
        RAM[address] = R[index_r];
    }
    public void load(int index_r, int address){
        R[index_r] = RAM[address];
    }
    public void show(){
        for (int j : R) {
            System.out.println(j);
        }
    }
    public void add(int r_first, int r_second, int r_ans){
        R[r_ans] = R[r_first] + R[r_second];
    }
    public void sub(int r_first, int r_second, int r_ans){
        R[r_ans] = R[r_first] - R[r_second];
    }
    public void mult(int r_first, int r_second, int r_ans){
        R[r_ans] = R[r_first] * R[r_second];
    }
    public void div(int r_first, int r_second, int r_ans){
        R[r_ans] = R[r_first] / R[r_second];
    }
}
