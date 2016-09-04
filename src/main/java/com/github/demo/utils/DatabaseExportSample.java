package com.github.demo.utils;




/**
 * Created by zhuoshangyi on 2016/9/1.
 */
public class DatabaseExportSample {
    public static void main(String[] args) throws Exception {
        // database connection
//        Class driverClass = Class.forName("org.postgresql.Driver");
//        Connection jdbcConnection = DriverManager.getConnection(
//                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "446794");
//        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
//
//        // partial database export
//        QueryDataSet partialDataSet = new QueryDataSet(connection);
//        // partialDataSet.addTable("FOO", "SELECT * FROM TABLE WHERE COL='VALUE'");
//        partialDataSet.addTable("T_USER");
//        FlatXmlDataSet.write(partialDataSet, new FileOutputStream(new File("T_USER.xml")));


        // full database export
//        IDataSet fullDataSet = connection.createDataSet();
//        FlatXmlDataSet.write(fullDataSet, new FileOutputStream("full.xml"));

        // dependent tables database export: export table X and all tables that
        // have a PK which is a FK on X, in the right order for insertion
//        String[] depTableNames =
//                TablesDependencyHelper.getAllDependentTables( connection, "X" );
//        IDataSet depDataset = connection.createDataSet( depTableNames );
//        FlatXmlDataSet.write(depDataset, new FileOutputStream("dependents.xml"));

    }
}
