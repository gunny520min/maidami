package com.yongjia.model;

public class MemberPoint {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_point.id
     *
     * @mbggenerated Tue Jul 07 14:25:04 CST 2015
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_point.member_id
     *
     * @mbggenerated Tue Jul 07 14:25:04 CST 2015
     */
    private Long memberId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_point.point_pool_id
     *
     * @mbggenerated Tue Jul 07 14:25:04 CST 2015
     */
    private Long pointPoolId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_point.point
     *
     * @mbggenerated Tue Jul 07 14:25:04 CST 2015
     */
    private Integer point;

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getPointPoolId() {
        return pointPoolId;
    }

    public void setPointPoolId(Long pointPoolId) {
        this.pointPoolId = pointPoolId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member_point.point
     *
     * @return the value of member_point.point
     *
     * @mbggenerated Tue Jul 07 14:25:04 CST 2015
     */
    public Integer getPoint() {
        return point;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member_point.point
     *
     * @param point the value for member_point.point
     *
     * @mbggenerated Tue Jul 07 14:25:04 CST 2015
     */
    public void setPoint(Integer point) {
        this.point = point;
    }
}