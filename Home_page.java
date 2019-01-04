package Bootcamp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;  
  
public class Home_page {  
	JLabel l1;
	public Home_page()
	{
		JFrame f=new JFrame("Customs Management System");  
		
	    l1=new JLabel("Customs Management System"); 
	    l1.setFont(new Font("Serif",Font.BOLD,30));
	    l1.setBounds(50,100,500,50);
	    
	    JButton b4=new JButton("Sign up");  
	    b4.setBounds(100,200,100,30);  
	    b4.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{
				f.dispose();
				new customer_details();
			}
		});
	    
	    JButton b5=new JButton("Login");  
	    b5.setBounds(250,200,100,30);  
	    b5.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{
				f.dispose();
				new Login();
			}
		});
	    
	    f.add(l1);
		f.add(b4);
		f.add(b5);
		f.setSize(500,500);  
		f.setLayout(null);  
		f.setVisible(true);
	    
	}
	public static void main(String []args)
	{
		new Home_page();
	}
     
  
}  
