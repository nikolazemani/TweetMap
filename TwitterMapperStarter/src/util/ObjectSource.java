package util;

import java.io.*;

/**
 * Read objects from a file
 */
public class ObjectSource {
    private final File file;
    private ObjectInputStream inStream;

    public ObjectSource(String filename)  {
        file = new File(filename);
        try {
            inStream = new ObjectInputStream(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object readObject() {
        Object o = null;
        try {
            o = inStream.readObject();
        } catch (EOFException e) {
            // Do nothing, EOF is expected to happen eventually
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }

    public void close() {
        try {
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
