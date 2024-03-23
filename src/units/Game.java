package units;

public class Game {

    protected GameTeamWhite commandWhite;
    protected GameTeamBlack commandBlack;

    public Game(String nameW, String nameB) {
        commandWhite = new GameTeamWhite(nameW);
        commandBlack = new GameTeamBlack(nameB);
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
    }
}