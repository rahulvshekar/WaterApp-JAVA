package java_assign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WaterApp extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelQuestion;
    private JLabel labelWeight;
    private JTextField fieldWeight;
    private JButton buttonTellMe;
	private JLabel labelHeight;
	private JTextField fieldHeight;
	private JButton buttonTellMe1;
	private JButton button;
	
	
    public WaterApp() {
        super("Health");
 
        initComponents();
 
        setSize(200, 210);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
    private void initComponents() {
        labelQuestion = new JLabel("Enter details required");
        labelWeight = new JLabel("Weight in kg:");
        fieldWeight = new JTextField(5);
        labelHeight = new JLabel("Height in meters:");
        fieldHeight = new JTextField(5);
        buttonTellMe = new JButton("Calculate Water");
        buttonTellMe1 = new JButton("Calculate BMI");
        button = new JButton("Give Label");
 
 
        setLayout(new FlowLayout());
 
        add(labelQuestion);
        add(labelWeight);
        add(fieldWeight);
        add(labelHeight);
        add(fieldHeight);
        add(buttonTellMe);
        add(buttonTellMe1);
        add(button);

 
        buttonTellMe.addActionListener(this);
        buttonTellMe1.addActionListener(this);
        button.addActionListener(this);
    }
 
    public void actionPerformed(ActionEvent event) {
        String message = "You should drink %.1f L of water a day";
        String message1 = "Your BMI is %.1f";
 
        float weight = Float.parseFloat(fieldWeight.getText());
        float height = Float.parseFloat(fieldHeight.getText());
        float waterAmount = calculateWaterAmount(weight);
        float bmi = calculateBMI(weight,height);
 
        message = String.format(message, waterAmount);
        message1 = String.format(message1, bmi); 
        String message2 = bodyLabel(bmi);
        String errmes = "Values not acceptable";
        
        if (event.getSource()==buttonTellMe) {
        	if(weight < 15 || height < 0.70 || weight > 250 || height > 2.6) {
        		JOptionPane.showMessageDialog(this,errmes);
            }
        	else
        	JOptionPane.showMessageDialog(this, message);
        }
        if (event.getSource()==button) {
        	if(weight < 15 || height < 0.70 || weight > 250 || height > 2.6) {
        		JOptionPane.showMessageDialog(this,errmes);
            }
        	else
        	JOptionPane.showMessageDialog(this, message2);
        }
        if (event.getSource()==buttonTellMe1 ){
        	if(weight < 15 || height < 0.70 || weight > 250 || height > 2.6) {
        		JOptionPane.showMessageDialog(this,errmes);
            }
        	else
        	JOptionPane.showMessageDialog(this, message1);
        }
    }
 
    private float calculateWaterAmount(float weight) {
        return (weight / 10f) * 0.4f;
    }
    
    private float calculateBMI(float weight, float height) {
    	return (weight / (height * height) );
    }

    private String bodyLabel(float bmi)
    {
    	if (bmi < 18.5) {
    		String message4 = "Underweight";
    		return message4;
    	}
    	
    	if (bmi > 18.5 && bmi < 24.9) {
    		String message5 = "Ideal";
    		return message5;
    	}
    	
    	if (bmi > 24.9 && bmi < 29.9) {
    		String message6 = "Overweight";
    		return message6;
    	}
    	
    	if (bmi > 30) {
    		String message7 = "Obese";
    		return message7;
    	}
		return null;	
    	
    }
 
    public static void main(String[] args) {
        new WaterApp().setVisible(true);
    }
}
