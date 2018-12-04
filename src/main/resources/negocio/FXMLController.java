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
import negocio.repositories.ArticuloR;
import negocio.repositories.ClienteR;

public class FXMLController implements Initializable {
    private ClienteR cr;
    private ArticuloR ar;
    
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtCuit;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtInfo;
    @FXML
    private Button btnAgregarCliente;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtStock;
    @FXML
    private Button btnAgregarArticulo;
    @FXML
    private TableView<?> tblArticulos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        cr = new ClienteR(emf.createEntityManager());
        ar = new ArticuloR(emf.createEntityManager());
    }    

    @FXML
    private void agregarCliente(ActionEvent event) {
    }

    @FXML
    private void agregarArticulo(ActionEvent event) {
    }

    
}
