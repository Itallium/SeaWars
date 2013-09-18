import java.io.IOException;

public class SeaWars {

    public static char myField[][] = {
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
    };

    public static char enemyField[][] = {
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
    };

    public static char enemyFieldForMy[][] = {
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
    };

    public static char myFieldForEnemy[][] = {
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
    };

    public static char winner = ' ';

    public static void prepareFieldsToGame() {
        for(int i = 0; i <= 9; i++) {
            for(int j = 0; j <= 9; j++) {
                if(enemyField[i][j] == '%') enemyField[i][j] = ' ';
                if(myField[i][j] == '%') myField[i][j] = ' ';
            }
        }
    }

    public static void printFields() {
        System.out.println("       Ваш флот:            Флот врага:");
        System.out.println("  0 1 2 3 4 5 6 7 8 9     0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i <= 9; i++) {
            System.out.print(i + "|");
            for (int j = 0; j <= 9; j++) {
                if(myField[i][j] == '0' || myField[i][j] == '1' || myField[i][j] == '2' || myField[i][j] == '3' || myField[i][j] == '4' ||
                        myField[i][j] == '5' || myField[i][j] == '6' || myField[i][j] == '7' || myField[i][j] == '8' || myField[i][j] == '9') {
                    System.out.print("@|");
                } else {
                    System.out.print(myField[i][j] + "|");
                }
            }
            System.out.print("  " + i + "|");
            for (int j = 0; j <= 9; j++) {
                if(enemyField[i][j] == '0' || enemyField[i][j] == '1' || enemyField[i][j] == '2' || enemyField[i][j] == '3' || enemyField[i][j] == '4' ||
                        enemyField[i][j] == '5' || enemyField[i][j] == '6' || enemyField[i][j] == '7' || enemyField[i][j] == '8' || enemyField[i][j] == '9') {
                    System.out.print("@|");
                } else {
                    System.out.print(enemyFieldForMy[i][j] + "|");
                }
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) throws IOException {

        HumanMove.move();
        CompMove.move();
        prepareFieldsToGame();
        while(true) {
            printFields();
            HumanMove.shoot();
            if(CheckWinner.isWinner()) {
                break;
            }
            CompMove.shoot();
            if(CheckWinner.isWinner()) {
                break;
            }
        }
        if(CheckWinner.humanWinner) {
            printFields();
            System.out.println("YOU WIN!!!");
        }
        if(CheckWinner.compWinner) {
            printFields();
            System.out.println("YOU LOSE!!!");
        }
    }
}
