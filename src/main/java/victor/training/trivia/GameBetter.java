package victor.training.trivia;

import java.util.ArrayList;
import java.util.List;

public class GameBetter implements IGame {
	
   public static final int BOARD_SIZE = 12;
   private final QuestionRepository questionRepository = new QuestionRepository();

   private List<Player> players = new ArrayList<>();

   int currentPlayerIndex = 0;
   boolean isGettingOutOfPenaltyBox;

   private Player getCurrentPlayer() {
	   return players.get(currentPlayerIndex);
   }
   
   // TODO e un bug ascuns in cod. Gaseste-l
   public void addPlayer(String playerName) {
      players.add(new Player(playerName));
      System.out.println(playerName + " was added");
      System.out.println("They are player number " + players.size());
   }

   public void roll(int roll) {
      System.out.println(currentPlayer().getName() + " is the current player");
      System.out.println("They have rolled a " + roll);

      if ( getCurrentPlayer().isInPenaltyBox() ) {
         if (roll % 2 == 0) {
            System.out.println(currentPlayer().getName() + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
            return;
         }
         isGettingOutOfPenaltyBox = true;
         System.out.println(currentPlayer().getName() + " is getting out of the penalty box");
      }
      currentPlayer().advance(roll);
      System.out.println(currentPlayer().getName() + "'s new location is " + currentPlayer().getPlace());
      System.out.println("The category is " + questionRepository.getCurrentCategory(currentPlayer().getPlace()).getLabel());
      askQuestion();
   }

   private Player currentPlayer() {
      return players.get(currentPlayerIndex);
   }

   private void askQuestion() {
      System.out.println(questionRepository.nextQuestion(currentPlayer().getPlace()));
   }

// TODO e un nume misleading care e ?
   public boolean wasCorrectlyAnswered() {
      if ( getCurrentPlayer().isInPenaltyBox() ) {
         if (isGettingOutOfPenaltyBox) {
            System.out.println("Answer was correct!!!!");
            getCurrentPlayer().awardCoin();
            System.out.println(currentPlayer().getName()
                               + " now has "
                               + getCurrentPlayer().getNumberOfCoins()
                               + " Gold Coins.");

            boolean winner = getCurrentPlayer().didWon();
            currentPlayerIndex++;
            if (currentPlayerIndex == players.size()) currentPlayerIndex = 0;

            return winner;
         } else {
            currentPlayerIndex++;
            if (currentPlayerIndex == players.size()) currentPlayerIndex = 0;
            return true;
         }


      } else {

         System.out.println("Answer was corrent!!!!");
         getCurrentPlayer().awardCoin();
         System.out.println(currentPlayer().getName()
                            + " now has "
                            + getCurrentPlayer().getNumberOfCoins()
                            + " Gold Coins.");

         boolean winner = getCurrentPlayer().didWon();
         currentPlayerIndex++;
         if (currentPlayerIndex == players.size()) currentPlayerIndex = 0;

         return winner;
      }
   }

   public boolean wrongAnswer() {
      System.out.println("Question was incorrectly answered");
      System.out.println(currentPlayer().getName() + " was sent to the penalty box");
      getCurrentPlayer().setInPenaltyBox( true );

      currentPlayerIndex++;
      if (currentPlayerIndex == players.size()) currentPlayerIndex = 0;
      return true;
   }


  
}
