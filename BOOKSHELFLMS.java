// James Lehnen, CEN-3024C, 7-14-24
// Software Development I

package DBGUIDE;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
public class BOOKSHELFLMS extends DBGUIDE {
    private final String TABLE_NAME = "BOOKSHELF";
    public static final String TITLE = "TITLE";
    public static final String AUTHOR = "AUTHOR";
    public static final String ID = "ID";
    public static final String STATUS = "STATUS";
    public static final String DUE_DATE = "DUE_DATE";

    private String prepareSQL(String fields, String whatField, String whatValue, String sortField, String sort) {
        String query = "SELECT ";
        query += fields == null ? " * FROM " + TABLE_NAME : fields + " FROM " + TABLE_NAME;
        query += whatField != null && whatValue != null ? " WHERE " + whatField + " = \"" + whatValue + "\"" : "";
        query += sort != null && sortField != null ? " order by " + sortField + " " + sort : "";
        return query;
    }
    public void insert(String TITLE, String AUTHOR, String ID, String STATUS, String DUE_DATE) {
        TITLE = TITLE != null ? "\"" + TITLE + "\"" : null;
        AUTHOR = AUTHOR != null ? "\"" + AUTHOR + "\"" : null;
        ID = ID != null ? "\"" + ID + "\"" : null;
        STATUS = STATUS != null ? "\"" + STATUS + "\"" : null;
        DUE_DATE = DUE_DATE != null ? "\"" + DUE_DATE + "\"" : null;

        Object[] values_ar = {TITLE, AUTHOR, ID, STATUS, DUE_DATE};
        String[] fields_ar = {BOOKSHELFLMS.TITLE, BOOKSHELFLMS.AUTHOR, BOOKSHELFLMS.ID, BOOKSHELFLMS.STATUS, BOOKSHELFLMS.DUE_DATE};
        String values = "", fields = "";
        for (int i = 0; i < values_ar.length; i++) {
            if (values_ar[i] != null) {
                values += values_ar[i] + ", ";
                fields += fields_ar[i] + ", ";
            }
        }
        if (!values.isEmpty()) {
            values = values.substring(0, values.length() - 2);
            fields = fields.substring(0, fields.length() - 2);
            super.execute("INSERT INTO " + TABLE_NAME + "(" + fields + ") values(" + values + ");");
        }
    }

    public void delete(String whatField, String whatValue) {
        super.execute("DELETE from " + TABLE_NAME + " where " + whatField + " = " + whatValue + ";");
    }

    public void update(String whatField, String whatValue, String whereField, String whereValue) {
        super.execute("UPDATE " + TABLE_NAME + " set " + whatField + " = " + whatValue + " where " + whereField + " = " + whereValue + ";");
    }

    public ArrayList<ArrayList<Object>> select(String fields, String whatField, String whatValue, String sortField, String sort) {
        return super.executeQuery(prepareSQL(fields, whatField, whatValue, sortField, sort));
    }

    public ArrayList<ArrayList<Object>> getExecuteResult(String query) {
        return super.executeQuery(query);
    }

    public void execute(String query) {
        super.execute(query);
    }

    public DefaultTableModel selectToTable(String fields, String whatField, String whatValue, String sortField, String sort) {
        return super.executeQueryToTable(prepareSQL(fields, whatField, whatValue, sortField, sort));
    }

}
