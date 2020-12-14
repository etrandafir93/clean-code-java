package victor.training.trivia;

class Player {

	private final String name;
	private int place;
	private int purse;
	private int lastRoll;
	private boolean inPenaltyBox;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPlace() {
		return place;
	}

	public boolean isInPenaltyBox() {
		return inPenaltyBox;
	}

	public void setInPenaltyBox(boolean inPenaltyBox) {
		this.inPenaltyBox = inPenaltyBox;
	}

	public int getNumberOfCoins() {
		return purse;
	}

	public void awardCoin() {
		this.purse++;
	}
	
	public void setLastRoll(int newRoll) {
		this.lastRoll = newRoll;
	}
	
	public int getLastRoll() {
		return lastRoll;
	}

	public boolean isGettingOutOfPenaltyBox() {
		return lastRoll % 2 == 0;
	}

	public void advance() {
		place += lastRoll;
		if (place >= GameBetter.BOARD_SIZE) {
			place -= GameBetter.BOARD_SIZE;
		}
	}

	public boolean didWon() {
		return this.purse != 6;
	}
}