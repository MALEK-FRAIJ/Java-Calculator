package javaProject.Calculator;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Calculator implements ActionListener {
    JFrame window;
    JTextField textField;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, decButton;
    JButton equButton, delButton, clrButton, negButton, sqrButton;
    JPanel panel;
    JLabel label;

    Font textFont = new Font("Arial", Font.BOLD, 24);

    double number1 = 0, number2 = 0, result = 0;
    char operator;
    Border border = BorderFactory.createLoweredSoftBevelBorder();

    Calculator() {

        createAndShowGUI();
        screenOutput();
        buttons();
        buttonPad();
        frame();

    }

    public void screenOutput() {

        label = new JLabel();
        label.setBounds(7, 15, 310, 30);
        label.setFont(new Font("Monospaced", Font.BOLD, 25));
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        label.setEnabled(false);
        label.setBackground(Color.DARK_GRAY);
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(JTextField.RIGHT);

        textField = new JTextField();
        textField.setBounds(7, 50, 310, 125);
        textField.setFont(new Font("Monospaced", Font.BOLD, 30));
        textField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        textField.setBorder(border);
        textField.setBackground(Color.DARK_GRAY);
        textField.setForeground(Color.WHITE);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        // textField. setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

    }

    void frame() {

        window = new JFrame("Calculator");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.getContentPane().setBackground(Color.DARK_GRAY);
        window.setSize(340, 500);
        window.setVisible(true);
        window.add(panel);
        window.add(label);
        window.add(textField);
      

    }

    void buttonPad() {

        panel = new JPanel();
        panel.setBounds(7, 205, 310, 300);
        panel.setLayout(new GridLayout(6, 4, 4, 4));
        panel.setBackground(Color.DARK_GRAY);///////////////////

        panel.add(clrButton);
        panel.add(delButton);
        panel.add(sqrButton);
        panel.add(divButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(negButton);
        panel.add(numberButton[0]);
        panel.add(decButton);
        panel.add(equButton);

    }

    public void buttons() {
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("X");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("D");
        clrButton = new JButton("C");
        negButton = new JButton("+/-");
        sqrButton = new JButton("\u221A");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = sqrButton;

        for (int i = 0; i < 10; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(textFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(Color.BLACK);
            functionButtons[i].setForeground(new Color(0xffffff));
           

            /*
             * functionButtons[i].setOpaque(false);
             * functionButtons[i].setFocusPainted(false);
             * functionButtons[i].setBorderPainted(false);
             * functionButtons[i].setContentAreaFilled(false);
             * functionButtons[i].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
             */
        }

        for (int i = 0; i < 10; i++) {

            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(textFont);
            numberButton[i].setFocusable(false);
            numberButton[i].setBackground(Color.DARK_GRAY);
            numberButton[i].setForeground(new Color(0xffffff));

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {

            if (e.getSource() == numberButton[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
                label.setText(label.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {

            textField.setText(textField.getText().concat("."));
            label.setText(label.getText() + String.valueOf('.'));
        }
        if (e.getSource() == addButton) {

            number1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
            label.setText(label.getText() + String.valueOf(operator));

        }
        if (e.getSource() == subButton) {

            number1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
            label.setText(label.getText() + String.valueOf(operator));
        }
        if (e.getSource() == mulButton) {

            number1 = Double.parseDouble(textField.getText());
            operator = 'x';
            textField.setText("");
            label.setText(label.getText() + String.valueOf(operator));

        }
        if (e.getSource() == divButton) {

            number1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
            label.setText(label.getText() + String.valueOf(operator));

        }

        if (e.getSource() == equButton) {

            number2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case 'x':
                    result= number1 * number2;
                    break;
                   
                case '/':
                    result = number1 / number2;
                    break;

            }
            if (result == (int) result) {

                textField.setText(String.valueOf((int) result));
                number1 = result;
            } else {

                textField.setText(String.valueOf(result));
                number1 = result;
            }
        }
        if (e.getSource() == clrButton) {

            textField.setText("");
            label.setText("");
        }
        if (e.getSource() == delButton) {

            String str = textField.getText();
            textField.setText("");
            label.setText("");

            for (int i = 0; i < str.length() - 1; i++) {

                textField.setText(textField.getText() + str.charAt(i));
                label.setText(label.getText() + str.charAt(i));

            }
        }
        if (e.getSource() == negButton) {

            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
            label.setText(String.valueOf(temp));
        }
        if (e.getSource() == sqrButton) {

            number1 = Double.parseDouble(textField.getText());
            double sqr = Math.sqrt(number1);
            if (sqr == (int) sqr) {
                textField.setText(String.valueOf(sqr));
                label.setText("\u221A(" + String.valueOf(number1) + ')');
            } else {
                textField.setText(String.valueOf(Math.sqrt(sqr)));
                label.setText("\u221A(" + String.valueOf(number1) + ')');
            }

        }

    }

    

    
    private void createAndShowGUI() {

        try {

            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {

                    UIManager.setLookAndFeel(info.getClassName());

                    break;
                }
            }
        } catch (Exception e) {
        }
    }
    
    

    public static void main(String[] args) {

        new Calculator();

    }

}
