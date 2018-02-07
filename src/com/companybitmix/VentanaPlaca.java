package com.companybitmix;
/*
 * programa que verifica la circulacion de las placas de los veiculos
 * segun el dia determinado de la semana
 * bajo el criterio de que los lunes no circulan las placas terminadas en 0 y 1
 * martes las placas que terminan en 2 y 3
 * miercoles las placas que terminan en 4 y 5
 * jueves las placas que terminan en 6 y 7
 * viernes las placas que terminan en 8 y 9
 * sabado y domingo sin restriccion veicular
 */

import java.util.Calendar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPlaca extends JFrame {
    private JLabel etiqueta1, etiqueta2;//nombre del label
    private JTextField campo;//tamaño del cuadro de texto
    private JButton verificarP; //nombre del boton para verificar la placa
    private JDialog verificacion;//cuadro de dialogo para verificar la placa

    public VentanaPlaca() {
        super("Verifion de Ciculacion del veiculo");//titulo de la ventana
        etiqueta1 = new JLabel("Introdusca el numero de placa");//contenido de label
        campo = new JTextField(10);//tamaño de la barra de texto
        verificarP = new JButton("Verificar");//nombre del boton
        verificacion = new JDialog(this);//cuadro de dialogo
        verificacion.setSize(600, 300);//tamaño del cuadro de dialogo
        etiqueta2 = new JLabel("");//contenido original del label del cuadro de dialogo
        FlowLayout orden = new FlowLayout();
        setLayout(orden);
        add(etiqueta1);
        add(campo);
        add(verificarP);
        verificacion.add(etiqueta2);
        verificarP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                verificarPlaca();
            }
        });
    }

    /*
     *metodo que consigue el ultimo digito de la parte numerica
     */
    public int getParteNumerica(String placa) {
        int res = 0;

        for (int i = 0; i < placa.length(); i++) {
            char c = placa.charAt(i);
            if (c >= '0' && c <= '9') {
                res = res * 10 + Character.getNumericValue(c);
            }
        }
        return res % 10;
    }

    /*
     *metodo que modifica el label para saber si circula o no
     */

    public void verificarPlaca() {
        if (circula()) {
            etiqueta2.setText("su placa circula");
        } else
            etiqueta2.setText("su placa no circula");
        verificacion.setVisible(true);

    }

    /*
     *metodo que compara el valor del ultimo dijito de la parte numerica de la placa
     * par aluego comparar si circula o no segun el dia
     * y devuelve un valor booleano
     */
    public boolean circula() {
        boolean circ = true;
        String placa = campo.getText();//devuelve lo que tenemos en el campoint
        int numero = getParteNumerica(placa);
        if (numero == 0 || numero == 1) {
            if (Calendar.DAY_OF_WEEK == 0) {
                circ = false;
            }
        }
        if (numero == 2 || numero == 3) {
            if (Calendar.DAY_OF_WEEK == 1) {
                circ = false;
            }
        }
        if (numero == 4 || numero == 5) {
            if (Calendar.DAY_OF_WEEK == 2) {
                circ = false;
            }
        }
        if (numero == 6 || numero == 7) {
            if (Calendar.DAY_OF_WEEK == 3) {
                circ = false;
            }
        }
        if (numero == 80 || numero == 9) {
            if (Calendar.DAY_OF_WEEK == 4) {
                circ = false;
            }
        }
        return circ;
    }
}
