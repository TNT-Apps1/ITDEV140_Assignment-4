package thompson_guesstheword;

import java.awt.Toolkit;
import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Grant Thompson <adin.tocc@gmail.com>
 * ITDEV 140 THUR EVE ASSIGNMENT #4
 */
public class Admin {
    
    Scanner scan_1 = new Scanner(System.in);
    public void Hello(){//opening display message
        
        System.out.println("Welcome to my guess a word game. You will have 7 in correct chances to guess a word such as '******' (school). ");
        System.out.println("Press enter to begin.");
        scan_1.nextLine();
}
 public void GoodBye(){//closing display message
     System.out.println("\n\n\nThanks for playing!!\n\n\tPress enter to exit.");
        scan_1.nextLine();
 }
 
 public static void PlaySound(int arg1){
     
     
     
     switch(arg1){//play sounds
         case 0:
             
             try {
                 //attribution http://soundbible.com/2156-Text-Message-Alert-3.html
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("sms_alert_3_daniel_simon.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (Exception e) {
                 System.out.printf("\n\nerror %s",e);}
            
             break;
         case 1:
             Toolkit tk = Toolkit.getDefaultToolkit();
             tk.beep();
             break;
     }
     
    
         
 }
         
    
}

