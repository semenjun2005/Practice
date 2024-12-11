package pr22;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorFrame::new);
    }
}

class CalculatorFrame extends JFrame {
    private final JTextField display;

    public CalculatorFrame() {
        setTitle("Infix Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(new BorderLayout());

        // Display field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = ((JButton) e.getSource()).getText();

            if (command.equals("=")) {
                try {
                    String expression = display.getText();
                    double result = evaluateInfix(expression);
                    display.setText(String.valueOf(result));
                } catch (Exception ex) {
                    display.setText("Error");
                }
            } else {
                display.setText(display.getText() + command);
            }
        }
    }

    private double evaluateInfix(String expression) {
        String rpn = infixToRPN(expression);
        return evaluateRPN(rpn);
    }

    private String infixToRPN(String infix) {
        StringBuilder output = new StringBuilder();
        Stack<Character> operators = new Stack<>();

        StringTokenizer tokenizer = new StringTokenizer(infix, "()+-*/ ", true);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (token.isEmpty()) continue;

            char c = token.charAt(0);

            if (Character.isDigit(c) || token.matches("\\d+(\\.\\d+)?")) {
                output.append(token).append(' ');
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    output.append(operators.pop()).append(' ');
                }
                operators.pop(); // Pop '('
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    output.append(operators.pop()).append(' ');
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            output.append(operators.pop()).append(' ');
        }

        return output.toString();
    }

    private double evaluateRPN(String rpn) {
        Stack<Double> stack = new Stack<>();

        StringTokenizer tokenizer = new StringTokenizer(rpn);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (token.matches("\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token.charAt(0))) {
                double b = stack.pop();
                double a = stack.pop();

                switch (token.charAt(0)) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }

        return stack.pop();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }
}
