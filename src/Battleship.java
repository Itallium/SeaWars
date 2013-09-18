import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Battleship {

    int x = 0, y = 0;
    int health = 0;
    int number = 0;
    String orientation = "vertical";
    char symbol = '!';

    public static void dotPaintForMyShips(int shipNumber, int shipHealth) {

        if (HumanMove.myBattleships.get(shipNumber).orientation.equals("horizontal")) {
            for(int i = HumanMove.myBattleships.get(shipNumber).x; i < HumanMove.myBattleships.get(shipNumber).x + HumanMove.myBattleships.get(shipNumber).health; i++) {
                SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y][i] = HumanMove.myBattleships.get(shipNumber).symbol;
                if(HumanMove.myBattleships.get(shipNumber).y > 0) SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y-1][i] = '%';
                if(HumanMove.myBattleships.get(shipNumber).y < 9) SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y+1][i] = '%';
            }
        } else {
            for(int i = HumanMove.myBattleships.get(shipNumber).y; i < HumanMove.myBattleships.get(shipNumber).y + HumanMove.myBattleships.get(shipNumber).health; i++) {
                SeaWars.myField[i][HumanMove.myBattleships.get(shipNumber).x] = HumanMove.myBattleships.get(shipNumber).symbol;
                if(HumanMove.myBattleships.get(shipNumber).x > 0) SeaWars.myField[i][HumanMove.myBattleships.get(shipNumber).x-1] = '%';
                if(HumanMove.myBattleships.get(shipNumber).x < 9) SeaWars.myField[i][HumanMove.myBattleships.get(shipNumber).x+1] = '%';
            }
        }

        if(HumanMove.myBattleships.get(shipNumber).orientation.equals("horizontal")) {
            if(HumanMove.myBattleships.get(shipNumber).x >= 0 && HumanMove.myBattleships.get(shipNumber).x < (10 - shipHealth)) {
                if(HumanMove.myBattleships.get(shipNumber).y > 0) SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y - 1][HumanMove.myBattleships.get(shipNumber).x + shipHealth] = '%';
                SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y][HumanMove.myBattleships.get(shipNumber).x + shipHealth] = '%';
                if(HumanMove.myBattleships.get(shipNumber).y < 9) SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y + 1][HumanMove.myBattleships.get(shipNumber).x + shipHealth] = '%';
            }

            if(HumanMove.myBattleships.get(shipNumber).x <= (10 - shipHealth) && HumanMove.myBattleships.get(shipNumber).x > 0) {
                if(HumanMove.myBattleships.get(shipNumber).y > 0) SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y - 1][HumanMove.myBattleships.get(shipNumber).x - 1] = '%';
                SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y][HumanMove.myBattleships.get(shipNumber).x - 1] = '%';
                if(HumanMove.myBattleships.get(shipNumber).y < 9) SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y + 1][HumanMove.myBattleships.get(shipNumber).x - 1] = '%';
            }
        }

        if(HumanMove.myBattleships.get(shipNumber).orientation.equals("vertical")) {
            if(HumanMove.myBattleships.get(shipNumber).y >= 0 && HumanMove.myBattleships.get(shipNumber).y < (10 - shipHealth)) {
                if(HumanMove.myBattleships.get(shipNumber).x > 0) SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y + shipHealth][HumanMove.myBattleships.get(shipNumber).x - 1] = '%';
                SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y + shipHealth][HumanMove.myBattleships.get(shipNumber).x] = '%';
                if(HumanMove.myBattleships.get(shipNumber).x < 9) SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y + shipHealth][HumanMove.myBattleships.get(shipNumber).x + 1] = '%';
            }

            if(HumanMove.myBattleships.get(shipNumber).y <= (10 - shipHealth) && HumanMove.myBattleships.get(shipNumber).y > 0) {
                if(HumanMove.myBattleships.get(shipNumber).x > 0) SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y - 1][HumanMove.myBattleships.get(shipNumber).x - 1] = '%';
                SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y - 1][HumanMove.myBattleships.get(shipNumber).x] = '%';
                if(HumanMove.myBattleships.get(shipNumber).x < 9) SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y - 1][HumanMove.myBattleships.get(shipNumber).x + 1] = '%';
            }
        }

    }

    public static void standMyShips(int shipNumber) throws IOException {

        System.out.println("Необходимо поставить корабль на " + HumanMove.myBattleships.get(shipNumber).health + " палубы.\n Ввод координат:");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("Введите строку:");
            HumanMove.myBattleships.get(shipNumber).y = Integer.parseInt(reader.readLine());
            System.out.println("Введите столбец:");
            HumanMove.myBattleships.get(shipNumber).x = Integer.parseInt(reader.readLine());
            if(HumanMove.myBattleships.get(shipNumber).y < 0 || HumanMove.myBattleships.get(shipNumber).y > 9 || HumanMove.myBattleships.get(shipNumber).x < 0 || HumanMove.myBattleships.get(shipNumber).x > 9) {
                System.out.println("Вы вышли за пределы поля. Повторите ввод");
                continue;
            }

            System.out.println("1 - горизонтально, 2 - вертикально");
            if (Integer.parseInt(reader.readLine()) == 1) HumanMove.myBattleships.get(shipNumber).orientation = "horizontal";
            else HumanMove.myBattleships.get(shipNumber).orientation = "vertical";

            if(HumanMove.myBattleships.get(shipNumber).orientation.equals("vertical") && (HumanMove.myBattleships.get(shipNumber).y + HumanMove.myBattleships.get(shipNumber).health - 1) > 9) {
                System.out.println("Корабль выходит за пределы поля. Повторите ввод");
                HumanMove.myBattleships.get(shipNumber).y = -1;
                continue;
            }

            if(HumanMove.myBattleships.get(shipNumber).orientation.equals("horizontal") && (HumanMove.myBattleships.get(shipNumber).x + HumanMove.myBattleships.get(shipNumber).health - 1) > 9) {
                System.out.println("Корабль выходит за пределы поля. Повторите ввод");
                HumanMove.myBattleships.get(shipNumber).y = -1;
                continue;
            }

            if(HumanMove.myBattleships.get(shipNumber).orientation.equals("vertical")) {
                for(int i = HumanMove.myBattleships.get(shipNumber).y; i < HumanMove.myBattleships.get(shipNumber).y + HumanMove.myBattleships.get(shipNumber).health; i++) {
                    if(SeaWars.myField[i][HumanMove.myBattleships.get(shipNumber).x] != ' ') {
                        System.out.println("Недопустимая позиция для корабля. Повторите ввод");
                        HumanMove.myBattleships.get(shipNumber).y = -1;
                        break;
                    }
                }
            }

            if(HumanMove.myBattleships.get(shipNumber).orientation.equals("horizontal") && HumanMove.myBattleships.get(shipNumber).y != -1) {
                for(int i = HumanMove.myBattleships.get(shipNumber).x; i < HumanMove.myBattleships.get(shipNumber).x + HumanMove.myBattleships.get(shipNumber).health; i++) {
                    if(SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y][i] != ' ') {
                        System.out.println("Недопустимая позиция для корабля. Повторите ввод");
                        HumanMove.myBattleships.get(shipNumber).y = -1;
                        break;
                    }
                }
            }

        } while(HumanMove.myBattleships.get(shipNumber).y < 0 || HumanMove.myBattleships.get(shipNumber).y > 9 || HumanMove.myBattleships.get(shipNumber).x < 0 || HumanMove.myBattleships.get(shipNumber).x > 9);
    }

    public static void dotPaintForEnemyShips(int shipNumber, int shipHealth) {

        if (CompMove.enemyBattleships.get(shipNumber).orientation.equals("horizontal")) {
            for(int i = CompMove.enemyBattleships.get(shipNumber).x; i < CompMove.enemyBattleships.get(shipNumber).x + CompMove.enemyBattleships.get(shipNumber).health; i++) {
                SeaWars.enemyField[CompMove.enemyBattleships.get(shipNumber).y][i] = CompMove.enemyBattleships.get(shipNumber).symbol;
                if(CompMove.enemyBattleships.get(shipNumber).y > 0) SeaWars.enemyField[CompMove.enemyBattleships.get(shipNumber).y-1][i] = '%';
                if(CompMove.enemyBattleships.get(shipNumber).y < 9) SeaWars.enemyField[CompMove.enemyBattleships.get(shipNumber).y+1][i] = '%';
            }
        } else {
            for(int i = CompMove.enemyBattleships.get(shipNumber).y; i < CompMove.enemyBattleships.get(shipNumber).y + CompMove.enemyBattleships.get(shipNumber).health; i++) {
                SeaWars.enemyField[i][CompMove.enemyBattleships.get(shipNumber).x] = CompMove.enemyBattleships.get(shipNumber).symbol;
                if(CompMove.enemyBattleships.get(shipNumber).x > 0) SeaWars.enemyField[i][CompMove.enemyBattleships.get(shipNumber).x-1] = '%';
                if(CompMove.enemyBattleships.get(shipNumber).x < 9) SeaWars.enemyField[i][CompMove.enemyBattleships.get(shipNumber).x+1] = '%';
            }
        }

        if(CompMove.enemyBattleships.get(shipNumber).orientation.equals("horizontal")) {
            if(CompMove.enemyBattleships.get(shipNumber).x >= 0 && CompMove.enemyBattleships.get(shipNumber).x < (10 - shipHealth)) {
                if(CompMove.enemyBattleships.get(shipNumber).y > 0) SeaWars.enemyField[CompMove.enemyBattleships.get(shipNumber).y - 1][CompMove.enemyBattleships.get(shipNumber).x + shipHealth] = '%';
                SeaWars.enemyField[CompMove.enemyBattleships.get(shipNumber).y][CompMove.enemyBattleships.get(shipNumber).x + shipHealth] = '%';
                if(CompMove.enemyBattleships.get(shipNumber).y < 9) SeaWars.enemyField[CompMove.enemyBattleships.get(shipNumber).y + 1][CompMove.enemyBattleships.get(shipNumber).x + shipHealth] = '%';
            }

            if(CompMove.enemyBattleships.get(shipNumber).x <= (10 - shipHealth) && CompMove.enemyBattleships.get(shipNumber).x > 0) {
                if(CompMove.enemyBattleships.get(shipNumber).y > 0) SeaWars.enemyField[CompMove.enemyBattleships.get(shipNumber).y - 1][CompMove.enemyBattleships.get(shipNumber).x - 1] = '%';
                SeaWars.enemyField[CompMove.enemyBattleships.get(shipNumber).y][CompMove.enemyBattleships.get(shipNumber).x - 1] = '%';
                if(CompMove.enemyBattleships.get(shipNumber).y < 9) SeaWars.enemyField[CompMove.enemyBattleships.get(shipNumber).y + 1][CompMove.enemyBattleships.get(shipNumber).x - 1] = '%';
            }
        }

        if(CompMove.enemyBattleships.get(shipNumber).orientation.equals("vertical")) {
            if(CompMove.enemyBattleships.get(shipNumber).y >= 0 && CompMove.enemyBattleships.get(shipNumber).y < (10 - shipHealth)) {
                if(CompMove.enemyBattleships.get(shipNumber).x > 0) SeaWars.enemyField[CompMove.enemyBattleships.get(shipNumber).y + shipHealth][CompMove.enemyBattleships.get(shipNumber).x - 1] = '%';
                SeaWars.enemyField[CompMove.enemyBattleships.get(shipNumber).y + shipHealth][CompMove.enemyBattleships.get(shipNumber).x] = '%';
                if(CompMove.enemyBattleships.get(shipNumber).x < 9) SeaWars.enemyField[CompMove.enemyBattleships.get(shipNumber).y + shipHealth][CompMove.enemyBattleships.get(shipNumber).x + 1] = '%';
            }

            if(CompMove.enemyBattleships.get(shipNumber).y <= (10 - shipHealth) && CompMove.enemyBattleships.get(shipNumber).y > 0) {
                if(CompMove.enemyBattleships.get(shipNumber).x > 0) SeaWars.enemyField[CompMove.enemyBattleships.get(shipNumber).y - 1][CompMove.enemyBattleships.get(shipNumber).x - 1] = '%';
                SeaWars.enemyField[CompMove.enemyBattleships.get(shipNumber).y - 1][CompMove.enemyBattleships.get(shipNumber).x] = '%';
                if(CompMove.enemyBattleships.get(shipNumber).x < 9) SeaWars.enemyField[CompMove.enemyBattleships.get(shipNumber).y - 1][CompMove.enemyBattleships.get(shipNumber).x + 1] = '%';
            }
        }

    }

    public static void standEnemyShips(int shipNumber) throws IOException {

        int x = 0, y = 0, orientation;

        do {
            CompMove.enemyBattleships.get(shipNumber).y = (int) Math.floor(Math.random() * 10);
            CompMove.enemyBattleships.get(shipNumber).x = (int) Math.floor(Math.random() * 10);
            if(CompMove.enemyBattleships.get(shipNumber).y < 0 || CompMove.enemyBattleships.get(shipNumber).y > 9 || CompMove.enemyBattleships.get(shipNumber).x < 0 || CompMove.enemyBattleships.get(shipNumber).x > 9) {
                continue;
            }

            orientation = (int) Math.floor(Math.random() * 2);
            if (orientation == 1) CompMove.enemyBattleships.get(shipNumber).orientation = "horizontal";
            else CompMove.enemyBattleships.get(shipNumber).orientation = "vertical";

            if(CompMove.enemyBattleships.get(shipNumber).orientation.equals("vertical") && (CompMove.enemyBattleships.get(shipNumber).y + CompMove.enemyBattleships.get(shipNumber).health - 1) > 9) {
                CompMove.enemyBattleships.get(shipNumber).y = -1;
                continue;
            }

            if(CompMove.enemyBattleships.get(shipNumber).orientation.equals("horizontal") && (CompMove.enemyBattleships.get(shipNumber).x + CompMove.enemyBattleships.get(shipNumber).health - 1) > 9) {
                CompMove.enemyBattleships.get(shipNumber).y = -1;
                continue;
            }

            if(CompMove.enemyBattleships.get(shipNumber).orientation.equals("vertical")) {
                for(int i = CompMove.enemyBattleships.get(shipNumber).y; i < CompMove.enemyBattleships.get(shipNumber).y + CompMove.enemyBattleships.get(shipNumber).health; i++) {
                    if(SeaWars.enemyField[i][CompMove.enemyBattleships.get(shipNumber).x] != ' ') {
                        CompMove.enemyBattleships.get(shipNumber).y = -1;
                        break;
                    }
                }
            }

            if(CompMove.enemyBattleships.get(shipNumber).orientation.equals("horizontal") && CompMove.enemyBattleships.get(shipNumber).y != -1) {
                for(int i = CompMove.enemyBattleships.get(shipNumber).x; i < CompMove.enemyBattleships.get(shipNumber).x + CompMove.enemyBattleships.get(shipNumber).health; i++) {
                    if(SeaWars.enemyField[CompMove.enemyBattleships.get(shipNumber).y][i] != ' ') {
                        CompMove.enemyBattleships.get(shipNumber).y = -1;
                        break;
                    }
                }
            }

        } while(CompMove.enemyBattleships.get(shipNumber).y < 0 || CompMove.enemyBattleships.get(shipNumber).y > 9 || CompMove.enemyBattleships.get(shipNumber).x < 0 || CompMove.enemyBattleships.get(shipNumber).x > 9);
    }
}
