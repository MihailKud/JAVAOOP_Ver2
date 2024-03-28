package units;

/*
public class View {

    public static void view(Game game){

        System.out.println("Step number " + game.moveCounter);
        System.out.println("The white team");
        for (Person unit : game.commandWhite.teamPersons) unit.statusOutput();
        System.out.println("The black team");
        for (Person unit : game.commandBlack.teamPersons) unit.statusOutput();
    }
*/

import java.util.ArrayList;
import java.util.Collections;

public class View {
        private static int step = 1;
        private static int l = 0;
        private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
        private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
        private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");
        private static void tabSetter(int cnt, int max){
            int dif = max - cnt + 2;
            if (dif>0) System.out.printf("%" + dif + "s", ":\t"); else System.out.print(":\t");
        }
        private static String formatDiv(String str) {
            return str.replace('a', '┌')
                      .replace('b', '\u252c')
                      .replace('c', '\u2510')
                      .replace('d', '\u251c')
                      .replace('e', '\u253c')
                      .replace('f', '\u2524')
                      .replace('g', '\u2514')
                      .replace('h', '\u2534')
                      .replace('i', '\u2518')
                      .replace('-', '\u2500');
        }
        private static String getChar(Game g, int x, int y){
            String out = "| ";
            for (Person human: g.tempAllTeam) {
                if (human.position.x == x && human.position.y == y){
                    if (human.health == 0) {
                        out = "|" + (AnsiColors.ANSI_RED + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                        break;
                    }
                    if (g.commandBlack.teamPersons.contains(human)){
                        out = "|" + (AnsiColors.ANSI_GREEN + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                    }
                    if (g.commandWhite.teamPersons.contains(human)){
                        out = "|" + (AnsiColors.ANSI_BLUE + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                    }
                    break;
                }
            }
             return out;
        }
        public static void view(Game game) {
            if (step == 1 ){
                System.out.print(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
            } else {
                System.out.print(AnsiColors.ANSI_RED + "Step:" + step + AnsiColors.ANSI_RESET);
            }
            step++;
            game.tempAllTeam.forEach((v) -> l = Math.max(l, v.toString().length()));
            System.out.print("_".repeat(l*2));
            System.out.println();
            System.out.print(top10 + "    ");
            System.out.print("Blue side");
            //for (int i = 0; i < l[0]-9; i++)
            System.out.print(" ".repeat(l-9));
            System.out.println(":\tGreen side");
            for (int i = 0; i < 10; i++) {
                System.out.print(getChar(game,0, i));
            }
            System.out.print("|    ");
            System.out.print(game.commandWhite.teamPersons.get(0));
            tabSetter(game.commandWhite.teamPersons.get(0).toString().length(), l);
            System.out.println(game.commandBlack.teamPersons.get(0));
            System.out.println(midl10);

            for (int i = 1; i < 9; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(getChar(game, i, j));
                }
                System.out.print("|    ");
                System.out.print(game.commandWhite.teamPersons.get(i));
                tabSetter(game.commandWhite.teamPersons.get(i).toString().length(), l);
                System.out.println(game.commandBlack.teamPersons.get(i));
                System.out.println(midl10);
            }
            for (int j = 0; j < 10; j++) {
                System.out.print(getChar(game, 9, j));
            }
            System.out.print("|    ");
            System.out.print(game.commandWhite.teamPersons.get(9));
            tabSetter(game.commandWhite.teamPersons.get(9).toString().length(), l);
            System.out.println(game.commandBlack.teamPersons.get(9));
            System.out.println(bottom10);
        }
    }  


