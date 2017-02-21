-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: sportstory
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `d_dictionary`
--

DROP TABLE IF EXISTS `d_dictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `d_dictionary` (
  `dictionaryId` int(11) NOT NULL AUTO_INCREMENT,
  `dicType` int(11) NOT NULL COMMENT '字典类型\n0：运动类型字典',
  `name` varchar(45) NOT NULL COMMENT '某类型下，字典对应的中文表示',
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`dictionaryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `d_dictionary`
--

LOCK TABLES `d_dictionary` WRITE;
/*!40000 ALTER TABLE `d_dictionary` DISABLE KEYS */;
/*!40000 ALTER TABLE `d_dictionary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_user_activity`
--

DROP TABLE IF EXISTS `r_user_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_user_activity` (
  `userActivityId` int(11) NOT NULL AUTO_INCREMENT,
  `activityId` int(11) NOT NULL COMMENT '活动ID',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `tradeId` int(11) NOT NULL COMMENT '交易ID',
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`userActivityId`),
  KEY `FK_userActivityActivityId_idx` (`activityId`),
  KEY `FK_userActivityUserId_idx` (`userId`),
  CONSTRAINT `FK_userActivityActivityId` FOREIGN KEY (`activityId`) REFERENCES `t_activity` (`activityId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_userActivityUserId` FOREIGN KEY (`userId`) REFERENCES `t_user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户参加活动';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_user_activity`
--

LOCK TABLES `r_user_activity` WRITE;
/*!40000 ALTER TABLE `r_user_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_user_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_user_sporttype`
--

DROP TABLE IF EXISTS `r_user_sporttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_user_sporttype` (
  `userSportTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `dictionaryId` int(11) NOT NULL COMMENT '字典表中对应Id',
  `name` varchar(45) NOT NULL COMMENT '字典表中对应名称',
  `sportLevel` int(11) NOT NULL COMMENT '运动等级\n1：一级\n2：二级\n3：三级',
  `creatTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`userSportTypeId`),
  KEY `FK_userSportTypeUserId_idx` (`userId`),
  KEY `FK_userSportTypeDicionaryId_idx` (`dictionaryId`),
  CONSTRAINT `FK_userSportTypeDicionaryId` FOREIGN KEY (`dictionaryId`) REFERENCES `d_dictionary` (`dictionaryId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_userSportTypeUserId` FOREIGN KEY (`userId`) REFERENCES `t_user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和运动类型字典关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_user_sporttype`
--

LOCK TABLES `r_user_sporttype` WRITE;
/*!40000 ALTER TABLE `r_user_sporttype` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_user_sporttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_user_video`
--

DROP TABLE IF EXISTS `r_user_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_user_video` (
  `userVideoId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `videoId` int(11) NOT NULL COMMENT '视频ID',
  `tradeId` int(11) NOT NULL COMMENT '交易ID',
  `state` int(11) NOT NULL COMMENT '用户对视频的状态\n0：没有支付\n1：支付中\n2：支付完成',
  `score` int(11) NOT NULL COMMENT '阅览后，评分',
  `comment` varchar(100) NOT NULL COMMENT '阅览后，评价',
  `viewTimes` int(11) NOT NULL COMMENT '阅览次数',
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`userVideoId`),
  KEY `FK_userVideoUserId_idx` (`userId`),
  KEY `FK_userVideoVideoId_idx` (`videoId`),
  CONSTRAINT `FK_userVideoUserId` FOREIGN KEY (`userId`) REFERENCES `t_user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_userVideoVideoId` FOREIGN KEY (`videoId`) REFERENCES `t_video` (`videoId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与别人视频的关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_user_video`
--

LOCK TABLES `r_user_video` WRITE;
/*!40000 ALTER TABLE `r_user_video` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_user_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_ability`
--

DROP TABLE IF EXISTS `t_ability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_ability` (
  `abilityId` int(11) NOT NULL AUTO_INCREMENT,
  `commentUserId` int(11) NOT NULL COMMENT '评价者',
  `commentedUserId` int(11) NOT NULL COMMENT '被评价人',
  `activityId` int(11) NOT NULL COMMENT '活动ID',
  `scoreInDetail` json NOT NULL COMMENT '根据不同的sportType,评分细则不同',
  `sportTypeId` int(11) DEFAULT NULL,
  `sportTypeName` varchar(45) NOT NULL COMMENT '运动类型',
  `comment` varchar(100) NOT NULL COMMENT '评论',
  `createTime` datetime NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`abilityId`),
  KEY `FK_abilityCommentUserId_idx` (`commentUserId`),
  KEY `FK_abilityCommentedUserId_idx` (`commentedUserId`),
  KEY `FK_abilityActivityID_idx` (`activityId`),
  CONSTRAINT `FK_abilityActivityID` FOREIGN KEY (`activityId`) REFERENCES `t_activity` (`activityId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_abilityCommentUserId` FOREIGN KEY (`commentUserId`) REFERENCES `t_user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_abilityCommentedUserId` FOREIGN KEY (`commentedUserId`) REFERENCES `t_user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户能力评分信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_ability`
--

LOCK TABLES `t_ability` WRITE;
/*!40000 ALTER TABLE `t_ability` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_ability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_activity`
--

DROP TABLE IF EXISTS `t_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_activity` (
  `activityId` int(11) NOT NULL AUTO_INCREMENT,
  `createrId` int(11) NOT NULL COMMENT '创建者ID',
  `sportTypeName` varchar(45) NOT NULL COMMENT '运动类型',
  `sportTypeId` int(11) NOT NULL,
  `activityDate` date NOT NULL COMMENT '活动日期',
  `startTime` datetime NOT NULL COMMENT '开始时间',
  `endTime` datetime NOT NULL COMMENT '结束时间',
  `address` varchar(45) NOT NULL COMMENT '活动地点',
  `memberNum` int(11) NOT NULL COMMENT '活动人数',
  `activityState` int(11) NOT NULL COMMENT '活动状态\n0：未开始\n1：已开始\n2：结束\n3：取消',
  `sportLevel` int(11) NOT NULL COMMENT '活动等级',
  `chargeType` int(11) NOT NULL COMMENT '收费类型\n0：女生免费\n1：自费',
  `teamNature` int(11) NOT NULL COMMENT '组队类型\n0：随便玩玩\n1：专业级别',
  `activityNature` int(11) NOT NULL COMMENT '活动性质',
  `joinedNum` int(11) NOT NULL DEFAULT '0' COMMENT '报名人数',
  `price` decimal(10,0) NOT NULL COMMENT '活动单人价格',
  `groupChatId` int(11) NOT NULL COMMENT '群聊ID',
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`activityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_activity`
--

LOCK TABLES `t_activity` WRITE;
/*!40000 ALTER TABLE `t_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_chat`
--

DROP TABLE IF EXISTS `t_chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_chat` (
  `chatId` int(11) NOT NULL AUTO_INCREMENT,
  `senderId` int(11) NOT NULL COMMENT '发送者ID',
  `receiverId` int(11) NOT NULL COMMENT '接受者ID',
  `chatType` int(11) NOT NULL COMMENT '消息类型\n0：文字\n1：图片\n2：文件\n3：语音',
  `content` varchar(45) NOT NULL COMMENT '内容',
  `chatState` int(11) NOT NULL DEFAULT '0' COMMENT '消息状态\n0：正常\n1：撤销',
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`chatId`),
  KEY `FK_chatSenderId_idx` (`senderId`),
  KEY `FK_chatReceiverId_idx` (`receiverId`),
  CONSTRAINT `FK_chatReceiverId` FOREIGN KEY (`receiverId`) REFERENCES `t_user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_chatSenderId` FOREIGN KEY (`senderId`) REFERENCES `t_user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='聊天内容表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_chat`
--

LOCK TABLES `t_chat` WRITE;
/*!40000 ALTER TABLE `t_chat` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_feed`
--

DROP TABLE IF EXISTS `t_feed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_feed` (
  `feedId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '动态产生者',
  `feeType` int(11) NOT NULL COMMENT '动态类型\n如果是活动类型的动态，需要填活动ID，和活动的状态\n0：活动动态',
  `jsonContent` json NOT NULL COMMENT '将动态的内容存储为Json',
  `activityId` int(11) NOT NULL COMMENT '如果Type为活动，则填写',
  `feedState` int(11) NOT NULL DEFAULT '0' COMMENT '如果Type为活动，则填写\n0：创建\n1：取消\n2：修改',
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`feedId`),
  KEY `FK_feedUid_idx` (`userId`),
  CONSTRAINT `FK_feedUid` FOREIGN KEY (`userId`) REFERENCES `t_user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='动态信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_feed`
--

LOCK TABLES `t_feed` WRITE;
/*!40000 ALTER TABLE `t_feed` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_feed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_follow`
--

DROP TABLE IF EXISTS `t_follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_follow` (
  `followId` int(11) NOT NULL AUTO_INCREMENT,
  `userFromId` int(11) NOT NULL COMMENT '发起关注的用户',
  `userToId` int(11) NOT NULL COMMENT '被关注的用户',
  `followState` int(11) NOT NULL DEFAULT '0' COMMENT '关注状态\n0：关注\n1：取消关注',
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`followId`),
  KEY `FK_followUserFromId_idx` (`userFromId`),
  KEY `FK_followUserToId_idx` (`userToId`),
  CONSTRAINT `FK_followUserFromId` FOREIGN KEY (`userFromId`) REFERENCES `t_user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_followUserToId` FOREIGN KEY (`userToId`) REFERENCES `t_user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关注表。对于From用户是“关注”，对于To用户是“粉丝”';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_follow`
--

LOCK TABLES `t_follow` WRITE;
/*!40000 ALTER TABLE `t_follow` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_follow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_groupchat`
--

DROP TABLE IF EXISTS `t_groupchat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_groupchat` (
  `groupChatInfoId` int(11) NOT NULL AUTO_INCREMENT,
  `leaderId` int(11) NOT NULL COMMENT '群主ID',
  `chatType` int(11) NOT NULL COMMENT '群类型\n0：活动群\n1：用户群',
  `state` int(11) NOT NULL DEFAULT '0' COMMENT '群生存状态\n0：正常\n1：过期\n2：删除',
  `activityId` int(11) NOT NULL COMMENT '如果type=0,为活动群,则需要添加activityID',
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`groupChatInfoId`),
  KEY `FK_groupChatInfoLeaderId_idx` (`leaderId`),
  KEY `FK_groupChatInfoActivityId_idx` (`activityId`),
  CONSTRAINT `FK_groupChatInfoActivityId` FOREIGN KEY (`activityId`) REFERENCES `t_activity` (`activityId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_groupChatInfoLeaderId` FOREIGN KEY (`leaderId`) REFERENCES `t_user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群聊，创建活动后，默认插入一个群聊';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_groupchat`
--

LOCK TABLES `t_groupchat` WRITE;
/*!40000 ALTER TABLE `t_groupchat` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_groupchat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_groupchat_info`
--

DROP TABLE IF EXISTS `t_groupchat_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_groupchat_info` (
  `groupChatId` int(11) NOT NULL AUTO_INCREMENT,
  `gourpChatInfoId` int(11) NOT NULL COMMENT '群聊ID',
  `senderId` int(11) NOT NULL COMMENT '发送者',
  `content` varchar(256) NOT NULL COMMENT '内容',
  `chatType` int(11) NOT NULL COMMENT '消息类型\n0：文字\n1：图片\n2：文件\n3：语音',
  `chatState` int(11) NOT NULL COMMENT '消息状态\n0：正常\n1：撤销',
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`groupChatId`),
  KEY `FK_groupChatSenderId_idx` (`senderId`),
  KEY `FK_groupChatGroupChatInfoIs_idx` (`gourpChatInfoId`),
  CONSTRAINT `FK_groupChatGroupChatInfoIs` FOREIGN KEY (`gourpChatInfoId`) REFERENCES `t_groupchat` (`groupChatInfoId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_groupChatSenderId` FOREIGN KEY (`senderId`) REFERENCES `t_user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群聊消息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_groupchat_info`
--

LOCK TABLES `t_groupchat_info` WRITE;
/*!40000 ALTER TABLE `t_groupchat_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_groupchat_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_notice`
--

DROP TABLE IF EXISTS `t_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_notice` (
  `noticeId` int(11) NOT NULL AUTO_INCREMENT,
  `senderId` int(11) NOT NULL COMMENT '发送通知的用户\n0：系统\n其他值：为用户产生的消息，接收方从t_follow表中得到\n此表信息一般用作Push\n由于系统的引入，不用senderId做外键',
  `noticeType` int(11) NOT NULL COMMENT '通知类型\n0：系统通知\n',
  `jsonContent` json NOT NULL COMMENT '有些通知涉及到具体的数据信息，封装成Json',
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`noticeId`),
  KEY `FK_noticeSenderId_idx` (`senderId`),
  CONSTRAINT `FK_noticeSenderId` FOREIGN KEY (`senderId`) REFERENCES `t_user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通知';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_notice`
--

LOCK TABLES `t_notice` WRITE;
/*!40000 ALTER TABLE `t_notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_trade`
--

DROP TABLE IF EXISTS `t_trade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_trade` (
  `tradeId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '交易用户ID',
  `price` decimal(10,0) DEFAULT NULL COMMENT '交易金额',
  `tradeType` int(11) DEFAULT NULL COMMENT '交易类型\n0：买视频\n1：参加活动',
  `content` json DEFAULT NULL COMMENT '根据type的不同，json内容类型不同',
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`tradeId`),
  KEY `FK_tradeUserId_idx` (`userId`),
  CONSTRAINT `FK_tradeUserId` FOREIGN KEY (`userId`) REFERENCES `t_user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_trade`
--

LOCK TABLES `t_trade` WRITE;
/*!40000 ALTER TABLE `t_trade` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_trade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID（唯一）',
  `phone` varchar(45) NOT NULL COMMENT '手机号',
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL COMMENT '用户名',
  `nickname` varchar(45) NOT NULL COMMENT '昵称',
  `email` varchar(45) NOT NULL COMMENT '绑定的邮箱',
  `headImageUrl` varchar(256) NOT NULL DEFAULT 'http://7u2ouq.com2.z0.glb.qiniucdn.com/headimage.png' COMMENT '头像URL',
  `backgourdUrl` varchar(256) NOT NULL DEFAULT 'http://7u2r5d.com2.z0.glb.qiniucdn.com/background1.jpg' COMMENT '背景图片URL',
  `gender` int(11) NOT NULL DEFAULT '0' COMMENT '性别\n0：男\n1：女',
  `birthday` date NOT NULL COMMENT '出生日期',
  `stature` int(11) NOT NULL COMMENT '身高（厘米，整数）',
  `weight` int(11) NOT NULL COMMENT '体重（斤，整数）',
  `province` varchar(45) NOT NULL COMMENT '省',
  `city` varchar(45) NOT NULL COMMENT '市',
  `district` varchar(45) NOT NULL COMMENT '区',
  `address` varchar(45) NOT NULL COMMENT '详细地址',
  `assignment` varchar(45) NOT NULL COMMENT '用户签名',
  `userGroup` varchar(45) NOT NULL DEFAULT '0' COMMENT '用户分组（方便用户管理，用户分级等等）\n0：初级用户',
  `wallet` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '钱包余额',
  `isForbiden` int(11) NOT NULL DEFAULT '0' COMMENT '是否被禁止（用户可能被举报，核实后，可以禁止用户）\n0：没有被禁止\n1：禁止',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `uid_UNIQUE` (`uid`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户个人信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_video`
--

DROP TABLE IF EXISTS `t_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_video` (
  `videoId` int(11) NOT NULL AUTO_INCREMENT,
  `authorId` int(11) NOT NULL COMMENT '作者ID',
  `title` varchar(45) NOT NULL COMMENT '视频标题',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `screenshot` varchar(256) NOT NULL COMMENT '截图（做封面）',
  `stream` varchar(45) NOT NULL COMMENT '视频流',
  `viewed` int(11) NOT NULL COMMENT '阅览数',
  `price` decimal(10,0) NOT NULL COMMENT '定价',
  `finalScore` int(11) NOT NULL COMMENT '综合评分',
  `videoState` int(11) NOT NULL COMMENT '状态\n0：审核中\n1：审核通过\n2：删除',
  `creatTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`videoId`),
  KEY `FK_videoAuthorId_idx` (`authorId`),
  CONSTRAINT `FK_videoAuthorId` FOREIGN KEY (`authorId`) REFERENCES `t_user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='点播视频';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_video`
--

LOCK TABLES `t_video` WRITE;
/*!40000 ALTER TABLE `t_video` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `content` varchar(45) NOT NULL DEFAULT '中文测试',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='本表用于相关数据的测试，例如插入中文乱码等等';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,'数据库连接测试');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wp_test`
--

DROP TABLE IF EXISTS `wp_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wp_test` (
  `name` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wp_test`
--

LOCK TABLES `wp_test` WRITE;
/*!40000 ALTER TABLE `wp_test` DISABLE KEYS */;
INSERT INTO `wp_test` VALUES ('站牌',1),('测试',2),('无敌',3);
/*!40000 ALTER TABLE `wp_test` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-21 22:27:35
