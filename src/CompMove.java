import java.io.IOException;
import java.util.ArrayList;

public class CompMove {

    public static ArrayList<Battleship> enemyBattleships = new ArrayList<Battleship>();

    public static void move() throws IOException {
        int number = 0;

        for(int i = 0; i < 10; i++){
            enemyBattleships.add(i, new Battleship());
        }

        do {
            switch (number) {
                case 0:
                    enemyBattleships.get(number).health = 4;
                    enemyBattleships.get(number).number = number;
                    enemyBattleships.get(number).symbol = '0';
                    Battleship.standEnemyShips(number);
                    Battleship.dotPaintForEnemyShips(number, enemyBattleships.get(number).health);
                    break;
                case 1:
                    enemyBattleships.get(number).health = 3;
                    enemyBattleships.get(number).number = number;
                    enemyBattleships.get(number).symbol = '1';
                    Battleship.standEnemyShips(number);
                    Battleship.dotPaintForEnemyShips(number, enemyBattleships.get(number).health);
                    break;
                case 2:
                    enemyBattleships.get(number).health = 3;
                    enemyBattleships.get(number).number = number;
                    enemyBattleships.get(number).symbol = '2';
                    Battleship.standEnemyShips(number);
                    Battleship.dotPaintForEnemyShips(number, enemyBattleships.get(number).health);
                    break;
                case 3:
                    enemyBattleships.get(number).health = 2;
                    enemyBattleships.get(number).number = number;
                    enemyBattleships.get(number).symbol = '3';
                    Battleship.standEnemyShips(number);
                    Battleship.dotPaintForEnemyShips(number, enemyBattleships.get(number).health);
                    break;
                case 4:
                    enemyBattleships.get(number).health = 2;
                    enemyBattleships.get(number).number = number;
                    enemyBattleships.get(number).symbol = '4';
                    Battleship.standEnemyShips(number);
                    Battleship.dotPaintForEnemyShips(number, enemyBattleships.get(number).health);
                    break;
                case 5:
                    enemyBattleships.get(number).health = 2;
                    enemyBattleships.get(number).number = number;
                    enemyBattleships.get(number).symbol = '5';
                    Battleship.standEnemyShips(number);
                    Battleship.dotPaintForEnemyShips(number, enemyBattleships.get(number).health);
                    break;
                case 6:
                    enemyBattleships.get(number).health = 1;
                    enemyBattleships.get(number).number = number;
                    enemyBattleships.get(number).symbol = '6';
                    Battleship.standEnemyShips(number);
                    Battleship.dotPaintForEnemyShips(number, enemyBattleships.get(number).health);
                    break;
                case 7:
                    enemyBattleships.get(number).health = 1;
                    enemyBattleships.get(number).number = number;
                    enemyBattleships.get(number).symbol = '7';
                    Battleship.standEnemyShips(number);
                    Battleship.dotPaintForEnemyShips(number, enemyBattleships.get(number).health);
                    break;
                case 8:
                    enemyBattleships.get(number).health = 1;
                    enemyBattleships.get(number).number = number;
                    enemyBattleships.get(number).symbol = '8';
                    Battleship.standEnemyShips(number);
                    Battleship.dotPaintForEnemyShips(number, enemyBattleships.get(number).health);
                    break;
                case 9:
                    enemyBattleships.get(number).health = 1;
                    enemyBattleships.get(number).number = number;
                    enemyBattleships.get(number).symbol = '9';
                    Battleship.standEnemyShips(number);
                    Battleship.dotPaintForEnemyShips(number, enemyBattleships.get(number).health);
                    break;
            }
            number++;
        } while(number < 10);

    }

    public static void shoot() throws IOException {

        int x = -1, y = -1;
        while(y < 0 || y > 9 || x < 0 || x > 9 || SeaWars.myFieldForEnemy[y][x] != ' ') {
            y = (int) Math.floor(Math.random() * 10);
            x = (int) Math.floor(Math.random() * 10);
            }
        if(SeaWars.myField[y][x] != ' ' && SeaWars.myField[y][x] != '#') {
            HumanMove.myBattleships.get(Integer.parseInt(Character.toString(SeaWars.myField[y][x]))).health--;
            SeaWars.myFieldForEnemy[y][x] = '#';
            SeaWars.myField[y][x] = '#';
        }
        if(SeaWars.myField[y][x] == ' ') {
            SeaWars.myFieldForEnemy[y][x] = '·';
            SeaWars.myField[y][x] = '·';
        }
    }

}
