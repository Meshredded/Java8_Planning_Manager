package interface_Graphique.connexion_mvc;
import javax.swing.*;

import java.awt.BorderLayout;
public class ConnectionView {
    
    private JFrame frame;
    private JLabel label;
    private JLabel status;
    private JButton button;
    private JTextField usernameField;
    
    public ConnectionView(){
        frame = new JFrame("ADE V9999");                                    
        frame.getContentPane().setLayout(new BorderLayout());                                          
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(null);
        
        label = new JLabel("Username :");
        label.setBounds(97, 150, 250, 32);
        frame.getContentPane().add(label);
        
        usernameField= new JTextField();
		usernameField.setBounds(97, 176, 250, 32);
        frame.getContentPane().add(usernameField);
		
        button = new JButton("Connexion"); 
		button.setBounds(97, 220, 250, 32);
        frame.getContentPane().add(button);
        
        status = new JLabel("Connection");
        status.setBounds(97, 270, 250, 32);
        frame.getContentPane().add(status);
    }
        
    public JButton getButton(){
        return button;
    }
    
    public void setStatusText(String text){
    	status.setText(text);
    }
    
    public JTextField getUserTextField(){
    	return this.usernameField;
    }
    
    public void clearPane(){
    		this.frame.getContentPane().removeAll();

    }
    
    public JFrame getFrame(){
    	return this.frame;
    }
    
}