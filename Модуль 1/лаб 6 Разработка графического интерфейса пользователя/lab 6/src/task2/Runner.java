package task2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class MyForm extends JFrame {
    public MyForm() {
        super("Task 2");
        setBounds(100, 50, 380, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel firstOperandLabel = new JLabel("Первый операнд x:");
        firstOperandLabel.setBounds(10, 10, 350, 30);
        add(firstOperandLabel);
        JTextField firstOperandTextField = new JTextField();
        firstOperandTextField.setBounds(10, 50, 350, 30);
        add(firstOperandTextField);
        JLabel secondOperandLabel = new JLabel("Второй операнд точность e:");
        secondOperandLabel.setBounds(10, 90, 350, 30);
        add(secondOperandLabel);
        JTextField secondOperandTextField = new JTextField();
        secondOperandTextField.setBounds(10, 130, 350, 30);
        add(secondOperandTextField);
        JButton calculateButton = new JButton("Вычислить cos(x)");
        calculateButton.setBounds(60, 170, 250, 30);
        calculateButton.addActionListener(
            new CalculateButtonHandler(
                firstOperandTextField,
                secondOperandTextField
            )
        );
        add(calculateButton);
        validate();
        setVisible(true);
    }
}

class CalculateButtonHandler implements ActionListener {
    private JTextField f1, f2;
    public CalculateButtonHandler(JTextField f1, JTextField f2) {
        this.f1 = f1;
        this.f2 = f2;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Float x = Float.parseFloat(f1.getText());
            Float e = Float.parseFloat(f2.getText());
            Double d = 0.0;
            for(int i=0;;i++) {
            	Double res=Math.pow(-1.f,i)*Math.pow(x, 2*i)/calculateFactorial(2*i);
            	if(Math.abs(res)<e)
                {
                    break;
                }
            	d=d+res;
            }
            String result = "cos(x)=" + d+" "+"Math.cos(x)="+Math.cos(x);
            JOptionPane.showMessageDialog(null, result);
        } catch(NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Неверное число");
        }
    }
    
    public static int calculateFactorial(int n){
		int result = 1;
		for (int i = 1; i <=n; i ++){
			result = result*i;
		}
		return result;
	}
}

public class Runner {
    public static void main(String[] args) {
        new MyForm();
    }
}
