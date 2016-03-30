package test.web.rest;

/**
 * Created by smile on 24-Mar-16.
 */
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/students")
public class HelloWorldService {

    private DataTransfer dto = new DataTransfer();

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public ResponseList getContent(){
        List<String> list = dto.getContent();
        ResponseList response = new ResponseList();
        response.setList(list);
        return response;
    }

    @GET
    @Path("/columns")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public ColNumbers getColumns(){
        ColNumbers cn = new ColNumbers();
        cn.setColumns(dto.getColumns());
        return cn;
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void addContent(ResponseList listContent){
        List<String> list = listContent.getList();
        dto.addContent(list);
    }


    @PUT
    @Path("/put")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void changeContent(ChangeList listContent){
        List<String> personList = listContent.getPersonList();
        List<String> changeList = listContent.getChangelist();
        dto.changeContent(personList, changeList);
    }

    @DELETE
    @Path("/delete/{surname}/{name}/{fathername}")
    //@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void deleteContent(@PathParam("surname") String surname, @PathParam("name") String name,
                              @PathParam("fathername") String fathername) {
        List<String> personList = new ArrayList<String>();

        personList.add(surname);
        personList.add(name);
        personList.add(fathername);
        /*int n = fio.indexOf("%");
        String buf = fio.substring(0,n-1);
        fio = fio.substring(n);
        personList.add(buf);

        n = fio.indexOf("%");
        buf = fio.substring(0,n-1);
        fio = fio.substring(n);
        personList.add(buf);

        personList.add(fio);*/

        dto.deleteContent(personList);
    }
}
