import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * This frame implements the menu at a sub store
 * Assignment 6 Question 2
 * Student No 201640422
 * @author lagamelle
 *
 */
public class SubwayFrame extends JFrame
{
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 800;
	private static final double inch6Price = 5;
	private static final double inch12Price = 8;
	private static final double cheeseExtra = 1;
	
	private JComboBox typeBreadCombo;
	private JRadioButton inch6Button, inch12Button;
	private JRadioButton cheeseButton, nocheeseButton;
	private JCheckBox chickenCheckBox, turkeyCheckBox, hamCheckBox;
	private JCheckBox lettuceCheckBox, tomatoesCheckBox, onionsCheckBox, pepperCheckBox;
	private JRadioButton mayoButton, honeymusButton;
	private ActionListener listener;
	private JLabel priceLabel;
	public double price = 0; // The initial price of the sub
	public final double taxRate = 1.15;
	/**
	 * Construct the frame
	 */
	public SubwayFrame()
	{
		// This listener is shared among all components
		listener = new ChoiceListener();
		
		// A label for the price
		priceLabel = new JLabel("Price:" + price);
		
		createControlPanel(); // The control panel contain all the subpanels
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	class ChoiceListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (inch6Button.isSelected())
			{ 
				price = inch6Price;
				priceLabel.setText("Price: " + (price * taxRate));
			}
			else if (inch12Button.isSelected()) 
			{
				price = inch12Price;
				priceLabel.setText("Price: " + (price * taxRate));
			}
			if (cheeseButton.isSelected())
			{
				if (price == inch6Price) { price += cheeseExtra; }
				else if (price == inch12Price) { price += cheeseExtra; }
				
				priceLabel.setText("Price: $" + (price * taxRate) );
			}
		}
	}
	
	/**
	 * The controlpanel contains all the subpanels
	 */
	public void createControlPanel()
	{
		JPanel typeBreadPanel = createComboBoxBread();
		JPanel sizePanel = createRadioButtonsSize();
		JPanel cheesePanel = createRadioButtonsCheese();
		JPanel meatPanel = createCheckBoxMeat();
		JPanel toppingsPanel = createCheckBoxToppings();
		JPanel saucePanel = createRadioButtonsSauce();
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(7,1));
		// Add all the subpanels to the main controlpanel
		controlPanel.add(typeBreadPanel);
		controlPanel.add(sizePanel);
		controlPanel.add(cheesePanel);
		controlPanel.add(meatPanel);
		controlPanel.add(toppingsPanel);
		controlPanel.add(saucePanel);
		controlPanel.add(priceLabel);

		add(controlPanel); // Add the controlpanel to the main frame
	}
	
	/**
	 * Creates the combo box for the type of bread
	 * @return  the panel containing the combo box
	 */
	public JPanel createComboBoxBread()
	{
		typeBreadCombo = new JComboBox();
		typeBreadCombo.addItem("White");
		typeBreadCombo.addItem("Whole weat");
		typeBreadCombo.addItem("Multigrain");
		
		JPanel panel = new JPanel();
		panel.add(typeBreadCombo);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Type of bread"));
		return panel;	
	}
	
	/**
	 * Creates the radio buttons for the size of the bread
	 * @return the panel containing the radio buttons
	 */
	public JPanel createRadioButtonsSize()
	{
		inch6Button = new JRadioButton("6 inch");
		inch6Button.addActionListener(listener);
		
		inch12Button = new JRadioButton("12 inch");
		inch12Button.addActionListener(listener);
		
		ButtonGroup group = new ButtonGroup();
		group.add(inch6Button);
		group.add(inch12Button);
		
		JPanel panel = new JPanel();
		panel.add(inch6Button);
		panel.add(inch12Button);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Size"));
		
		return panel;
	}
	
	/**
	 * Creates the radio buttons for the cheese preference
	 * @return the panel containing the radio buttons
	 */
	public JPanel createRadioButtonsCheese()
	{
		cheeseButton = new JRadioButton("Cheese");
		cheeseButton.addActionListener(listener);
		
		nocheeseButton = new JRadioButton("No cheese");
		nocheeseButton.addActionListener(listener);
		nocheeseButton.setSelected(true); // preselected at first
		
		ButtonGroup group = new ButtonGroup();
		group.add(cheeseButton);
		group.add(nocheeseButton);
		
		JPanel panel = new JPanel();
		panel.add(cheeseButton);
		panel.add(nocheeseButton);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Cheese preference"));
		
		return panel;
	}

	/**
	 * Creates the check boxes for the type of meat
	 * @return the panel containing the type of meat
	 */
	public JPanel createCheckBoxMeat()
	{
		chickenCheckBox = new JCheckBox("Chicken");
		turkeyCheckBox = new JCheckBox("Turkey");
		hamCheckBox = new JCheckBox("Ham");
		
		JPanel panel = new JPanel();
		panel.add(chickenCheckBox);
		panel.add(turkeyCheckBox);
		panel.add(hamCheckBox);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Meat"));
		
		return panel;
	}

	/**
	 * Creates the check boxes for the toppings
	 * @return the panel containing the check boxes
	 */
	public JPanel createCheckBoxToppings()
	{
		lettuceCheckBox = new JCheckBox("Lettuce");
		tomatoesCheckBox = new JCheckBox("Tomatoes");
		onionsCheckBox = new JCheckBox("Onions");
		pepperCheckBox = new JCheckBox("Green pepper");
		
		JPanel panel = new JPanel();
		panel.add(lettuceCheckBox);
		panel.add(tomatoesCheckBox);
		panel.add(onionsCheckBox);
		panel.add(pepperCheckBox);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Toppings"));
		
		return panel;
	}
	
	/**
	 * Creates the radio buttons for the sauce
	 * @return the panel containing the radio buttons
	 */
	public JPanel createRadioButtonsSauce()
	{
		mayoButton = new JRadioButton("Mayonnaise");
		honeymusButton = new JRadioButton("Honey mustard");
		honeymusButton.setSelected(true); // preselected at first
		
		ButtonGroup group = new ButtonGroup();
		group.add(mayoButton);
		group.add(honeymusButton);
		
		JPanel panel = new JPanel();
		panel.add(mayoButton);
		panel.add(honeymusButton);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Sauce"));
		
		return panel;
	}
	
	
}
