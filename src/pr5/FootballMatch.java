package pr5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FootballMatch extends JFrame {
    private int scoreMilan = 0;
    private int scoreMadrid = 0;

    private JLabel resultLabel;
    private JLabel lastScorerLabel;
    private JLabel winnerLabel;

    public FootballMatch() {
        setTitle("Football Match Score");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton milanButton = new JButton("AC Milan");
        milanButton.setBounds(50, 50, 100, 30);
        add(milanButton);

        JButton madridButton = new JButton("Real Madrid");
        madridButton.setBounds(250, 50, 100, 30);
        add(madridButton);

        resultLabel = new JLabel("Result: 0 X 0");
        resultLabel.setBounds(150, 10, 200, 30);
        add(resultLabel);

        lastScorerLabel = new JLabel("Last Scorer: N/A");
        lastScorerLabel.setBounds(150, 90, 200, 30);
        add(lastScorerLabel);

        winnerLabel = new JLabel("Winner: DRAW");
        winnerLabel.setBounds(150, 130, 200, 30);
        add(winnerLabel);

        milanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scoreMilan++;
                updateScore("AC Milan");
            }
        });

        madridButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scoreMadrid++;
                updateScore("Real Madrid");
            }
        });
    }

    private void updateScore(String lastScorer) {
        resultLabel.setText("Result: " + scoreMilan + " X " + scoreMadrid);
        lastScorerLabel.setText("Last Scorer: " + lastScorer);

        if (scoreMilan > scoreMadrid) {
            winnerLabel.setText("Winner: AC Milan");
        } else if (scoreMadrid > scoreMilan) {
            winnerLabel.setText("Winner: Real Madrid");
        } else {
            winnerLabel.setText("Winner: DRAW");
        }
    }

    public static void main(String[] args) {
        // Запуск приложения
        FootballMatch frame = new FootballMatch();
        frame.setVisible(true);
    }
}
