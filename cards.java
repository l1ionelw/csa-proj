import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event .ActionListener;
import javax.swing.*;


public class cards extends JFrame{
    private int cardIndex = 0;
    private int lastCardIndex = 5;
    private CardLayout c;

    public cards() {
        setTitle("gui project");

        setSize(640, 480);

        setUpCards();


    }

    public void setUpCards(){
        JPanel cardP = new JPanel();


        c = new CardLayout();
        cardP.setLayout(c);

        JPanel home = new JPanel();
        JPanel main = new JPanel();
        JPanel action01 = new JPanel();
        JPanel action02 = new JPanel();
        JPanel reports = new JPanel();
        JPanel leaderboard = new JPanel();

        JLabel hL = new JLabel("home");
        JLabel mL = new JLabel("main dashboard");
        JLabel a01L = new JLabel("action screen 1");
        JLabel a02L = new JLabel("action screen 2");
        JLabel rL = new JLabel("reports");
        JLabel lbL = new JLabel("leaderboard");

        home.add(hL);
        main.add(mL);
        action01.add(a01L);
        action02.add(a02L);
        reports.add(rL);
        leaderboard.add(lbL);

        cardP.add(home, "0");
        cardP.add(main, "1");
        cardP.add(action01, "2");
        cardP.add(action02, "3");
        cardP.add(reports, "4");
        cardP.add(leaderboard, "5");

        // buttons on all cards - navigation
        JPanel buttonsP = new JPanel();

        JButton homeB = new JButton("home");
        JButton nextB = new JButton("next");
        JButton prevB = new JButton("previous");
        JButton leadB = new JButton("leaderboard");

        buttonsP.add(homeB);
        buttonsP.add(nextB);
        buttonsP.add(prevB);
        buttonsP.add(leadB);

        homeB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                c.first(cardP);

                cardIndex = 0;
            }

        });

        leadB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                c.last(cardP);

                cardIndex = lastCardIndex;
            }

        });

        nextB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                if (cardIndex < lastCardIndex)
                {


                    cardIndex++;


                    c.show(cardP, "" + (cardIndex));
                } else {
                    c.first(cardP);
                    cardIndex = 0;
                }

            }
        });

        prevB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {


                if (cardIndex > 0)
                {


                    cardIndex--;


                    c.show(cardP, "" + (cardIndex));

                } else {
                    c.last(cardP);
                    cardIndex = lastCardIndex;
                }

            }
        });

        //HOME
        home.setLayout(new BoxLayout(home,BoxLayout.Y_AXIS));

        JButton newRun = new JButton("new run");
        JButton help = new JButton("help");
        home.add(Box.createRigidArea(new Dimension(0,100)));
        home.add(newRun);
        home.add(Box.createRigidArea(new Dimension(0, 25)));
        home.add(help);
        hL.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        newRun.setAlignmentX(JButton.CENTER_ALIGNMENT);
        help.setAlignmentX(JButton.CENTER_ALIGNMENT);

        //MAIN DASHBOARD


        getContentPane().add(cardP, BorderLayout.NORTH);
        getContentPane().add(buttonsP, BorderLayout.SOUTH);


    }



}

// to add for gui:
// 1. methods that create and delete action pages as reaction to user action / games's progression

// 2. Home / Start screen: New Run, Load Run (optional), Help. - make buttons

// 3. Main dashboard: core gameplay/simulation controls and current status. - allow/respond to user input to make game progress (create fields/buttons needed)


// 4. Decision/action screen(s): where the player makes choices (can be a panel on the main screen). - make methods that create/delete action screens as game progresses/based on user choice

// 5. Reports screen: summary stats + Save Report button (writes to file).

// 6. History/Leaderboard screen: loads from file, supports sort + search.





