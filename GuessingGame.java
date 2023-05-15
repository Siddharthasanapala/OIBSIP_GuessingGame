import java.util.*;
class GuessingGame{
    public static void main(String[] args){
        int choice;
        Scanner IN =new Scanner(System.in);
        GuessingGame GAME=new GuessingGame();
        System.out.println("Welcome to GuessingGame..!");
        System.out.println("1 -> Read Rules of the game \n2 -> Play Game");
        System.out.println("Enter your choice : ");
        choice = IN.nextInt();
        try{
            switch (choice)
                {
                case 1:
                    GAME.DisplayRules();
                    GAME.WantToPlay();
                    break;
                case 2:
                    GAME.PlayGame();
                    break;
                default :
                    throw new InputMismatchException("Wrong number entered. Please try later ");
                }
            }
        catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            }
    }
    public void DisplayRules(){
        System.out.println("* Player has to Guess the number between 1-100");
        System.out.println("* There are only 5 attempts to guess the number if could'nt Player Loses the game");
        System.out.println("* For every wrong attempt Clue is given (Grater (or) lesser than original number)");
        System.out.println("* For every wrong attempt your Accuracy level is reduced");
    }
    public void WantToPlay(){
        Scanner Y_N=new Scanner(System.in);
        System.out.println("You want to Play now..!");
        System.out.println("Enter Y to start the game and N to Exit :");
        String CHOICE = Y_N.nextLine();
        if(CHOICE.equalsIgnoreCase("Y")){
            PlayGame();
        }
        else{
            System.out.println("Exiting From game...!");
            System.exit(1);
        }
    }
    public void PlayGame(){
        int guessNum=0,origNum,WrongGuessCount=0;
        double accuracy_rate=0.2;
        Scanner INP=new Scanner(System.in);
        Random r_num=new Random();
        origNum = r_num.nextInt(100)+1;
        if(origNum > 50){
            System.out.println("Number is grater than 50");
        }
        else{
            System.out.println("Number lies between 1-50");
        }
        while(guessNum != origNum){
            System.out.println("Guess the Number : ");
            guessNum = INP.nextInt();
            if(guessNum == origNum){
                System.out.println("You WON the Match!");
                System.out.println("Your Guess is Right! \nThe number is "+origNum);
                System.out.println("Your's Accuracy is : "+accuracy_rate*(5-WrongGuessCount)*100+"%");
            }
            else{
                WrongGuessCount++;
                if(WrongGuessCount == 5){
                    System.out.println("You lost the Match (You couldnt guess the number within 5 Attempts)");
                    System.out.println("The Number is "+origNum);
                    return;
                }
                if(guessNum > origNum){
                    System.out.println("The Number is lesser than "+guessNum);
                }
                else{
                    System.out.println("The Number is grater than "+guessNum);
                }
                if(WrongGuessCount==4){
                    System.out.println("This is your Last Attempt !");
                }
                else{
                    System.out.println((5-WrongGuessCount)+" Attempts left !");
                }
            }
        }

    }   

}
