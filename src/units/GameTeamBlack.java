package units;

import java.util.*;

public class GameTeamBlack {
    protected String teamName; // имя команды
    protected ArrayList<Person> teamPersons; // поле коллекция команды

    private final String[] tempListName = {"Andrey", "Mikhail", "Alexander", "Maxim",
            "Mark", "Alexandra", "Lev", "Matvey",
            "Alexey", "Vladimir", "Vasily", "Egor",
            "Dmitry", "Kirill", "Daniel", "Svyatoslav", "Platon", "Savely"};

    public GameTeamBlack(String name){
        this.teamName = name;
        teamPersons = new ArrayList<Person>();

        // формирование второй команды
        int temp;
        for (int i = 0; i < 10; i++) {
            temp = new Random().nextInt(0, 4);
            if (temp == 0) {
                teamPersons.add(new Peasant(outName(), i, 9)); // добавляем крестьянина
            } else if (temp == 1){
                teamPersons.add(new Sniper(outName(), i, 9)); // добавляем снайпера
            } else if (temp == 2){
                teamPersons.add(new Monk(outName(), i, 9)); // добавляем монаха
            } else if (temp == 3){
                teamPersons.add(new Outlaw(outName(), i, 9)); // добавляем разбойника
            }
            //System.out.println(teamPersons.get(i).getClass().getName() + " " + teamPersons.get(i).getNamePerson());
        }
    }
    public String outName(){
        int kod = new Random().nextInt(0, tempListName.length);
        return tempListName[kod];
    }
}
