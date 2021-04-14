package LanguageLearningProj;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LanguageLearningApp {
    private ArrayList<KeyValue> vocabulary = new ArrayList<>();

    public void start(){
        System.out.println("type quit to end the game");
        Scanner scanner = new Scanner(System.in);
        while(true){
            int index = new Random().nextInt(vocabulary.size());
            KeyValue currentWord = vocabulary.get(index);
            System.out.printf("What does " + currentWord.getKey() + " mean in English?");
            String guess = scanner.nextLine();
            guess = guess.toLowerCase();
            if(guess.equals("quit")){
                break;
            }
            if(guess.equals(currentWord.getValue())){
                System.out.println("CORRECT!");
            }else{
                System.out.println("WRONG!");
            }
        }
    }

    public void addEntry(String key, String value){
        KeyValue entry = new KeyValue(key, value);
        vocabulary.add(entry);
    }
}
