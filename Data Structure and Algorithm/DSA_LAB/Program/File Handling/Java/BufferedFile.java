import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
 class BufferedFile extends FrameListen implements ActionListener {

  private Button viewBT;
  private TextField tf;
  private TextArea ta;

  public static void main(String[] args) {
   Frame f = new BufferedFile();
   f.setSize(400,300);
   f.setVisible(true);
  }

  public BufferedFile() {
   setTitle("View File");
   Panel p1 = new Panel();
   p1.setLayout(new FlowLayout());
   p1.add(ta = new TextArea(10,60));

   Panel p2 = new Panel();
   p2.setLayout(new FlowLayout());
   p2.add(new Label("Filename"));
   p2.add(tf = new TextField(" ",12));
   p2.add(viewBT = new Button("View"));

   setLayout(new FlowLayout());
   add(p1);
   add(p2);

   viewBT.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
   String arg = e.getActionCommand();
   if(e.getSource() instanceof Button)
    if("View".equals(arg))
     showFile();
  }

  private void showFile() {
   BufferedReader infile = null;
   String filename = tf.getText().trim();
   String inLine;

   try {
    infile = new BufferedReader(new FileReader(filename));

    inLine = infile.readLine();

    boolean firstLine = true;

    while(inLine != null) {
     if(firstLine) {
      firstLine = false;
      ta.append(inLine);
     }
     else {
      ta.append("\n"+inLine);
     }
     inLine = infile.readLine();
    }
   }
   catch(FileNotFoundException e) {
    System.out.println("File not found: "+filename);
   }
   catch(IOException e) {
    System.out.println(e.getMessage());
   }
   finally {
    try {
     if(infile != null)
      infile.close();
    }
    catch(IOException e)
    {}
   }
  }
}


