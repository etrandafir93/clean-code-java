package victor.training.trivia;

public interface IGame {

	void addPlayer(String playerName);

	void roll(int roll);

	boolean didCorrectAnswerEndTheGame();

	void wrongAnswer();

}