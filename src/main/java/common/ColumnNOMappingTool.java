package common;

import java.util.HashMap;
import java.util.Map;

public class ColumnNOMappingTool {
    public static final Integer NAME = 0;
    public static final Integer BIRTH = 1;
    public static final Integer SEX = 3;
    public static Map<Integer,String> columnMap = new HashMap<>();
    static {
        columnMap.put(NAME,"name");
        columnMap.put(BIRTH,"birth");
        columnMap.put(SEX,"sex");
    }
    public static String ColumnNO2ColumnName(Integer columnNO){
        return columnMap.get(columnNO);
    }
}
