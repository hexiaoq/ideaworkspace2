package decrator;

class flycar extends supercar{


    public flycar(Icar car) {
        super(car);
    }

    public void fly()
    {
        System.out.println("天上飞");
    }
    @Override
    public void move() {
        super.move();
        fly();
    }

}
