package units;

public class View {
    public static void view(Game game){

        System.out.println("Step number " + game.moveCounter);
        System.out.println("The white team");
        for (Person unit : game.commandWhite.teamPersons) unit.statusOutput();
        System.out.println("The black team");
        for (Person unit : game.commandBlack.teamPersons) unit.statusOutput();
    }
}
