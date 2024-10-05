package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Login1.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);
        
        questions[0][0] = "Which of the following statements about relation R in 1NF is/are True?";
        questions[0][1] = "R cannot have a foreign key";
        questions[0][2] = "R can have a multi-attribute key";
        questions[0][3] = "R cannot have more than one candidate key";
        questions[0][4] = "R cannot have a composite key";

        questions[1][0] = "The number of spanning trees in a complete graph of 4 vertices labelled A, B, C and D is?";
        questions[1][1] = "8";
        questions[1][2] = "12";
        questions[1][3] = "16";
        questions[1][4] = "20";

        questions[2][0] = "Which of the following process state transition is/are NOT possible?";
        questions[2][1] = "Ready to Waiting";
        questions[2][2] = "Running to Ready";
        questions[2][3] = "Running to Terminated";
        questions[2][4] = "Waiting to Running";

        questions[3][0] = "In a B+tree the requirement of at least half full (50%) node occupancy is relaxed for which are of the following case?";
        questions[3][1] = "All leaf node ";
        questions[3][2] = "Only the root node";
        questions[3][3] = "All internal nodes ";
        questions[3][4] = "Only the left most leaf node";

        questions[4][0] = "Consider a 512 GB hard disk with 32 storage surface. There are 4096 sectors per track and each sector had 1024 bytes of data. The number of cylinder in the hard disk is?";
        questions[4][1] = "512";
        questions[4][2] = "1024";
        questions[4][3] = "2048";
        questions[4][4] = "4096";

        questions[5][0] = "log(p2+ q2)= logp + logq + 2log3 .find the value of?";
        questions[5][1] = "9";
        questions[5][2] = "79";
        questions[5][3] = "81";
        questions[5][4] = "83";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "Consider a binary min-heap containing 105 distinct elements?";
        questions[7][1] = "50";
        questions[7][2] = "51";
        questions[7][3] = "52";
        questions[7][4] = "53";

        questions[8][0] = "If two distinct non-zero real variables x and y such that x and y is proportional to x + y is proportional to (x-y) then x/y ? ";
        questions[8][1] = "depends only on x ";
        questions[8][2] = "depends on xy";
        questions[8][3] = "depends only on y";
        questions[8][4] = "is a constant";

        questions[9][0] = "An array [82, 101, 90, 11, 111, 75, 33, 131, 44, 93] is heapified. Which one of the following options represents the first three elements in the heapified array??";
        questions[9][1] = "82, 90, 101";
        questions[9][2] = "82, 11, 93 ";
        questions[9][3] = "131, 11, 93";
        questions[9][4] = "131, 111, 90";
        
        answers[0][1] = "R can have a multi-attribute key";
        answers[1][1] = "16";
        answers[2][1] = "Ready to Waiting";
        answers[3][1] = "Only the root node";
        answers[4][1] = "4096";
        answers[5][1] = "79";
        answers[6][1] = "import";
        answers[7][1] = "53";
        answers[8][1] = "is a constant";
        answers[9][1] = "131, 111, 90";
        
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        if (timer > 0) { 
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }
        
        timer--; // 14
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }
        
    }
    
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz("User");
    }
}
