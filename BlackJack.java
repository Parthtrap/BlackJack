package BlackJack;
import java.util.*;
class GameInfo
{
    public String Cards[] = new String[5];
    public int Value = 0;
    public boolean Want = true;
}
public class BlackJack {
    static int i = 0;
    static GameInfo Player = new GameInfo();
    static GameInfo AI = new GameInfo();
    static Random Draw = new Random();
    public static void main(String[] args) {
        boolean again = true;
        char Input;
        Scanner Sc = new Scanner(System.in);
        System.out.println("Welcome to BlackJack");
        System.out.println("Play Black Jack against Computer");
        while (again) {
            Player.Want = true;
            AI.Want = true;
            Player.Value =0;
            AI.Value =0;
            Arrays.fill(Player.Cards, null);
            Arrays.fill(Player.Cards, null);
            for (i = 0; i < 10; i++) {
                if (i==0)
                {
                    Rand(i);
                }
                else if (i%2 == 0)
                {
                    if (Player.Want) {
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
                                Player.Want = false;
                                Player.Cards[i / 2] = "Stay";
                                break;
                            default:
                                System.out.println("Not a valid response... Retry");
                                i--;
                                break;
                        }
                    }
                    else {
                        Player.Cards[i / 2] = "Stay";
                        Print(1);
                    }
                }
                else
                {
                    if(AI.Want)
                        Rand(i);
                    else {
                        AI.Cards[i / 2] = "Stay";
                        Print(2);
                    }
                }
                if (!AI.Want & !Player.Want) {
                    i = 11;
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
            Player.Cards[a/2] = CardSymbol;
            Player.Value += CardValue;
            Print(1);
            Check(1);
        }
        else{
            if (AI.Value + CardValue <= 21)
            {
                AI.Value += CardValue;
                AI.Cards[a / 2] = CardSymbol;
            }
            else {
                AI.Want = false;
                AI.Cards[a / 2] = "Stay";
            }
            Print(2);
            Check(2);
        }
    }


    public static void Print(int a)
    {
        if (a==1) {
            System.out.println("Your Cards are : " + Arrays.toString(Player.Cards));
            System.out.println("Player Cards total value : " + Player.Value + "\n");
        }
        else {
            System.out.println("Computer Cards are : " + Arrays.toString(AI.Cards));
            System.out.println("Computer Cards total value : " + AI.Value + "\n");
        }
    }


    public static void Check(int a)
    {
        if(a==1)
        {
            if (Player.Value > 21)
            {
                System.out.println("Player 1 loose");
                i=11;
            }
            else if (Player.Value == 21)
            {
                System.out.println("JackPot. Player 1 Wins");
                i=11;
            }
        }
        else
        {
            if (AI.Value > 21)
            {
                System.out.println("Computer loose");
                i=20;
            }
            else if (Player.Value == 21)
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
        if(Player.Value < AI.Value)
        {
            System.out.println("Computer Wins");
        }
        else if (Player.Value == AI.Value)
        {
            System.out.println("Its a Tie");
        }
        else
        {
            System.out.println("You win");
        }
    }
}