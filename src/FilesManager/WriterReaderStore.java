package FilesManager;

import java.io.*;
import java.util.ArrayList;

public class WriterReaderStore {

    private File file;
    private ArrayList ObjectsList = new ArrayList();
    private FileOutputStream fileOutput;
    private FileInputStream fileInput;
    private AppendableObjectOutputStream objectOutput;
    private ObjectInputStream objectInput;
    private String path;

    public String getPath() {
        return path;
    }

    public WriterReaderStore(String path) {
        this.path=path;
        try {
            file = new File(path);
            boolean append = file.exists();
            fileOutput = new FileOutputStream(file, append);
            objectOutput = new AppendableObjectOutputStream(fileOutput, append);
            fileInput = new FileInputStream(file);
            objectInput = new ObjectInputStream(fileInput);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteFile() {
        return file.delete();
    }

    public boolean isEmptyFile() {
        if (!file.exists() || file.length() == 0) {
            return true;
        }
        return false;
    }

    public void Closer() throws Exception{
        fileInput.close();
        fileOutput.close();
    }
    public void clearFile() {
        try {
            FileWriter fwOb = new FileWriter(file, false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addObject(Object object) {
        try {
            objectOutput.writeObject(object);
            //objectOutput.close();
           // objectOutput.flush();
        } catch (EOFException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object readObject(){//new
        Object temp=null;
        try{
            try{
                temp=objectInput.readObject();
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }catch(EOFException e)
        {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return temp;
    }

    public ArrayList readObjectList() {
        boolean count = true;
        try {

            while (count) {
                Object temp = null;
                try {
                    temp = objectInput.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (/*fileInput.available() != 0 */temp != null) {
                    ObjectsList.add(temp);
                } else {
                    count = false;
                }
            }
        } catch (EOFException e) {
            count = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ObjectsList;
    }


}
