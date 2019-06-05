import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * This class represents the graphical interface to a simple image manipulation program.
 * 
 * @author Nathan Sprague
 * @version 2.0, 1/10/17
 * 
 */
public class MimpApp
{

  protected JFrame frame;
  private ImageComponent imageComponent;

  // Menu Items
  private JMenuItem mntmSaveFile;
  private JMenuItem mntmThreshold;
  private JMenuItem mntmGrayScale;
  private JMenuItem mntmRoseTintedGlasses;
  private JMenuItem mntmRotateLeft;
  private JMenuItem mntmRotateRight;
  private JMenuItem mntmMirror;
  private JMenuItem mntmFlip;
  private JMenuItem mntmSaveMim;

  private JFileChooser fileChooser;

  /**
   * Create the application.
   */
  public MimpApp()
  {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize()
  {
    frame = new JFrame();
    frame.setTitle("MIMP Image Editor");
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);

    // ----------------------------
    // SET UP THE File... Menu
    // ----------------------------

    JMenu mnFileMenu = new JMenu("File");
    menuBar.add(mnFileMenu);

    JMenuItem mntmOpenFile = new JMenuItem("Open File...");

    mntmOpenFile.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        openFile();
      }
    });
    mnFileMenu.add(mntmOpenFile);

    JMenuItem mntmLoadFile = new JMenuItem("Load as Mimp");

    mntmLoadFile.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        try
        {
          openMimp();
        }
        catch (ImageFileFormatException e1)
        {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
    });
    mnFileMenu.add(mntmLoadFile);

    mntmSaveFile = new JMenuItem("Save File...");
    mntmSaveFile.setEnabled(false);
    mntmSaveFile.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        saveFile();
      }
    });
    mnFileMenu.add(mntmSaveFile);

    mntmSaveMim = new JMenuItem("Save Mim");
    mntmSaveMim.setEnabled(false);
    mntmSaveMim.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        saveFile();
      }
    });
    mnFileMenu.add(mntmSaveMim);

    // ----------------------------
    // SET UP THE Transforms Menu
    // ----------------------------

    JMenu mnTransformMenu = new JMenu("Transform");
    menuBar.add(mnTransformMenu);

    mntmGrayScale = new JMenuItem("Convert to Grayscale");
    mntmGrayScale.setEnabled(false);
    mntmGrayScale.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Image image = ImageUtils.bufferedImageToImage(imageComponent.getImage());
        image = ImageTransforms.convertToGrayscale(image);
        imageComponent.setImage(image);
      }
    });
    mnTransformMenu.add(mntmGrayScale);

    mntmRoseTintedGlasses = new JMenuItem("Rose-Tinted Glasses");
    mntmRoseTintedGlasses.setEnabled(false);
    mntmRoseTintedGlasses.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Image image = ImageUtils.bufferedImageToImage(imageComponent.getImage());
        image = ImageTransforms.roseTintedGlasses(image);
        imageComponent.setImage(image);
      }
    });
    mnTransformMenu.add(mntmRoseTintedGlasses);

    mntmThreshold = new JMenuItem("Threshold...");
    mntmThreshold.setEnabled(false);
    mntmThreshold.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        Integer threshold = requestInteger(0, 255);
        if (threshold != null)
        {
          Image image = ImageUtils.bufferedImageToImage(imageComponent.getImage());
          image = ImageTransforms.threshold(image, threshold);
          imageComponent.setImage(image);
        }
      }
    });
    mnTransformMenu.add(mntmThreshold);

    mntmRotateLeft = new JMenuItem("Rotate Left");
    mntmRotateLeft.setEnabled(false);
    mntmRotateLeft.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Image image = ImageUtils.bufferedImageToImage(imageComponent.getImage());
        image = ImageTransforms.rotateLeft(image);
        imageComponent.setImage(image);
      }
    });
    mnTransformMenu.add(mntmRotateLeft);

    mntmRotateRight = new JMenuItem("Rotate Right");
    mntmRotateRight.setEnabled(false);
    mntmRotateRight.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Image image = ImageUtils.bufferedImageToImage(imageComponent.getImage());
        image = ImageTransforms.rotateRight(image);
        imageComponent.setImage(image);
      }
    });
    mnTransformMenu.add(mntmRotateRight);

    mntmMirror = new JMenuItem("Mirror");
    mntmMirror.setEnabled(false);
    mntmMirror.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Image image = ImageUtils.bufferedImageToImage(imageComponent.getImage());
        image = ImageTransforms.mirror(image);
        imageComponent.setImage(image);
      }
    });
    mnTransformMenu.add(mntmMirror);

    mntmFlip = new JMenuItem("Flip");
    mntmFlip.setEnabled(false);
    mntmFlip.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Image image = ImageUtils.bufferedImageToImage(imageComponent.getImage());
        image = ImageTransforms.flip(image);
        imageComponent.setImage(image);
      }
    });
    mnTransformMenu.add(mntmFlip);

    imageComponent = new ImageComponent();
    frame.getContentPane().add(imageComponent, BorderLayout.CENTER);
    fileChooser = new JFileChooser(new File("."));
  }

  /**
   * Pop up a file dialog, and open the requested file.
   */
  private void openFile()
  {
    int returnVal = fileChooser.showOpenDialog(frame);
    if (returnVal == JFileChooser.APPROVE_OPTION)
    {
      File file = fileChooser.getSelectedFile();
      try
      {
        BufferedImage img = ImageIO.read(file);
        Image image = ImageUtils.bufferedImageToImage(img);
        imageComponent.setImage(image);
        mntmSaveMim.setEnabled(true);
        mntmSaveFile.setEnabled(true);
        mntmThreshold.setEnabled(true);
        mntmGrayScale.setEnabled(true);
        mntmRotateLeft.setEnabled(true);
        mntmRotateRight.setEnabled(true);
        mntmFlip.setEnabled(true);
        mntmMirror.setEnabled(true);
        mntmRoseTintedGlasses.setEnabled(true);

      }
      catch (IOException e)
      {
        JOptionPane.showMessageDialog(frame, "Error opening the file: " + file.getName());
      }
    }
  }

  /**
   * We open our mimp app as an image.
   * 
   * @throws ImageFileFormatException
   *           our exception
   **/
  private void openMimp() throws ImageFileFormatException
  {
    int returnVal = fileChooser.showSaveDialog(frame);
    Image image;
    if (returnVal == JFileChooser.APPROVE_OPTION)
    {
      File file = fileChooser.getSelectedFile();
      try
      {
        image = Image.loadImage(file);
        imageComponent.setImage(image);
      }
      catch (FileNotFoundException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
  }

  /**
   * Pop up a file dialog, and save the file in the requested location. Automatically chooses the
   * file type as .jpg, .png, or .gif according to the file extension.
   */
  private void saveFile()
  {
    int returnVal = fileChooser.showSaveDialog(frame);
    if (returnVal == JFileChooser.APPROVE_OPTION)
    {
      File file = fileChooser.getSelectedFile();
      int dotPos = file.getName().lastIndexOf('.');
      String ext = file.getName().substring(dotPos + 1);
      BufferedImage img = imageComponent.getImage();
      try
      {
        if (ext.equals("png"))
        {
          ImageIO.write(img, "png", file);
        }
        else if (ext.equals("jpg"))
        {
          ImageIO.write(img, "jpg", file);
        }
        else if (ext.equals("gif"))
        {
          ImageIO.write(img, "gif", file);
        }
        else if (ext.equals("mim"))
        {
          Image image = ImageUtils.bufferedImageToImage(img);
          Image.saveImage(image, file);
        }
        else
        {
          JOptionPane.showMessageDialog(frame,
              " Unrecognized file extension ." + ext + "\n Please select .jpg .gif or .png  ");
        }

        Image image = ImageUtils.bufferedImageToImage(img);
        imageComponent.setImage(image);
      }
      catch (IOException e)
      {
        JOptionPane.showMessageDialog(frame, "Error saving the file: " + file.getName());
      }

    }

  }

  /**
   * Pop up a dialog to obtain an integer value from the user within a certain range.
   * 
   * @param min
   *          minimum integer value to accept
   * @param max
   *          maximum integer value to accept
   * @return The entered value or null if the user cancels the dialog
   */
  private Integer requestInteger(int min, int max)
  {
    int value = min - 1;
    while (value < min || value > max)
    {
      String s = (String) JOptionPane
          .showInputDialog("Enter an integer between " + min + " and " + max);

      if (s == null) // User pressed cancel.
      {
        return null;
      }

      try
      {
        value = Integer.parseInt(s);
      }
      catch (NumberFormatException e)
      {
      }
    }
    return new Integer(value);
  }

  /**
   * Starting point for the application.
   */
  public static void launch()
  {
    try
    {
      for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
      {
        if ("Nimbus".equals(info.getName()))
        {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }
    catch (Throwable e)
    {
      e.printStackTrace();
    }
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          MimpApp window = new MimpApp();
          window.frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }

}
