package units;

import java.util.ArrayList;
import java.util.Random;

//крестьянин.
public class Peasant extends Person {
    protected Integer spearNumber; // количество заготовленных копий для копейщика у крестьянина
    protected Integer arrowNumber; // количество заготовленных стрел для арбалета и снайпера


    public Peasant(String name, int x, int y) {
        super(name, x, y);
        spearNumber = 2;
        arrowNumber = 2;
        initiative = 0;
    }

    /**
    * Передает стрелу случайно выбранному снайперу или арбалетчику
    */
    @Override
    public void step(GameTeamWhite white, GameTeamBlack black) {
        ArrayList<Person> arrPerson = new ArrayList<Person>();
        if (white.teamPersons.contains(this)){
            arrPerson.addAll(white.teamPersons);
        } else{
            arrPerson.addAll(black.teamPersons);
        }
        for (int i = 0; i < arrPerson.size(); i++) {
            if (!((arrPerson.get(i) instanceof Crossbowman) || (arrPerson.get(i) instanceof Sniper))){
                arrPerson.remove(arrPerson.get(i));
                i--;
            }
        }
        transferArrow(arrPerson.get(new Random().nextInt(0, arrPerson.size())));
    }

    // действие производство стрелы
    public void arrowProduction() {
        this.arrowNumber = this.arrowNumber + 1;
    }

    // действие производство копья
    public void spearProduction() {
        this.spearNumber = this.spearNumber + 1;
    }

    //действие передать стрелу арбалетчику или снайперу
    public void transferArrow(Person person) {
        if ((this.arrowNumber > 0) & (person instanceof Sniper)) {
           ((Sniper) person).arrowNumber += 1;
        }
        if ((this.arrowNumber > 0) & (person instanceof Crossbowman)) {
           ((Crossbowman) person).arrowNumber += 1;
        }
    }
    //действие передать копье копейщику
    public void transferSpear(Person person){
        if ((this.spearNumber > 0) & (person instanceof Spearman)){
            this.spearNumber = this.spearNumber - 1;
            ((Spearman) person).spearNumber += 1;
        }
    }
    public void statusOutput(){
        System.out.println(this.getNamePerson() + " " + "Health = " + this.health);
    }

    @Override
    public String getInfo() {
        return "Peasant";
    }
}
