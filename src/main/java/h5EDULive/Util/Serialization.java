package h5EDULive.Util;

import java.io.*;

public class Serialization {
    //将java对象序列化为byte
    public static byte[] obj2byte(Object obj) {
        byte[] ret = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream out = new ObjectOutputStream(baos);
            out.writeObject(obj);
            out.close();
            ret = baos.toByteArray();
            baos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return ret;
    }

    //将byte[]反序列化为java对象
    public static Object byte2obj(byte[] bytes){
        Object ret = null;
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(bais);
            ret = in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
