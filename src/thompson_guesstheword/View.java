/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thompson_guesstheword;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Grant Thompson <adin.tocc@gmail.com>
 * ITDEV 140 THUR EVE ASSIGNMENT #4
 */
public class View {

    Model model_1;
    

    View(Model model_1) {
        this.model_1=model_1;
        BeginGame();
    }

    private void BeginGame() {
        
        int gamesLooped=0, characterTries=0;
        char[] charHolder = new char[26];
        char mChar;
        String tempCarToString;
        Scanner scan_1 = new Scanner(System.in);
        String[] tempString = model_1.CreateSecretWord();
        String lookUp = String.valueOf(tempString[1]);
        
    
        
        
        do{
            if(gamesLooped>0){
                System.out.printf("\n\n\n\nIncorrect guess #%d of 7\n",gamesLooped);
                System.out.printf("Letters already Chosen: %s", Arrays.toString(charHolder).replace("[", "").replace("]", "").replace(", ", ""));
            }
            System.out.printf("\nGuess this word that contains %d letters: %s\nOr just press 'Enter' to quit.\n> ",tempString[1].length(), tempString[1]);
            tempCarToString= scan_1.nextLine();
            
            if(tempCarToString.equals(""))
                return;
            
            mChar = tempCarToString.charAt(0);
            
            
            
            
            while(model_1.CheckIfCharExists(charHolder, mChar)==true){
                System.out.printf("\n\n************\nYou've already chosen '%s'. Try again.\n************\n", mChar);
                System.out.printf("Letters already Chosen: %s", Arrays.toString(charHolder).replace("[", "").replace("]", "").replace(", ", ""));
                System.out.printf("\nGuess this word that contains %d letters: %s\nOr just press 'Enter' to quit.\n> ",tempString[1].length(), tempString[1]);
                tempCarToString= scan_1.nextLine();
            
                if(tempCarToString.equals(""))
                return;
            
                mChar = tempCarToString.charAt(0);
            }
                
            
            charHolder[characterTries]=mChar;
            Arrays.sort(charHolder);//sort used letters alphanumericaly
            lookUp= String.valueOf(tempString[1]);//holder displayed word temporarily
            tempString[1] = model_1.regenerateStringArray(tempString, mChar);//build displayed user word '*******'
           if(lookUp.equals(tempString[1])){
               
            gamesLooped++;
            Admin.PlaySound(1);
           }
           else
               Admin.PlaySound(0);
           
           characterTries++;
        }while(gamesLooped<7 && !tempString[0].equalsIgnoreCase(tempString[1]));
        
        if(gamesLooped==7){//if guesses == 7 they lost
            System.out.printf("\n\nSorry you Lost...\nThe word was %s\n", tempString[0]);
        }else{//else they won
            System.out.printf("\n\nYou win!!\nYour guess of '%s' was correct.\n", tempString[1]);
        }
        
    }
    
    
}
