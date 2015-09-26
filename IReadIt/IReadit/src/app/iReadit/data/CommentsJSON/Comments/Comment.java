package app.iReadit.data.CommentsJSON.Comments;

import java.util.ArrayList;
import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Comment {

@SerializedName("subreddit_id")
@Expose
private String subredditId;
@SerializedName("banned_by")
@Expose
private Object bannedBy;
@SerializedName("link_id")
@Expose
private String linkId;
@Expose
private Object likes;
@Expose
private CommentsJSON replies;
@SerializedName("user_reports")
@Expose
private List<Object> userReports = new ArrayList<Object>();
@Expose
private boolean saved;
@Expose
private String id;
@Expose
private int gilded;
@SerializedName("report_reasons")
@Expose
private Object reportReasons;
@Expose
private String author;
@SerializedName("parent_id")
@Expose
private String parentId;
@Expose
private int score;
@SerializedName("approved_by")
@Expose
private Object approvedBy;
@Expose
private int controversiality;
@Expose
private String body;
@Expose
private String edited;
@SerializedName("author_flair_css_class")
@Expose
private String authorFlairCssClass;
@Expose
private int downs;
@SerializedName("body_html")
@Expose
private String bodyHtml;
@Expose
private String subreddit;
@SerializedName("score_hidden")
@Expose
private boolean scoreHidden;
@Expose
private String name;
@Expose
private double created;
@SerializedName("author_flair_text")
@Expose
private String authorFlairText;
@SerializedName("created_utc")
@Expose
private double createdUtc;
@Expose
private int ups;
@SerializedName("mod_reports")
@Expose
private List<Object> modReports = new ArrayList<Object>();
@SerializedName("num_reports")
@Expose
private Object numReports;
@Expose
private Object distinguished;

private int indentation;

public int getIndentation() {
	return indentation;
}

public void setIndentation(int indentation) {
	this.indentation = indentation;
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

/**
* 
* @return
* The linkId
*/
public String getLinkId() {
return linkId;
}

/**
* 
* @param linkId
* The link_id
*/
public void setLinkId(String linkId) {
this.linkId = linkId;
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

/**
* 
* @return
* The replies
*/
//Will this work?
public CommentsJSON getReplies() {
return replies;
}

/**
* 
* @param <T>
 * @param <T>
 * @param replies
* The replies
*/
public void setReplies(CommentsJSON replies) {
	
	//replies could be null or empty

	this.replies = replies;
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

/**
* 
* @return
* The saved
*/
public boolean isSaved() {
return saved;
}

/**
* 
* @param saved
* The saved
*/
public void setSaved(boolean saved) {
this.saved = saved;
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

/**
* 
* @return
* The gilded
*/
public int getGilded() {
return gilded;
}

/**
* 
* @param gilded
* The gilded
*/
public void setGilded(int gilded) {
this.gilded = gilded;
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

/**
* 
* @return
* The parentId
*/
public String getParentId() {
return parentId;
}

/**
* 
* @param parentId
* The parent_id
*/
public void setParentId(String parentId) {
this.parentId = parentId;
}

/**
* 
* @return
* The score
*/
public int getScore() {
return score;
}

/**
* 
* @param score
* The score
*/
public void setScore(int score) {
this.score = score;
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

/**
* 
* @return
* The controversiality
*/
public int getControversiality() {
return controversiality;
}

/**
* 
* @param controversiality
* The controversiality
*/
public void setControversiality(int controversiality) {
this.controversiality = controversiality;
}

/**
* 
* @return
* The body
*/
public String getBody() {
return body;
}

/**
* 
* @param body
* The body
*/
public void setBody(String body) {
this.body = body;
}

/**
* 
* @return
* The edited
*/
public String isEdited() {
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

/**
* 
* @return
* The authorFlairCssClass
*/
public String getAuthorFlairCssClass() {
return authorFlairCssClass;
}

/**
* 
* @param authorFlairCssClass
* The author_flair_css_class
*/
public void setAuthorFlairCssClass(String authorFlairCssClass) {
this.authorFlairCssClass = authorFlairCssClass;
}

/**
* 
* @return
* The downs
*/
public int getDowns() {
return downs;
}

/**
* 
* @param downs
* The downs
*/
public void setDowns(int downs) {
this.downs = downs;
}

/**
* 
* @return
* The bodyHtml
*/
public String getBodyHtml() {
return bodyHtml;
}

/**
* 
* @param bodyHtml
* The body_html
*/
public void setBodyHtml(String bodyHtml) {
this.bodyHtml = bodyHtml;
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

/**
* 
* @return
* The scoreHidden
*/
public boolean isScoreHidden() {
return scoreHidden;
}

/**
* 
* @param scoreHidden
* The score_hidden
*/
public void setScoreHidden(boolean scoreHidden) {
this.scoreHidden = scoreHidden;
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

/**
* 
* @return
* The created
*/
public double getCreated() {
return created;
}

/**
* 
* @param created
* The created
*/
public void setCreated(double created) {
this.created = created;
}

/**
* 
* @return
* The authorFlairText
*/
public String getAuthorFlairText() {
return authorFlairText;
}

/**
* 
* @param authorFlairText
* The author_flair_text
*/
public void setAuthorFlairText(String authorFlairText) {
this.authorFlairText = authorFlairText;
}

/**
* 
* @return
* The createdUtc
*/
public double getCreatedUtc() {
return createdUtc;
}

/**
* 
* @param createdUtc
* The created_utc
*/
public void setCreatedUtc(double createdUtc) {
this.createdUtc = createdUtc;
}

/**
* 
* @return
* The ups
*/
public int getUps() {
return ups;
}

/**
* 
* @param ups
* The ups
*/
public void setUps(int ups) {
this.ups = ups;
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

}
