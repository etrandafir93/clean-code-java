package victor.training.trivia;

import java.util.ArrayList;
import java.util.List;

public class GameBetter implements IGame {

	public static final int BOARD_SIZE = 12;
	private final QuestionRepository questionRepository = new QuestionRepository();

	private List<Player> players = new ArrayList<>();
	private DisplayMessages messages = new DisplayMessages();;

	int currentPlayerIndex = 0;
	boolean isGettingOutOfPenaltyBox;

	public void addPlayer(String playerName) {
		players.add(new Player(playerName));
		System.out.println(messages.getAddPlayer(playerName, players.size()));
	}

	public void roll(int roll) {

		System.out.println(messages.getPlayerRolledTheDice(currentPlayer().getName(), roll));

		if (getCurrentPlayer().isInPenaltyBox()) {
			
			tryToGetOutOfPenaltyBox(roll);
		}
		else {
			jumpToNextQuestion(roll);
		}
	}

	private void tryToGetOutOfPenaltyBox(int roll) {

		if (roll % 2 == 0) {
			
			System.out.println(messages.getPlayerNotGettingOutOfPenlatyBox(currentPlayer().getName()));
			isGettingOutOfPenaltyBox = false;
		} 
		else {
		
			isGettingOutOfPenaltyBox = true;
			System.out.println(messages.getPlayerGettingOutOfPenlatyBox(currentPlayer().getName()));
			jumpToNextQuestion(roll);
		}

	}


	private void jumpToNextQuestion(int roll) {
		currentPlayer().advance(roll);

		System.out.println(messages.getPlayerAdvances(currentPlayer().getName(), currentPlayer().getPlace(),
				questionRepository.getCurrentCategory(currentPlayer().getPlace()).getLabel()));

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
		if (getCurrentPlayer().isInPenaltyBox()) {
			if (isGettingOutOfPenaltyBox) {

				getCurrentPlayer().awardCoin();
				System.out.println(
						messages.getCorrectAnswer(currentPlayer().getName(), getCurrentPlayer().getNumberOfCoins()));

				boolean winner = getCurrentPlayer().didWon();
				currentPlayerIndex++;
				if (currentPlayerIndex == players.size())
					currentPlayerIndex = 0;

				return winner;
			} else {
				currentPlayerIndex++;
				if (currentPlayerIndex == players.size())
					currentPlayerIndex = 0;
				return true;
			}

		} else {

			getCurrentPlayer().awardCoin();
			System.out.println(
					messages.getCorrectAnswer(currentPlayer().getName(), getCurrentPlayer().getNumberOfCoins()));

			boolean winner = getCurrentPlayer().didWon();
			currentPlayerIndex++;
			if (currentPlayerIndex == players.size())
				currentPlayerIndex = 0;

			return winner;
		}
	}

	public boolean wrongAnswer() {
		System.out.println(messages.getWrongAnswer(currentPlayer().getName()));
		getCurrentPlayer().setInPenaltyBox(true);

		currentPlayerIndex++;
		if (currentPlayerIndex == players.size())
			currentPlayerIndex = 0;
		return true;
	}

	private Player getCurrentPlayer() {
		return players.get(currentPlayerIndex);
	}

}
