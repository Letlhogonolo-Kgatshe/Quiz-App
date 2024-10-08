
package quizapp;
import javax.swing.JOptionPane;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp 
 {
    public static void main(String[] args) {
        int score = 0; // Initialize score to 0
        StringBuilder correctAnswers = new StringBuilder(); // Store correct answers

        // Quiz loop for 10 different questions
        for (int i = 0; i < 10; i++) {

            // Countdown timer before each question
            //countdownTimer(10);

            // Generate a random number between 1 and 3 (inclusive) to simulate the correct answer
            int correctAnswer = (int) (Math.random() * 3) + 1;

            // Prompt the user to enter a question for this iteration
            String prompt = JOptionPane.showInputDialog(null, "Please enter question " + (i + 1));
            if (prompt == null) {
                // User canceled the input dialog
                JOptionPane.showMessageDialog(null, "You canceled the input. Exiting the quiz.");
                return; // Exit the program
            }

            // Display instructions to the user
            JOptionPane.showMessageDialog(null, "Ensure that you write the correct answer in the right variable Ans1, Ans2, or Ans3 \n Correct answer should be stored in Answer: " + correctAnswer);

            // Prompt the user to enter three possible answers for the current question
            String Ans1 = JOptionPane.showInputDialog(null, "Please enter answer option 1 for question " + (i + 1));
            if (Ans1 == null) {
                // User canceled the input dialog
                JOptionPane.showMessageDialog(null, "You canceled the input. Exiting the quiz.");
                return; // Exit the program
            }
            
            String Ans2 = JOptionPane.showInputDialog(null, "Please enter answer option 2 for question " + (i + 1));
            if (Ans2 == null) {
                // User canceled the input dialog
                JOptionPane.showMessageDialog(null, "You canceled the input. Exiting the quiz.");
                return; // Exit the program
            }
            
            String Ans3 = JOptionPane.showInputDialog(null, "Please enter answer option 3 for question " + (i + 1));
            if (Ans3 == null) {
                // User canceled the input dialog
                JOptionPane.showMessageDialog(null, "You canceled the input. Exiting the quiz.");
                return; // Exit the program
            }

            String correctAnswerText = ""; // Store the text of the correct answer
            switch (correctAnswer) {
                case 1:
                    correctAnswerText = Ans1;
                    break;
                case 2:
                    correctAnswerText = Ans2;
                    break;
                case 3:
                    correctAnswerText = Ans3;
                    break;
            }

            // Ask the user to choose an answer from the three options
            try {
                String userAnswerStr = JOptionPane.showInputDialog(null,
                    prompt + "\n1) " + Ans1 + "\n2) " + Ans2 + "\n3) " + Ans3);
                if (userAnswerStr == null) {
                    // User canceled the input dialog
                    JOptionPane.showMessageDialog(null, "You canceled the input. Exiting the quiz.");
                    return; // Exit the program
                }
                int userAnswer = Integer.parseInt(userAnswerStr);

                // Check if the user's answer matches the correct answer
                if (userAnswer == correctAnswer) {
                    score++; // Increment score if the answer is correct
                }

                // Store the correct answer for this iteration
                correctAnswers.append("Question ").append(i + 1).append(": Correct answer is ").append(correctAnswerText).append("\n");

            } catch (NumberFormatException e) {
                // Handle invalid input
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between 1 and 3.");
            }
        }

        // Display the correct answers and final score
        JOptionPane.showMessageDialog(null, "Your score is: " + score + "\n\n" + correctAnswers.toString());
    }
/*
    private static void countdownTimer(int seconds) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int timeLeft = seconds;

            @Override
            public void run() {
                if (timeLeft > 0) {
                    System.out.println("Time left: " + timeLeft + " seconds");
                    timeLeft--;
                } else {
                    System.out.println("Time's up! Moving on...");
                    timer.cancel(); // Stop the timer
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000); // Schedule the task to run every second

        try {
            Thread.sleep(seconds * 1000); // Wait for the countdown to finish before moving on
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
*/
}
