package victor.training.trivia;

class DisplayMessages {

	private final String addPlayer;
	private final String playerRolledTheDice;
	private final String playerNotGettingOutOfPenlatyBox;
	private final String playerGettingOutOfPenlatyBox;
	private final String playerAdvances;
	private final String correctAnswer;
	private final String wrongAnswer;

	public DisplayMessages() {

		// read them from a lang file if needed
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

	public String getPlayerRolledTheDice(Player player) {
		return String.format(playerRolledTheDice, player.getName(), player.getLastRoll());
	}

	public String getPlayerNotGettingOutOfPenlatyBox(String playerName) {
		return String.format(playerNotGettingOutOfPenlatyBox, playerName);
	}

	public String getPlayerGettingOutOfPenlatyBox(String playerName) {
		return String.format(playerGettingOutOfPenlatyBox, playerName);
	}

	public String getPlayerAdvances(Player player, String newCategory) {
		return String.format(playerAdvances, player.getName(), player.getPlace(), newCategory);
	}

	public String getCorrectAnswer(Player player) {
		return String.format(correctAnswer, player.getName(), player.getNumberOfCoins());
	}

	public String getWrongAnswer(String playerName) {
		return String.format(wrongAnswer, playerName);
	}

}