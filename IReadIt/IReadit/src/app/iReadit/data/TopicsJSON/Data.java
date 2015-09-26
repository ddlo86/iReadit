package app.iReadit.data.TopicsJSON;
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
		private String after;
		@Expose
		private String before;

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

		public Data withModhash(String modhash) {
		this.modhash = modhash;
		return this;
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

		public Data withChildren(List<Child> children) {
		this.children = children;
		return this;
		}

		/**
		* 
		* @return
		* The after
		*/
		public String getAfter() {
		return after;
		}

		/**
		* 
		* @param after
		* The after
		*/
		public void setAfter(String after) {
		this.after = after;
		}

		public Data withAfter(String after) {
		this.after = after;
		return this;
		}

		/**
		* 
		* @return
		* The before
		*/
		public String getBefore() {
		return before;
		}

		/**
		* 
		* @param before
		* The before
		*/
		public void setBefore(String before) {
		this.before = before;
		}

		public Data withBefore(String before) {
		this.before = before;
		return this;
		}
}
