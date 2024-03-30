package units;

import java.util.ArrayList;

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
        ArrayList<Person> arrPerson = new ArrayList<Person>();
        if (white.teamPersons.contains(this)){
            arrPerson.addAll(white.teamPersons);
        } else{
            arrPerson.addAll(black.teamPersons);
        }
        for (int i = 0; i < arrPerson.size(); i++) {
            if (arrPerson.get(i) instanceof Monk){
                arrPerson.remove(arrPerson.get(i));
                i--;
            }
        }
        // Лечим персонажа в своей команде, у которого показатель
        // здоровья минимален, но более 0 (то есть, он был ранее атакован, не погиб, но обладает
        // минимальным здоровьем). При этом в случае если маны
        // не хватает, то мы не лечим, а накапливаем ману.
        // Мана, затрачиваемая на лечение, составляет 15
        int minHealth = 100;
        Person tempP = null;
        if  (this.mana > 15) {
            for (Person person : arrPerson) {
                if ((person.health < minHealth) && (person.health > 0)) {
                    minHealth = person.health;
                    tempP = person;
                }
            }
            if (tempP != null){
                toHeal(tempP);
            }
        } else {
            accumulateMana();
        }
    }
    // действие лечить
    public void toHeal(Person person) {
            person.health += 40;
            this.mana -= 15;
    }
    public void statusOutput(){
        System.out.println(this.getNamePerson() + " " + "Mana = " + this.mana
                + " Health = " + this.health);
    }

    @Override
    public String getInfo() {
        return "Monk";
    }

    // действие накопить ману
    public void accumulateMana(){
        this.mana = this.mana + 5;
    }
}
