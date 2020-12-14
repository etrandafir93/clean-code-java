package victor.training.trivia;

import java.util.ArrayList;
import java.util.List;

public class QuestionProvider {

	public enum Category {
		ROCK("Rock"),
		POP("Pop"),
		SPORTS("Sports"),
		SCIENCE("Science");
		
		private final String label;
		
		Category(String label) {
			this.label = label;
		}
		
		public String getLabel() {
			return label;
		}
	}

	private List<String> questions;
	private Category category;
	
	
	public QuestionProvider(Category category) {
		this.category = category;
		initQuestions();
	}

	private void initQuestions() {
		questions = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			questions.add(category.getLabel() + " Question " + i);
		}
	}

	public String nextQuestion() {
		return questions.remove(0);
	}
}
