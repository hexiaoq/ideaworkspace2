package abstractfactory;

public interface tire {
    public void tire();

}

class htire implements tire {

    @Override
    public void tire() {
        System.out.println("高级轮胎");
    }


}
class lowhire implements tire {

    @Override
    public void tire() {
        System.out.println("低段轮胎");
    }


}