package hinatazaka46.smash.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import javax.sql.DataSource;
import org.dbunit.Assertion;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.ext.h2.H2Connection;

public class DBUnitUtil {


    public static void assertMutateResult(DataSource source, String tableName, File expected, List<String> skipCols) {
        IDatabaseConnection connection = null;
        try {
            connection = dbUnitConnection(source);
            ITable expectedTable = getExcelITbale(expected.getPath(), tableName);
            ITable actualTable = getCurrentITable(connection, tableName);
            Assertion.assertEqualsIgnoreCols(expectedTable,actualTable,skipCols.toArray(new String[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static ITable getExcelITbale(String path, String tableName) throws Exception {
        XlsDataSet dataset = new XlsDataSet(new FileInputStream(path));
        return dataset.getTable(tableName);
    }

    static ITable getCurrentITable(IDatabaseConnection connection, String tableName) throws Exception{
        try {
            IDataSet dbDataSet = connection.createDataSet();
            return dbDataSet.getTable(tableName);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    static IDatabaseConnection dbUnitConnection(DataSource dataSource) throws Exception{
       return new H2Connection(dataSource.getConnection(),"Sheet1");
    }

}
