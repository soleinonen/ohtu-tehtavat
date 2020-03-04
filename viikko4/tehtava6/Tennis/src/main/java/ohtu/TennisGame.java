package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String[] scoreNames = {"Love", "Fifteen", "Thirty", "Forty"};
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    public String getScore() {
        if(isOver()){
                return "Win for "+whoWon();
        }
        if(isAdvantageStage() && isEven()){
                return "Deuce";
        }
        if(isAdvantageStage() && !isEven()){
                return "Advantage "+whoHasMorePoints();
        }
        if(!isAdvantageStage() && isEven()){
                return scoreNames[player1Score]+"-All";
        }
        return scoreNames[player1Score]+"-"+scoreNames[player2Score];
    }

    private boolean isAdvantageStage() {
        if(player1Score>3 || player2Score>3){
            return true;
        } else {
            return false;
        }
    }

    private boolean isOver(){
        if(Math.abs(player1Score-player2Score)>1 && (player1Score>3 || player2Score>3)){
            return true;
        } else {
            return false;
        }
    }

    private String whoWon(){
        if(player1Score>player2Score){
            return player1Name;
        } else {
            return player2Name;
        }
    }

    private boolean isEven(){
        if(player1Score == player2Score){
            return true;
        } else {
            return false;
        }
    }

    private String whoHasMorePoints(){
        if(player1Score>player2Score){
            return player1Name;
        } else {
            return player2Name;
        }
    }
}