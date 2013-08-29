import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanMove {

    public static void move() throws IOException {

        int x = -1, y = -1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(y < 0 || y > 9 || x < 0 || x > 9 || SeaWars.enemyFieldForMy[y][x] != ' ') {
            System.out.println("Введите строку (0 - 9):");
            y = Integer.parseInt(reader.readLine());
            System.out.println("Введите столбец (0 - 9):");
            x = Integer.parseInt(reader.readLine());
            if(y < 0 || y > 9 || x < 0 || x > 9) {
                System.out.println("Вы попали за пределы поля. Повторите ввод.");
                SeaWars.printFields();
                continue;
            }
            if(SeaWars.enemyFieldForMy[y][x] != ' '){
                System.out.println("Данная клетка уже проверена. Повторите ввод.");
                SeaWars.printFields();
                continue;
            }
        }
        if(SeaWars.enemyField[y][x] == '@') {
            SeaWars.enemyFieldForMy[y][x] = '@';
        }
        if(SeaWars.enemyField[y][x] == ' ') {
            SeaWars.enemyFieldForMy[y][x] = '·';
        }
    }

    public static void standShips() {

    }
}
