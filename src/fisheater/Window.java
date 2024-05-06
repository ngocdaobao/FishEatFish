package fisheater;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window extends JFrame
{
    private final int WIDTH = 1280;
    private final int HEIGHT = 720;
    public Window()
    {
        add( new Board( WIDTH, HEIGHT ));
        ImageIcon icon = new ImageIcon("fisheater/resources/menus/icon.png");

        // Đặt biểu tượng cho cửa sổ
        setIconImage(icon.getImage());

        setTitle( "Fish Eater" );
        setDefaultCloseOperation(EXIT_ON_CLOSE); // đóng chương trình khi cửa sổ bị đóng
        setSize( WIDTH, HEIGHT );
        setLocationRelativeTo(null); // đặt cửa sổ tại trung tâm của màn hình
        setVisible(true);
        setResizable(false); // cố định kích cỡ của cửa sổ
        
    }

    public static void main(String[] args)
    {
        new Window();
    }


}
