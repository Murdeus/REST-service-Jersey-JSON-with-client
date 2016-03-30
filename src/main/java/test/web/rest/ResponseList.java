package test.web.rest;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by smile on 25-Mar-16.
 */
//@XmlRootElement(name = "responseList")
public class ResponseList {

    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

}
