package app.iReadit.data.CommentsJSON.Comments;

import java.util.ArrayList;
import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

//@Generated("org.jsonschema2pojo")
public class Data {

@Expose
private String modhash;
@Expose
private List<Child> children = new ArrayList<Child>();
@Expose
private Object after;
@Expose
private Object before;

/**
* 
* @return
* The modhash
*/
public String getModhash() {
return modhash;
}

/**
* 
* @param modhash
* The modhash
*/
public void setModhash(String modhash) {
this.modhash = modhash;
}

/**
* 
* @return
* The children
*/
public List<Child> getChildren() {
return children;
}

/**
* 
* @param children
* The children
*/
public void setChildren(List<Child> children) {
this.children = children;
}

/**
* 
* @return
* The after
*/
public Object getAfter() {
return after;
}

/**
* 
* @param after
* The after
*/
public void setAfter(Object after) {
this.after = after;
}

/**
* 
* @return
* The before
*/
public Object getBefore() {
return before;
}

/**
* 
* @param before
* The before
*/
public void setBefore(Object before) {
this.before = before;
}

}