package units;

// колдун
public class Magician extends Person {
    protected Integer mana;

    public Magician(String name, int x, int y) {
        super(name, x, y);
        mana = 10;
        initiative = 1;
    }

    @Override
    public void step(GameTeamWhite white, GameTeamBlack black) {

    }
    // действие возрождать
    public void toRevive(Person person) {
        if ((this.mana > 0) & (person.health <= 0)){
            person.health = 100;
            this.mana -= 1;
        }
    }
    public void statusOutput(){
        System.out.println(this.getNamePerson() + " " + "Mana = " + this.mana
                + " Health = " + this.health);
    }

    @Override
    public String getInfo() {
        return "Колдун";
    }

}
