package negocio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import negocio.entities.Articulo;
import negocio.entities.Cliente;
import negocio.repositories.ArticuloR;
import negocio.repositories.ClienteR;
import negocio.utils.Validator;

public class FXMLController implements Initializable {
    private ClienteR cr;
    private ArticuloR ar;
    
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtCuit;
    @FXML private TextField txtDireccion;
    @FXML private Button btnAgregarCliente;
    @FXML private TextField txtDescripcion;
    @FXML private TextField txtPrecio;
    @FXML private TextField txtStock;
    @FXML private Button btnAgregarArticulo;
    @FXML private TableView<Articulo> tblArticulos;
    @FXML private Label lblInfoCliente;
    @FXML private Label lblInfoArticulo;

    @Override public void initialize(URL url, ResourceBundle rb) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        cr = new ClienteR(emf.createEntityManager());
        ar = new ArticuloR(emf.createEntityManager());
    }    

    @FXML private void agregarCliente(ActionEvent event) {
        if(!validarCliente()) return;
        Cliente cliente = new Cliente(
                txtNombre.getText(),
                txtApellido.getText(),
                txtCuit.getText(),
                txtDireccion.getText()
        );
        cr.save(cliente);
        lblInfoCliente.setText("Se ingreso el cliente con codigo:"+cliente.getCodigo());
        limpiarCliente();
    }

    @FXML
    private void agregarArticulo(ActionEvent event) {
        if(!validarArticulo()) return;
            
        Articulo articulo = new Articulo(
                txtDescripcion.getText(),
                Double.parseDouble(txtPrecio.getText()),
                Integer.parseInt(txtStock.getText())
        );
        ar.save(articulo);
        lblInfoArticulo.setText("Se ingreso el articulo con codigo:"+articulo.getCodigo());
        limpiarArticulo();
    }
    private boolean validarCliente(){
        //valida nombre string entre 2 y 20 caracteres.
        if(!new Validator(txtNombre,lblInfoCliente).length(2, 20))     return false;
        //valida apellido String entre 2 y 20 caracteres.
        if(!new Validator(txtApellido,lblInfoCliente).length(2, 20))   return false;
        //valida Cuit String de 13 caracteres
        if(!new Validator(txtCuit,lblInfoCliente).length(13, 13))   return false;
        //valida direccion String entre 5 y 30 caracteres.
        if(!new Validator(txtDireccion,lblInfoCliente).length(5, 30))   return false;
        return true;
    }
    
    private boolean validarArticulo(){
        //valida Descripcion string entre 2 y 30 caracteres.
        if(!new Validator(txtDescripcion,lblInfoArticulo).length(2, 30))     return false;
        //valida Stock String entre 1 y 200 caracteres.
        if(!new Validator(txtStock,lblInfoArticulo).isInteger(1, 200))   return false;
        //valida Precio Double > 0
        if(!new Validator(txtPrecio,lblInfoArticulo).isDouble())   return false;
        return true;
    }
    
    private void limpiarCliente(){
        txtNombre.setText("");
        txtNombre.requestFocus();
        txtApellido.setText("");
        txtCuit.setText("");
        txtDireccion.setText("");
    }
    
    private void limpiarArticulo(){
        txtDescripcion.setText("");
        txtDescripcion.requestFocus();
        txtPrecio.setText("");
        txtStock.setText("");
    }

    
}
