package util;

import java.io.*;


public class ObjectSink {
    private File file;
    private ObjectOutputStream outStream;

    public ObjectSink(String filename) throws FileNotFoundException {
        try {
            file = new File(filename);
            outStream = new ObjectOutputStream(new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storeObject(Object o) {
        try {
            outStream.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
