package Builder;

public class client {
    public static void main(String[] args) {
        whutAirshipbuilder whutAirshipbuilder=new whutAirshipbuilder();
        whutdirector whutdirector=new whutdirector(whutAirshipbuilder);
        Airship whut=whutdirector.airshipdirector();

        System.out.println(whut.getEngine());
        System.out.println(whut.getEscapetower());
        System.out.println(whut.getOrbital());
    }
}
