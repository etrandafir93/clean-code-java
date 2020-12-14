package victor.training.trivia;

class DisplayMessages {

	private String addPlayer;
	private String playerRolledTheDice;
	private String playerNotGettingOutOfPenlatyBox;
	private String playerGettingOutOfPenlatyBox;
	private String playerAdvances;
	private String correctAnswer;
	private String wrongAnswer;

	public DisplayMessages() {

		// read them from a lang file?
		this.addPlayer = "%s was added\r\nThey are player number %s";
		this.playerRolledTheDice = "%s is the current player\r\nThey have rolled a %s";
		this.playerNotGettingOutOfPenlatyBox = "%s is not getting out of the penalty box";
		this.playerGettingOutOfPenlatyBox = "%s is getting out of the penalty box";
		this.playerAdvances = "%s's new location is %s\r\nThe category is %s";
		this.correctAnswer = "Answer was correct!!!!\r\n%s now has %s Gold Coins.";
		this.wrongAnswer = "Question was incorrectly answered\r\n%s was sent to the penalty box";
	}

	public String getAddPlayer(String playerName, int numberOfPlayers) {
		return String.format(addPlayer, playerName, numberOfPlayers);
	}

	public String getPlayerRolledTheDice(String playerName, int roll) {
		return String.format(playerRolledTheDice, playerName, roll);
	}

	public String getPlayerNotGettingOutOfPenlatyBox(String playerName) {
		return String.format(playerNotGettingOutOfPenlatyBox, playerName);
	}

	public String getPlayerGettingOutOfPenlatyBox(String playerName) {
		return String.format(playerGettingOutOfPenlatyBox, playerName);
	}

	public String getPlayerAdvances(String playerName, int playerPosition, String newCategory) {
		return String.format(playerAdvances, playerName, playerPosition, newCategory);
	}

	public String getCorrectAnswer(String playerName, int numberOfCoins) {
		return String.format(correctAnswer, playerName, numberOfCoins);
	}

	public String getWrongAnswer(String playerName) {
		return String.format(wrongAnswer, playerName);
	}

}