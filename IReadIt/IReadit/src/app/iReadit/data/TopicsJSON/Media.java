package app.iReadit.data.TopicsJSON;

import com.google.gson.annotations.Expose;

public class Media {


@Expose
private Oembed_ oembed;
@Expose
private String type;

/**
* 
* @return
* The oembed
*/
public Oembed_ getOembed() {
return oembed;
}

/**
* 
* @param oembed
* The oembed
*/
public void setOembed(Oembed_ oembed) {
this.oembed = oembed;
}

public Media withOembed(Oembed_ oembed) {
this.oembed = oembed;
return this;
}

/**
* 
* @return
* The type
*/
public String getType() {
return type;
}

/**
* 
* @param type
* The type
*/
public void setType(String type) {
this.type = type;
}

public Media withType(String type) {
this.type = type;
return this;
}
	
}
