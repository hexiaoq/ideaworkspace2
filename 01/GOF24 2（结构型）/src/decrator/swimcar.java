package decrator;

class swimcar extends supercar{



    public swimcar(decrator.Icar car) {
        super(car);
    }

    public void swim()
    {
        System.out.println("水上行驶");
    }
    @Override
    public void move() {
        super.move();
        swim();
    }
}
