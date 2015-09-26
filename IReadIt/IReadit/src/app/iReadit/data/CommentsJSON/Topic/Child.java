package app.iReadit.data.CommentsJSON.Topic;

//import javax.annotation.Generated;

import app.iReadit.data.CommentsJSON.Topic.Topic;

import com.google.gson.annotations.Expose;

//@Generated("org.jsonschema2pojo")
public class Child {

@Expose
private String kind;
@Expose
private Topic data;

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
public Topic getData() {
return data;
}

/**
* 
* @param data
* The data
*/
public void setData(Topic data) {
this.data = data;
}

}