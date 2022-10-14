import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String args[]) {
        StopWatch stopWatch = new StopWatch();

    }
}

 class StopWatch implements ActionListener{
JFrame f = new JFrame("Timer ");
JButton startbtn = new JButton();
JButton resetbtn = new JButton();
JLabel time = new JLabel();
int passed = 0;
int second = 0;
int minute = 0;
int hour = 0;
boolean started =false;
String second_string = String.format("%02d"  ,second);
String minute_string = String.format("%02d"  ,minute);
String hour_string = String.format("%02d" , hour);
ImageIcon icon = new ImageIcon(Main.class.getResource("/clock.png"));

   Timer t = new Timer(1000 , new ActionListener() {                  //1 second = 1000 millisecond . Converting 1 sec to ms
    @Override
    public void actionPerformed(ActionEvent e) {
    passed += 1000;
    hour =  (passed / (3600 * 1000));
    minute = (passed / (60* 1000)) % 60;                                 // last operator prevents incrementing minute more than 60
    second = (passed / 1000) %60;

    //update strings
        second_string = String.format("%02d"  ,second);
        minute_string = String.format("%02d"  ,minute);
        hour_string = String.format("%02d" , hour);

        time.setText(hour_string + " : " + minute_string + " : " + second_string);


    }
});


StopWatch(){
    f.setVisible(true);
    f.getContentPane().setBackground(Color.black);
    f.setSize(475,450);
    f.setLayout(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(time);
    f.add(startbtn);
    f.add(resetbtn);
    f.setIconImage(icon.getImage());
    time.setText(hour_string + " : " + minute_string + " : " + second_string);
    time.setBounds(82,140,280,100);
    time.setOpaque(true);
    time.setForeground(Color.green);
    time.setBackground(Color.black);
    time.setBorder(new LineBorder(Color.white, 5 , true));
    time.setHorizontalAlignment(JTextField.CENTER);
    time.setFont(new Font("Arial" , Font.BOLD , 30 ));
    startbtn.setBounds(100 , 290 , 100, 40);
    startbtn.setFont(new Font("Arial" , Font.BOLD, 17));
    startbtn.setText("Start");
    startbtn.setBorder(new LineBorder(Color.white, 4 , false));
    startbtn.setBackground(Color.white);
    startbtn.setFocusable(false);
    startbtn.setForeground(Color.black);
    startbtn.addActionListener(this);
    resetbtn.setBounds(236 , 290 , 102, 40);
    resetbtn.setFont(new Font("Arial" , Font.BOLD, 17));
    resetbtn.setText("Reset");
    resetbtn.setBorder(new LineBorder(Color.white, 4 , false));
    resetbtn.setBackground(Color.white);
    resetbtn.setFocusable(false);
    resetbtn.setForeground(Color.black);
    resetbtn.addActionListener(this);








}
@Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource() == startbtn){
        if(!started){
            started = true;
            startbtn.setText("Stop");
            start();
        }
        else{
            started = false;
            startbtn.setText("Start");
            stop();
        }
    }
    if(e.getSource() == resetbtn){
      started = false;
      startbtn.setText("Start");
      reset();


    }

    }
    public void start(){
    t.start();

    }
    public void stop(){
    t.stop();
    }
    public void reset(){
    t.stop();
    passed = 0;
    second = 0;
    minute = 0;
    hour = 0;
        second_string = String.format("%02d"  ,second);
        minute_string = String.format("%02d"  ,minute);
        hour_string = String.format("%02d" , hour);

        time.setText(hour_string + " : " + minute_string + " : " + second_string);


    }












}
