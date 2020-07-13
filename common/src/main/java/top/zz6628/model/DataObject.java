package top.zz6628.model;

/**
 * @author zhenz
 * @description
 * @date 2020/7/6 14:11
 */
public class DataObject {
    private final String data;

    private static int objectCounter = 0;

    public DataObject(String data) {
        this.data = data;
    }
    // standard constructors/getters

    public static DataObject get(String data) {
        objectCounter++;
        return new DataObject(data);
    }
}
