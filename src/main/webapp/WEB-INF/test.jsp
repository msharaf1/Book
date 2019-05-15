<div class="container">
        <h1>All Posted Ideas</h1>


        <table>
            <thead>
            <tr>
                <th>New Idea</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td><c:out value="${post.postName}"/></td>

                    <td> 
                        <form Action="/posts/${post.id}" method="POST">
                            <input type="hidden" name="_method" value="delete">
                            <input type="submit" value="Delete"/>
                            <%-- <button type="submit">Delete </button> --%>
                        </form>
                        <a href="/posts/${post.id}">Show ||</a>
                        <a href="/posts/${post.id}/edit">Edit</a> 
                        <%-- <a href="/posts/${post.id}"><button>Show</buttn> </a>
                        <a href="/posts/${post.id}/edit"><button>Edit</button></a>  --%>
                    </td>
                    </tr>
            </c:forEach>

            </tbody>
        </table>
        <a href="/posts/new"><button>New Idea </button></a>
    </div>