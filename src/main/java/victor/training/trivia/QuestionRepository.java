package victor.training.trivia;

import java.util.EnumMap;
import java.util.Map;

import victor.training.trivia.QuestionProvider.Category;


public class QuestionRepository {

	Map<Category, QuestionProvider> questions = new EnumMap<>(Category.class);
	
	public QuestionRepository() {
		questions.put(Category.POP, new QuestionProvider(Category.POP));
		questions.put(Category.ROCK, new QuestionProvider(Category.ROCK));
		questions.put(Category.SPORTS, new QuestionProvider(Category.SPORTS));
		questions.put(Category.SCIENCE, new QuestionProvider(Category.SCIENCE));
	}

	public QuestionProvider.Category getCurrentCategory(int place) {
		switch (place % 4) {
			case 0: return QuestionProvider.Category.POP;
			case 1: return QuestionProvider.Category.SCIENCE;
			case 2: return QuestionProvider.Category.SPORTS;
			case 3: return QuestionProvider.Category.ROCK;
			
			default: throw new IllegalStateException("Unexpected value: " + place % 4);
		}
	}

	public String nextQuestion(int place) {
		return questions.get( getCurrentCategory(place) ).nextQuestion();
	}

}
