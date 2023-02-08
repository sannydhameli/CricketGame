import java.util.ArrayList;

public class ScoreBord
{
    void PrintScoreBordOfBattingTeam(Team T) {

        System.out.println( T.getTeamName() +" Innings");
        ArrayList<Player>  player = T.getPlayers();
        System.out.println("+----------------------+----------+-------+----------+");
        System.out.println("|     Name             |    Role   | Runs  | Balls   |");
        System.out.println("+----------------------+----------+-------+----------+");
        for (Player p : player) {
            System.out.println(String.format("| %-20s | %-8s | %5d | %8d |", p.getName(), p.getRole(), p.getRunScoredByPlayer(), p.getBallsFacedByPlayer()));
        }
        System.out.println("+----------------------+----------+-------+----------+");

        System.out.println();
        System.out.println();
        System.out.println();
    }

    void PrintScoreBordOfBowlingTeam(Team T)
    {
        ArrayList<Player>  player = T.getPlayers();
        System.out.println("+----------------------+----------+-----------+---------------+------------+");
        System.out.println("|     Name             |    Role  |  Wickets  |  RunConsider  | BallBowled |");
        System.out.println("+----------------------+----------+-----------+---------------+------------+");
        for (Player p : player) {
            if (p.getRole().equals("Bowler"))
            {
                System.out.println(String.format("| %-20s | %-8s | %10d | %10d | %10d |", p.getName(), p.getRole(), p.getWicketTakenByPlayer(), p.getRunConsiderByPlayer(),p.getBallBowledByPlayer()));

            }
       }

        System.out.println("+----------------------+----------+-----------+---------------+------------+");

        System.out.println();
        System.out.println();
        System.out.println();
    }


    void GetDetailOfBall(Team team) {
        ArrayList<Ball> BallDetail = team.getBallDetails();

        System.out.println("+---------------------+---------------------+-------+-------+-------+");
        System.out.println("|    Batsman          |     Bowler          |  Ball |  Over | Runs  |");
        System.out.println("+---------------------+---------------------+-------+-------+-------+");
        for (Ball B : BallDetail) {
            System.out.println(String.format("| %-20s | %-20s | %5d | %5d | %5d |", B.getNameOfBatsman(), B.getNameOfBowler(), B.getSerialNoOfBall(), B.getOverNo(), B.getRuns()));
        }
        System.out.println("+---------------------+---------------------+-------+-------+--------+");

        System.out.println();
        System.out.println();
        System.out.println();
    }

    void printMatchResult(Team team1, Team team2, int team1Score, int team2Score, int overs) {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                 Match Result                     |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("| Team1: " + team1.getTeamName() + "                                    |");
        System.out.println("| Team2: " + team2.getTeamName() + "                                 |");
        System.out.println("| Score: " + team1Score + " / " + team1.getWicketLoss() + " (" + team1.getOversPlay() + " overs)                      |");
        System.out.println("| Score: " + team2Score + " / " + team2.getWicketLoss() + " (" + team2.getOversPlay() + " overs)                      |");
        System.out.println("+--------------------------------------------------+");
        if (team1Score > team2Score) {
            System.out.println("| " + team1.getTeamName() + " won the match                           |");
        } else if (team2Score > team1Score) {
            System.out.println("| " + team2.getTeamName() + " won the match                           |");
        } else {
            System.out.println("| The match was a draw                              |");
        }
        System.out.println("+--------------------------------------------------+");
    }



}


