package Bootcamp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class validation {
	 JLabel l1;  
     JTextField t1; 
     String cid;
     public validation(String id)
     {
         JFrame f=new JFrame("Validation");
         cid=id;
         l1=new JLabel("Item Name");  
         l1.setBounds(65,50, 70,30);
         t1=new JTextField();  
         t1.setBounds(150,50, 150,30);
         
         JButton b1=new JButton("Check");  
         b1.setBounds(50,100,100,30);
         b1.addActionListener(new ActionListener(){  
             public void actionPerformed(ActionEvent e){  
            	 String s1=t1.getText();
            	 int i=0;
            	 try{
                     File file =new File("F:\\Customs\\illegal.txt");
                     if(!file.exists()){
                       file.createNewFile();
                     }
            	 FileReader fr = new FileReader(file);
            	 BufferedReader reader = new BufferedReader(fr);
            	 String line;
            	 while ((line = reader.readLine()) != null)
            	 {
            		 if(s1.equals(line))
            		 {
            			 i=1;
            			 JOptionPane.showMessageDialog(f,"Illegal Item"); 
            			 break;
            		 }
            	 }
            	 File files =new File("F:\\Customs\\stolen.txt");
            	 if(!files.exists()){
                     files.createNewFile();
                   }
            	 FileReader frs = new FileReader(files);
            	 BufferedReader readers = new BufferedReader(frs);
            	 String lines;
            	 while ((lines = readers.readLine()) != null)
            	 {
            		 if(s1.equals(lines))
            		 {
            			 i=1;
            			 JOptionPane.showMessageDialog(f,"Stolen Item"); 
            			 break;
            		 }
            	 }
            	 if(i==0)
            		 JOptionPane.showMessageDialog(f,"Proceed Furthur");
            	 
             }
            	 catch(IOException ioe){
                     System.out.println("Exception occurred:");
                     ioe.printStackTrace();
                 }
            	 t1.setText("");
             }
             });
         JButton b2=new JButton("Back");  
         b2.setBounds(175,100,100,30);
         b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					f.dispose();
					new Main_page(cid);
				}
			});
         
         f.add(l1);
         f.add(t1);
         f.add(b1);
         f.add(b2);
         f.setSize(500,500);  
         f.setLayout(null);  
         f.setVisible(true);  
     }

}
