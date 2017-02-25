/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thompson_guesstheword;

import java.util.Scanner;

/**
 *
 * @author Grant Thompson <adin.tocc@gmail.com>
 * ITDEV 140 THUR EVE ASSIGNMENT #4
 */
public class Controller {
    
    Model model_1 = new Model();
    

    public Controller() {
        
        begin();
    }

    private void begin() {
        String loopController = "y";
        Scanner scan1 = new Scanner(System.in);
        View view_1;
        
        do {   
            view_1 = new View(model_1);
            System.out.println("Would you like to play again? y:n\n> ");
            loopController = scan1.nextLine().toLowerCase();
            
        } while (!loopController.equals("n"));
    }
    
    
    
    
    
}
