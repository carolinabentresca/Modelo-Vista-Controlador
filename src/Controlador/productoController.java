package Controlador;

import Modelo.producto;
import Modelo.productoDao;
import Vista.productoJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class productoController implements ActionListener {

    private final producto modelo;
    private final productoDao modeloDao;
    private final productoJFrame vista;

    public productoController(producto modelo, productoDao modeloDao, productoJFrame vista) {
        this.modelo = modelo;
        this.modeloDao = modeloDao;
        this.vista = vista;
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("PRODUCTOS");
        vista.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Registrar Producto
        if (e.getSource() == vista.btnRegistrar) {
            modelo.setCódigo(Integer.parseInt(vista.txtcodigo.getText()));
            modelo.setNombre(vista.txtnombre.getText());
            modelo.setPrecio(Double.parseDouble(vista.txtprecio.getText()));
            if (modeloDao.registrar(modelo)) {
                JOptionPane.showMessageDialog(null, "Producto Registrado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Registrar Producto");
                limpiar();
            }
        }

        //Modificar Producto
        if (e.getSource() == vista.btnModificar) {
            modelo.setCódigo(Integer.parseInt(vista.txtcodigo.getText()));
            modelo.setNombre(vista.txtnombre.getText());
            modelo.setPrecio(Double.parseDouble(vista.txtprecio.getText()));
            if (modeloDao.modificar(modelo)) {
                JOptionPane.showMessageDialog(null, "Producto Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar Producto");
                limpiar();
            }
        }

        //Buscar Producto
        if (e.getSource() == vista.btnBuscar) {
            modelo.setCódigo(Integer.parseInt(vista.txtcodigo.getText()));
            if (modeloDao.buscar(modelo)) {
                vista.txtcodigo.setText(String.valueOf(modelo.getCódigo()));
                vista.txtnombre.setText(modelo.getNombre());
                vista.txtprecio.setText(String.valueOf(modelo.getPrecio()));
            } else {
                JOptionPane.showMessageDialog(null, "Error al Buscar Producto");
                limpiar();
            }
        }

        //Eliminar Producto
        if (e.getSource() == vista.btnEliminar) {
            modelo.setCódigo(Integer.parseInt(vista.txtcodigo.getText()));
            if (modeloDao.eliminar(modelo)) {
                JOptionPane.showMessageDialog(null, "Producto Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar Producto");
                limpiar();
            }
        }

        //Limpiar
        if (e.getSource() == vista.btnLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        vista.txtcodigo.setText(null);
        vista.txtnombre.setText(null);
        vista.txtprecio.setText(null);
    }

}
