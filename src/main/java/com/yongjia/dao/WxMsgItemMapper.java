package com.yongjia.dao;

import java.util.List;

import com.yongjia.model.WxMsgItem;

public interface WxMsgItemMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_msg_item
	 * @mbggenerated  Tue Jul 07 14:25:04 CST 2015
	 */
    Long deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_msg_item
	 * @mbggenerated  Tue Jul 07 14:25:04 CST 2015
	 */
    Long insert(WxMsgItem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_msg_item
	 * @mbggenerated  Tue Jul 07 14:25:04 CST 2015
	 */
    Long insertSelective(WxMsgItem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_msg_item
	 * @mbggenerated  Tue Jul 07 14:25:04 CST 2015
	 */
	WxMsgItem selectByPrimaryKey(Long id);
	
	/**
	 * 
	 * @param msgId
	 * @return
	 */
	List<WxMsgItem> selectByWxMsgId(Long wxMsgId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_msg_item
	 * @mbggenerated  Tue Jul 07 14:25:04 CST 2015
	 */
	Long updateByPrimaryKeySelective(WxMsgItem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_msg_item
	 * @mbggenerated  Tue Jul 07 14:25:04 CST 2015
	 */
	Long updateByPrimaryKeyWithBLOBs(WxMsgItem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_msg_item
	 * @mbggenerated  Tue Jul 07 14:25:04 CST 2015
	 */
	Long updateByPrimaryKey(WxMsgItem record);
}