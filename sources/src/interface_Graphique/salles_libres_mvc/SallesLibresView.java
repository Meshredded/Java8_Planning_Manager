package interface_Graphique.salles_libres_mvc;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import interface_Graphique.DateLabelFormatter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
public class SallesLibresView {
	JFrame frame;
    private JLabel dateLabel;
    private JLabel heuresDebutLabel;
    private JLabel minutesDebutLabel;
    private JComboBox<Integer> heuresDebut;
    private JComboBox<Integer> minutesDebut;
    private JLabel heuresFinLabel;
    private JLabel minutesFinLabel;
    private JComboBox<Integer> heuresFin;
    private JComboBox<Integer> minutesFin;
    private JDatePickerImpl datePicker;
    private JTextArea textArea;
    private JButton button;
	
	public SallesLibresView(){
		frame = new JFrame("Salles Libres Par creneau");                                    
        frame.getContentPane().setLayout(new BorderLayout());                                          
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);           
        frame.setSize(800,600);        
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        
        heuresDebutLabel = new JLabel("Heure debut:");
        heuresDebutLabel.setBounds(10, 10, 250, 32);
        frame.getContentPane().add(heuresDebutLabel);
        
        heuresDebut  = new JComboBox<Integer>();
        heuresDebut.setBounds(10, 40, 150, 32);
        for (int i =0 ; i<24 ;i++)heuresDebut.addItem(new Integer(i));
        frame.getContentPane().add(heuresDebut);
        
        minutesDebutLabel = new JLabel("Minutes debut:");
        minutesDebutLabel.setBounds(200, 10, 250, 32);
        frame.getContentPane().add(minutesDebutLabel);
        
        minutesDebut  = new JComboBox<Integer>();
        minutesDebut.setBounds(200, 40, 150, 32);
        for (int i =0 ; i<60 ;i++)minutesDebut.addItem(new Integer(i));
        frame.getContentPane().add(minutesDebut);
        
        
        
        heuresFinLabel = new JLabel("Heure fin:");
        heuresFinLabel.setBounds(10, 80, 250, 32);
        frame.getContentPane().add(heuresFinLabel);
        
        heuresFin  = new JComboBox<Integer>();
        heuresFin.setBounds(10, 110, 150, 32);
        for (int i =0 ; i<24 ;i++)heuresFin.addItem(new Integer(i));
        frame.getContentPane().add(heuresFin);
        
        minutesFinLabel = new JLabel("Minutes Fin:");
        minutesFinLabel.setBounds(200, 80, 250, 32);
        frame.getContentPane().add(minutesFinLabel);
        
        minutesFin  = new JComboBox<Integer>();
        minutesFin.setBounds(200, 110, 150, 32);
        for (int i =0 ; i<60 ;i++)minutesFin.addItem(new Integer(i));
        frame.getContentPane().add(minutesFin);
        
        
        
        
        dateLabel = new JLabel("Date :");
        dateLabel.setBounds(530, 10, 250, 32);
        frame.getContentPane().add(dateLabel);
        
        
        

        
        button = new JButton("Afficher");
        button.setBounds(10, 210, 150, 32);
        frame.getContentPane().add(button);
        
        textArea = new JTextArea();
        textArea.setBounds(10, 250, 773, 300);
        textArea.setBackground(Color.pink);
        frame.getContentPane().add(textArea);
        
        
        UtilDateModel dateModel = new UtilDateModel();
        //model.setDate(20,04,2014);
        // Need this...
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, p);
        // Don't know about the formatter, but there it is...
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePanel.setBounds(530, 40, 250, 200);
        frame.getContentPane().add(datePanel);
		
	}
	
	
	
	

	
	//getters
	public JFrame getFrame() {
		return frame;
	}

	public JComboBox<Integer> getHeuresDebut() {
		return heuresDebut;
	}

	public JComboBox<Integer> getMinutesDebut() {
		return minutesDebut;
	}
	

	public JComboBox<Integer> getHeuresFin() {
		return heuresFin;
	}

	public JComboBox<Integer> getMinutesFin() {
		return minutesFin;
	}
	public JDatePickerImpl getDatePicker() {
		return datePicker;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JButton getButton() {
		return button;
	}

	
	
}
