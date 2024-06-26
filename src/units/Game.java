package units;

import java.util.ArrayList;

public class Game {

    protected GameTeamWhite commandWhite;
    protected GameTeamBlack commandBlack;
    protected Integer moveCounter = 0;

    protected ArrayList<Person> tempAllTeam = new ArrayList<Person>();

    public Game(String nameW, String nameB) {
        commandWhite = new GameTeamWhite(nameW);
        commandBlack = new GameTeamBlack(nameB);
        tempAllTeam.addAll(commandWhite.teamPersons);
        tempAllTeam.addAll(commandBlack.teamPersons);
    }

    // Метод, в котором все игроки двух команд делают поочередно по одному ходу.
    // Первый ход делает команда "белых". В первую очередь ходят персонажи с максимальной
    // инициативой, в последнюю с минимальной инициативой.
    public void action() {
        for (int iniz = 3; iniz >= 0; iniz--) {
            for (int i = 0; i < 10; i++) {
                if (this.commandWhite.teamPersons.get(i).initiative == iniz) {
                    this.commandWhite.teamPersons.get(i).step(this.commandWhite, this.commandBlack);
                }
                if (this.commandBlack.teamPersons.get(i).initiative == iniz) {
                    this.commandBlack.teamPersons.get(i).step(this.commandWhite, this.commandBlack);
                }
            }
        }
        moveCounter++;
    }
}