package com.example.assignment02_sodv3202;

public class CelebrityGuess {

    public int imageResourceID;

    public String[] options;

    public String correctAnswer;

    public boolean answered = false;

    public CelebrityGuess(int image, String[] options, String correctAnswer) {
        this.imageResourceID = image;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean verifyAnswer(String guess){

        return guess.equals(correctAnswer);
    }

    //This whole thing is statically typed but it's necessary.
    //ideally, it would be done with a JSON file.
    public static CelebrityGuess[] generateTotalGuesses(){

        return new CelebrityGuess[] {
            new CelebrityGuess(R.drawable.johnny_depp, new String[] {
                    "Brad Pitt", "Leonardo DiCaprio", "Tom Cruise", "Johnny Depp", "Chuck Connors"
                }, "Johnny Depp")
            , new CelebrityGuess(R.drawable.eminem, new String[] {
                    "NF", "Eminem", "Machine Gun Kelly", "Mac Miller", "Logic"
                }, "Eminem")
            , new CelebrityGuess(R.drawable.cristiano_ronaldo, new String[] {
                    "Lionel Messi", "Luka Modric", "Christiano Ronaldo", "Neymar Jr.", "Kylian Mbappe"
                }, "Christiano Ronaldo")
            , new CelebrityGuess(R.drawable.will_smith, new String[] {
                    "Will Smith", "Jamie Foxx", "Charlie Murphy", "Denzel Washington", "Logic"
                }, "Will Smith")
            , new CelebrityGuess(R.drawable.scarlett_johansson, new String[] {
                "Natalie Portman", "Anne Hathaway", "Sabrina Carpenter", "Charlize Theron", "Scarlett Johansson"
                }, "Scarlett Johansson")
            , new CelebrityGuess(R.drawable.adele, new String[] {
                "Taylor Swift", "Adele", "Billie Eilish", "Mariah Carey", "Celine Dion"
                }, "Taylor Swift")
            , new CelebrityGuess(R.drawable.lady_gaga, new String[] {
                "Beyoncé", "Lady Gaga", "Taylor Swift", "Ariana Grande", "Rihanna"
                }, "Lady Gaga")
            , new CelebrityGuess(R.drawable.robert_downey_jr, new String[] {
                "Chris Hemsworth", "Robert Downey Jr.", "Mark Ruffalo", "Tom Holland", "Benedict Cumberbatch"
                }, "Robert Downey Jr.")
            , new CelebrityGuess(R.drawable.angelina_jolie, new String[] {
                "Angelina Jolie", "Jennifer Aniston", "Jennifer Lawrence", "Margot Robbie", "Emma Watson"
                }, "Angelina Jolie")
            , new CelebrityGuess(R.drawable.leonardo_dicaprio, new String[] {
                "Leonardo DiCaprio", "Tom Hardy", "Matt Damon", "Brad Pitt", "Jake Gyllenhaal"
                }, "Leonardo DiCaprio")
        };
    }
}
