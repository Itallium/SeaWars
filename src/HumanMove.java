import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HumanMove {

    public static ArrayList<Battleship> myBattleships = new ArrayList<Battleship>();

    public static void stand() throws IOException {

        int number = 0;
        for(int i = 0; i < 10; i++){
            myBattleships.add(i, new Battleship());
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SeaWars.printFields();
        System.out.println("Необходимо расставить корабли на поле.\n");
        do {
            switch (number) {
                case 0:
                    System.out.println("Необходимо поставить 4-х палубный корабль.\n Ввод координат:");
                    do {
                        System.out.println("Введите строку:");
                        myBattleships.get(number).y = Integer.parseInt(reader.readLine());
                        System.out.println("Введите столбец:");
                        myBattleships.get(number).x = Integer.parseInt(reader.readLine());
                        if(myBattleships.get(number).y < 0 || myBattleships.get(number).y > 9 || myBattleships.get(number).x < 0 || myBattleships.get(number).x > 9) {
                            System.out.println("Вы вышли за пределы поля. Повторите ввод");
                            continue;
                        }

                        System.out.println("1 - горизонтально, 2 - вертикально");
                        if (Integer.parseInt(reader.readLine()) == 1) myBattleships.get(number).orientation = "horizontal";
                        else myBattleships.get(number).orientation = "vertical";

                        if(myBattleships.get(number).orientation.equals("vertical") && (myBattleships.get(number).y + 4 - 1) > 9) {
                            System.out.println("Корабль выходит за пределы поля. Повторите ввод");
                            myBattleships.get(number).y = -1;
                            continue;
                        }

                        if(myBattleships.get(number).orientation.equals("horizontal") && (myBattleships.get(number).x + 4 - 1) > 9) {
                            System.out.println("Корабль выходит за пределы поля. Повторите ввод");
                            myBattleships.get(number).y = -1;
                            continue;
                        }
                    } while(myBattleships.get(number).y < 0 || myBattleships.get(number).y > 9 || myBattleships.get(number).x < 0 || myBattleships.get(number).x > 9);
                    myBattleships.get(number).health = 4;
                    myBattleships.get(number).number = number;

                    if (myBattleships.get(number).orientation.equals("horizontal")) {
                        for(int i = myBattleships.get(number).x; i < myBattleships.get(number).x + myBattleships.get(number).health; i++) {
                            SeaWars.myField[myBattleships.get(number).y][i] = '0';
                            if(myBattleships.get(number).y > 0) SeaWars.myField[myBattleships.get(number).y-1][i] = '%';
                            if(myBattleships.get(number).y < 9) SeaWars.myField[myBattleships.get(number).y+1][i] = '%';
                        }
                    } else {
                        for(int i = myBattleships.get(number).y; i < myBattleships.get(number).y + myBattleships.get(number).health; i++) {
                            SeaWars.myField[i][myBattleships.get(number).x] = '0';
                            if(myBattleships.get(number).x > 0) SeaWars.myField[i][myBattleships.get(number).x-1] = '%';
                            if(myBattleships.get(number).x < 9) SeaWars.myField[i][myBattleships.get(number).x+1] = '%';
                        }
                    }

                    Battleship.dotPaint(number);
                    break;
                case 1:
                    System.out.println("Необходимо поставить 3-х палубный корабль.\n Ввод координат:");
                    do {
                        System.out.println("Введите строку:");
                        myBattleships.get(number).y = Integer.parseInt(reader.readLine());
                        System.out.println("Введите столбец:");
                        myBattleships.get(number).x = Integer.parseInt(reader.readLine());

                        if(myBattleships.get(number).y < 0 || myBattleships.get(number).y > 9 || myBattleships.get(number).x < 0 || myBattleships.get(number).x > 9) {
                            System.out.println("Вы вышли за пределы поля. Повторите ввод");
                            continue;
                        }

                        System.out.println("1 - горизонтально, 2 - вертикально");
                        if (Integer.parseInt(reader.readLine()) == 1) myBattleships.get(number).orientation = "horizontal";
                        else myBattleships.get(number).orientation = "vertical";

                        if(myBattleships.get(number).orientation.equals("vertical") && (myBattleships.get(number).y + 4 - 1) > 9) {
                            System.out.println("Корабль выходит за пределы поля. Повторите ввод");
                            myBattleships.get(number).y = -1;
                            continue;
                        }

                        if(myBattleships.get(number).orientation.equals("horizontal") && (myBattleships.get(number).x + 4 - 1) > 9) {
                            System.out.println("Корабль выходит за пределы поля. Повторите ввод");
                            myBattleships.get(number).y = -1;
                            continue;
                        }
                    } while(myBattleships.get(number).y < 0 || myBattleships.get(number).y > 9 || myBattleships.get(number).x < 0 || myBattleships.get(number).x > 9);
                    myBattleships.get(number).health = 3;
                    myBattleships.get(number).number = number;
                    if (myBattleships.get(number).orientation.equals("horizontal")) {
                        for(int i = myBattleships.get(number).x; i < myBattleships.get(number).x + myBattleships.get(number).health; i++) {
                            SeaWars.myField[myBattleships.get(number).y][i] = '1';
                        }
                    } else {
                        for(int i = myBattleships.get(number).y; i < myBattleships.get(number).y + myBattleships.get(number).health; i++) {
                            SeaWars.myField[i][myBattleships.get(number).x] = '1';
                        }
                    }
                    break;
                case 2:
                    System.out.println("Необходимо поставить 3-х палубный корабль.\n Ввод координат:");
                    do {
                        System.out.println("Введите строку:");
                        myBattleships.get(number).y = Integer.parseInt(reader.readLine());
                        System.out.println("Введите столбец:");
                        myBattleships.get(number).x = Integer.parseInt(reader.readLine());

                        if(myBattleships.get(number).y < 0 || myBattleships.get(number).y > 9 || myBattleships.get(number).x < 0 || myBattleships.get(number).x > 9) {
                            System.out.println("Вы вышли за пределы поля. Повторите ввод");
                            continue;
                        }

                        System.out.println("1 - горизонтально, 2 - вертикально");
                        if (Integer.parseInt(reader.readLine()) == 1) myBattleships.get(number).orientation = "horizontal";
                        else myBattleships.get(number).orientation = "vertical";

                        if(myBattleships.get(number).orientation.equals("vertical") && (myBattleships.get(number).y + 4 - 1) > 9) {
                            System.out.println("Корабль выходит за пределы поля. Повторите ввод");
                            myBattleships.get(number).y = -1;
                            continue;
                        }

                        if(myBattleships.get(number).orientation.equals("horizontal") && (myBattleships.get(number).x + 4 - 1) > 9) {
                            System.out.println("Корабль выходит за пределы поля. Повторите ввод");
                            myBattleships.get(number).y = -1;
                            continue;
                        }
                    } while(myBattleships.get(number).y < 0 || myBattleships.get(number).y > 9 || myBattleships.get(number).x < 0 || myBattleships.get(number).x > 9);
                    myBattleships.get(number).health = 3;
                    myBattleships.get(number).number = number;
                    if (myBattleships.get(number).orientation.equals("vertical")) {
                        for(int i = myBattleships.get(number).x; i < myBattleships.get(number).x + myBattleships.get(number).health; i++) {
                            SeaWars.myField[myBattleships.get(number).y][i] = '2';
                        }
                    } else {
                        for(int i = myBattleships.get(number).y; i < myBattleships.get(number).y + myBattleships.get(number).health; i++) {
                            SeaWars.myField[i][myBattleships.get(number).x] = '2';
                        }
                    }
                    break;
            }
//            number++;
            SeaWars.printFields();
        } while(number < 3);

    }

    public static void move() throws IOException {

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
        if(SeaWars.enemyField[y][x] == '@') {
            SeaWars.enemyFieldForMy[y][x] = '@';
        }
        if(SeaWars.enemyField[y][x] == ' ') {
            SeaWars.enemyFieldForMy[y][x] = '·';
        }
    }

}
