package units;

import static java.lang.Math.sqrt;

// класс определения координат на плоскости.
public class LocationOfThePosition {
    protected Integer x;
    protected Integer y;

    public LocationOfThePosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    // метод определения расстояния между двумя позициями
    public Double distance(LocationOfThePosition a, LocationOfThePosition b){
        return sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    // метод, определяющий направление, в котором должен переместиться персонаж
    // для приближения к противнику
    // возвращает параметр для использования в качестве входного значения для метода движения.
    public int vectorPerson(LocationOfThePosition a, LocationOfThePosition b){
        int tempX = b.x - a.x;
        int tempY = b.y - a.y;
        if (tempX > 0){
            if (tempY > tempX){
                return 3;
            } else if (tempY < -tempX){
                return 4;
            } else {
                return 1;
            }
        } else {
            if (tempY > -tempX) {
                return 3;
            } else if (tempY < tempX) {
                return 4;
            } else {
                return 2;
            }
        }
    }

    // метод "перемещение персонажа" (движение)
    // в качестве входного параметра будет использовать целое число, указывающее направление перемещения.
    public void movingPerson(int movingParam){
        switch (movingParam) {
            case 1: this.x = this.x + 1;
            break;
            case 2: this.x = this.x - 1;
            break;
            case 3: this.y = this.y + 1;
            break;
            case 4: this.y = this.y - 1;
            break;
        }
    }
}
