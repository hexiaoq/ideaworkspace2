package Builder;

/**
 * 此方法中new的构件可以借助简单工厂模式来创建，完成两个模式的合作（此处未用）
 */

public class whutAirshipbuilder  implements Airshipbuilder{
    @Override
    public engine enginebuilderr() {
        return new engine("whut发动机");
    }

    @Override
    public orbital ORBITALbuilder() {
        return new orbital("whut轨道舱");
    }

    @Override
    public escapetower ESCAPETOWERbuilder() {
        return new escapetower("whut逃逸舱");
    }
}
