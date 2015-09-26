package app.iReadit.data.TopicsJSON;

//import javax.annotation.Generated;

import com.google.gson.annotations.Expose;

//@Generated("org.jsonschema2pojo")
public class SecureMediaEmbed {
	@Expose
	private String content;
	@Expose
	private Integer width;
	@Expose
	private Boolean scrolling;
	@Expose
	private Integer height;

	/**
	* 
	* @return
	* The content
	*/
	public String getContent() {
	return content;
	}

	/**
	* 
	* @param content
	* The content
	*/
	public void setContent(String content) {
	this.content = content;
	}

	public SecureMediaEmbed withContent(String content) {
	this.content = content;
	return this;
	}

	/**
	* 
	* @return
	* The width
	*/
	public Integer getWidth() {
	return width;
	}

	/**
	* 
	* @param width
	* The width
	*/
	public void setWidth(Integer width) {
	this.width = width;
	}

	public SecureMediaEmbed withWidth(Integer width) {
	this.width = width;
	return this;
	}

	/**
	* 
	* @return
	* The scrolling
	*/
	public Boolean getScrolling() {
	return scrolling;
	}

	/**
	* 
	* @param scrolling
	* The scrolling
	*/
	public void setScrolling(Boolean scrolling) {
	this.scrolling = scrolling;
	}

	public SecureMediaEmbed withScrolling(Boolean scrolling) {
	this.scrolling = scrolling;
	return this;
	}

	/**
	* 
	* @return
	* The height
	*/
	public Integer getHeight() {
	return height;
	}

	/**
	* 
	* @param height
	* The height
	*/
	public void setHeight(Integer height) {
	this.height = height;
	}

	public SecureMediaEmbed withHeight(Integer height) {
	this.height = height;
	return this;
	}
}
