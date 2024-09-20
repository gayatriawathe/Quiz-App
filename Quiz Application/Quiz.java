import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Quiz extends JFrame implements ActionListener{
    //2D Array for Questions
    String questions[][]=new String[10][5];
    //to stores ans
    String answers[][]=new String[10][2];
    String useranswers[][]=new String[10][1];
    JLabel qno,question;
    JRadioButton op1,op2,op3,op4;
    ButtonGroup groupoptions;
    JButton next,lifeline,submit;
    public static int timer=15;//initial value of timer
    //After Times up next flag will be display to which "ans_given" flag is maintain
    public static int ans_given=0;
    public static int count=0;
    //Initially score will be 0
    public static int score=0;
    //for which globally declared
    String name;
    Quiz(String name){
        this.name=name;//globally store
        setBounds(50,0,1440,800);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1440,390);
        add(image);

        qno=new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(qno);

        question=new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(question);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

//Find below the Answers Array of the above Questions
        
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        //JRadioButton means round button...Select only 1 out of 4..which is inside "" it is written with round button
        op1=new JRadioButton();
        op1.setBounds(170,520,700,30);
        op1.setBackground(Color.WHITE);
        op1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(op1);

        op2=new JRadioButton();
        op2.setBounds(170,560,700,30);
        op2.setBackground(Color.WHITE);
        op2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(op2);

        op3=new JRadioButton();
        op3.setBounds(170,600,700,30);
        op3.setBackground(Color.WHITE);
        op3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(op3);

        op4=new JRadioButton();
        op4.setBounds(170,640,700,30);
        op4.setBackground(Color.WHITE);
        op4.setFont(new Font("Dialog",Font.PLAIN,20));
        add(op4);

        //To group the button..to group all option..if we select 1 opt then all the remaining opt will be disselect
        groupoptions=new ButtonGroup();
        groupoptions.add(op1);
        groupoptions.add(op2);
        groupoptions.add(op3);
        groupoptions.add(op4);

        //TO make Button
        next=new JButton("Next");
        next.setBounds(1100,550,200,40);
        next.setFont(new Font("Tahoma",Font.PLAIN,22));
        next.setBackground(new Color(30,144,255));
        next.setForeground(Color.WHITE);
        //for funtion of next button
        next.addActionListener(this);
        add(next);

        lifeline=new JButton("50-50 Lifeline");
        lifeline.setBounds(1100,630,200,40);
        lifeline.setFont(new Font("Tahoma",Font.PLAIN,22));
        lifeline.setBackground(new Color(30,144,255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit=new JButton("Submit");
        submit.setBounds(1100,710,200,40);
        submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        //Function to insert the value...(0)from which question no.it will be start 
        start(count);

        setVisible(true);
    }
    //Function of Buttons
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            repaint();

            //After Clicking to next Button
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);

            ans_given=1;

            //Whether the user give the ans or not
            if(groupoptions.getSelection()==null){                //user ne select nhi kiya hai toh
                useranswers[count][0]="";         
            }else{                 //user ne select kiya hai
                useranswers[count][0]=groupoptions.getSelection().getActionCommand();
            }

            //At 9th question,next button-disable & submit button-enable
            if(count==8){     //9th question...because count start from 0
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);

        }else if(ae.getSource()==lifeline){
            if(count==2 || count==4 || count==6 || count==8 || count==9){
                op2.setEnabled(false);
                op3.setEnabled(false);
            }else{
                op1.setEnabled(false);
                op4.setEnabled(false);
            }
            //It will be disable, after 1 time use
            lifeline.setEnabled(false);
        }else if(ae.getSource()==submit){
            ans_given=1;
            if(groupoptions.getSelection()==null){                //user ne select nhi kiya hai toh
            useranswers[count][0]="";         
                }else{                 //user ne select kiya hai
                    useranswers[count][0]=groupoptions.getSelection().getActionCommand();
                                    //4option        //select one opt     //ans of this question
                }
                //after selecting last question,want to calculate score by for loop
                for(int i=0;i<useranswers.length;i++){
                    if(useranswers[i][0].equals(answers[i][1])){      //if userans=actualans then score++
                        score+=10;
                    }else{    //if ans is wrong
                    score+=0;
                    }
                }
                //after calculating the score
                setVisible(false);
                //to make the score name obj
                new Score(name,score);

        }

    }

    //timer value continuously change ...means continuouly repaint happen with the help of Graphics class
    public void paint(Graphics g){
        super.paint(g);
        //Timer lagane ke liye
        String time="Time left - "+ timer +"seconds";   //this is graphics which display
        //to change the graphics class text..with the help of graphics class obj
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma",Font.BOLD,25));

        if(timer>0){
            //with the help of"drawString",where to show which string (konsi string ko kaha pr dikhani hai)
            g.drawString(time,1100,500);
        }else{
            g.drawString("Times Up !!",1100,500);
        }
        timer--;//14 after 1 sec
        try{
            //To stop the Code of execution in 1 sec
            Thread.sleep(1000);//it take the value in mili sec (1sec=1000msec)
            repaint(1);//it decreasing the value by 1 sec
        }catch(Exception e){
            e.printStackTrace();
        }
        //if user give the ans...then shift it to next question...Timer again 15 sec
        if(ans_given ==1){
            ans_given=0;
            timer=15;
        }else if(timer<0){ //if we didn't give the ans and timer will be < 0 then it goes to next question
            timer=15;
            //After Time Ups....
            //Option Enable after shifting to next question
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);
            
            if(count==8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count==9){    //submit button
                //without click on submit button ,it automatically submit...for which we calculate something
                if(groupoptions.getSelection()==null){                //if user don't select 
                    useranswers[count][0]="";         
                }else{                 //if user selected
                    useranswers[count][0]=groupoptions.getSelection().getActionCommand();
                                    //4 option        //select one opt     //ans of this question
                }
                //after selecting last question,want to calculate score by for loop
                for(int i=0;i<useranswers.length;i++){
                    if(useranswers[i][0].equals(answers[i][1])){      //if userans=actualans then score++
                        score+=10;
                    }else{    //if ans is wrong
                    score+=0;
                    }
                }
                //after calculating the score
                setVisible(false);
                //new class where we display our score to become the class of that class we call it
                new Score(name,score);
            }
            else{           //next Button
            //Check wheather the user give the ans or not means select the ans or not
            if(groupoptions.getSelection()==null){                //if user didn't select it
                useranswers[count][0]="";         
            }else{                 //if the user select it
                useranswers[count][0]=groupoptions.getSelection().getActionCommand();
                                //4 option        //select one opt     //ans of this question
            }
            count++;//ini=0
            //next question display nhi honga untill the start function haven't be call ...for start func 
            ///count taken to count the correct ans
            start(count);
        }
        }
    }

    public void start(int count){
        //for double code we convert int into string
        qno.setText("" +(count+1)+". ");
        question.setText(questions[count][0]);
        op1.setText(questions[count][1]);
        op1.setActionCommand(questions[count][1]);

        op2.setText(questions[count][2]);
        op2.setActionCommand(questions[count][2]);

        op3.setText(questions[count][3]);
        op3.setActionCommand(questions[count][3]);

        op4.setText(questions[count][4]);
        op4.setActionCommand(questions[count][4]);

        //After Shift to next question....Option will be Disselect
        groupoptions.clearSelection();

    }
    public static void main(String[] args) {
        new Quiz("User");
    }
}
