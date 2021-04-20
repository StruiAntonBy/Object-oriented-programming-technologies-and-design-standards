package task1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class MyForm extends JFrame {
    public MyForm() {
        super("Task 1");
        setBounds(100, 50, 380, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel firstOperandLabel = new JLabel("Первый операнд a:");
        firstOperandLabel.setBounds(10, 10, 350, 30);
        add(firstOperandLabel);
        JTextField firstOperandTextField = new JTextField();
        firstOperandTextField.setBounds(10, 50, 350, 30);
        add(firstOperandTextField);
        JLabel secondOperandLabel = new JLabel("Второй операнд b:");
        secondOperandLabel.setBounds(10, 90, 350, 30);
        add(secondOperandLabel);
        JTextField secondOperandTextField = new JTextField();
        secondOperandTextField.setBounds(10, 130, 350, 30);
        add(secondOperandTextField);
        JLabel thirdOperandLabel =new JLabel("Третий операнд c:");
        thirdOperandLabel.setBounds(10,170,350,30);
        add(thirdOperandLabel);
        JTextField thirdOperandTextField=new JTextField();
        thirdOperandTextField.setBounds(10,210,350,30);
        add(thirdOperandTextField);
        JButton calculateButton = new JButton("Вычислить (c/b)+3*(a-b)");
        calculateButton.setBounds(60, 250, 250, 30);
        calculateButton.addActionListener(
            new CalculateButtonHandler(
                firstOperandTextField,
                secondOperandTextField,
                thirdOperandTextField
            )
        );
        add(calculateButton);
        validate();
        setVisible(true);
    }
}

class CalculateButtonHandler implements ActionListener {
    private JTextField f1, f2, f3;
    public CalculateButtonHandler(JTextField f1, JTextField f2, JTextField f3) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3=f3;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Double a = Double.parseDouble(f1.getText());
            Double b = Double.parseDouble(f2.getText());
            Double c = Double.parseDouble(f3.getText());
            Double d = (c/b)+3*(a-b);
            String result = "(c/b)+3*(a-b)=" + d;
            JOptionPane.showMessageDialog(null, result);
        } catch(NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Неверное число");
        }
    }
}

public class Runner {
    public static void main(String[] args) {
        new MyForm();
    }
}
