package abstractfactory;

public interface seat {
public void seat();

}

class hseat implements seat {

    @Override
    public void seat() {
        System.out.println("高端座椅");
    }


}
class lowseat implements seat {

    @Override
    public void seat() {
        System.out.println("低端座椅");
    }


}