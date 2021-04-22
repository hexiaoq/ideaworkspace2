package Builder;

public class Airship {
    private engine engine;
    private orbital orbital;
    private escapetower escapetower;

    public String getEngine() {


        StringBuilder
        return engine.name;
    }

    public void setEngine(Builder.engine engine) {
        this.engine = engine;
    }

    public String getOrbital() {
        return orbital.name;
    }

    public void setOrbital(Builder.orbital orbital) {
        this.orbital = orbital;
    }

    public String getEscapetower() {
        return escapetower.name;
    }

    public void setEscapetower(Builder.escapetower escapetower) {
        this.escapetower = escapetower;
    }
}
class engine{
    String name;

    public engine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
class orbital{
    String name;

    public orbital(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
class escapetower{
    String name;

    public String getName() {
        return name;
    }

    public escapetower(String name) {
        this.name = name;
    }
}
