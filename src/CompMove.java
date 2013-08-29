import java.io.IOException;

public class CompMove {

    public static void move() throws IOException {

        int x = -1, y = -1;
        while(y < 0 || y > 9 || x < 0 || x > 9 || SeaWars.myFieldForEnemy[y][x] != ' ') {
            y = (int) Math.floor(Math.random() * 10);
            x = (int) Math.floor(Math.random() * 10);
            }
        if(SeaWars.myField[y][x] == '@') {
            SeaWars.myFieldForEnemy[y][x] = '@';
            SeaWars.myField[y][x] = '#';
        }
        if(SeaWars.myField[y][x] == ' ') {
            SeaWars.myFieldForEnemy[y][x] = '·';
            SeaWars.myField[y][x] = '·';
        }
    }
}
