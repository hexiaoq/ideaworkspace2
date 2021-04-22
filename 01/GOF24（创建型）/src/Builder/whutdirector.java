package Builder;

/**
 * 建造模式：想要生成由不同构件组成的不同的产品只需要增加两个接口的实现类就行了
 *
 * 此方法里定义一个builder对象，以此调用builder中生产的构件，并用airship中的set方法
 * 来完成airship的实例化
 */

public class whutdirector implements director {
    private Airshipbuilder airshipbuilder;

    public whutdirector(Airshipbuilder airshipbuilder) {
        this.airshipbuilder = airshipbuilder;
    }

    @Override
    public Airship airshipdirector() {
        Airship whutairship=new Airship();
        whutairship.setEngine(airshipbuilder.enginebuilderr());
        whutairship.setOrbital(airshipbuilder.ORBITALbuilder());
        whutairship.setEscapetower(airshipbuilder.ESCAPETOWERbuilder());
        return whutairship;
    }
}
