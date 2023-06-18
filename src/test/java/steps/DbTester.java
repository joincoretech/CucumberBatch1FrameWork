package steps;

import utils.ConfigReader;
import utils.Constants;
import utils.DbUtils;

import java.util.List;
import java.util.Map;

public class DbTester {
    public static void main(String[] args) {
        ConfigReader.readProperties(Constants.configurationFilePath);
        String query="select firstname, middlename, lastname from employee where employeeid=13;";

        List<Map<String, String>> table= DbUtils.getTableDataAsListOfMaps(query);
        System.out.println(table);
    }
}
