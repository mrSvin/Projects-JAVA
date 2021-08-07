import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {
    private JPanel mainPanel;
    private JButton collapseButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton expandButton;
    private JTextField textField4;

    public MainForm() {
        collapseButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                String textSurname = textField1.getText();
                String textName = textField2.getText();
                int lengthSurname = textSurname.length();
                int lengthName = textName.length();
                if (lengthName == 0 || lengthSurname == 0) {
                    JOptionPane.showMessageDialog(
                            mainPanel,
                            "Заполните поля!",
                            "Ошибка",
                            JOptionPane.PLAIN_MESSAGE
                    );
                } else {
                    textField1.setVisible(false);
                    textField2.setVisible(false);
                    textField3.setVisible(false);
                    label1.setVisible(false);
                    label2.setVisible(false);
                    label3.setVisible(false);
                    collapseButton.setVisible(false);

                    textField4.setVisible(true);
                    expandButton.setVisible(true);
                    textField4.setText(textField1.getText() + " " + textField2.getText() + " " + textField3.getText());
                }
            }
        });

        expandButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                int inFIO = textField4.getText().length();
                int searchSpace = textField4.getText().replaceAll(" ", "").length();
                if (inFIO-searchSpace==0 || inFIO-searchSpace>2) {
                    JOptionPane.showMessageDialog(
                            mainPanel,
                            "Заполните поле корректно!",
                            "Ошибка",
                            JOptionPane.PLAIN_MESSAGE
                    );
                } else {

                    textField1.setVisible(true);
                    textField2.setVisible(true);
                    textField3.setVisible(true);
                    label1.setVisible(true);
                    label2.setVisible(true);
                    label3.setVisible(true);
                    collapseButton.setVisible(true);

                    textField4.setVisible(false);
                    expandButton.setVisible(false);

                    String fio = textField4.getText();
                    int endName = fio.indexOf(" ");
                    int endSurname = fio.lastIndexOf(" ");
                    String name = fio.substring(0, endName);
                    String surname = fio.substring(endName+1, endSurname);
                    String fatherName= fio.substring(endSurname+1, fio.length());

                    System.out.println(surname);

                        textField1.setText(name);
                        textField2.setText(surname);
                        textField3.setText(fatherName);



                }
            }
        });
    }

    public JPanel getMainPanel() {
        expandButton.setVisible(false);
        textField4.setVisible(false);
        return mainPanel;
    }

}
