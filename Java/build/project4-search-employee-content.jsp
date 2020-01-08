<div id="content">
    <div class="box">

    <form action="/java112/perform-search" method="get">
        <div class="formcontainer">
            <div class="container">
                <label for="searchTerm"><strong>Search Term</strong></label>
                <input type="text" name="searchTerm" required />

                <label for="searchType"><strong>Search Type:</strong></label>
                <select name="searchType">
                  <option value="id">Employee ID</option>
                  <option value="firstName">First Name</option>
                  <option value="lastName">Last Name</option>
                </select>
             </div>

             <button type="submit"><strong>SEARCH EMPLOYEE</strong></button><br>

        </div>
     </form>
    </div>
</div>
