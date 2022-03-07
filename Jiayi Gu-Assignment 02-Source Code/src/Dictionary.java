/**************************************************************** *
 * File: [CSC340-Assignment 02-Interactive Dictionary]
 * By: [Jiayi Gu]
 * Date: [02-17-2022]
 *
 * Description: [This programme will output a dictionary list to the users by using the keywords and the optional
 * parameters which the users input.]
 * ****************************************************************/

import java.util.*;

public class Dictionary {

    private enum DictionaryList {
        ARROWNONE1("Arrow", "noun", "Here is one arrow: <IMG> -=>> </IMG>"),
        BOOKNONE1("Book", "noun", "A set of pages."),
        BOOKNONE2("Book", "noun", "A written work published in printed or electronic form."),
        BOOKVERB1("Book", "verb", "To arrange for someone to have a seat on a plane."),
        BOOKVERB2("Book", "verb", "To arrange for something on a particular date."),
        DISTINCTADJ1("Distinct", "adjective", "Familiar. Worked in Java."),
        DISTINCTADJ2("Distinct", "adjective", "Unique. No duplicates. Clearly different or of a different kind."),
        DISTINCTADV1("Distinct", "adverb", "Uniquely. Written 'distinctly'."),
        DISTINCTNOUN1("Distinct", "noun", "A keyword in this assignment."),
        DISTINCTNOUN2("Distinct", "noun", "A keyword in this assignment."),
        DISTINCTNOUN3("Distinct", "noun", "A keyword in this assignment."),
        DISTINCTNOUN4("Distinct", "noun", "An advanced search option."),
        DISTINCTNOUN5("Distinct", "noun", "Distinct is a parameter in this assignment."),
        PLACEHOLDERADJ1("Placeholder", "adjective", "To be updated..."),
        PLACEHOLDERADJ2("Placeholder", "adjective", "To be updated..."),
        PLACEHOLDERADV1("Placeholder", "adverb", "To be updated..."),
        PLACEHOLDERCON1("Placeholder", "conjunction", "To be updated..."),
        PLACEHOLDERINT1("Placeholder", "interjection", "To be updated..."),
        PLACEHOLDERNOUN1("Placeholder", "noun", "To be updated..."),
        PLACEHOLDERNOUN2("Placeholder", "noun", "To be updated..."),
        PLACEHOLDERNOUN3("Placeholder", "noun", "To be updated..."),
        PLACEHOLDERPREP1("Placeholder", "preposition", "To be updated..."),
        PLACEHOLDERPRO1("Placeholder", "pronoun", "To be updated..."),
        PLACEHOLDERVERB1("Placeholder", "verb", "To be updated..."),
        REVERSEADJ1("Reverse", "adjective", "On back side."),
        REVERSEADJ2("Reverse", "adjective", "Opposite to usual or previous arrangement."),
        REVERSENOUN1("Reverse", "noun", "A dictionary program's parameter."),
        REVERSENOUN2("Reverse", "noun", "Change to opposite direction."),
        REVERSENOUN3("Reverse", "noun", "The opposite."),
        REVERSENOUN4("Reverse", "noun", "To be updated..."),
        REVERSENOUN5("Reverse", "noun", "To be updated..."),
        REVERSENOUN6("Reverse", "noun", "To be updated..."),
        REVERSENOUN7("Reverse", "noun", "To be updated..."),
        REVERSEVERB1("Reverse", "verb", "Change something to opposite."),
        REVERSEVERB2("Reverse", "verb", "Go back."),
        REVERSEVERB3("Reverse", "verb", "Revoke ruling."),
        REVERSEVERB4("Reverse", "verb", "To be updated..."),
        REVERSEVERB5("Reverse", "verb", "To be updated..."),
        REVERSEVERB6("Reverse", "verb", "Turn something inside out.");

        private String keyWord;
        private String partOfSpeech;
        private String definition;

        // constructor
        DictionaryList(String keyWord, String partOfSpeech, String definition) {
            this.keyWord = keyWord;
            this.partOfSpeech = partOfSpeech;
            this.definition = definition;
        }

        // getter
        public String getKeyWord() {
            return this.keyWord.toUpperCase();
        }

        public String getPartOfSpeech() {
            return this.partOfSpeech;
        }

        public String getDefinition() {
            return this.definition;
        }

        @Override
        public String toString() {
            return this.keyWord + " [" + this.partOfSpeech + "] : " + this.definition;
        }

    }

    // printout the help message when user input !help or " " (space)
    public static void helpPrintOut() {
        System.out.println("|\n" +
                "     PARAMETER HOW-TO,  please enter:\n" +
                "     1. A search key -then 2. An optional part of speech -then\n" +
                "     3. An optional 'distinct' -then 4. An optional 'reverse'\n" +
                "|");
    }

    // check the optional parameters the users entered, and return the specifically number to let the programme know
    // which one did the user input
    public static int parameterChecker(String parameter) {

        // 1 --> partOfSpeeches
        // 2 --> distinct
        // 3 --> reverse
        // 4 --> no parameter

        String[] partOfSpeeches = {"noun", "verb", "adjective", "adverb", "pronoun",
                "preposition", "conjunction", "interjection"};

        if ((Arrays.asList(partOfSpeeches).contains(parameter.toLowerCase()))) {
            return 1;
        } else if (parameter.equalsIgnoreCase("distinct")) {
            return 2;
        } else if ((parameter.equalsIgnoreCase("reverse"))) {
            return 3;
        }
        return 4;
    }


    // return the dictionary arraylist by searching the same partOfSpeech
    public static ArrayList<DictionaryList> returnDictionaryWithPartOfSpeech(ArrayList<DictionaryList> dictList, String partOfSpeech) {
        ArrayList<DictionaryList> result = new ArrayList<DictionaryList>();
        if (dictList != null) {
            for (DictionaryList dict: dictList) {
                if(partOfSpeech.equalsIgnoreCase(dict.getPartOfSpeech())) {
                    result.add(dict);
                }
            }
        }
        return result;
    }

    // return the dictionary arrayList without duplicates
    public static ArrayList<DictionaryList> returnDictionaryWithDistinct(ArrayList<DictionaryList> dictList) {
        HashMap<String, DictionaryList> hMap = new HashMap<String, DictionaryList>();
        if (dictList != null) {
            for (DictionaryList dict : dictList) {
                String definition = dict.getDefinition();
                if (!hMap.containsKey(definition)) {
                    hMap.put(definition, dict);  // need change
                }
            }
        }
        return new ArrayList<DictionaryList>(hMap.values());
    }

    // reverse the result
    public static ArrayList<DictionaryList> returnDictionaryWithReverse (ArrayList<DictionaryList> dictList) {
        ArrayList<DictionaryList> result = new ArrayList<DictionaryList>();
        for (int i = dictList.size() - 1; i >= 0; i--) {
            result.add(dictList.get(i));
        }
        return result;
    }

    // the numSort method for the printout
    public static String returnNumSort(int num) {
        switch(num) {
            case 1: return "1st";
            case 2: return "2rd";
            case 3: return "3rd";
            case 4: return "4th";
        }
        return "need fixed [error at returnNumSort]";
    }

    public static void main(String[] args) {

        HashMap<String, ArrayList<DictionaryList>> hashMap = new HashMap<String, ArrayList<DictionaryList>>();

        int totalDefinition = 0;

        // put the DictionaryList to the hashMap
        for (DictionaryList dictionary : DictionaryList.values()) {
            String keyWord = dictionary.getKeyWord();

            ArrayList<DictionaryList> list;

            if (hashMap.containsKey(keyWord)) {
                list = hashMap.get(keyWord);
            } else {
                list = new ArrayList<DictionaryList>();
            }

            list.add(dictionary);
            hashMap.put(keyWord, list);
            totalDefinition ++;
        }

        System.out.println("\n");
        System.out.println(" ===== DICTIONARY 340 JAVA ===== ");
        System.out.println(" ----- Keyword: " + hashMap.size()); // printout total keywords we have
        System.out.println(" ----- definition: " + totalDefinition); // printout total definitions we have

        Boolean exit = true;
        int times = 1; // means how many times we do the searching

        Scanner input = new Scanner(System.in);

        while (exit) { // loop end while users input '!q' to exit

            System.out.print("Search [" + times + "]: ");
            String userInput = input.nextLine();

            String[] split = userInput.split(" "); // split each words

            String word = null;
            Boolean distinct = false;
            String partOfSpeech = null;
            Boolean reverse = false;

            if (split.length > 0) { // means it has words
                word = split[0];
            }


            // create an ArrayList to collect the optional parameters we have
            ArrayList<String> parameters = new ArrayList<>();
            parameters.add("part of speech");
            parameters.add("reverse");
            parameters.add("distinct");

            // check parameter line 97-115
            if (split.length >= 2) { // exclude the keyword, we still have some other optional parameters
                for(int i = 1; i < split.length; i++) {
                    // check if the first if the first optional parameter is part of speech
                    if (parameterChecker(split[i]) == 1) {
                        partOfSpeech = split[i].toLowerCase();
                        parameters.remove("part of speech");
                    } else if (parameterChecker(split[i]) == 2) { // if is distinct
                        distinct = true;
                        parameters.remove("distinct");
                    } else if (parameterChecker(split[i]) == 3) { // if is reverse
                        reverse = true;
                        parameters.remove("reverse");
                    } else { // printout if the parameter is not the required word by using for loop
                        for (int j = 0; j < parameters.size(); j++) {
                            System.out.println("<The " + returnNumSort(i) + " parameter '" + split[i] +
                                    "' is NOT '" + parameters.get(j) + "'.>"); // print out if not those three parameters
                            }
                        // check which parameter, can use switch statement later
                        // print out the hint for users
                        if (i == 1) { // if we're at the first optional parameter
                            System.out.println("<The entered " + returnNumSort(i) + " parameter should be a part of speech or 'distinct' or 'reverse'.");
                        } else if (i == 2) { // if we're at the second optional parameter
                            System.out.println("<The entered " + returnNumSort(i) + " parameter should be 'distinct' or 'reverse'.");
                        } else if (i == 3) { // if we're at the third optional parameter
                            System.out.println("<The entered " + returnNumSort(i) + " parameter should be 'reverse'.");
                        }
                    }
                }
            } else { // only one word, printout the definition if it has
                partOfSpeech = null;
                distinct = false;
                reverse = false;
            }

            // printout
            if (!userInput.equalsIgnoreCase("!q")) { // exit the programme
                if (userInput.equalsIgnoreCase("!help")||userInput.equals("")) { // get the helpPrintout method
                    helpPrintOut();
                } else {
                    System.out.println("\t|");
                    // all word results
                    ArrayList<DictionaryList> result = hashMap.get(word.toUpperCase());
                    // check part of speech
                    ArrayList<DictionaryList> secondResult = (partOfSpeech != null) ? returnDictionaryWithPartOfSpeech(result, partOfSpeech):result;
                    // check distinct
                    ArrayList<DictionaryList> thirdResult = (distinct == true) ? returnDictionaryWithDistinct(secondResult):secondResult;
                    // check reverse
                    ArrayList<DictionaryList> fourthResult = (reverse == true) ? returnDictionaryWithReverse(thirdResult):thirdResult;
                    // printout the final result
                    if (!(fourthResult == null)) { // if the result does have any keywords and definitons
                        for (DictionaryList dict : fourthResult) {
                            System.out.println("\t" + dict);
                        }
                    } else { // means our DictionaryList doesn't have that keywords
                        System.out.println("<NOT FOUND> To be considered for the next release. Thank you.");
                        helpPrintOut(); // give users some hint to get the correct result
                    }
                    System.out.println("\t|");
                }
                times++;
            } else {
                System.out.println(" ---- THANK YOU ---- ");
                exit = false; // exit the while loop
            }
        }
    }
}

