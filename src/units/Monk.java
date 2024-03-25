package units;

// монах
public class Monk extends Person{
    protected Integer mana;

    public Monk(String name, int x, int y){
        super(name, x, y);
        mana = 10;
        initiative = 1;
    }
    @Override
    public void step(GameTeamWhite white, GameTeamBlack black){

    }
    // действие лечить
    public void toHeal(Person person) {
        if ((this.mana > 0) & (person.health > 0)){
            person.health += 10;
            this.mana -= 1;
        }
    }
    public void statusOutput(){
        System.out.println(this.getNamePerson() + " " + "Mana = " + this.mana
                + " Health = " + this.health);
    }

    @Override
    public String getInfo() {
        return "Монах";
    }
}
