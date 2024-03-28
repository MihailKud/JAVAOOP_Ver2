package units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// класс команды белых (первой команды)
public class GameTeamWhite {
        protected String teamName; // имя команды
        protected ArrayList<Person> teamPersons; // поле коллекция команды
        private final String[] tempListName = {"Andrey", "Mikhail", "Alexander", "Maxim",
                "Mark", "Alexandra", "Lev", "Matvey",
                "Alexey", "Vladimir", "Vasily", "Egor",
                "Dmitry", "Kirill", "Daniel", "Svyatoslav", "Platon", "Savely"};


    public GameTeamWhite(String name){
            this.teamName = name;
            teamPersons = new ArrayList<Person>();
            // формирование первой команды

            int temp;
            // формируем первую команду
            for (int i = 0; i < 10; i++) {
                temp = new Random().nextInt(0, 4);
                if (temp == 0) {
                    teamPersons.add(new Peasant(outName(), i, 0)); // добавляем крестьянина
                } else if (temp == 1){
                    teamPersons.add(new Magician(outName(), i, 0)); // добавляем колдуна
                } else if (temp == 2){
                    teamPersons.add(new Crossbowman(outName(), i, 0)); // добавляем арбалетчика
                } else if (temp == 3){
                    teamPersons.add(new Spearman(outName(), i, 0)); // добавляем копейщика
                }
                //System.out.println(teamPersons.get(i).getClass().getName() + " " + teamPersons.get(i).getNamePerson());
            }
        }
    public String outName(){
        int kod = new Random().nextInt(0, tempListName.length);
        return tempListName[kod];
    }
}



