package task4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


class Demo extends JFrame { 
    JRadioButton jRadioButton1; 
    JRadioButton jRadioButton2; 
    JButton jButton; 
    ButtonGroup G1;  
    JLabel L1; 
    JLabel L2;
    JLabel L3;
    JTextField T1;
    JTextField T2;

    public Demo() { 
        this.setLayout(null); 
        jRadioButton1 = new JRadioButton(); 
        jRadioButton2 = new JRadioButton(); 
        jButton = new JButton("Click"); 
        G1 = new ButtonGroup();
        L1 = new JLabel("¬ведите массив строк:");
        L2 = new JLabel("—ортировка:");
        L3=new JLabel("ќтсортированный массив:");
        T1=new JTextField();
        T2=new JTextField();
        jRadioButton1.setText("Sort1"); 
        jRadioButton2.setText("Sort2"); 
        jRadioButton1.setBounds(100, 40, 60, 50); 
        jRadioButton2.setBounds(160, 40, 60, 50); 
        jButton.setBounds(60, 90, 80, 30); 
        L1.setBounds(20,0,150,50);
        L2.setBounds(20,40,150, 50);
        L3.setBounds(20,120,180, 50);
        T1.setBounds(170,10,550,30);
        T2.setBounds(200,130,550,30);
        this.add(jRadioButton1); 
        this.add(jRadioButton2); 
        this.add(jButton); 
        this.add(L1);
        this.add(L2);
        this.add(L3);
        this.add(T1);
        this.add(T2);
        G1.add(jRadioButton1); 
        G1.add(jRadioButton2); 
        jButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
            	String Text=T1.getText();
            	String[] array=Text.split(" ");
                StringBuilder[] Array=converting(array);
                if (jRadioButton1.isSelected()) { 
                	Object result=JOptionPane.showInputDialog("¬ведите подстроку:");
                    array=sort1(Array,String.valueOf(result));
                    Text=beautifulArray(array);
                    T2.setText(Text);
                } 
                else if (jRadioButton2.isSelected()) { 
                	Object result=JOptionPane.showInputDialog("¬ведите подстроку1 и подстроку2(подстроки должны быть разделены пробелом):");
                	if(String.valueOf(result).split(" ").length<2 || String.valueOf(result).split(" ").length>2) {
                		JOptionPane.showMessageDialog(Demo.this, "Error");
                		Text=beautifulArray(array);
                        T2.setText(Text);
                		return;
                	}
                	String substringArray[]=String.valueOf(result).split(" ");
                	array=sort2(array,substringArray[0],substringArray[1]);
                	Text=beautifulArray(array);
                    T2.setText(Text);
                } 
                else {
                	JOptionPane.showMessageDialog(Demo.this, "NO Button selected"); 
                }   
            } 
        }); 
    }
    
    public static String beautifulArray(String Array[]) {
    	String str=new String();
    	for(int i=0;i<Array.length;i++) {
    		str=str+Array[i]+" ";
    	}
    	return str;
    }
    
    public static String[] sort2(String[] arrayStr,String substring1,String substring2) {
		StringCompatator comporator=new StringCompatator(substring1,substring2);
		Arrays.sort(arrayStr, comporator);
		return arrayStr;
	}
    
    public static String[] sort1(StringBuilder argv[],String substring) {
		int n=argv.length;
		for(int i=0;i<n;i++) {
			int pos=argv[i].lastIndexOf(substring);
			StringBuilder tmp=argv[i];
			for(int j=i-1;j>=0;j--) {
				if(pos<argv[j].lastIndexOf(substring)) {
					StringBuilder buf=argv[j];
					argv[j]=tmp;
					argv[j+1]=buf;
				}
				else {
					break;
				}
			}
		}
		String array[]=convertingString(argv);
		return array;
	}
    
	public static String[] convertingString(StringBuilder[] arrayStr) {
		int n=arrayStr.length;
		String mas[]=new String[n];
		for(int i=0;i<n;i++) {
			mas[i]=new String(arrayStr[i].toString());
		}
		return mas;
	}
	
	public static StringBuilder[] converting(String[] arrayStr) {
		int n=arrayStr.length;
		StringBuilder mas[]=new StringBuilder[n];
		for(int i=0;i<n;i++) {
			mas[i]=new StringBuilder(arrayStr[i]);
		}
		return mas;
	}
    
} 

public class Runner {
    public static void main(String[] args) {
    	Demo f = new Demo(); 
        f.setBounds(100, 100, 400, 200); 
        f.setTitle("Task 4"); 
        f.setVisible(true); 
    }
}
