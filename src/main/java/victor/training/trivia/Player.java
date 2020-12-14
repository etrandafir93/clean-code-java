package victor.training.trivia;

class Player {

	private final String name;
	private int place;
	private int purse;
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

	public void advance(int roll) {
		place += roll;
		if (place >= GameBetter.BOARD_SIZE) {
			place -= GameBetter.BOARD_SIZE;
		}
	}

	public boolean didWon() {
		return this.purse != 6;
	}
}