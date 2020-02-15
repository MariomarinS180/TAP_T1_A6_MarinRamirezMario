import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;
class GUITemperaturas extends JFrame implements ActionListener{
	JTextField cajaGradosConvertir, cajaResultado; 
	JComboBox<String> comboBoxTemperaturas, comboBoxTemperaturas2; 
	JButton btnConvertir; 
	DecimalFormat formato = new DecimalFormat("°#,###.000");
	public GUITemperaturas() {
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("CONVERTIDOR DE TEMPERATURAS");
		setSize(300,320);
		setLocationRelativeTo(null);
		setVisible(true);	
		add(new JLabel("Convertir:")); 
		cajaGradosConvertir = new JTextField("100",10);
		add(cajaGradosConvertir); 
		//1
		String [] items = {"° Celcius", "° Fahrenheit", "° Kelvin", "° Rankin"};
		comboBoxTemperaturas = new JComboBox<String>(items);
		add(comboBoxTemperaturas); 
		//2
		add(new JLabel("A: "));
		comboBoxTemperaturas2 = new JComboBox<>(items); 
		add(comboBoxTemperaturas2); 
		comboBoxTemperaturas2.addActionListener(this);
		//3
		add(new JLabel(" = "));
		cajaResultado = new JTextField(10);
		add(cajaResultado);
	}//constructor
	/*
	 * 0 = c
	 * 1 = F
	 * 2 = K
	 * 3 = R
	 */
	public void actionPerformed(ActionEvent e) {
		if(comboBoxTemperaturas.getSelectedIndex() == 0) {
			if(comboBoxTemperaturas2.getSelectedIndex() == 0) {
				cajaResultado.setText(cajaGradosConvertir.getText());
			}else if(comboBoxTemperaturas2.getSelectedIndex() == 1) {
				cajaResultado.setText(String.valueOf(formato.format((Double.parseDouble(cajaGradosConvertir.getText()) * 9/5) + 32)));
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 2) {
				cajaResultado.setText(String.valueOf(formato.format(Double.parseDouble(cajaGradosConvertir.getText()) + 273.15)));
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 3) {
				cajaResultado.setText(String.valueOf(formato.format(Double.parseDouble(cajaGradosConvertir.getText()) * 9/5 + 491.67)));
			}
		}else if(comboBoxTemperaturas.getSelectedIndex() == 1) { //Elección
			if(comboBoxTemperaturas2.getSelectedIndex() == 0) {
				cajaResultado.setText(String.valueOf(formato.format((Double.parseDouble(cajaGradosConvertir.getText()) - 32) * 5/9)));
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 1) {
				cajaResultado.setText(cajaGradosConvertir.getText());
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 2) {
				cajaResultado.setText(String.valueOf(formato.format((Double.parseDouble(cajaGradosConvertir.getText()) - 32) * 5/9 + 273.15)));
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 3) {
				cajaResultado.setText(String.valueOf(formato.format(Double.parseDouble(cajaGradosConvertir.getText()) + 459.67)));
			}
		
		}else if(comboBoxTemperaturas.getSelectedIndex() == 2) { //Elección
			if(comboBoxTemperaturas2.getSelectedIndex() == 0) {
				cajaResultado.setText(String.valueOf(formato.format(Double.parseDouble(cajaGradosConvertir.getText()) - 273.15)));
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 1) {
				cajaResultado.setText(String.valueOf(formato.format(((Double.parseDouble(cajaGradosConvertir.getText())-273.15 ) * 9/5) + 32)));
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 2) {
				cajaResultado.setText(cajaGradosConvertir.getText());
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 3) {
				cajaResultado.setText(String.valueOf(formato.format(Double.parseDouble(cajaGradosConvertir.getText())*1.8)));
			}
		}else if(comboBoxTemperaturas.getSelectedIndex() == 3) { //Elección
			if(comboBoxTemperaturas2.getSelectedIndex() == 0) {
				cajaResultado.setText(String.valueOf(formato.format(( Double.parseDouble(cajaGradosConvertir.getText()) -  491.67) * 5/9)));
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 1) {
				cajaResultado.setText(String.valueOf(formato.format(Double.parseDouble(cajaGradosConvertir.getText()) - 459.67)));
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 2) {
				cajaResultado.setText(String.valueOf(formato.format(Double.parseDouble(cajaGradosConvertir.getText())* 5/9)));
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 3) {
				cajaResultado.setText(cajaGradosConvertir.getText());
			}
		}
	}//constructor actionPerformed
}//class
public class Actividad6 {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUITemperaturas(); 
			}
		});
	}//main
}//class
