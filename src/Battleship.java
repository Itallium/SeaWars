public class Battleship {

    int x = 0, y = 0;
    int health = 0;
    int number = 0;
    String orientation = "vertical";

    public static void dotPaint(int shipNumber) {

        if(HumanMove.myBattleships.get(shipNumber).orientation.equals("horizontal")) {
            if(HumanMove.myBattleships.get(shipNumber).x >= 0 && HumanMove.myBattleships.get(shipNumber).x < 6) {
                if(HumanMove.myBattleships.get(0).y > 0) SeaWars.myField[HumanMove.myBattleships.get(0).y - 1][HumanMove.myBattleships.get(shipNumber).x + 4] = '%';
                SeaWars.myField[HumanMove.myBattleships.get(0).y][HumanMove.myBattleships.get(shipNumber).x + 4] = '%';
                if(HumanMove.myBattleships.get(0).y < 9) SeaWars.myField[HumanMove.myBattleships.get(0).y + 1][HumanMove.myBattleships.get(shipNumber).x + 4] = '%';
            }

            if(HumanMove.myBattleships.get(shipNumber).x <= 6 && HumanMove.myBattleships.get(shipNumber).x > 0) {
                if(HumanMove.myBattleships.get(0).y > 0) SeaWars.myField[HumanMove.myBattleships.get(0).y - 1][HumanMove.myBattleships.get(shipNumber).x - 1] = '%';
                SeaWars.myField[HumanMove.myBattleships.get(0).y][HumanMove.myBattleships.get(shipNumber).x - 1] = '%';
                if(HumanMove.myBattleships.get(0).y < 9) SeaWars.myField[HumanMove.myBattleships.get(0).y + 1][HumanMove.myBattleships.get(shipNumber).x - 1] = '%';
            }
        }

        if(HumanMove.myBattleships.get(shipNumber).orientation.equals("vertical")) {
            if(HumanMove.myBattleships.get(shipNumber).y >= 0 && HumanMove.myBattleships.get(shipNumber).y < 6) {
                if(HumanMove.myBattleships.get(0).x > 0) SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y + 4][HumanMove.myBattleships.get(shipNumber).x - 1] = '%';
                SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y + 4][HumanMove.myBattleships.get(shipNumber).x] = '%';
                if(HumanMove.myBattleships.get(0).x < 9) SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y + 4][HumanMove.myBattleships.get(shipNumber).x + 1] = '%';
            }

            if(HumanMove.myBattleships.get(shipNumber).y <= 6 && HumanMove.myBattleships.get(shipNumber).y > 0) {
                if(HumanMove.myBattleships.get(0).x > 0) SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y - 1][HumanMove.myBattleships.get(shipNumber).x - 1] = '%';
                SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y - 1][HumanMove.myBattleships.get(shipNumber).x] = '%';
                if(HumanMove.myBattleships.get(0).x < 9) SeaWars.myField[HumanMove.myBattleships.get(shipNumber).y - 1][HumanMove.myBattleships.get(shipNumber).x + 1] = '%';
            }
        }

    }
}
