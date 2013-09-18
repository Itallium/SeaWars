public class CheckWinner {

    static boolean humanWinner, compWinner;

    public static boolean isWinner() {
        humanWinner = true;
        compWinner = true;

        for(int i = 0; i < 10; i++) {

            if(HumanMove.myBattleships.get(i).health != 0) {
                humanWinner = false;
            }

            if(CompMove.enemyBattleships.get(i).health != 0) {
                compWinner = false;
            }
        }

        if(humanWinner || compWinner) {
            return true;
        } else {
            return false;
        }
    }
}
