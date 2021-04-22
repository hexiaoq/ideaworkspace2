public class test {
    private int op;
    private String ob;

    public test() {
    }

    public test(int op, String ob) {
        this.op = op;
        this.ob = ob;
    }
    public void sayhello(int i){
        System.out.println(i+"hello");
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public String getOb() {
        return ob;
    }

    public void setOb(String ob) {
        this.ob = ob;
    }
}
