package Bootcamp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.util.*;
import java.io.*;
class Login
{
	int b;
	JLabel l1,l2;  
	JTextField t1,t2;
	JButton b4;
	JFrame f=new JFrame("Login Page");
	Login()
	{
		l1=new JLabel("Customer Id");
		l1.setBounds(50,50, 150,30);
		t1=new JTextField();  
		t1.setBounds(200,50, 150,30);
		    
		l2=new JLabel("Password");  
		l2.setBounds(50,85, 150,30); 
		t2=new JTextField();  
		t2.setBounds(200,85, 150,30);
		
		b4=new JButton("Login");  
	    b4.setBounds(175,175,150,30);  
	    b4.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{
				validate();
			}
		});
		
		f.add(l1);
		f.add(l2);
		f.add(t1);
		f.add(t2);
		f.add(b4);
		f.setSize(500,500);  
		f.setLayout(null);  
		f.setVisible(true);
	}
	void validate()
	{		
		    String s1=t1.getText();  
		    String s2=t2.getText();
		    String tempUser,tempPass,tempname;
		    int found=0;
		    try
    		    {
		    	File file =new File("F:\\Customs\\customer_details.txt");
		    	if(!file.exists()){
                    file.createNewFile();
                  }
               FileReader fr = new FileReader(file);
             	 BufferedReader reader = new BufferedReader(fr);
             	 String line;
             	// int found=0;
             	 while((line=reader.readLine())!=null)
             	 {
             		String[] list = line.split(",");
             		if(list[0].equals(s1)&&list[1].equals(s2))
             		{
             			found=1;
             			JOptionPane.showMessageDialog(f,"Welcome "+list[2]);
             			f.dispose();
             			new Main_page(s1);
             		}
             	 }
             	 if(found == 0)
             	 {
             		JOptionPane.showMessageDialog(f,"Invalid!Please Enter correct Customer Id or Password");
             		t1.setText("");
             		t2.setText("");
             	 }
		}

    catch (Exception e)
    {
        JOptionPane.showMessageDialog(f,"Invalid!Please Enter correct Customer Id or Password");

    }
}

}