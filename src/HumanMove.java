import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HumanMove {

    public static ArrayList<Battleship> myBattleships = new ArrayList<Battleship>();

    public static void move() throws IOException {

        int number = 0;

        for(int i = 0; i < 10; i++){
            myBattleships.add(i, new Battleship());
        }

        SeaWars.printFields();
        System.out.println("Необходимо расставить корабли на поле.\n");
        do {
            switch (number) {
                case 0:
                    myBattleships.get(number).health = 4;
                    myBattleships.get(number).number = number;
                    myBattleships.get(number).symbol = '0';
                    Battleship.standMyShips(number);
                    Battleship.dotPaintForMyShips(number, myBattleships.get(number).health);
                    break;
                case 1:
                    myBattleships.get(number).health = 3;
                    myBattleships.get(number).number = number;
                    myBattleships.get(number).symbol = '1';
                    Battleship.standMyShips(number);
                    Battleship.dotPaintForMyShips(number, myBattleships.get(number).health);
                    break;
                case 2:
                    myBattleships.get(number).health = 3;
                    myBattleships.get(number).number = number;
                    myBattleships.get(number).symbol = '2';
                    Battleship.standMyShips(number);
                    Battleship.dotPaintForMyShips(number, myBattleships.get(number).health);
                    break;
                case 3:
                    myBattleships.get(number).health = 2;
                    myBattleships.get(number).number = number;
                    myBattleships.get(number).symbol = '3';
                    Battleship.standMyShips(number);
                    Battleship.dotPaintForMyShips(number, myBattleships.get(number).health);
                    break;
                case 4:
                    myBattleships.get(number).health = 2;
                    myBattleships.get(number).number = number;
                    myBattleships.get(number).symbol = '4';
                    Battleship.standMyShips(number);
                    Battleship.dotPaintForMyShips(number, myBattleships.get(number).health);
                    break;
                case 5:
                    myBattleships.get(number).health = 2;
                    myBattleships.get(number).number = number;
                    myBattleships.get(number).symbol = '5';
                    Battleship.standMyShips(number);
                    Battleship.dotPaintForMyShips(number, myBattleships.get(number).health);
                    break;
                case 6:
                    myBattleships.get(number).health = 1;
                    myBattleships.get(number).number = number;
                    myBattleships.get(number).symbol = '6';
                    Battleship.standMyShips(number);
                    Battleship.dotPaintForMyShips(number, myBattleships.get(number).health);
                    break;
                case 7:
                    myBattleships.get(number).health = 1;
                    myBattleships.get(number).number = number;
                    myBattleships.get(number).symbol = '7';
                    Battleship.standMyShips(number);
                    Battleship.dotPaintForMyShips(number, myBattleships.get(number).health);
                    break;
                case 8:
                    myBattleships.get(number).health = 1;
                    myBattleships.get(number).number = number;
                    myBattleships.get(number).symbol = '8';
                    Battleship.standMyShips(number);
                    Battleship.dotPaintForMyShips(number, myBattleships.get(number).health);
                    break;
                case 9:
                    myBattleships.get(number).health = 1;
                    myBattleships.get(number).number = number;
                    myBattleships.get(number).symbol = '9';
                    Battleship.standMyShips(number);
                    Battleship.dotPaintForMyShips(number, myBattleships.get(number).health);
                    break;
            }
            number++;
            SeaWars.printFields();
        } while(number < 10);

    }

    public static void shoot() throws IOException {

        int x = -1, y = -1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(y < 0 || y > 9 || x < 0 || x > 9 || SeaWars.enemyFieldForMy[y][x] != ' ') {
            System.out.println("Enter row (0 - 9):");
            y = Integer.parseInt(reader.readLine());
            System.out.println("Enter column (0 - 9):");
            x = Integer.parseInt(reader.readLine());
            if(y < 0 || y > 9 || x < 0 || x > 9) {
                System.out.println("Out of field. Re-enter, please.");
                SeaWars.printFields();
                continue;
            }
            if(SeaWars.enemyFieldForMy[y][x] != ' '){
                System.out.println("This point is checked. Re-enter, please.");
                SeaWars.printFields();
                continue;
            }
        }
        if(SeaWars.enemyField[y][x] != ' ' && SeaWars.enemyField[y][x] != '#') {
            CompMove.enemyBattleships.get(Integer.parseInt(Character.toString(SeaWars.enemyField[y][x]))).health--;
            SeaWars.enemyFieldForMy[y][x] = '#';
            SeaWars.enemyField[y][x] = '#';
        }
        if(SeaWars.enemyField[y][x] == ' ') {
            SeaWars.enemyFieldForMy[y][x] = '·';
        }
    }

}
