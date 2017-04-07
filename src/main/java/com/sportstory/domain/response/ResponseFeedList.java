package com.sportstory.domain.response;

import com.sportstory.domain.Feed;

public class ResponseFeedList extends AbstractResponse{
	String headImageUrl;//头像
	String nickname;
	Feed feed;//动态内容以json形式，映射不同的类
	int likeNum;//点赞数目
	int unlikeNum;//踩数目
	int commentNum;//评论数目
	public String getHeadImageUrl() {
		return headImageUrl;
	}
	public void setHeadImageUrl(String headImageUrl) {
		this.headImageUrl = headImageUrl;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Feed getFeed() {
		return feed;
	}
	public void setFeed(Feed feed) {
		this.feed = feed;
	}
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	public int getUnlikeNum() {
		return unlikeNum;
	}
	public void setUnlikeNum(int unlikeNum) {
		this.unlikeNum = unlikeNum;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
			
}
