/**
 * Copyright 2012 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.appengine.demos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Greeting")
public class Post1 {
	private long id;
	private String ownerKey;
	private Date postDate;
	private String content;
	private String internalContent;
	private String parentTaskKey;

	public Post1() {
	}

	public Post1(String ownerKey, String content) {
		setOwnerKey(ownerKey);
		setContent(content);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public String getOwnerKey() {
		return ownerKey;
	}

	public void setOwnerKey(String ownerKey) {
		this.ownerKey = ownerKey;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInternalContent() {
		return internalContent;
	}

	public void setInternalContent(String internalContent) {
		this.internalContent = internalContent;
	}

	public String getParentTaskKey() {
		return parentTaskKey;
	}

	public void setParentTaskKey(String parentTaskKey) {
		this.parentTaskKey = parentTaskKey;
	}

	public void setId(long id) {
		this.id = id;
	}

}
