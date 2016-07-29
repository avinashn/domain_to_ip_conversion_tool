package domaintoip;

/**
 *
 * @author Avinash
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class DomaintoIp extends JFrame implements ActionListener {

    JLabel url = new JLabel("Enter URL");
    JLabel ipad = new JLabel("Corresponding Ip Address");
    JTextField tfurl = new JTextField(30);
    JTextField tfipad = new JTextField(20);
    JButton submit = new JButton("Submit");
    JButton clear = new JButton("Clear");
    JPanel p, p1, p2, p3, p4;

    public DomaintoIp() throws Exception {
        setTitle("Domain to Ip Address");
        tfipad.setEditable(false);
        setSize(400, 400);
        setLayout(new GridLayout(5, 2));

        p = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        p1.add(url);
        p2.add(ipad);
        p1.add(tfurl);
        p2.add(tfipad);
        p3.add(submit);
        p3.add(clear);

        add(p);
        add(p1);
        add(p2);
        add(p3);

        submit.addActionListener(this);
        clear.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DomaintoIp().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(DomaintoIp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            if (ae.getSource() == submit) {
                String str = tfurl.getText();
                InetAddress address = InetAddress.getByName(new URL(str).getHost());
                String ip = address.getHostAddress();

                tfipad.setText(ip);
            }
            if (ae.getSource() == clear) {
                tfipad.setText(" ");
                tfurl.setText(" ");
            }
        } catch (MalformedURLException | UnknownHostException e) {
        }
    }

}
