package app.iReadit.data.TopicsJSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Oembed_ {

	@SerializedName("provider_url")
	@Expose
	private String providerUrl;
	@Expose
	private String description;
	@Expose
	private String title;
	@Expose
	private String url;
	@Expose
	private String type;
	@SerializedName("author_name")
	@Expose
	private String authorName;
	@Expose
	private Integer height;
	@Expose
	private Integer width;
	@Expose
	private String html;
	@SerializedName("thumbnail_width")
	@Expose
	private Integer thumbnailWidth;
	@Expose
	private String version;
	@SerializedName("provider_name")
	@Expose
	private String providerName;
	@SerializedName("thumbnail_url")
	@Expose
	private String thumbnailUrl;
	@SerializedName("thumbnail_height")
	@Expose
	private Integer thumbnailHeight;
	@SerializedName("author_url")
	@Expose
	private String authorUrl;

	/**
	* 
	* @return
	* The providerUrl
	*/
	public String getProviderUrl() {
	return providerUrl;
	}

	/**
	* 
	* @param providerUrl
	* The provider_url
	*/
	public void setProviderUrl(String providerUrl) {
	this.providerUrl = providerUrl;
	}

	public Oembed_ withProviderUrl(String providerUrl) {
	this.providerUrl = providerUrl;
	return this;
	}

	/**
	* 
	* @return
	* The description
	*/
	public String getDescription() {
	return description;
	}

	/**
	* 
	* @param description
	* The description
	*/
	public void setDescription(String description) {
	this.description = description;
	}

	public Oembed_ withDescription(String description) {
	this.description = description;
	return this;
	}

	/**
	* 
	* @return
	* The title
	*/
	public String getTitle() {
	return title;
	}

	/**
	* 
	* @param title
	* The title
	*/
	public void setTitle(String title) {
	this.title = title;
	}

	public Oembed_ withTitle(String title) {
	this.title = title;
	return this;
	}

	/**
	* 
	* @return
	* The url
	*/
	public String getUrl() {
	return url;
	}

	/**
	* 
	* @param url
	* The url
	*/
	public void setUrl(String url) {
	this.url = url;
	}

	public Oembed_ withUrl(String url) {
	this.url = url;
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

	public Oembed_ withType(String type) {
	this.type = type;
	return this;
	}

	/**
	* 
	* @return
	* The authorName
	*/
	public String getAuthorName() {
	return authorName;
	}

	/**
	* 
	* @param authorName
	* The author_name
	*/
	public void setAuthorName(String authorName) {
	this.authorName = authorName;
	}

	public Oembed_ withAuthorName(String authorName) {
	this.authorName = authorName;
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

	public Oembed_ withHeight(Integer height) {
	this.height = height;
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

	public Oembed_ withWidth(Integer width) {
	this.width = width;
	return this;
	}

	/**
	* 
	* @return
	* The html
	*/
	public String getHtml() {
	return html;
	}

	/**
	* 
	* @param html
	* The html
	*/
	public void setHtml(String html) {
	this.html = html;
	}

	public Oembed_ withHtml(String html) {
	this.html = html;
	return this;
	}

	/**
	* 
	* @return
	* The thumbnailWidth
	*/
	public Integer getThumbnailWidth() {
	return thumbnailWidth;
	}

	/**
	* 
	* @param thumbnailWidth
	* The thumbnail_width
	*/
	public void setThumbnailWidth(Integer thumbnailWidth) {
	this.thumbnailWidth = thumbnailWidth;
	}

	public Oembed_ withThumbnailWidth(Integer thumbnailWidth) {
	this.thumbnailWidth = thumbnailWidth;
	return this;
	}

	/**
	* 
	* @return
	* The version
	*/
	public String getVersion() {
	return version;
	}

	/**
	* 
	* @param version
	* The version
	*/
	public void setVersion(String version) {
	this.version = version;
	}

	public Oembed_ withVersion(String version) {
	this.version = version;
	return this;
	}

	/**
	* 
	* @return
	* The providerName
	*/
	public String getProviderName() {
	return providerName;
	}

	/**
	* 
	* @param providerName
	* The provider_name
	*/
	public void setProviderName(String providerName) {
	this.providerName = providerName;
	}

	public Oembed_ withProviderName(String providerName) {
	this.providerName = providerName;
	return this;
	}

	/**
	* 
	* @return
	* The thumbnailUrl
	*/
	public String getThumbnailUrl() {
	return thumbnailUrl;
	}

	/**
	* 
	* @param thumbnailUrl
	* The thumbnail_url
	*/
	public void setThumbnailUrl(String thumbnailUrl) {
	this.thumbnailUrl = thumbnailUrl;
	}

	public Oembed_ withThumbnailUrl(String thumbnailUrl) {
	this.thumbnailUrl = thumbnailUrl;
	return this;
	}

	/**
	* 
	* @return
	* The thumbnailHeight
	*/
	public Integer getThumbnailHeight() {
	return thumbnailHeight;
	}

	/**
	* 
	* @param thumbnailHeight
	* The thumbnail_height
	*/
	public void setThumbnailHeight(Integer thumbnailHeight) {
	this.thumbnailHeight = thumbnailHeight;
	}

	public Oembed_ withThumbnailHeight(Integer thumbnailHeight) {
	this.thumbnailHeight = thumbnailHeight;
	return this;
	}

	/**
	* 
	* @return
	* The authorUrl
	*/
	public String getAuthorUrl() {
	return authorUrl;
	}

	/**
	* 
	* @param authorUrl
	* The author_url
	*/
	public void setAuthorUrl(String authorUrl) {
	this.authorUrl = authorUrl;
	}

	public Oembed_ withAuthorUrl(String authorUrl) {
	this.authorUrl = authorUrl;
	return this;
	}

	
}
