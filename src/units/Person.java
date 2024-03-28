package units;

public abstract class Person implements GameInterface{
    protected String name; // имя
    protected Integer health; // Здоровье
    protected Integer power; // Сила
    protected Integer age; // Возраст
    protected Integer initiative; //инициатива
    protected LocationOfThePosition position; // координаты персонажа

    public Person(String name, int x, int y){
        this.name = name;
        this.health = 100;
        this.power = 10;
        this.age = 20;
        this.position = new LocationOfThePosition(x, y);
    }
    // метод чтения имени персонажа, возвращает имя и координаты (тип String)
    public String getNamePerson(){
        return "Class " + this.getClass().getName() + " " + this.name + " " + "X= " +
                this.position.x + " " + "Y= " + this.position.y;
    }

    @Override
    public String toString() {
        return getNamePerson();
    }


}
