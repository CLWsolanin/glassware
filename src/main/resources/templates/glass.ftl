<#ftl encoding="utf-8">
<!-- 
    Servlet che mi chiama: HomepageController
    attributi che mi passa: products, una lista di Glassware (sia tazze che bicchieri)
 -->
<!DOCTYPE html>
<html>
    <head>
        <title>Homepage</title>
    </head>
    <body>
        <#include "navbar.ftl"/>
        <h2 class="w3-center w3-khaki w3-text-teal w3-padding" style="margin:0px !important;">Our Glasses</h2>
        <div class="w3-row w3-margin-top" >
            <#list glasses as glass>
                <div class="w3-col m3 l3 w3-padding">
                    <div class="w3-card-4 w3-center ">

                        <header class="w3-container w3-teal">
                            <h1>${glass.getMaterial()}</h1>
                        </header>

                        <div class="w3-container">
                            <p>You can drink ${glass.getVolume()} ml of delicius bevarage from it</p>
                            <p>color: ${glass.getColor()}</p>
                            <p>type: ${glass.getType()}</p>
                        </div>

                        <footer class="w3-container w3-khaki">
                            <h5>Price: ${glass.getPrice()} &euro;</h5>
                        </footer>
                    </div>
                </div>
            </#list>
        </div>
    </body>
</html>