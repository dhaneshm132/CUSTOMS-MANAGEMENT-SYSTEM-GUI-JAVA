package Bootcamp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;

import javax.swing.*;    
	public class customer_details {
		 JLabel l1,l2,l3,l4,l5,l6;  
		 JTextField t1,t2,t3,t4,t5,t6;
		 
		public customer_details()
		{
			JFrame f=new JFrame("Customer Details");  
		   
		    
		    l1=new JLabel("Name");  
		    l1.setBounds(50,50, 100,30);
		    t1=new JTextField();  
		    t1.setBounds(130,50, 150,30);
		    
		    l2=new JLabel("Aadhar No");  
		    l2.setBounds(50,85, 100,30); 
		    t2=new JTextField();  
		    t2.setBounds(130,85, 150,30);  
		    
		    l3=new JLabel("Contact No");  
		    l3.setBounds(50,120, 100,30); 
		    t3=new JTextField();  
		    t3.setBounds(130,120, 150,30);
		    
		    l4=new JLabel("Passport No");  
		    l4.setBounds(50,155, 100,30); 
		    t4=new JTextField();  
		    t4.setBounds(130,155, 150,30);
		    
		    l5=new JLabel("Address");  
		    l5.setBounds(50,190, 100,30); 
		    t5=new JTextField();   
	        t5.setBounds(130,190, 150,30);  
	        
	        l6=new JLabel("Password");  
		    l6.setBounds(50,225, 100,30); 
		    t6=new JTextField();   
	        t6.setBounds(130,225, 150,30);
	        
	        JButton b1=new JButton("Add");  
	        b1.setBounds(70,275,95,30);  
	        b1.addActionListener(new ActionListener(){  
			    public void actionPerformed(ActionEvent e){  
			    	 String s1=t1.getText();  
				     String s2=t2.getText();
				     String s3=t3.getText();
				     String s4=t4.getText();
				     String s5=t5.getText();
				     String s6=t6.getText();
				     try{
				          File file =new File("F:\\Customs\\customer_details.txt");
				    	  if(!file.exists()){
				    	 	file.createNewFile();
				    	  }
				    	  FileWriter fw = new FileWriter(file,true);
				    	  BufferedWriter bw = new BufferedWriter(fw);
				    	  PrintWriter pw = new PrintWriter(bw);
				    	  final String AB = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
						  SecureRandom rnd = new SecureRandom();
						  int a=5;
						  StringBuilder sb = new StringBuilder( a);
						  for( int i = 0; i < a; i++ ) 
						     sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
					      String id=sb.toString();

				      	  pw.println(id+","+s6+","+s1+","+s2+","+s3+","+s4+","+s5);
				      	  JOptionPane.showMessageDialog(f,"Sucessfully Added");  
				      	  JOptionPane.showMessageDialog(f,"Your Id "+id);
				      	 
				    	  pw.close();

				       }catch(IOException ioe){
				    	   System.out.println("Exception occurred:");
				    	   ioe.printStackTrace();
				       } 
				     t1.setText("");
				     t2.setText("");
				     t3.setText("");
				     t4.setText("");
				     t5.setText("");
				     f.dispose();
				     new Home_page();
			    }  
			    }); 
	        
	        
	        
		    f.add(l1); f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);
		    f.add(t1);f.add(t2);f.add(t3);f.add(t4);f.add(t5);f.add(t6);
		    
		    f.add(b1);
		    f.setSize(500,500);  
		    f.setLayout(null);  
		    f.setVisible(true);    
		}
		 
	}  
