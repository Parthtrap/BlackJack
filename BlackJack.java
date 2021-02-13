package BlackJack;
import java.util.*;
public class BlackJack {
    static int hi;
    static int i = 0;
    static String[] PlayerCards = new String[5];
    static String[] AICards = new String[5];
    static int PlayerValue = 0;
    static int AIValue = 0;
    static Random Draw = new Random();
    static boolean AIWant=true;
    static boolean PlayerWant = true;
    public static void main(String[] args) {
        boolean again = true;
        char Input;
        Scanner Sc = new Scanner(System.in);
        System.out.println("Welcome to BlackJack");
        System.out.println("Play Black Jack against Computer");
        while (again) {
            AIWant = true;
            PlayerWant = true;
            PlayerValue = 0;
            AIValue = 0;
            Arrays.fill(PlayerCards, null);
            Arrays.fill(PlayerCards, null);
            for (i = 0; i < 10; i++) {
                if (i==0)
                {
                    Rand(i);
                }
                else if (i%2 == 0)
                {
                    if (PlayerWant) {
                        System.out.println("Hit(H)/Stay(S)?");
                        Input = Sc.next().charAt(0);
                        System.out.println("");
                        switch (Input) {
                            case 'H':
                            case 'h':
                                Rand(i);
                                break;
                            case 'S':
                            case 's':
                                PlayerWant = false;
                                PlayerCards[i / 2] = "Stay";
                                break;
                            default:
                                System.out.println("Not a valid response... Retry");
                                i--;
                                break;
                        }
                    }
                    else {
                        PlayerCards[i / 2] = "Stay";
                        Print(1);
                    }
                }
                else
                {
                    if(AIWant)
                        Rand(i);
                    else {
                        AICards[i / 2] = "Stay";
                        Print(2);
                    }
                }
                if (!AIWant && !PlayerWant) {
                    i = 20;
                    FinalCheck();
                }
            }
            System.out.println("\nWanna Play again? (Y/N)");
            Input = Sc.next().charAt(0);
            switch (Input) {
                case 'N':
                case 'n':
                    again = false;
                    break;
                default:break;
            }
        }
    }


    public static void Rand(int a)
    {
        String CardSymbol = null;
        int CardValue =0;
        switch (Draw.nextInt(13))
        {
            case 0:
                CardValue += 11;
                CardSymbol = "A";
                break;
            case 1:
                CardValue += 2;
                CardSymbol = "2";
                break;
            case 2:
                CardValue += 3;
                CardSymbol = "3";
                break;
            case 3:
                CardValue += 4;
                CardSymbol = "4";
                break;
            case 4:
                CardValue += 5;
                CardSymbol = "5";
                break;
            case 5:
                CardValue += 6;
                CardSymbol = "6";
                break;
            case 6:
                CardValue += 7;
                CardSymbol = "7";
                break;
            case 7:
                CardValue += 8;
                CardSymbol = "8";
                break;
            case 8:
                CardValue += 9;
                CardSymbol = "9";
                break;
            case 9:
                CardValue += 10;
                CardSymbol = "10";
                break;
            case 10:
                CardValue += 10;
                CardSymbol = "J";
                break;
            case 11:
                CardValue += 10;
                CardSymbol = "Q";
                break;
            case 12:
                CardValue += 10;
                CardSymbol = "K";
                break;
            default:break;
        }
        if (a%2 == 0) {
            PlayerCards[a/2] = CardSymbol;
            PlayerValue += CardValue;
            Print(1);
            Check(1);
        }
        else{
            if (AIValue + CardValue <= 21)
            {
                AIValue += CardValue;
                AICards[a / 2] = CardSymbol;
            }
            else {
                AIWant = false;
                AICards[a / 2] = "Stay";
            }
            Print(2);
            Check(2);
        }
    }


    public static void Print(int a)
    {
        if (a==1) {
            System.out.println("Your Cards are : " + Arrays.toString(PlayerCards));
            System.out.println("Player Cards total value : " + PlayerValue + "\n");
        }
        else {
            System.out.println("Computer Cards are : " + Arrays.toString(AICards));
            System.out.println("Computer Cards total value : " + AIValue + "\n");
        }
    }


    public static void Check(int a)
    {
        if(a==1)
        {
            if (PlayerValue > 21)
            {
                System.out.println("Player 1 loose");
                i=20;
            }
            else if (PlayerValue == 21)
            {
                System.out.println("JackPot. Player 1 Wins");
                i=20;
            }
        }
        else
        {
            if (AIValue > 21)
            {
                System.out.println("Computer loose");
                i=20;
            }
            else if (PlayerValue == 21)
            {
                System.out.println("JackPot. Computer Wins");
                i=20;
            }
        }
    }


    public static void FinalCheck()
    {
        Print(1);
        Print(2);
        if(PlayerValue < AIValue)
        {
            System.out.println("Computer Wins");
        }
        else if (PlayerValue == AIValue)
        {
            System.out.println("Its a Tie");
        }
        else
        {
            System.out.println("You win");
        }
    }
}
