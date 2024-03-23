package units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// класс команды белых (первой команды)
public class GameTeamWhite {
        protected String teamName; // имя команды
        protected ArrayList<Person> teamPersons; // поле коллекция команды

        public GameTeamWhite(String name){
            this.teamName = name;
            teamPersons = new ArrayList<Person>();
            // формирование первой команды

            int temp;
            // формируем первую команду
            for (int i = 0; i < 10; i++) {
                temp = new Random().nextInt(0, 4);
                if (temp == 0) {
                    teamPersons.add(new Peasant(outName(), new Random().nextInt(0, 10), 0)); // добавляем крестьянина
                } else if (temp == 1){
                    teamPersons.add(new Magician(outName(), new Random().nextInt(0, 10), 0)); // добавляем колдуна
                } else if (temp == 2){
                    teamPersons.add(new Crossbowman(outName(), new Random().nextInt(0, 10), 0)); // добавляем арбалетчика
                } else if (temp == 3){
                    teamPersons.add(new Spearman(outName(), new Random().nextInt(0, 10), 0)); // добавляем копейщика
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



