<#ftl encoding="utf-8">
<!DOCTYPE html>
<html>
    <head>
        <style>
            #formToMod input
            {
                width: 40% !important;
            }
        </style>
    </head>
    <body>
        <#include "/navbar.ftl"/>
        <h2 class="w3-center w3-khaki w3-text-teal w3-padding" style="margin:0px !important;">glasses Admin Page</h2>
        <div class="w3-row w3-margin-top" >
            <#list glasses as glass>
                <div class="w3-col m3 l3 w3-padding">
                    <div class="w3-card-4">

                        <header class="w3-container w3-teal">
                            <h3>${glass.getMaterial()}</h3>
                        </header>
                        <div class="w3-container">
                            <p>${glass.getPrice()} &euro;</p>
                            <hr>
                            <img src="https://picsum.photos/200" height="200" class="w3-left w3-circle">
                            <p>${glass.getVolume()} ml Glass <br> color: ${glass.getColor()} <br> type: ${glass.getType()}</p>
                            <a href="glassadmin?cmd=update&id=${glass.getId()}"><button class="w3-button  w3-khaki">Modify</button></a>
                        </div>


                    </div>
                </div>
            </#list>

            <#if (glassToUpdate??)><!--?? significa diverso da null -->
                <div class="w3-card-4 w3-margin ">
                    <div class="w3-container">
                        <h2>glass to Update <a href="glassadmin?unupdate=true"><button class="w3-button  w3-khaki">X</button></a> </h2>
                    </div>
                    <form id="formToMod" class="w3-container" action="glassadmin" method="post">
                        <label>Material</label>
                        <input name="material" class="w3-input" type="text" value="${glassToUpdate.getMaterial()}" >
                        <label>Price</label>
                        <input name="price" class="w3-input" type="text" value="${glassToUpdate.getPrice()}" >
                        <label>Volume</label>
                        <input name="volume" class="w3-input" type="number" value="${glassToUpdate.getVolume()}" >
                        <label>Type</label>
                        <input name="type" class="w3-input" type="text" value="${glassToUpdate.getType()}" >
                        <label>Color</label>
                        <input name="color" class="w3-input" type="text" value="${glassToUpdate.getColor()}" >
                        <br/>
                        <input class="w3-button w3-teal w3-margin"  type="submit" value="Update"/>
                        <input type="hidden" name="id" value="${glassToUpdate.getId()}" />
                    </form>
                </div>
            </#if>
        </div>
    </body>
</html>