package Bootcamp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.*;
    
class Main_page
{
	JButton b1,b2,b3,b4,b5,b6,b7;

	Main_page(String s1)
        {
	
		JFrame f=new JFrame("Main Page");
		
		b1=new JButton("Item Details");  
	        b1.setBounds(175,150,150,30);  
	        b1.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{
				f.dispose();
				new item_details(s1);
			}
		});
	        
		b2=new JButton("Payment Details");  
	        b2.setBounds(175,175,150,30);  
	        b2.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{
				f.dispose();
				new payment_details(s1);
			}
		});
                b3=new JButton("Summary");  
	        b3.setBounds(175,250,150,30);  
	        b3.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{
				try{
                    File cfile =new File("F:\\Customs\\customer_details.txt");
                    File ifile =new File("F:\\Customs\\item_details.txt");
                    File pfile =new File("F:\\Customs\\payment_details.txt");

                 FileReader cfr = new FileReader(cfile);
                 FileReader ifr = new FileReader(ifile);
                 FileReader pfr = new FileReader(pfile);
               	 BufferedReader creader = new BufferedReader(cfr);
               	 BufferedReader ireader = new BufferedReader(ifr);
               	 BufferedReader preader = new BufferedReader(pfr);
               	 
               	 String cline;
               	 int found=0;
               	 while((cline=creader.readLine())!=null)
               	 {
               		String[] clist = cline.split(",");
               		if(clist[0].equals(s1))
               		{
               			String iline;
               			while((iline=ireader.readLine())!=null)
                      	 {
                      		String[] ilist = iline.split(",");
                      		if(ilist[0].equals(s1))
                      		{
                      			String pline;
                      			while((pline=preader.readLine())!=null)
                             	 {
                             		String[] plist = pline.split(",");
                             		if(plist[0].equals(s1))
                             		{
                           			found=1;
                           			JOptionPane.showMessageDialog(f,"Details of Customer"+"\n"+"Customer Name:"+clist[2]+"\n"+"Customer id:"+clist[0]+"\n"+"Aadhar no:"+clist[3]+
                           					"\nContact no :"+clist[4]+"\nPassport No:"+clist[5]+"\nAddress :"+clist[6]+"\n\nDetails of Item :"+"\n"+"Item Name:"+ilist[1]+"\n"+"Item id:"+ilist[2]+"\n"+"Quantity :"+ilist[3]+"\nType of Trade :"+ilist[4]+"\nItem Price :"+ilist[5]+"\nDestination :"+ilist[6]+"\nSource :"+ilist[7]
                           					+"\n\nPayment Details :"+"\nBank Name :"+plist[1]+"\nBranch Name :"+plist[2]+"\nAccount no :"+plist[3]+"\nMode of payment :"+plist[5]+"\nCheque no :"+plist[6]);
                           			f.dispose();
                           			new Main_page(s1);

                             			
                             		}
                      			
                      	                      			
                      		}

               		}
               	 }
               	 
               	 
             	}
				}
				}
			 	catch (Exception e1) 
				{
					System.out.println("Exception"+e1);
		        	}
		      }
			
		});
	        
	        b4=new JButton("Validation");  
	        b4.setBounds(175,225,150,30);  
	        b4.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{
				f.dispose();
				new validation(s1);		
		}
		});
	       
	        b5=new JButton("Transportation");  
	        b5.setBounds(175,200,150,30);  
	        b5.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{
				f.dispose();
				new Transportation(s1);		
		}
		});
	     
	        b6=new JButton("Back");  
	        b6.setBounds(200,300,100,30);  
	        b6.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{
				f.dispose();
				new Home_page();
			}
		});
	      
	       
	        
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
	
		
		f.setSize(500,500);  
		f.setLayout(null);  
		f.setVisible(true);  
	}
	

}	