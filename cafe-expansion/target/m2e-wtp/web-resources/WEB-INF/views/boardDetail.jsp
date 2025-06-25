<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
         "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.kakaopage.expansion.dao.EventMapper">

  <resultMap id="EventResult" type="com.kakaopage.expansion.vo.EventVO">
    <id     property="id"        column="ID"/>
    <result property="title"     column="TITLE"/>
    <result property="imageUrl"  column="IMAGE_URL"/>
    <result property="linkUrl"   column="LINK_URL"/>
    <result property="startDate" column="START_DATE"/>
    <result property="endDate"   column="END_DATE"/>
  </resultMap>

  <!-- 활성화된 이벤트 조회 -->
  <select id="selectActiveEvents" resultMap="EventResult">
    SELECT
      ID,
      TITLE,
      IMAGE_URL,
      LINK_URL,
      START_DATE,
      END_DATE
    FROM EVENT
    WHERE SYSDATE BETWEEN START_DATE AND END_DATE
    ORDER BY START_DATE
  </select>

  <!-- 단일 이벤트 조회 -->
  <select id="selectEventById" parameterType="long" resultMap="EventResult">
    SELECT
      ID,
      TITLE,
      IMAGE_URL,
      LINK_URL,
      START_DATE,
      END_DATE
    FROM EVENT
    WHERE ID = #{id}
  </select>

</mapper>
