<#ftl encoding="utf-8">
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <#include "/navbar.ftl"/>
        <h2 class="w3-margin">Insert Admin password</h2>
        <form action="glassadmin" method="get">
            <input class="w3-input w3-margin" name="password" type="password" placeholder="Password"/>
            <input class="w3-button w3-teal w3-margin"  type="submit" value="Login"/>
        </form>

        <#if (wrongPass)>
            <div class="w3-panel w3-red">
                <p>Wrong password. Please insert the correct one</p>
            </div> 
        </#if>
    </body>
</html>