package units;

import java.util.ArrayList;

// разбойник (вор)
public class Outlaw extends Person{

    public Outlaw(String name, int x, int y){
        super(name, x, y);
        initiative = 2;
    }

    // Разбойник во время хода будет бить и грабить вражеского персонажа, который будет от него на
    // расстоянии одного хода (дистанция менее 1.5). Если таких врагов не обнаружено, то он делает
    // ход в сторону ближайшего врага.
    @Override
    public void step(GameTeamWhite white, GameTeamBlack black){
        ArrayList<Person> arrPerson = new ArrayList<Person>();
        if (white.teamPersons.contains(this)){
            arrPerson.addAll(black.teamPersons);
        } else{
            arrPerson.addAll(white.teamPersons);
        }
        if (this.position.distance(this.position, theClosestEnemy(white, black).position) < 1.5){
            beat(theClosestEnemy(white, black));
            rob(theClosestEnemy(white, black));
        } else {
            this.position.movingPerson(this.position.vectorPerson(this.position, theClosestEnemy(white, black).position));
        }

    }
    // действие побить
    public void beat(Person person){
        person.health = person.health - 20;
    }

    // действие ограбить
    public void rob(Person person) {
        if (person instanceof Peasant){
          //  ((Peasant) person).spearNumber -= 1;
          //  ((Peasant) person).arrowNumber -= 1;
        }
        if (person instanceof Spearman){
            ((Spearman) person).spearNumber -= 1;
        }
        if (person instanceof Crossbowman){
            ((Crossbowman) person).arrowNumber -= 1;
        }
        if (person instanceof Sniper){
            ((Sniper) person).arrowNumber -= 1;
        }
    }
    public void statusOutput(){
        System.out.println(this.getNamePerson() + " " + "Health = " + this.health);
    }

    @Override
    public String getInfo() {
        return "Outlaw";
    }
    public Person theClosestEnemy(GameTeamWhite white, GameTeamBlack black){
        ArrayList<Person> arrPerson = new ArrayList<Person>();
        if (white.teamPersons.contains(this)){
            arrPerson.addAll(black.teamPersons);
        } else{
            arrPerson.addAll(white.teamPersons);
        }

        Double[] tempArr = new Double[arrPerson.size()];
        for (int i = 0; i < arrPerson.size(); i++){
            tempArr[i] = this.position.distance(this.position, arrPerson.get(i).position);
        }
        Person tempPerson = arrPerson.get(0);
        double min = tempArr[0];
        for (int j = 1; j < arrPerson.size(); j++){
            if (tempArr[j] < min){
                min = tempArr[j];
                tempPerson = arrPerson.get(j);
            }
        }
        return tempPerson;
    }



}
