package LanguageLearningProj;

public class Main {
    public static void main(String[] args) {
        LanguageLearningApp languageLearningApp = new LanguageLearningApp();
        languageLearningApp.addEntry("Hallo","hello");
        languageLearningApp.addEntry("Guten Tag","good day");
        languageLearningApp.addEntry("Bitte","please");
        languageLearningApp.start();
    }
}
