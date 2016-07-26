package cool.superfcking.apps.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int homeScore;
    int awayScore;

    int homeStrikes;
    int homeBalls;

    int awayStrikes;
    int awayBalls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetGame();
    }

    private void refreshScoreboard(){
        TextView homeScoreView = (TextView) findViewById(R.id.home_score_text_view);
        TextView awayScoreView = (TextView) findViewById(R.id.away_score_text_view);

        TextView homeStrikeCountView = (TextView) findViewById(R.id.home_strikes_text_view);
        TextView homeBallCountView = (TextView) findViewById(R.id.home_balls_text_view);

        TextView awayStrikeCountView = (TextView) findViewById(R.id.away_strikes_text_view);
        TextView awayBallCountView = (TextView) findViewById(R.id.away_balls_text_view);

        homeScoreView.setText(String.valueOf(homeScore));
        awayScoreView.setText(String.valueOf(awayScore));

        homeStrikeCountView.setText(String.valueOf(homeStrikes));
        homeBallCountView.setText(String.valueOf(homeBalls));

        awayStrikeCountView.setText(String.valueOf(awayStrikes));
        awayBallCountView.setText(String.valueOf(awayBalls));

    }

    private void resetGame(){
        homeScore = 0;
        awayScore = 0;

        resetHomeBatting();
        resetAwayBatting();
        refreshScoreboard();

    }

    private void resetHomeBatting(){
        homeStrikes = 0;
        homeBalls = 0;
    }

    private void resetAwayBatting(){
        awayStrikes = 0;
        awayBalls = 0;
    }

    public void resetScores(View view){
        resetGame();
    }

    public void homeRegisterStrike(View view){
        // Add a strike to the strike count
        homeStrikes += 1;

        // Mark the player as out if they are at 3 strikes now
        if (homeStrikes == 3){
            homeStrikes = 0;
        }

        refreshScoreboard();
    }

    public void homeRegisterFoul(View view){
        // Fouls only add to the strike count if the current strike count is 0 or 1
        if (homeStrikes <= 1){
            homeStrikes += 1;
        }

        refreshScoreboard();
    }

    public void homeRegisterBall(View view){
        homeBalls += 1;
        if (homeBalls == 4){
           homeBalls = 0;
        }

        refreshScoreboard();
    }

    public void homeRegisterOut(View view){
        resetHomeBatting();
        refreshScoreboard();
    }

    public void homeRegisterRun(View view){
        homeScore += 1;
        resetHomeBatting();
        refreshScoreboard();
    }

    public void awayRegisterStrike(View view){
        // Add a strike to the strike count
        awayStrikes += 1;

        // Mark the player as out if they are at 3 strikes now
        if (awayStrikes == 3){
            resetAwayBatting();
        }

        refreshScoreboard();
    }

    public void awayRegisterFoul(View view){
        // Fouls only add to the strike count if the current strike count is 0 or 1
        if (awayStrikes <= 1){
            awayStrikes += 1;
        }

        refreshScoreboard();
    }

    public void awayRegisterBall(View view){
        awayBalls += 1;
        if (awayBalls == 4){
            resetAwayBatting();
        }

        refreshScoreboard();
    }

    public void awayRegisterOut(View view){
        resetAwayBatting();
        refreshScoreboard();
    }

    public void awayRegisterRun(View view){
        awayScore += 1;
        resetAwayBatting();
        refreshScoreboard();
    }

}
