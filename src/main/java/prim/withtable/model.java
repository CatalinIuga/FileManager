package prim.withtable;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.table.AbstractTableModel;
import static prim.withtable.WithTable.dir_c;
import static prim.withtable.WithTable.files;

public class model extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return files.length;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int n) {
        switch (n) {
            case 0:
                return "Name";
            case 1:
                return "Size";
            default:
                return "Type";
        }
    }

    public boolean image_check(File a) throws IOException {
        BufferedImage buf = ImageIO.read(a);
        if (buf != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            File f = new File(dir_c + "\\" + files[rowIndex]);
            switch (columnIndex) {
                case 0:
                    return f.getName();
                case 1:
                    if (!f.isDirectory()) {
                        return f.length();
                    }
                    return null;
                case 2:
                    if (f.isDirectory()) {
                        return "directory";
                    } else if (f.isFile()) {
                        if (image_check(f)) {
                            return "image";
                        }
                        return "file";
                    } else {
                        return "unknown";
                    }
            }
            return null;
        } catch (IOException ex) {
            Logger.getLogger(model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
