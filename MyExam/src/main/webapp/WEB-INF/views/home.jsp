<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>views/home.jsp</title>
</head>
<body>
	<h3>인덱스 페이지 입니다.</h3>
	<c:choose>
		<c:when test="${empty id }">
			<div>
				<a href="users/signinform.do?uri=${pageContext.request.contextPath }">로그인</a>
				<a href="users/signupform.do">회원가입</a>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				<strong><a href="users/private/info.do">${id }</a></strong>님 로그인중
				<a href="users/signout.do">로그아웃</a>
			</div>
		</c:otherwise>
	</c:choose>
	<ul>
		<li><a href="cafe/list.do">카페 글 목록 보기</a></li>
	</ul>
	<h3>공지사항 입니다.</h3>
	<ol>
	<c:forEach var="tmp" items="${list }">
		<li>${tmp }</li>
	</c:forEach>
	</ol>
</body>
</html>