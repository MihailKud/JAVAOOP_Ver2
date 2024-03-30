import units.*;

public class Main {
    public static void main(String[] args) {
        Game t = new Game("BB", "WW");
        System.out.println("-----------------------------------");
        // делаем десять ходов.
        for (int i=0; i < 10; i++){
            View.view(t);
            t.action();
        }
    }
}