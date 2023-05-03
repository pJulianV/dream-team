package view;

import Controller.dbController;
import Model.DBModel;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbFilter {

    public JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton buscarButton;
    private JButton buscarButton1;
    private JButton buscarButton2;
    private JTextField authorIDTextField;
    private JTextField URLTextField;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField affiliationsTextField;
    private JButton editarButton;
    private JButton eliminarButton;
    private JTextPane textPane1;
    private JButton mostrarTodosButton;

    public dbFilter() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBModel db = new DBModel();
                try {
                    Connection conn = db.connect();
                    dbController controller = new dbController(conn);
                    ResultSet res = controller.selectByID(textField1.getText());
                    while (res.next()) {
                        String author_id = res.getString("author_id");
                        String url = res.getString("url");
                        String name = res.getString("name");
                        String email = res.getString("email");
                        String affiliations = res.getString("affiliatios");
                        textPane1.setText("\nAuthor ID:" + author_id + "\n" + url + "\nName: " + name + "\nEmail: "
                                + email + "\nAffiliation: " + affiliations);
                        authorIDTextField.setText(author_id);
                        URLTextField.setText(url);
                        nameTextField.setText(name);
                        emailTextField.setText(email);
                        affiliationsTextField.setText(affiliations);
                    }

                    conn.close();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        buscarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBModel db = new DBModel();
                try {
                    Connection conn = db.connect();
                    dbController controller = new dbController(conn);
                    ResultSet res = controller.selectByAuthorID(textField2.getText());
                    while (res.next()) {
                        String author_id = res.getString("author_id");
                        String url = res.getString("url");
                        String name = res.getString("name");
                        String email = res.getString("email");
                        String affiliations = res.getString("affiliatios");
                        textPane1.setText("\nAuthor ID:" + author_id + "\n" + url + "\nName: " + name + "\nEmail: "
                                + email + "\nAffiliation: " + affiliations);
                        authorIDTextField.setText(author_id);
                        URLTextField.setText(url);
                        nameTextField.setText(name);
                        emailTextField.setText(email);
                        affiliationsTextField.setText(affiliations);
                    }
                    conn.close();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        buscarButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBModel db = new DBModel();
                try {
                    Connection conn = db.connect();
                    dbController controller = new dbController(conn);
                    ResultSet res = controller.selectByName(textField3.getText());
                    while (res.next()) {
                        String author_id = res.getString("author_id");
                        String url = res.getString("url");
                        String name = res.getString("name");
                        String email = res.getString("email");
                        String affiliations = res.getString("affiliatios");
                        textPane1.setText("\nAuthor ID:" + author_id + "\n" + url + "\nName: " + name + "\nEmail: "
                                + email + "\nAffiliation: " + affiliations);
                        authorIDTextField.setText(author_id);
                        URLTextField.setText(url);
                        nameTextField.setText(name);
                        emailTextField.setText(email);
                        affiliationsTextField.setText(affiliations);
                    }
                    conn.close();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBModel db = new DBModel();
                try {
                    Connection conn = db.connect();
                    dbController controller = new dbController(conn);
                    controller.update(authorIDTextField.getText(), URLTextField.getText(), nameTextField.getText(),
                            emailTextField.getText(), affiliationsTextField.getText());
                    textPane1.setText("Se actualizo la informacion correctamente.");
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBModel db = new DBModel();
                try {
                    Connection conn = db.connect();
                    dbController controller = new dbController(conn);
                    controller.delete(authorIDTextField.getText());
                    textPane1.setText("Eliminado correctamente.");
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        mostrarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBModel db = new DBModel();
                try {
                    Connection conn = db.connect();
                    dbController controller = new dbController(conn);
                    ResultSet res = controller.selectAll();
                    String author_id = "";
                    String url = "";
                    String name = "";
                    String email = "";
                    String affiliations = "";
                    String str = "";
                    while (res.next()) {
                        author_id = res.getString("author_id");
                        url = res.getString("url");
                        name = res.getString("name");
                        email = res.getString("email");
                        affiliations = res.getString("affiliatios");
                        str += "\nAuthor ID:" + author_id + "\n" + url + "\nName: " + name + "\nEmail: " + email
                                + "\nAffiliation: " + affiliations;
                        textPane1.setText(str);
                    }
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
