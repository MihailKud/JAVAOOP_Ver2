package units;

import java.util.ArrayList;

// копейщик
public class Spearman extends Person{
    protected Integer spearNumber; // количество копий у копейщика
    public Spearman(String name, int x, int y){
        super(name, x, y);
        spearNumber = 1;
        initiative =2;
    }
    @Override
    // метод "step()" копейщика.
    // если он жив и у него есть копья, то при условии, что дистанция до ближайшего противника менее 1.5
    // (противник находится в досягаемости по одному из восьми направлений удара) копейщик атакует этого
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
    public void attack(Person attackPerson){
        attackPerson.health = attackPerson.health - 8;
        this.spearNumber -= 1;
    }


    // функция проверки "жив" и "есть копья"
    Boolean aliveAndArrows(){
        return (this.health > 0) & (this.spearNumber > 0);
    }

    // поиск ближайшего противника
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

}
