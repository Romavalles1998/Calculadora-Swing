package Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aplicacion {
    private JPanel Cabecera;
    private JPanel Botonera;
    private JButton btnReset;
    private JLabel lblDisplay;
    private JButton btn0;
    private JButton btn2;
    private JButton btn3;
    private JButton btn1;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnPunto;
    private JButton btnSum;
    private JButton btnResta;
    private JButton btnMulti;
    private JButton btnDiv;
    private JButton btnIgual;
    private JPanel root;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicacion");
        frame.setContentPane(new Aplicacion().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Aplicacion() {

        ActionListener listenerDigitos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = lblDisplay.getText() + ((JButton) e.getSource()).getText();
                lblDisplay.setText(texto);
            }
        };
        btn0.addActionListener(listenerDigitos);
        btnPunto.addActionListener(listenerDigitos);
        btn1.addActionListener(listenerDigitos);
        btn2.addActionListener(listenerDigitos);
        btn3.addActionListener(listenerDigitos);
        btn4.addActionListener(listenerDigitos);
        btn5.addActionListener(listenerDigitos);
        btn6.addActionListener(listenerDigitos);
        btn7.addActionListener(listenerDigitos);
        btn8.addActionListener(listenerDigitos);
        btn9.addActionListener(listenerDigitos);

        ActionListener listenerOperaciones = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = calcular(lblDisplay.getText());
                lblDisplay.setText(resultado);

                if (e.getSource() != btnIgual) {
                    String texto = lblDisplay.getText() + ((JButton) e.getSource()).getText();
                    lblDisplay.setText(texto);
                }
            }
        };
        btnIgual.addActionListener(listenerOperaciones);
        btnResta.addActionListener(listenerOperaciones);
        btnSum.addActionListener(listenerOperaciones);
        btnMulti.addActionListener(listenerOperaciones);
        btnDiv.addActionListener(listenerOperaciones);

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblDisplay.setText("");
            }
        });
    }

    public String calcular(String operacion) {
        String resultado;
        String[] ops = operacion.split("[\\+\\-x\\/]");
        if (ops.length == 1) {
            resultado = ops[0];
        } else {
            float v1 = Float.parseFloat(ops[0]);
            float v2 = Float.parseFloat(ops[1]);
            float r;
            if (operacion.contains("+"))
                r = v1 + v2;
            else if (operacion.contains("-"))
                r = v1 - v2;
            else if (operacion.contains("x"))
                r = v1 * v2;
            else
                r = v1 / v2;
            resultado = String.valueOf(r);
        }
        return resultado;
    }
}
