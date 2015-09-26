package app.iReadit.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import app.iReadit.data.CommentsJSON.Comments.Comment;
import app.iReadit.data.CommentsJSON.Comments.CommentsJSON;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommentDeserializer implements JsonDeserializer<Comment> {

		  @Override
		  public Comment deserialize(JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
		      throws JsonParseException {
				Log.d(this.getClass().toString(), "TESTING");
			  final JsonObject jsonObject = json.getAsJsonObject();
			  final CommentsJSON replies;
			  //TODO: Code for too many replies such that it's given a link
			  if ( (jsonObject.get("replies") != null) && !(jsonObject.get("replies").toString().equals("\"\"")) )
			  {
			  Log.d(this.getClass().toString(), jsonObject.get("author").getAsString());
			  Log.d(this.getClass().toString(), jsonObject.get("body").getAsString());
				  replies = context.deserialize(jsonObject.get("replies"), CommentsJSON.class);
				  
			  } else {
				  Log.e("CommentDeserializer", "Error Deserializing Replies");

				  replies = null; //TODO: tidy type
			  }
			  

			  
			  final String body = jsonObject.get("body").getAsString();
			  final String author = jsonObject.get("author").getAsString();
			  final int score = jsonObject.get("score").getAsInt();
			  final double created = jsonObject.get("created").getAsDouble();
			  final String bodyHTML = jsonObject.get("body_html").getAsString();
			  
			  Comment comment = new Comment();
			  comment.setReplies(replies);
			  comment.setBody(body);
			  comment.setAuthor(author);
			  comment.setScore(score);
			  comment.setCreated(created);
			  comment.setBodyHtml(bodyHTML);
			  
			  return comment;

		  }

}

