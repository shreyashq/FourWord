package FourWord;

import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        String words[] = {
                "arch", "aver",
                "bach", "back", "bade", "bail", "bait", "bake", "bale",
                "ball", "band", "bang", "bank", "barb", "bard", "bare",
                "bark", "base", "bash", "bask", "bate", "bawl",
                "bean", "bear", "beat", "beef", "been", "beep", "bell", "belt",
                "bend", "bent", "bias", "bide", "bike", "bilk", "bill",
                "bind", "bird", "bite", "blab", "blat",
                "bled", "blew", "blob", "blot", "blow", "blub", "blue", "blur",
                "boat", "bode", "body", "boil", "bolt", "bomb", "bond", "bone",
                "bong", "bonk", "book", "boom", "boot", "bore", "born", "boss",
                "bowl", "brag", "bray", "bred", "brew", "brim", "buck", "buff",
                "bulk", "bull", "bump", "bung", "bunk", "bunt", "buoy", "burl",
                "burn", "burp", "burr", "bury", "bush", "busk", "buss", "bust",
                "busy", "butt", "buzz", "caca", "cage", "cake", "calk", "call",
                "calm", "came", "camp", "cane", "cant", "card", "care", "cart",
                "case", "cash", "cast", "cave", "cede", "cere", "chap", "char",
                "chat", "chaw", "chid", "chin", "chip", "chop", "chug", "chum",
                "cite", "clad", "clam", "clap", "claw", "clew", "clip", "clog",
                "clop", "clot", "cloy", "club", "clue", "coal", "coat", "coax",
                "cock", "code", "coif", "coil", "coin", "coke", "comb", "come",
                "comp", "cone", "conk", "cook", "cool", "coop", "cope", "copy",
                "cord", "core", "cork", "corn", "cosh", "cost", "cowl", "crab",
                "cram", "crap", "crew", "crib", "crop", "crow", "cube", "cuff",
                "cull", "curb", "cure", "curl", "cuss", "dado", "damn", "damp",
                "dang", "dare", "darn", "dart", "dash", "date", "daub", "dawn",
                "daze", "deal", "deck", "deed", "deem", "defy", "deke", "demo",
                "dent", "deny", "dial", "dice", "died", "diet", "dike", "dine",
                "ding", "disc", "dish", "disk", "diss", "dive", "dock", "doff",
                "dole", "done", "doom", "dope", "doss", "dote", "dove", "down",
                "doze", "drag", "draw", "drew", "drip", "drop", "drub", "drug",
                "drum", "duck", "duel", "dull", "dump", "dung", "dunk", "dupe",
                "dusk", "dust", "earn", "ease", "echo", "edge", "edit", "emit",
                "envy", "espy", "etch", "even", "exit", "face", "fade", "fail",
                "fake", "fall", "fare", "farm", "fart", "fast", "fate", "fawn",
                "faze", "fear", "feed", "feel", "fell", "felt", "fend", "fess",
                "fete", "feud", "file", "fill", "film", "find", "fine", "fink",
                "fire", "firm", "fish", "fist", "fizz", "flag", "flap", "flat",
                "flaw", "flay", "fled", "flee", "flew", "flex", "flip", "flit",
                "flog", "flop", "flow", "flub", "flux", "foal", "foam", "foil",
                "fold", "fond", "fool", "foot", "ford", "fork", "form", "foul",
                "fowl", "frag", "frap", "fray", "free", "fret", "frit", "fuel",
                "full", "fume", "fund", "funk", "furl", "fuse", "fuss", "futz",
                "gain", "gait", "gall", "game", "gang", "gaol", "gape", "garb",
                "gash", "gasp", "gate", "gave", "gawk", "gawp", "gaze", "gear",
                "geld", "gibe", "gift", "gild", "gimp", "gird", "give", "glom",
                "glow", "glue", "glug", "glut", "gnaw", "goad", "golf", "gone",
                "gong", "goof", "gore", "gown", "grab", "gray", "grew", "grey",
                "grid", "grin", "grip", "grit", "grow", "grub", "gull", "gulp",
                "gush", "gust", "gybe", "hack", "hail", "hale", "halt", "hand",
                "hang", "hare", "hark", "harm", "harp", "hash", "hasp", "hast",
                "hate", "hath", "haul", "have", "hawk", "haze", "head", "heal",
                "heap", "hear", "heat", "heed", "heel", "heft", "held", "helm",
                "help", "herd", "hewn", "hide", "hike", "hill", "hint", "hire",
                "hiss", "hive", "hoax", "hock", "hold", "hole", "home", "hone",
                "honk", "hood", "hoof", "hook", "hoop", "hoot", "hope", "horn",
                "hose", "host", "hove", "howl", "huff", "hulk", "hull", "hump",
                "hung", "hunt", "hurl", "hurt", "hush", "husk", "hymn", "hype",
                "idle", "inch", "iron", "itch", "jack", "jade", "jail", "jape",
                "jazz", "jeer", "jell", "jerk", "jest", "jibe", "jilt", "jinx",
                "jive", "join", "joke", "josh", "juke", "jump", "junk",
                "kayo", "keel", "keen", "keep", "kept", "kern", "kick", "kill",
                "kink", "kiss", "kite", "knap", "knew", "knit", "knot", "know",
                "lace", "lack", "laid", "lain", "lamb", "lame", "land", "lard",
                "lark", "lash", "last", "laud", "lave", "laze", "lead", "leaf",
        };

        Random r = new Random();
        int randomIndex = r.nextInt(words.length);
        String randomWord = words[randomIndex];

        StringBuilder result = new StringBuilder();

        System.out.println("We have selected a 4 letter word, try to guess it in 5 guesses: ");
        Scanner sc = new Scanner(System.in);
        int userWin = 0;
        int guessCount = 5;


        while (userWin != 1) {
            System.out.println();
            String userInput = sc.next();

            // Check if the word is 4 letters long
            if (userInput.length() != 4) {
                System.out.println("Invalid input! Please enter a word with exactly 4 letters.");
                continue; 
            }

            if (randomWord.equals(userInput)) {
                System.out.println();
                System.out.println("You win!!");
                userWin = 1;
            } else {
                System.out.println();
                System.out.println("Try again: ");

                // Hint 1: Correct letters in correct positions
                System.out.print("The letters you see below are at their correct index: ");
                for (int i = 0; i < userInput.length(); i++) {
                    if (userInput.charAt(i) == randomWord.charAt(i)) {
                        System.out.print(userInput.charAt(i));
                    } else {
                        System.out.print("_");
                    }
                }
                System.out.println();

                // Hint 2: Letters in the word but not at correct index
                System.out.print("Letters in the word but not at the correct index: ");
                for (int i = 0; i < userInput.length(); i++) {
                    char userChar = userInput.charAt(i);
                    if (randomWord.contains(String.valueOf(userChar)) && randomWord.charAt(i) != userChar) {
                        System.out.print(userChar + " ");
                    }
                }
                System.out.println();

                // Decrease guesses
                guessCount--;
                if (guessCount == 0) {
                    System.out.println();
                    System.out.println("You lost...");
                    userWin = 1;
                }
            }
        }


        System.out.println("The word was: " + randomWord);
        System.out.println();
        System.out.println("To play again, simply rerun the program.");
        System.out.println();
    }
}
