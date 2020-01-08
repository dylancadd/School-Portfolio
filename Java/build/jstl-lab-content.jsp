<div id="content">
    <div class="box">
        <p>
          Hi, ${name}!
        </p>
        <ul>
            <c:forEach var="name" items="${myList}">
                <li>${name}</li>
            </c:forEach>
        </ul>
    </div>
</div>
