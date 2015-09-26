package app.iReadit.data.TopicsJSON;

import java.util.ArrayList;
import java.util.List;

//import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Topic {


@Expose
private String domain;
@SerializedName("banned_by")
@Expose
private Object bannedBy;
@SerializedName("media_embed")
@Expose
private MediaEmbed mediaEmbed;
@Expose
private String subreddit;
@SerializedName("selftext_html")
@Expose
private Object selftextHtml;
@Expose
private String selftext;
@Expose
private Object likes;
@SerializedName("user_reports")
@Expose
private List<Object> userReports = new ArrayList<Object>();
@SerializedName("secure_media")
@Expose
private SecureMedia secureMedia;
@SerializedName("link_flair_text")
@Expose
private String linkFlairText;
@Expose
private String id;
@Expose
private Integer gilded;
@SerializedName("secure_media_embed")
@Expose
private SecureMediaEmbed secureMediaEmbed;
@Expose
private Boolean clicked;
@SerializedName("report_reasons")
@Expose
private Object reportReasons;
@Expose
private String author;
@Expose
private Media media;
@Expose
private Integer score;
@SerializedName("approved_by")
@Expose
private Object approvedBy;
@SerializedName("over_18")
@Expose
private Boolean over18;
@Expose
private Boolean hidden;
@Expose
private String thumbnail;
@SerializedName("subreddit_id")
@Expose
private String subredditId;
@Expose
private String edited;
@SerializedName("link_flair_css_class")
@Expose
private String linkFlairCssClass;
@SerializedName("author_flair_css_class")
@Expose
private Object authorFlairCssClass;
@Expose
private Integer downs;
@SerializedName("mod_reports")
@Expose
private List<Object> modReports = new ArrayList<Object>();
@Expose
private Boolean saved;
@SerializedName("is_self")
@Expose
private Boolean isSelf;
@Expose
private String name;
@Expose
private String permalink;
@Expose
private Boolean stickied;
@Expose
private Integer created;
@Expose
private String url;
@SerializedName("author_flair_text")
@Expose
private Object authorFlairText;
@Expose
private String title;
@SerializedName("created_utc")
@Expose
private Integer createdUtc;
@Expose
private Integer ups;
@SerializedName("num_comments")
@Expose
private Integer numComments;
@Expose
private Boolean visited;
@SerializedName("num_reports")
@Expose
private Object numReports;
@Expose
private Object distinguished;

/**
* 
* @return
* The domain
*/
public String getDomain() {
return domain;
}

/**
* 
* @param domain
* The domain
*/
public void setDomain(String domain) {
this.domain = domain;
}

public Topic withDomain(String domain) {
this.domain = domain;
return this;
}

/**
* 
* @return
* The bannedBy
*/
public Object getBannedBy() {
return bannedBy;
}

/**
* 
* @param bannedBy
* The banned_by
*/
public void setBannedBy(Object bannedBy) {
this.bannedBy = bannedBy;
}

public Topic withBannedBy(Object bannedBy) {
this.bannedBy = bannedBy;
return this;
}

/**
* 
* @return
* The mediaEmbed
*/
public MediaEmbed getMediaEmbed() {
return mediaEmbed;
}

/**
* 
* @param mediaEmbed
* The media_embed
*/
public void setMediaEmbed(MediaEmbed mediaEmbed) {
this.mediaEmbed = mediaEmbed;
}

public Topic withMediaEmbed(MediaEmbed mediaEmbed) {
this.mediaEmbed = mediaEmbed;
return this;
}

/**
* 
* @return
* The subreddit
*/
public String getSubreddit() {
return subreddit;
}

/**
* 
* @param subreddit
* The subreddit
*/
public void setSubreddit(String subreddit) {
this.subreddit = subreddit;
}

public Topic withSubreddit(String subreddit) {
this.subreddit = subreddit;
return this;
}

/**
* 
* @return
* The selftextHtml
*/
public Object getSelftextHtml() {
return selftextHtml;
}

/**
* 
* @param selftextHtml
* The selftext_html
*/
public void setSelftextHtml(Object selftextHtml) {
this.selftextHtml = selftextHtml;
}

public Topic withSelftextHtml(Object selftextHtml) {
this.selftextHtml = selftextHtml;
return this;
}

/**
* 
* @return
* The selftext
*/
public String getSelftext() {
return selftext;
}

/**
* 
* @param selftext
* The selftext
*/
public void setSelftext(String selftext) {
this.selftext = selftext;
}

public Topic withSelftext(String selftext) {
this.selftext = selftext;
return this;
}

/**
* 
* @return
* The likes
*/
public Object getLikes() {
return likes;
}

/**
* 
* @param likes
* The likes
*/
public void setLikes(Object likes) {
this.likes = likes;
}

public Topic withLikes(Object likes) {
this.likes = likes;
return this;
}

/**
* 
* @return
* The userReports
*/
public List<Object> getUserReports() {
return userReports;
}

/**
* 
* @param userReports
* The user_reports
*/
public void setUserReports(List<Object> userReports) {
this.userReports = userReports;
}

public Topic withUserReports(List<Object> userReports) {
this.userReports = userReports;
return this;
}

/**
* 
* @return
* The secureMedia
*/
public SecureMedia getSecureMedia() {
return secureMedia;
}

/**
* 
* @param secureMedia
* The secure_media
*/
public void setSecureMedia(SecureMedia secureMedia) {
this.secureMedia = secureMedia;
}

public Topic withSecureMedia(SecureMedia secureMedia) {
this.secureMedia = secureMedia;
return this;
}

/**
* 
* @return
* The linkFlairText
*/
public String getLinkFlairText() {
return linkFlairText;
}

/**
* 
* @param linkFlairText
* The link_flair_text
*/
public void setLinkFlairText(String linkFlairText) {
this.linkFlairText = linkFlairText;
}

public Topic withLinkFlairText(String linkFlairText) {
this.linkFlairText = linkFlairText;
return this;
}

/**
* 
* @return
* The id
*/
public String getId() {
return id;
}

/**
* 
* @param id
* The id
*/
public void setId(String id) {
this.id = id;
}

public Topic withId(String id) {
this.id = id;
return this;
}

/**
* 
* @return
* The gilded
*/
public Integer getGilded() {
return gilded;
}

/**
* 
* @param gilded
* The gilded
*/
public void setGilded(Integer gilded) {
this.gilded = gilded;
}

public Topic withGilded(Integer gilded) {
this.gilded = gilded;
return this;
}

/**
* 
* @return
* The secureMediaEmbed
*/
public SecureMediaEmbed getSecureMediaEmbed() {
return secureMediaEmbed;
}

/**
* 
* @param secureMediaEmbed
* The secure_media_embed
*/
public void setSecureMediaEmbed(SecureMediaEmbed secureMediaEmbed) {
this.secureMediaEmbed = secureMediaEmbed;
}

public Topic withSecureMediaEmbed(SecureMediaEmbed secureMediaEmbed) {
this.secureMediaEmbed = secureMediaEmbed;
return this;
}

/**
* 
* @return
* The clicked
*/
public Boolean getClicked() {
return clicked;
}

/**
* 
* @param clicked
* The clicked
*/
public void setClicked(Boolean clicked) {
this.clicked = clicked;
}

public Topic withClicked(Boolean clicked) {
this.clicked = clicked;
return this;
}

/**
* 
* @return
* The reportReasons
*/
public Object getReportReasons() {
return reportReasons;
}

/**
* 
* @param reportReasons
* The report_reasons
*/
public void setReportReasons(Object reportReasons) {
this.reportReasons = reportReasons;
}

public Topic withReportReasons(Object reportReasons) {
this.reportReasons = reportReasons;
return this;
}

/**
* 
* @return
* The author
*/
public String getAuthor() {
return author;
}

/**
* 
* @param author
* The author
*/
public void setAuthor(String author) {
this.author = author;
}

public Topic withAuthor(String author) {
this.author = author;
return this;
}

/**
* 
* @return
* The media
*/
public Media getMedia() {
return media;
}

/**
* 
* @param media
* The media
*/
public void setMedia(Media media) {
this.media = media;
}

public Topic withMedia(Media media) {
this.media = media;
return this;
}

/**
* 
* @return
* The score
*/
public Integer getScore() {
return score;
}

/**
* 
* @param score
* The score
*/
public void setScore(Integer score) {
this.score = score;
}

public Topic withScore(Integer score) {
this.score = score;
return this;
}

/**
* 
* @return
* The approvedBy
*/
public Object getApprovedBy() {
return approvedBy;
}

/**
* 
* @param approvedBy
* The approved_by
*/
public void setApprovedBy(Object approvedBy) {
this.approvedBy = approvedBy;
}

public Topic withApprovedBy(Object approvedBy) {
this.approvedBy = approvedBy;
return this;
}

/**
* 
* @return
* The over18
*/
public Boolean getOver18() {
return over18;
}

/**
* 
* @param over18
* The over_18
*/
public void setOver18(Boolean over18) {
this.over18 = over18;
}

public Topic withOver18(Boolean over18) {
this.over18 = over18;
return this;
}

/**
* 
* @return
* The hidden
*/
public Boolean getHidden() {
return hidden;
}

/**
* 
* @param hidden
* The hidden
*/
public void setHidden(Boolean hidden) {
this.hidden = hidden;
}

public Topic withHidden(Boolean hidden) {
this.hidden = hidden;
return this;
}

/**
* 
* @return
* The thumbnail
*/
public String getThumbnail() {
return thumbnail;
}

/**
* 
* @param thumbnail
* The thumbnail
*/
public void setThumbnail(String thumbnail) {
this.thumbnail = thumbnail;
}

public Topic withThumbnail(String thumbnail) {
this.thumbnail = thumbnail;
return this;
}

/**
* 
* @return
* The subredditId
*/
public String getSubredditId() {
return subredditId;
}

/**
* 
* @param subredditId
* The subreddit_id
*/
public void setSubredditId(String subredditId) {
this.subredditId = subredditId;
}

public Topic withSubredditId(String subredditId) {
this.subredditId = subredditId;
return this;
}

/**
* 
* @return
* The edited
*/
public String getEdited() {
	
	
return edited;
}

/**
* 
* @param edited
* The edited
*/
public void setEdited(String edited) {
	
	
	
this.edited = edited;
}

public Topic withEdited(String edited) {
this.edited = edited;
return this;
}

/**
* 
* @return
* The linkFlairCssClass
*/
public String getLinkFlairCssClass() {
return linkFlairCssClass;
}

/**
* 
* @param linkFlairCssClass
* The link_flair_css_class
*/
public void setLinkFlairCssClass(String linkFlairCssClass) {
this.linkFlairCssClass = linkFlairCssClass;
}

public Topic withLinkFlairCssClass(String linkFlairCssClass) {
this.linkFlairCssClass = linkFlairCssClass;
return this;
}

/**
* 
* @return
* The authorFlairCssClass
*/
public Object getAuthorFlairCssClass() {
return authorFlairCssClass;
}

/**
* 
* @param authorFlairCssClass
* The author_flair_css_class
*/
public void setAuthorFlairCssClass(Object authorFlairCssClass) {
this.authorFlairCssClass = authorFlairCssClass;
}

public Topic withAuthorFlairCssClass(Object authorFlairCssClass) {
this.authorFlairCssClass = authorFlairCssClass;
return this;
}

/**
* 
* @return
* The downs
*/
public Integer getDowns() {
return downs;
}

/**
* 
* @param downs
* The downs
*/
public void setDowns(Integer downs) {
this.downs = downs;
}

public Topic withDowns(Integer downs) {
this.downs = downs;
return this;
}

/**
* 
* @return
* The modReports
*/
public List<Object> getModReports() {
return modReports;
}

/**
* 
* @param modReports
* The mod_reports
*/
public void setModReports(List<Object> modReports) {
this.modReports = modReports;
}

public Topic withModReports(List<Object> modReports) {
this.modReports = modReports;
return this;
}

/**
* 
* @return
* The saved
*/
public Boolean getSaved() {
return saved;
}

/**
* 
* @param saved
* The saved
*/
public void setSaved(Boolean saved) {
this.saved = saved;
}

public Topic withSaved(Boolean saved) {
this.saved = saved;
return this;
}

/**
* 
* @return
* The isSelf
*/
public Boolean getIsSelf() {
return isSelf;
}

/**
* 
* @param isSelf
* The is_self
*/
public void setIsSelf(Boolean isSelf) {
this.isSelf = isSelf;
}

public Topic withIsSelf(Boolean isSelf) {
this.isSelf = isSelf;
return this;
}

/**
* 
* @return
* The name
*/
public String getName() {
return name;
}

/**
* 
* @param name
* The name
*/
public void setName(String name) {
this.name = name;
}

public Topic withName(String name) {
this.name = name;
return this;
}

/**
* 
* @return
* The permalink
*/
public String getPermalink() {
return permalink;
}

/**
* 
* @param permalink
* The permalink
*/
public void setPermalink(String permalink) {
this.permalink = permalink;
}

public Topic withPermalink(String permalink) {
this.permalink = permalink;
return this;
}

/**
* 
* @return
* The stickied
*/
public Boolean getStickied() {
return stickied;
}

/**
* 
* @param stickied
* The stickied
*/
public void setStickied(Boolean stickied) {
this.stickied = stickied;
}

public Topic withStickied(Boolean stickied) {
this.stickied = stickied;
return this;
}

/**
* 
* @return
* The created
*/
public Integer getCreated() {
return created;
}

/**
* 
* @param created
* The created
*/
public void setCreated(Integer created) {
this.created = created;
}

public Topic withCreated(Integer created) {
this.created = created;
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

public Topic withUrl(String url) {
this.url = url;
return this;
}

/**
* 
* @return
* The authorFlairText
*/
public Object getAuthorFlairText() {
return authorFlairText;
}

/**
* 
* @param authorFlairText
* The author_flair_text
*/
public void setAuthorFlairText(Object authorFlairText) {
this.authorFlairText = authorFlairText;
}

public Topic withAuthorFlairText(Object authorFlairText) {
this.authorFlairText = authorFlairText;
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

public Topic withTitle(String title) {
this.title = title;
return this;
}

/**
* 
* @return
* The createdUtc
*/
public Integer getCreatedUtc() {
return createdUtc;
}

/**
* 
* @param createdUtc
* The created_utc
*/
public void setCreatedUtc(Integer createdUtc) {
this.createdUtc = createdUtc;
}

public Topic withCreatedUtc(Integer createdUtc) {
this.createdUtc = createdUtc;
return this;
}

/**
* 
* @return
* The ups
*/
public Integer getUps() {
return ups;
}

/**
* 
* @param ups
* The ups
*/
public void setUps(Integer ups) {
this.ups = ups;
}

public Topic withUps(Integer ups) {
this.ups = ups;
return this;
}

/**
* 
* @return
* The numComments
*/
public Integer getNumComments() {
return numComments;
}

/**
* 
* @param numComments
* The num_comments
*/
public void setNumComments(Integer numComments) {
this.numComments = numComments;
}

public Topic withNumComments(Integer numComments) {
this.numComments = numComments;
return this;
}

/**
* 
* @return
* The visited
*/
public Boolean getVisited() {
return visited;
}

/**
* 
* @param visited
* The visited
*/
public void setVisited(Boolean visited) {
this.visited = visited;
}

public Topic withVisited(Boolean visited) {
this.visited = visited;
return this;
}

/**
* 
* @return
* The numReports
*/
public Object getNumReports() {
return numReports;
}

/**
* 
* @param numReports
* The num_reports
*/
public void setNumReports(Object numReports) {
this.numReports = numReports;
}

public Topic withNumReports(Object numReports) {
this.numReports = numReports;
return this;
}

/**
* 
* @return
* The distinguished
*/
public Object getDistinguished() {
return distinguished;
}

/**
* 
* @param distinguished
* The distinguished
*/
public void setDistinguished(Object distinguished) {
this.distinguished = distinguished;
}

public Topic withDistinguished(Object distinguished) {
this.distinguished = distinguished;
return this;
}
}
