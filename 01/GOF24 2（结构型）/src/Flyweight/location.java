package Flyweight;

public class location {
    public location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int x,y;
    public void display(){
        System.out.println("位置是（"+x+","+y+")");
    }
}
