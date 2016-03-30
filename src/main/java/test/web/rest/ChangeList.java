package test.web.rest;

import java.util.List;

/**
 * Created by smile on 30-Mar-16.
 */
public class ChangeList {

    private List<String> personlist;
    private List<String> changelist;

    public List<String> getPersonList() {
        return this.personlist;
    }

    public void setPersonList(List<String> personlist) {
        this.personlist = personlist;
    }

    public List<String> getChangelist() {
        return changelist;
    }

    public void setChangelist(List<String> changelist) {
        this.changelist = changelist;
    }
}
