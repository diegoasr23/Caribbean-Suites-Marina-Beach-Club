package com.caribbeanmarinabeachclub.controlbrazaletescaribbean.main;

import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.view.RegistrarBrazalete;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CBT_CaribbeanBrazaletTrackerMain extends JFrame {

    public CBT_CaribbeanBrazaletTrackerMain(String title) {
        super(title);
        FlatLightLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CBT_CaribbeanBrazaletTrackerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        RegistrarBrazalete registrarBrazalete = new RegistrarBrazalete();
        setContentPane(registrarBrazalete.getMainPane());
        setSize(1060, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
