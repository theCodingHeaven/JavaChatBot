package org.example;

import java.util.Random;
import java.util.Scanner; //make sure to add this line or Java will not be able to run your app

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello! My name is Cedric and I am a chat bot! What is your name?");

        //Read User Input
        Scanner inputReader = new Scanner(System.in); // variable holds a reference to our Scanner instance

        // anything that user will type in the console will be stored in this variable
        String userInput = inputReader.nextLine(); //this variable holds string data type
        String userName = userInput;
        //Chat Bot output
        System.out.println("Hey " + userInput + ", it's nice to meet you!");

        System.out.println("How can I help you?");
        //Make our bot keep talking to user until user is done
        while (!userInput.contains("bye") && !userInput.contains("Bye")) { // '!' means NOT, && - means AND (both statements must be true)


            //To avoid infinite loop we have to update our condition
            userInput = inputReader.nextLine();

            if(userInput.toLowerCase().contains("bye")){
                break;
            }
            System.out.println(getResponse(userInput));

            System.out.println("Is there anything else you want to share?");
        }

        System.out.println("Bye " + userName + "!");

    }


    public static String getResponse(String userInput) {

        //Array of strings for bad mood
        String[] unhappyKeywords = {

                "sad",
                "bad",
                "angry",
                "upset",
                "tired",
                "not happy"
        };

        //Array of strings for good mood
        String[] happyKeywords = {

                "happy",
                "good",
                "great",
                "awesome",
                "amazing"
        };


        String output = "";

        //For loop to iterate through all our keywords in good and bad array
        for (String keyword : unhappyKeywords) {

            if (userInput.contains(keyword)) {
                output = "I'm sorry you feel " + keyword + "." + generateSadResponses();
                return output;
            }
        }

        for (String keyword : happyKeywords) {

            if (userInput.contains(keyword)) {
                output = "I am glad you feel " + keyword + ". " + generateHappyResponses();
                return output;
            }
        }

        return " I don't think I understand what do you mean";
    }

    public static String generateSadResponses() {

        String[] unhappyResponses = {

                "I'm here if you want to talk.", // index 0
                "That sounds tough. Remember, you're not alone.", //1
                "Things will get better, I promise.", //2 ...
                "It's okay to feel down sometimes. I'm listening.",
                "Take your time, and know that I care.",
                "I'm here to support you anytime.",
                "You're stronger than you think.",
                "If you want to share more, I'm here.",
                "Hang in there! Better days are ahead.",
                "Don't hesitate to tell me what's bothering you." //9

        };

        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(unhappyResponses.length);
        return unhappyResponses[index];
    }

    public static String generateHappyResponses() {

        String[] happyResponses = {

            "That's wonderful to hear! Keep shining!",
            "I'm so glad you're feeling good!",
            "Awesome! Your positivity is contagious!",
            "Yay! That makes me happy too!",
            "Great vibes! Let's keep the good energy going!",
            "Fantastic! You're doing amazing!",
            "Love hearing that! Keep up the great mood!",
            "Sounds like a perfect day!",
            "Keep smiling, it looks great on you!",
            "Happiness suits you well!"

        };

        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(happyResponses.length);
        return happyResponses[index];
    }

}