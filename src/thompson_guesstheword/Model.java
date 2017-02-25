/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thompson_guesstheword;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Grant Thompson <adin.tocc@gmail.com>
 * ITDEV 140 THUR EVE ASSIGNMENT #4
 */
public class Model {
    
    String[] gameWords = new String[] { "adjust", "pizza", "punish", "buzz", "dusty", "account", "jeans", "sip", "shelter", "lethal" };
    private int[] gameWordsPositionHolder = new int[gameWords.length];
    

   
    
    public Model() {
        
    }//end constructor
    
    
    public String[] CreateSecretWord(){//create a secret word
        String[] secretWord = new String[2];
        String tempWord;
        
        //if last # of array isn't -1 reset all array elements to -1
            if (gameWordsPositionHolder[gameWords.length-1] !=-1)
            {
                Arrays.fill(gameWordsPositionHolder, -1);
                
            }
        
        
        tempWord = GetNewWord();
        secretWord[0]=tempWord;
        secretWord[1]= tempWord.replaceAll(".", "*");
        return secretWord;
    }

    private String GetNewWord() {//get a 1 of a kind random secret word
        Random random_1 = new Random();
        //int[] gameWordsPositionHolder = new int[gameWords.length];
        int tempInt;
        
        
        do {            
            tempInt = random_1.nextInt(gameWords.length);
        } while (CheckIfRandom( gameWordsPositionHolder, tempInt)==true);
        
        return gameWords[tempInt];
    }

    private boolean CheckIfRandom( int[]arg1, int arg2) {//check if word is really 1 of a kind and random
        int tempHolder=0;
        for(int i = 0; i<arg1.length; i++)
            {
                if (arg1[i] == arg2)
                {
                    return true;
                }
            }

        while(arg1[tempHolder]!=-1){
            tempHolder++;
        }
            arg1[tempHolder]=arg2;
            return false;
                
    }
    
    public String regenerateStringArray(String[] arg1, char arg2){// build the displayed word for user
        char[] tempCharArray = arg1[1].toCharArray();
        for(int i = 0 ; i<arg1[0].length() ; i++){
            if(arg1[0].charAt(i)==arg2){
                tempCharArray[i]=arg2;
            }
        }
        arg1[1]=String.valueOf(tempCharArray); 
        return String.valueOf(tempCharArray);
    }

   

    boolean CheckIfCharExists(char[] charHolder, char mChar) {//check if character exists in char array
        for(char char_1 : charHolder){
            if (char_1==mChar)
                return true;
        }
        return false;
    }
    
    
    
            
            
            
    
}
