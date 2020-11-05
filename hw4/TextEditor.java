package hw4;

/**
 * @author Tiancheng Xu
 * Load file
 * Save file
 * Quit
 * Save as
 * Setting the color of the background and fontground
 * Compiling java file
 */
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor extends JFrame {
    private String path = "";

    public TextEditor(int w, int h) {
        final JFrame jf = new JFrame("TextEditor");
        jf.setSize(w, h);
        JMenuBar mb = new JMenuBar();
        JMenu m = new JMenu("File");
        JMenu m2 = new JMenu("SetColor");
        JMenu m3 = new JMenu("▶");
        JMenuItem open = new JMenuItem("Open...");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveas = new JMenuItem("Save as");
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem cpl = new JMenuItem("Compile");
        JMenuItem rfs = new JMenuItem("Refresh");
        JMenuItem bkg = new JMenuItem("Background");
        JMenuItem fontcolor = new JMenuItem("Fontground");

        JTextArea msgTextArea = new JTextArea(10, 40);
        Font font = new Font("Consolas", Font.BOLD, 18);
        msgTextArea.setFont(font);
        JScrollPane scrollPane = new JScrollPane(msgTextArea);
        msgTextArea.setLineWrap(true);
        jf.add(scrollPane, BorderLayout.CENTER);

        // open
        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                msgTextArea.setText("");
                JFileChooser fc = new JFileChooser();
                fc.setFileFilter(new FileNameExtensionFilter(".txt", "txt"));
                fc.setFileFilter(new FileNameExtensionFilter(".java", "java"));
                int returnVal = fc.showOpenDialog(TextEditor.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File fl = fc.getSelectedFile();
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(fl.getAbsolutePath()));
                        path = fl.getAbsolutePath();
                        /// read file
                        String line;
                        while ((line = br.readLine()) != null) {
                            msgTextArea.append(line + "\n");
                        }
                        br.close();
                    } catch (Exception exc) {
                        exc.printStackTrace();
                    }
                    save.setEnabled(true);
                    cpl.setEnabled(true);
                }
            }
        });

        // save
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (msgTextArea.getText() != null) {
                    BufferedWriter bw = null;
                    try {
                        bw = new BufferedWriter(new FileWriter(path));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    String[] strs = msgTextArea.getText().split("\n");
                    for (String str : strs) {
                        try {
                            bw.write(str);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        try {
                            bw.newLine();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        try {
                            bw.flush();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    msgTextArea.setText("");
                    path = "";
                    save.setEnabled(false);
                    cpl.setEnabled(false);
                }
            }
        });

        // save as
        saveas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
		
                int option = chooser.showSaveDialog(null);
                if(option==JFileChooser.APPROVE_OPTION){
                    File file = chooser.getSelectedFile();
                    try {
                        FileOutputStream fos = new FileOutputStream(file);
                        
                        //write in
                        BufferedWriter out = new BufferedWriter(new FileWriter(file));
                        String[] strs = msgTextArea.getText().split("\n");
                        for (String str : strs) {
                            out.write(str);
                            out.newLine();
                            out.flush();
                        }
                        fos.close();
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    }	
                }
                msgTextArea.setText("");
                path = "";
                save.setEnabled(false);
                cpl.setEnabled(false);
            }
        });

        // quit
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // compile
        cpl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // null ->
                Runtime r = Runtime.getRuntime();
                try {
                    r.exec("javac " + path);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                msgTextArea.setText("");
                path = "";
                save.setEnabled(false);
                cpl.setEnabled(false);
            }
        });

        // bkg color
        bkg.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                Color color = JColorChooser.showDialog(jf, "Choose Background Color", null);
                if (color == null) {
                    return;
                }
                msgTextArea.setBackground(color);
            }
        });

        // font color
        fontcolor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                Color color = JColorChooser.showDialog(jf, "Choose Font Color", null);
                if (color == null) {
                    return;
                }
                msgTextArea.setForeground(color);
            }
        });

        // refresh
        rfs.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                msgTextArea.setText("");
                path = "";
                save.setEnabled(false);
                cpl.setEnabled(false);
            }
        });

        m.add(open);
        m.add(save);
        m.add(saveas);
        m.addSeparator();
        m.add(exit);
        m2.add(bkg);
        m2.add(fontcolor);
        m3.add(cpl);
        m3.addSeparator();
        m3.add(rfs);
        mb.add(m);
        mb.add(m2);
        mb.add(m3);
        save.setEnabled(false);
        cpl.setEnabled(false);
        jf.setJMenuBar(mb);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TextEditor(1000, 800);
    }
}
