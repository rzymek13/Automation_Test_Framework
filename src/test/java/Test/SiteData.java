package Test;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;
import com.poiji.bind.Poiji;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SiteData {
    public static final List<SiteData> lista = new ArrayList<>();
    public static List<SiteData> listOfLinks;
    @ExcelRow
    private int rowIndex;
    @ExcelCellName("name")
    private String name;
    @ExcelCellName("url")
    private String url;

    public SiteData() {
    }

    public SiteData(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    @Override
//    public String toString() {
//        return "\n" + url;
//    }
    public String toString() {
        return "\n" + "nazwa podstrony : "  + name + " " +
                "url : " + url;
    }

    public static List<SiteData> readData(String filePath) {
        listOfLinks = Poiji.fromExcel(new File(filePath), SiteData.class);
        System.out.println(listOfLinks);
        return listOfLinks;
    }


}
