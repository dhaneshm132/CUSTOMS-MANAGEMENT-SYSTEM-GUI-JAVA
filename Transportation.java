package Bootcamp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Transportation {
	JLabel l1,l2,l3,l4,l5,l6,l7,lid;  
    JTextField t1,t2,t3,t4,t5,t6,t7,tid;
    public Transportation(String id)
    {
    	 JFrame f=new JFrame("Transportation");
    	 
    	 lid=new JLabel("Item Id");  
         lid.setBounds(50,50, 100,30);
         tid=new JTextField();  
         tid.setBounds(160,50, 150,30);
         
         JButton b1=new JButton("Status");  
         b1.setBounds(150,150,100,50);  
         b1.addActionListener(new ActionListener(){  
             public void actionPerformed(ActionEvent e){ 
             	String Iid=tid.getText();
             	try{
                    File file =new File("F:\\Customs\\item_details.txt");
                    if(!file.exists()){
                      file.createNewFile();
                    }
                 FileReader fr = new FileReader(file);
               	 BufferedReader reader = new BufferedReader(fr);
               	 String line;
               	 int found=0;
               	 while((line=reader.readLine())!=null)
               	 {
               		String[] list = line.split(",");
               		if(list[2].equals(Iid))
               		{
               			found=1;
               			JOptionPane.showMessageDialog(f,"Details of Item"+"\n"+"Item Name:"+list[1]+"\n"+"Item id:"+list[2]+"\n"
    							+"Quantity :"+list[3]+"\nType of Trade :"+list[4]+"\nItem Price :"+list[5]+"\nDestination :"+list[6]+"\nSource :"+list[7]+"\n");
               			f.dispose();
               			new Main_page(id);
               		}
               	 }
               	 
               	 if(found==0)
               	 {
               		JOptionPane.showMessageDialog(f,"Item not found "); 
               	    tid.setText("");
               	 }
             	}
             	catch(IOException ioe){
                    System.out.println("Exception occurred:");
                    ioe.printStackTrace();
                }
             }  
             }); 
         f.add(lid);
         f.add(tid);
         f.add(b1);
         
         f.setSize(500,500);  
         f.setLayout(null);  
         f.setVisible(true);  
    }
}
