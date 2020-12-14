package victor.training.trivia;

import java.util.ArrayList;
import java.util.List;

public class GameBetter implements IGame {

	public static final int BOARD_SIZE = 12;
	private final QuestionRepository questionRepository = new QuestionRepository();

	private List<Player> players = new ArrayList<>();
	private DisplayMessages messages = new DisplayMessages();;

	int currentPlayerIndex = 0;

	public void addPlayer(String playerName) {
		players.add(new Player(playerName));
		System.out.println(messages.getAddPlayer(playerName, players.size()));
	}

	public void roll(int roll) {

		getCurrentPlayer().setLastRoll(roll);
		System.out.println(messages.getPlayerRolledTheDice(currentPlayer()));

		if (getCurrentPlayer().isInPenaltyBox()) {
			tryToGetOutOfPenaltyBox();
		} else {
			jumpToNextQuestion();
		}
	}

	private void tryToGetOutOfPenaltyBox() {

		if (getCurrentPlayer().isGettingOutOfPenaltyBox()) {
			System.out.println(messages.getPlayerGettingOutOfPenlatyBox(currentPlayer().getName()));
			jumpToNextQuestion();
		} else {
			System.out.println(messages.getPlayerNotGettingOutOfPenlatyBox(currentPlayer().getName()));
		}
	}

	private void jumpToNextQuestion() {
		currentPlayer().advanceLastRolled();

		System.out.println(messages.getPlayerAdvances(currentPlayer(),
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
	 
		if ( getCurrentPlayer().isInPenaltyBox() && !getCurrentPlayer().isGettingOutOfPenaltyBox() ) {
			nextPlayer();
			return true;
		}

		getCurrentPlayer().awardCoin();
		System.out.println(messages.getCorrectAnswer(currentPlayer()));

		boolean winner = getCurrentPlayer().didWon();
		nextPlayer();

		return winner;
	}

	private void nextPlayer() {
		currentPlayerIndex++;
		if (currentPlayerIndex == players.size()) {
			currentPlayerIndex = 0;
		}
	}

	public void wrongAnswer() {
		System.out.println(messages.getWrongAnswer(currentPlayer().getName()));
		getCurrentPlayer().setInPenaltyBox(true);
		nextPlayer();
	}

	private Player getCurrentPlayer() {
		return players.get(currentPlayerIndex);
	}

}
