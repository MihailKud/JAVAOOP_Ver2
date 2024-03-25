package units;

// разбойник (вор)
public class Outlaw extends Person{

    public Outlaw(String name, int x, int y){
        super(name, x, y);
        initiative = 2;
    }
    @Override
    public void step(GameTeamWhite white, GameTeamBlack black){

    }
    // действие побить
    public void beat(Person person){
        person.health = person.health - 1;
    }
    // действие ограбить
    public void rob(Person person) {
        if (person instanceof Peasant){
            ((Peasant) person).spearNumber -= 1;
            ((Peasant) person).arrowNumber -= 1;
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
        return "Разбойник";
    }
}
