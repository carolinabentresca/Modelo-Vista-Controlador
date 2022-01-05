package mvc;

import Controlador.productoController;
import Modelo.producto;
import Modelo.productoDao;
import Vista.productoJFrame;

public class MVC {

    public static void main(String[] args) {
        producto modelo = new producto();
        productoDao modeloDao = new productoDao();
        productoJFrame vista = new productoJFrame();
        productoController controlador = new productoController(modelo, modeloDao, vista);
        controlador.iniciar();
        vista.setVisible(true);
    }

}
