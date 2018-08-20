package com.example.android.rickandmortycardgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout playerBWinner, score, playerAWinner;
    RelativeLayout progressSection, parasiteSection, realSection;
    int realPlayerA = 0;
    int realPlayerB = 0;
    int overallScoreViewA = 0;
    int overallScoreViewB = 0;
    int totalKill = 0;
    int progressA = 0;
    int progressB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerBWinner = findViewById(R.id.playerBWinner);
        realSection = findViewById(R.id.real_section);
        progressSection = findViewById(R.id.progress_section);
        parasiteSection = findViewById(R.id.parasite_section);
        score = findViewById(R.id.overall_score);
        playerAWinner = findViewById(R.id.playerAWinner);
    }

    /**
     * increase the point by 1 for overall score
     */
    public void parasite1(View v) {
        totalKill = totalKill + 1;
        displayForPlayers(totalKill);
    }
    /**
     * increase the point by 1 for Player A
     */
    public void real1(View v) {
        realPlayerA = realPlayerA + 1;
        totalKill = totalKill + 1;
        progressA = progressA + 1;
        displayForPlayers(totalKill);
        displayProgressA(progressA);
        displayForPlayerA(realPlayerA);

        /**
         * when points of Player A reaches 4, one score is added to Player B and players' score resets
         */

        if (realPlayerA == 4) {
            overallScoreViewB = overallScoreViewB + 1;
            realPlayerB = 0;
            realPlayerA = 0;
            totalKill = 0;
            progressB = 0;
            progressA = 0;
            playerBWinner.setVisibility(LinearLayout.VISIBLE);
            realSection.setVisibility(RelativeLayout.GONE);
            parasiteSection.setVisibility(RelativeLayout.GONE);
            score.setVisibility(LinearLayout.GONE);
            progressSection.setVisibility(RelativeLayout.GONE);
            displayForOverallPlayerB(overallScoreViewB);
            displayForPlayerA(realPlayerA);
            displayForPlayerB(realPlayerB);
            displayForPlayers(totalKill);
            displayProgressA(progressA);
            displayProgressB(progressB);

        }
    }


    /**
     * Displays the overall score of Player B on progressBar.
     */
    public void displayProgressA(int progress) {
        ProgressBar progressA = (ProgressBar) findViewById(R.id.progress_bar1);
        progressA.setProgress(progress);

    }

    /**
     * Displays the given score for Player A.
     */

    public void displayForPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the total kill amount merging both players kill amount.
     */

    public void displayForPlayers(int score) {
        TextView scoreView = (TextView) findViewById(R.id.total_kills);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * increase the point by 1 for overallScore
     */

    public void parasite2(View v) {
        totalKill = totalKill + 1;
        displayForPlayers(totalKill);
    }

    /**
     *increase the point by 1 for Player B
     */
    public void real2(View v) {
        totalKill = totalKill + 1;
        progressB = progressB + 1;
        realPlayerB = realPlayerB + 1;
        displayForPlayers(totalKill);
        displayProgressB(progressB);
        displayForPlayerB(realPlayerB);

        /**
         * when points of Player B reaches 4, one score is added to Player A and players' score resets
         */
        if (realPlayerB == 4) {
            overallScoreViewA = overallScoreViewA + 1;
            realPlayerB = 0;
            realPlayerA = 0;
            totalKill = 0;
            progressB = 0;
            progressA = 0;
            playerAWinner.setVisibility(LinearLayout.VISIBLE);
            score.setVisibility(LinearLayout.GONE);
            realSection.setVisibility(RelativeLayout.GONE);
            parasiteSection.setVisibility(RelativeLayout.GONE);
            displayForOverallPlayerA(overallScoreViewA);
            progressSection.setVisibility(RelativeLayout.GONE);
            displayForPlayerB(realPlayerB);
            displayForPlayerA(realPlayerA);
            displayForPlayers(totalKill);
            displayProgressA(progressA);
            displayProgressB(progressB);

        }
    }

    public void nextRoundOne(View v) {

        playerBWinner.setVisibility(LinearLayout.GONE);
        playerAWinner.setVisibility(LinearLayout.GONE);
        realSection.setVisibility(RelativeLayout.VISIBLE);
        parasiteSection.setVisibility(RelativeLayout.VISIBLE);
        score.setVisibility(LinearLayout.VISIBLE);
        progressSection.setVisibility(RelativeLayout.VISIBLE);


    }

    /**
     * Displays the overall score of Player B on progressBar.
     */

    public void displayProgressB(int progress) {
        ProgressBar progressB = (ProgressBar) findViewById(R.id.progress_bar2);
        progressB.setProgress(progress);
    }

    /**
     * Displays the given score for Player B.
     */

    public void displayForPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_b);
        scoreView.setText(String.valueOf(score));

    }

    /**
     * resets the game to restart
     */

    public void reset(View v) {
        overallScoreViewA = 0;
        overallScoreViewB = 0;
        realPlayerB = 0;
        realPlayerA = 0;
        totalKill = 0;
        progressB = 0;
        progressA = 0;
        playerBWinner.setVisibility(LinearLayout.GONE);
        playerAWinner.setVisibility(LinearLayout.GONE);
        realSection.setVisibility(RelativeLayout.VISIBLE);
        parasiteSection.setVisibility(RelativeLayout.VISIBLE);
        score.setVisibility(LinearLayout.VISIBLE);
        progressSection.setVisibility(RelativeLayout.VISIBLE);
        displayForPlayerB(realPlayerB);
        displayForPlayerA(realPlayerA);
        displayForOverallPlayerA(overallScoreViewA);
        displayForOverallPlayerB(overallScoreViewB);
        displayForPlayers(totalKill);
        displayProgressA(progressA);
        displayProgressB(progressB);

    }

    /**
     * display given overall score for Player A
     */

    public void displayForOverallPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.overall_score_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * display given overall score for Player B
     */
    public void displayForOverallPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.overall_score_b);
        scoreView.setText(String.valueOf(score));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        //To save the scores
        savedInstanceState.putInt("OverallScoreA", overallScoreViewA);
        savedInstanceState.putInt("OverallScoreB", overallScoreViewB);
        savedInstanceState.putInt("RealPlayerA", realPlayerA);
        savedInstanceState.putInt("RealPlayerB", realPlayerB);
        savedInstanceState.putInt("TotalKill", totalKill);
        savedInstanceState.putInt("ProgressA", progressA);
        savedInstanceState.putInt("ProgressA", progressB);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        //To restore the scores
        super.onRestoreInstanceState(savedInstanceState);
        overallScoreViewA = savedInstanceState.getInt("OverallScoreA");
        realPlayerA = savedInstanceState.getInt("RealPlayerA");
        realPlayerB = savedInstanceState.getInt("RealPlayerB");
        overallScoreViewB = savedInstanceState.getInt("OverallScoreB");
        totalKill = savedInstanceState.getInt("TotalKill");
        progressA = savedInstanceState.getInt("ProgressA");
        progressB = savedInstanceState.getInt("ProgressB");
        displayForPlayerB(realPlayerB);
        displayForPlayerA(realPlayerA);
        displayForOverallPlayerA(overallScoreViewA);
        displayForOverallPlayerB(overallScoreViewB);
        displayForPlayers(totalKill);
        displayProgressA(progressA);
        displayProgressB(progressB);
    }
}
