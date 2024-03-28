package units;

import java.util.ArrayList;

// колдун
public class Magician extends Person {
    protected Integer mana;

    public Magician(String name, int x, int y) {
        super(name, x, y);
        mana = 60;
        initiative = 1;
    }

    @Override
    public void step(GameTeamWhite white, GameTeamBlack black) {
        ArrayList<Person> arrPerson = new ArrayList<Person>();
        if (white.teamPersons.contains(this)){
            arrPerson.addAll(white.teamPersons);
        } else{
            arrPerson.addAll(black.teamPersons);
        }
        for (int i = 0; i < arrPerson.size(); i++) {
            if (arrPerson.get(i) instanceof Magician){
                arrPerson.remove(arrPerson.get(i));
                i--;
            }
        }

       // если маны больше 50, то можно запустить проверку для применения метода возрождения.
        if (this.mana >= 50) {
            int count = 0;
            for (int j = 0; j < arrPerson.size(); j++) {
                if (arrPerson.get(j).health <= 0) {
                    count++;
                    if (count == 4) {
                        toRevive(arrPerson.get(j));
                        break;
                    }
                }
            }
        }
        // Лечим первого выявленного персонажа в своей команде, у которого показатель
        // здоровья менее 100, но более 0 (то есть, он был ранее атакован и не погиб). При этом в случае если маны
        // не хватает, то мы не лечим, а накапливаем ману
       if  (this.mana > 10) {
           for (Person person : arrPerson) {
               if ((person.health < 100) & (person.health > 0)) {
                   toHeal(person);
                   break;
               }
           }
       } else {
           accumulateMana();
       }
    }
    // действие лечить
    public void toHeal(Person person) {
        if ((this.mana >= 10) & (person.health <= 0)){
            person.health = 100;
            this.mana -= 10;
        }
    }
    // действие накопить ману
    public void accumulateMana(){
        this.mana = this.mana + 5;
    }

    // действие возрождать (магия возрождения)
    public void toRevive(Person person) {
            person.health = 100;
            this.mana -= 50;
    }




    public void statusOutput(){
        System.out.println(this.getNamePerson() + " " + "Mana = " + this.mana
                + " Health = " + this.health);
    }

    @Override
    public String getInfo() {
        return "Magician";
    }

}
