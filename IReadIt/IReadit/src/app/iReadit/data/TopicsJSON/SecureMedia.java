package app.iReadit.data.TopicsJSON;

//import javax.annotation.Generated;

import app.iReadit.data.TopicsJSON.Oembed;
import app.iReadit.data.TopicsJSON.SecureMedia;

import com.google.gson.annotations.Expose;

//@Generated("org.jsonschema2pojo")
public class SecureMedia {

	@Expose
	private Oembed oembed;
	@Expose
	private String type;

	/**
	* 
	* @return
	* The oembed
	*/
	public Oembed getOembed() {
	return oembed;
	}

	/**
	* 
	* @param oembed
	* The oembed
	*/
	public void setOembed(Oembed oembed) {
	this.oembed = oembed;
	}

	public SecureMedia withOembed(Oembed oembed) {
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

	public SecureMedia withType(String type) {
	this.type = type;
	return this;
	}
	
}
