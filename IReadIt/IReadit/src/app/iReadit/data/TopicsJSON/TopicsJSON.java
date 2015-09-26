package app.iReadit.data.TopicsJSON;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

//@Generated("org.jsonschema2pojo")
public class TopicsJSON {

@Expose
private String kind;
@Expose
private Data data;

/**
* 
* @return
* The kind
*/
public String getKind() {
return kind;
}

/**
* 
* @param kind
* The kind
*/
public void setKind(String kind) {
this.kind = kind;
}

/**
* 
* @return
* The data
*/
public Data getData() {
return data;
}

/**
* 
* @param data
* The data
*/
public void setData(Data data) {
this.data = data;
}
}