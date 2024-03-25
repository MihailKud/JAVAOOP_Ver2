package units;

public interface GameInterface {
    void step(GameTeamWhite white, GameTeamBlack black);
    void statusOutput();
    String getInfo();
}
