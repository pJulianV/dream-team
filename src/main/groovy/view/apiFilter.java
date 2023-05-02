package view;

import Controller.apiController;
import Controller.dbController;
import Model.dbModel;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class apiFilter {
    public JPanel panel1;
    public JButton searchByNameAPI;
    private JButton searchByIdAPI;
    private JTextField textField1;
    private JTextField textField2;
    private JTextPane resultPanel;
    private JButton guardarEnDBButton;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;

    public apiFilter() {
    searchByNameAPI.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            apiController controller = new apiController();
            try {
                String res = controller.getByName(textField1.getText());

                JSONObject json = new JSONObject(res);

                JSONArray profilesArray = json.getJSONArray("profiles");
                String url = "";
                String name = "";
                String author_id = "";
                String email = "";
                String affiliations = "";
                String str = "";
                for (int i = 0; i < profilesArray.length(); i++) {
                    JSONObject profileObject = profilesArray.getJSONObject(i);

                     url = profileObject.getString("link");
                     name = profileObject.getString("name");
                     author_id = profileObject.getString("author_id");
                     email = profileObject.getString("email");
                     affiliations = profileObject.getString("affiliations");
                     str += "\nAuthor ID:" + author_id +"\nURL: "+url+ "\nName: " + name + "\nEmail: " + email + "\nAffiliation: " +affiliations;
                }
                resultPanel.setText(str);


            } catch (Exception ex) {
                resultPanel.setText("Error al encontrar la informacion...");
                throw new RuntimeException(ex);
            }
        }
    });
    searchByIdAPI.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            apiController controller = new apiController();
            try {
                String res = controller.getByID(textField2.getText());
                JSONObject json = new JSONObject(res);

                String name = json.getJSONObject("author").getString("name");
                String author_id = json.getJSONObject("search_parameters").getString("author_id");
                String email = json.getJSONObject("author").getString("email");
                String url = json.getJSONObject("public_access").getString("link");
                String affiliations = json.getJSONObject("author").getString("affiliations");
                resultPanel.setText("\nAuthor ID:" + author_id + "\nURL: "+url+ "\nName: " + name + "\nEmail: " + email + "\nAffiliation: " +affiliations);
                textField3.setText(author_id);
                textField4.setText(url);
                textField5.setText(name);
                textField6.setText(email);
                textField7.setText(affiliations);

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }
    });
        guardarEnDBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dbModel db = new dbModel();

                try {
                    Connection conn = db.connect();
                    dbController controller = new dbController(conn);
                    controller.insertFromAPI(textField3.getText(),textField4.getText(),textField5.getText(),textField6.getText(),textField7.getText());
                    resultPanel.setText("Se han ingresado los datos correctamente.");
                    conn.close();
                } catch (SQLException ex) {
                    resultPanel.setText("Error al guardar la informacion: " + ex.getMessage());
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}