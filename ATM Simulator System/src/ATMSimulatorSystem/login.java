
package ATMSimulatorSystem;

import ATMSimulatorSystem.Signup;
import ATMSimulatorSystem.Transations;
import ATMSimulatorSystem.conn;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Locale;

public class login extends JFrame implements ActionListener {
    
    //declare all global variables for login constructor
    //if we declare all swing variables in login constructor, we cant use it all in funtions. 
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;
    
    login()   //create login same class name constructor
    {
       //we can print "AUTOMATED TELER MACHINE" TEXT on login page at center using below coding 
       //we also use "super("text");" but this formulas not use for center the text its show only left top side texts.
       //super("AUTOMATED TELER MACHINE");  //this is not proper code
       setFont(new Font("System",Font.BOLD,22));
       Font f=getFont();
       FontMetrics fm=getFontMetrics(f);
       int x=fm.stringWidth("AUTOMATED TELER MACHINE");
       int y=fm.stringWidth(" ");
       int z=getWidth() -x;
       int w=z/y;
        String pad="";
        //for(int i=0;i!=w;i++) pad +=" ";
        pad=String.format("%"+w+"s", pad);
        setTitle(pad+"AUTOMATED TELER MACHINE"); 
        // complete code here for title of login page
        
        /*now we define all declared above swings varibles here*/
            //define label components l1,l2,l3
        l1=new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Osward",Font.BOLD,38));
        
        l2=new JLabel("Card No:");
        l2.setFont(new Font("Raleway",Font.BOLD,28));
        
        l3=new JLabel("PIN:");
        l3.setFont(new Font("Raleway",Font.BOLD,28));
        
        //define TextField & JPasswordField component
        tf1=new JTextField(15);
        pf2=new JPasswordField(15);
        
        //define buttons b1,b2,b3
        b1=new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2=new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3=new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        setLayout(null); // we can set login page layout ourselves. that why we make null . and fixed setBound() for it for setting and use add() on screen for display.
        
        l1.setBounds(175,50,450,200);
        add(l1);
        l2.setBounds(125, 150, 375, 200);
        add(l2);
        l3.setBounds(125, 225, 375, 200);
        add(l3);
        
        tf1.setFont(new Font("Arial",Font.BOLD,14));
        tf1.setBounds(300, 235, 230, 30);
        add(tf1);
        
        pf2.setFont(new Font("Arial",Font.BOLD,14));
        pf2.setBounds(300, 310, 230, 30);
        add(pf2);
        
        b1.setFont(new Font("Arial",Font.BOLD,14));
        b1.setBounds(300, 400, 100, 30);
        add(b1);
        
        b2.setFont(new Font("Arial",Font.BOLD,14));
        b2.setBounds(430,400, 100, 30);
        add(b2);
        
        b3.setFont(new Font("Arial",Font.BOLD,14));
        b3.setBounds(300, 450, 230, 30);
        add(b3);
        
        //need to perform action when user click on components
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        //set frame background color
        getContentPane().setBackground(Color.white);
        
        //set size of frame
        setSize(750,750);
        setLocation(500,200);
        setVisible(true);  //for  screen visualization 
    }
     //what kind of action we want to perform ? all action available in ActionPerformed()....
    public void actionPerformed(ActionEvent ae)
    {
        try{
            conn c1=new conn();
            String a=tf1.getText(); //getText() function used for retrive the data..
            String b=pf2.getName();
            String q="select * from login where cardno = '"+a+" and pin = '"+b+"' ";//this line get data from login card no and pin number directly from textfield and password field components.
            ResultSet rs=c1.s.executeQuery(q); 
            
            // we can use executeQuery(string sql) when we want to get data from database
            // another is executeUpdate(string sql) when we want to fill data in the database.
            //--------------------------------------
            
            //signIn button code into login page
            if(ae.getSource()==b1)
            {
                if(rs.next())
                {
                    String pin=null;
                    
                    new Transations(pin).setVisible(true);
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number Or Password.");
                }
            }
            else if(ae.getSource()==b2)  ///clear button
            {
                tf1.setText("");
                pf2.setText("");
            }
            else if(ae.getSource()==b3)  //signUp form
            {
                new Signup().setVisible(true);
                setVisible(false);
            }
        }
        catch(Exception e)
        {
             e.printStackTrace();
             System.out.println("Error:"+e);
        }
    }
    public static void main(String[] args) {
        new login().setVisible(true);  //login constructor call here using new keyword.
       
    }
    
}
