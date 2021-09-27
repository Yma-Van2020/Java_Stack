import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PuzzleJava {
    Random randMachine = new Random();
    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> randomNum =  new ArrayList<Integer>();
        for(int i = 0; i < 11; i++){
            randomNum.add(randMachine.nextInt(21));
        }
        return randomNum;
    }

    public char getRandomLetter(){
        char[] letters = new char[26];
        char a = 'a';
        for (int i = 0; i <26; i++){
            letters[i] = (char)(a + i);
        }
        int index = randMachine.nextInt(26);
        return letters[index];
    }
}
