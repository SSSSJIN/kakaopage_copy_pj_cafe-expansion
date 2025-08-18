<div class="bookshelf-container">
    <h2>내 책장</h2>
    <c:choose>
        <c:when test="${not empty bookList}">
            <c:forEach var="book" items="${bookList}">
                <div class="book-item">
                    <img src="${book.image}" alt="${book.title}" width="120px"/>
                    <div><b>${book.title}</b></div>
                    <div style="color: #9a8b66;">${book.author} | ${book.genre}</div>
                    <a href="${pageContext.request.contextPath}/detail?bookId=${book.id}" style="color:#b49561;">작품보기</a>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p>아직 본 책이 없습니다.</p>
        </c:otherwise>
    </c:choose>
</div>
