import java.util.ArrayList;
import java.util.Random;
public class Match
{
    Team team1;
    Team team2;
    public static final int numOfBallInOver = 6;
    public static final int wicketNumber = 7;
    public static final int lastWicket = 10;
    public static final int six = 6;
    public static final int four = 4;
    private int Overs;
    private ScoreBord scoreBord = new ScoreBord();
    Match(Team team1,Team team2,int overs) {
        this.team1 = team1;
        this.team2 = team2;
        this.Overs = overs;
    }
    public void startGame() {
        if(toss()==1)  // it is  decided which team play first
        {
            int scoreOfTeam1  = playGame(team1,team2);
            int scoreOfTeam2  = playGame(team2,team1);
            printScoreBord(team1,team2);
        }
        else
        {
            int scoreOfTeam2  = playGame(team2,team1);
            int scoreOfTeam1  = playGame(team1,team2);
            printScoreBord(team2,team1);
        }

        scoreBord.printMatchResult(team1,team2,team1.getScore(), team2.getScore(), Overs);
    }
    private int toss()
    {
        return (int)(Math.random()*2);
    }
    private int playGame(Team team1,Team team2) {
         int batsmanNo = 0;
         int lastBowlerNo = -1;

         Player batsman1 = team1.getBatsman(batsmanNo++); // on strike
         Player batsman2 = team1.getBatsman(batsmanNo++); // off side

         for(int i=0;i<Overs;i++)
         {
             int NextBowlerNo = team2.getNextBowlerNo(lastBowlerNo);
             Player Bowler = team2.getBowler(NextBowlerNo);
             lastBowlerNo = NextBowlerNo;

             for(int j=0;j<numOfBallInOver;j++)
             {
                 int run = RandomFunction();

                 if(run==wicketNumber)
                  {
                      // consider as wicket for Now
                      Ball ball = new Ball(i,j,batsman1.getName(),Bowler.getName(),0,true);
                      Bowler.addWicketByPlayer();
                      batsman1.addBallAtWicketDown();
                      team1.addBallDetails(ball);
                      team1.addWicketLoss();
                      if(team1.getWicketLoss() == lastWicket) {return team1.getScore();}
                      batsman1 = team1.getBatsman(batsmanNo++);
                  }
                  else
                  {
                     // 0,1,2,3,4,5,6
                      Ball ball = new Ball(i,j,batsman1.getName(),Bowler.getName(),run,false);
                      batsman1.addRunByPlayer(run);
                      Bowler.addRunConsiderByPlayer(run);
                      team1.addScore(run);
                      team1.addBallDetails(ball);
                      if((run%2) == 1) {
                         // Strike change  by batsman at run : 1,3,5
                          ArrayList<Player>  newPositionOfBatsman=  StrikeChange(batsman1,batsman2);
                         batsman1 = newPositionOfBatsman.get(0);
                         batsman2 = newPositionOfBatsman.get(1);
                     }


                    }


             }

             team1.addOversPlay();
             // Strike change every over
             ArrayList<Player> newPositionOfBatsman=  StrikeChange(batsman1,batsman2);
             batsman1 = newPositionOfBatsman.get(0);
             batsman2 = newPositionOfBatsman.get(1);
         }
         return team1.getScore();
    }

    private int RandomFunction()
    {
        int num = (int)(Math.random()*150);

        if(num > 140) return wicketNumber;
        else if(num > 130) return six;
        else if(num > 100) return four;
        else return (int)(Math.random()*5);
    }
    private ArrayList<Player> StrikeChange(Player batsman1, Player batsman2) {
        ArrayList<Player> p =  new ArrayList<Player> ();
        p.add(batsman2);
        p.add(batsman1);

        return p;
    }
    private void printScoreBord(Team team1,Team team2) {

        // 1st inning
        scoreBord.PrintScoreBordOfBattingTeam(team1);
        scoreBord.PrintScoreBordOfBowlingTeam(team2);
        scoreBord.GetDetailOfBall(team1);

        // 2nd inning
        scoreBord.PrintScoreBordOfBattingTeam(team2);
        scoreBord.PrintScoreBordOfBowlingTeam(team1);
        scoreBord.GetDetailOfBall(team2);
    }
}
