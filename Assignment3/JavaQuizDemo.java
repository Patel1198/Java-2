package Assignment3;

public class JavaQuizDemo {
    public static void main(String[] args) {
            JavaQuiz quiz = new JavaQuiz();
            quiz.setQuestions();
            quiz.attemptTest();
            System.out.println(quiz.toString());
     }
}
