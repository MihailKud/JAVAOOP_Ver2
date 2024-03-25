package units;

//крестьянин, будет выполнять функцию производства оружия.
public class Peasant extends Person {
    protected Integer spearNumber; // количество заготовленных копий для копейщика у крестьянина
    protected Integer arrowNumber; // количество заготовленных стрел для арбалета и снайпера


    public Peasant(String name, int x, int y) {
        super(name, x, y);
        spearNumber = 2;
        arrowNumber = 2;
        initiative = 0;
    }

    @Override
    public void step(GameTeamWhite white, GameTeamBlack black) {

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
            this.arrowNumber = this.arrowNumber - 1;
            ((Sniper) person).arrowNumber += 1;
        }
        if ((this.arrowNumber > 0) & (person instanceof Crossbowman)) {
            this.arrowNumber = this.arrowNumber - 1;
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
        System.out.println(this.getNamePerson() + " " + "Spears = " + this.spearNumber
                + " Arrows = " + this.arrowNumber + " Health = " + this.health);
    }

    @Override
    public String getInfo() {
        return "Крестьянин";
    }
}
