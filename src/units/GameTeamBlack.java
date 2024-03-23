package units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameTeamBlack {
    protected String teamName; // имя команды
    protected ArrayList<Person> teamPersons; // поле коллекция команды

    public GameTeamBlack(String name){
        this.teamName = name;
        teamPersons = new ArrayList<Person>();

        // формирование второй команды
        int temp;
        for (int i = 0; i < 10; i++) {
            temp = new Random().nextInt(0, 4);
            if (temp == 0) {
                teamPersons.add(new Peasant(outName(), new Random().nextInt(0, 10), 9)); // добавляем крестьянина
            } else if (temp == 1){
                teamPersons.add(new Sniper(outName(), new Random().nextInt(0, 10), 9)); // добавляем снайпера
            } else if (temp == 2){
                teamPersons.add(new Monk(outName(), new Random().nextInt(0, 10), 9)); // добавляем монаха
            } else if (temp == 3){
                teamPersons.add(new Outlaw(outName(), new Random().nextInt(0, 10), 9)); // добавляем разбойника
            }
            System.out.println(teamPersons.get(i).getClass().getName() + " " + teamPersons.get(i).getNamePerson());
        }
    }
    public String outName(){
        StringBuilder tempString = new StringBuilder();
        for (int j = 1; j <= 6; j++){
            int kodChar = new Random().nextInt(97, 123);
            tempString.append((char) kodChar);
        }
        return tempString.toString();
    }
}
