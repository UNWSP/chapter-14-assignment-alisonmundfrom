

import javax.swing.*;
import java.awt.event.*;

public class JVacationRental  extends JFrame implements ActionListener {

	private final int PARK_SIDE = 600;
	private final int POOL_SIDE = 750;
	private final int LAKE_SIDE = 825; 
	private final int ONE_BEDROOM = 75; 
	private final int TWO_BEDROOMS = 150;
	private final int THREE_BEDROOMS = 225;
	private final int MEALS = 200;
	
	private JLabel labelLocations = new JLabel("Location: ");
	private JLabel labelBedrooms = new JLabel("Bedrooms: ");
	private JLabel labelMeals = new JLabel("Include meals: ");
	
	private JRadioButton buttonPark = new JRadioButton("Park side");
	private JRadioButton buttonPool = new JRadioButton("Pool side");
	private JRadioButton buttonLake = new JRadioButton("Lake side");
	private JRadioButton buttonOne = new JRadioButton("One");
	private JRadioButton buttonTwo = new JRadioButton("Two");
	private JRadioButton buttonThree = new JRadioButton("Three");
	private JRadioButton yesButton = new JRadioButton("Yes");
	private JRadioButton noButton = new JRadioButton("No");
	
	private ButtonGroup groupLocations = new ButtonGroup();
	private ButtonGroup groupBedrooms = new ButtonGroup();
	private ButtonGroup groupMeals = new ButtonGroup();
	
	
	private JButton buttonCalculate = new JButton("Calculate Total Rent");
	private JButton buttonReset = new JButton("Reset");
	
	private JLabel result = new JLabel("TOTAL RENT: $0.0");
	
	
	private JPanel panelLocations = new JPanel();
	private JPanel panelBedrooms = new JPanel();
	private JPanel panelMeals = new JPanel();
	private JPanel panelButton = new JPanel();
	private JPanel panelLabel = new JPanel();
	private JPanel panel = new JPanel();
	
	private int locationRent = 0;
	private int bedroomsRent = 0; 
	private int mealsCost = 0; 
	
	public JVacationRental() {
		super ("LAMBERT'S VACATION RENTALS ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		groupLocations.add(buttonPark);
		groupLocations.add(buttonPool);
		groupLocations.add(buttonLake);
		
		groupBedrooms.add(buttonOne);
		groupBedrooms.add(buttonTwo);
		groupBedrooms.add(buttonThree);
		
		groupMeals.add(yesButton);
		groupMeals.add(noButton);
		
		panelLocations.add(labelLocations);
		panelLocations.add(buttonPark);
		panelLocations.add(buttonPool);
		panelLocations.add(buttonLake);
		
		panelBedrooms.add(labelBedrooms);
		panelBedrooms.add(buttonOne);
		panelBedrooms.add(buttonTwo);
		panelBedrooms.add(buttonThree);
		
		panelMeals.add(labelMeals);
		panelMeals.add(yesButton);
		panelMeals.add(noButton);
		
		panelButton.add(buttonCalculate);
		panelButton.add(buttonReset);
		panelLabel.add(result);
		
		panel.add(panelLocations);
		panel.add(panelBedrooms);
		panel.add(panelMeals);
		panel.add(panelButton);
		panel.add(panelLabel);
		
		add(panel);
		
		buttonPark.addItemListener(new LocationsListener());
		buttonPool.addItemListener(new LocationsListener());
		buttonLake.addItemListener(new LocationsListener());
		buttonOne.addItemListener(new BedroomsListener());
		buttonTwo.addItemListener(new BedroomsListener());
		buttonThree.addItemListener(new BedroomsListener());
		yesButton.addItemListener(new MealsListener());
		noButton.addItemListener(new MealsListener());
		buttonCalculate.addActionListener(this);
		buttonReset.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source == buttonCalculate) {
			double totalRent = locationRent + bedroomsRent + mealsCost;
			result.setText("TOTAL RENT: $ " + totalRent);
		}
		
		else if(source == buttonReset) {
			groupLocations.clearSelection();
			groupBedrooms.clearSelection();
			groupMeals.clearSelection();
			
			result.setText("Total Rent: $ 0.0");
			
			locationRent = 0;
			bedroomsRent = 0; 
			mealsCost = 0;
		}
	}
	
private class LocationsListener implements ItemListener { 
	
	public void itemStateChanged(ItemEvent e) {
		
		Object source = e.getItem();
		
		if(source == buttonPark)
			locationRent = PARK_SIDE;
		
		else if(source == buttonPool)
			locationRent = POOL_SIDE;
		
		else if(source == buttonLake)
			locationRent = LAKE_SIDE;
		
		else
			locationRent = 0;
	}
}

private class BedroomsListener implements ItemListener {
	
	public void itemStateChanged(ItemEvent e) {
		
		Object source = e.getItem();
		
		if(source == buttonOne)
			bedroomsRent = ONE_BEDROOM;
		
		else if (source == buttonTwo)
			bedroomsRent = TWO_BEDROOMS;
		
		else if (source == buttonThree)
			bedroomsRent = THREE_BEDROOMS;
		
		else
			bedroomsRent = 0;
	}
}

private class MealsListener implements ItemListener { 
	
	public void itemStateChanged(ItemEvent e) {
		
		Object source = e.getItem();
		
		if(source == yesButton)
			mealsCost = MEALS; 
		
		else if(source == noButton)
			mealsCost = 0; 
		
		else
			mealsCost = 0;
	}
}
	
	
	public static void main(String[] args) {
		JVacationRental frame = new JVacationRental();
		frame.setSize(350, 250);
		frame.setVisible(true);
	}
}

