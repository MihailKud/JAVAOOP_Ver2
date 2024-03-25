package units;

import java.util.ArrayList;

// арбалетчик
public class Crossbowman extends Person{
    protected Integer arrowNumber; // количество стрел у арбалетчика
    public Crossbowman(String name, int x, int y){
        super(name, x, y);
        arrowNumber = 1;
        initiative = 3;
    }

    @Override
    // метод "step()" арбалетчика.
    // если он жив и у него есть стрелы, то при условии, что дистанция до ближайшего противника менее 1.5
    // (противник находится в досягаемости по одному из восьми направлений удара) арбалетчик атакует этого
    // противника. Если же дистанция превосходит это значение, то осуществляется вычисление направления
    // ближайшего противника и перемещение на одну единицу (из четырех направлений) в его сторону.
    // методы определения направления и перемещения установлены в классе LocationOfThePosition.
    public void step(GameTeamWhite white, GameTeamBlack black){
        if (this.aliveAndArrows()){
            if (this.position.distance(this.position, theClosestEnemy(white, black).position) < 1.5){
                attack(theClosestEnemy(white, black));
            } else {
                this.position.movingPerson(this.position.vectorPerson(this.position, theClosestEnemy(white, black).position));
            }
        }
    }
    // действие "атака". Действие уменьшает значение поля health (здоровье) атакуемого на 5 единиц.
    // Сложные формулы (значение урона зависит от силы атакующего и т.п.) на данном этапе не реализовывал.
    // количество стрел уменьшается на 1
    public void attack(Person attackPerson){
        attackPerson.health = attackPerson.health - 5;
        this.arrowNumber -= 1;
    }
    // функция проверки "жив" и "есть стрелы"
    Boolean aliveAndArrows(){
        return (this.health > 0) & (this.arrowNumber > 0);
    }

    // метод поиска ближайшего противника
    public Person theClosestEnemy(GameTeamWhite white, GameTeamBlack black){
        ArrayList<Person> arrPerson;
        if (white.teamPersons.contains(this)){
            arrPerson = black.teamPersons;
        } else{
            arrPerson = white.teamPersons;
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
    public void statusOutput(){
        System.out.println(this.getNamePerson() + " " + "Arrows = " + this.arrowNumber
                + " Health = " + this.health);
    }

    @Override
    public String getInfo() {
        return "Арбалетчик";
    }

}

