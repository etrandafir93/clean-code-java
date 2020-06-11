package victor.training.trivia;

import java.util.Random;

public class GamePlay {
   public static void main(String[] args) {

      int seed = 1;

      Random random = new Random(seed);




      Game aGame = new Game();
      aGame.add("Chet");
      aGame.add("Pat");
      aGame.add("Sue");

      boolean gameContinues = true;
      while (gameContinues) {
         aGame.roll(random.nextInt(6) + 1);

         if (random.nextInt(9) == 7) {
            // 1/9: 11% sansa sa raspunda gresit
            gameContinues = aGame.wrongAnswer();
         } else {
            gameContinues = aGame.wasCorrectlyAnswered();
         }

      }
   }
}