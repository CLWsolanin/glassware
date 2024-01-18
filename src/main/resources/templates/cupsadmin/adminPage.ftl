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
        <h2 class="w3-center w3-khaki w3-text-teal w3-padding" style="margin:0px !important;">Cups Admin Page</h2>
        <div class="w3-row w3-margin-top" >
            <#list cups as cup>
                <div class="w3-col m3 l3 w3-padding">
                    <div class="w3-card-4">

                        <header class="w3-container w3-teal">
                            <h3>${cup.getMaterial()}</h3>
                        </header>
                        <div class="w3-container">
                            <p>${cup.getPrice()} &euro;</p>
                            <hr>
                            <img src="${cup.getImg_url()}" height="200" class="w3-left w3-circle">
                            <p>${cup.getVolume()} ml CUP ${cup.isHandle()?string("With Handle","Without Handle")}</p>
                            <a href="cupsadmin?cmd=update&id=${cup.getId()}"><button class="w3-button  w3-khaki">Modify</button></a>
                        </div>


                    </div>
                </div>
            </#list>

            <#if (cupToUpdate??)><!--?? significa diverso da null -->
                <div class="w3-card-4 w3-margin ">
                    <div class="w3-container">
                        <h2>Cup to Update</h2>
                    </div>
                    <form id="formToMod" class="w3-container" action="cupsadmin" method="post">
                        <label>Material</label>
                        <input name="material" class="w3-input" type="text" value="${cupToUpdate.getMaterial()}" >
                        <label>Price</label>
                        <input name="price" class="w3-input" type="text" value="${cupToUpdate.getPrice()}" >
                        <label>Volume</label>
                        <input name="volume" class="w3-input" type="number" value="${cupToUpdate.getVolume()}" >
                        <label>Image Url</label>
                        <input name="img_url" class="w3-input" type="text" value="${cupToUpdate.getImg_url()}" >
                        <input style="width:1% !important" name="handle" class="w3-check" type="checkbox" checked="${cupToUpdate.isHandle()?string('checked', '')}">
                        <label>Handle</label>
                        <br/>
                        <input class="w3-button w3-teal w3-margin"  type="submit" value="Update"/>
                    </form>
                </div>
            </#if>
        </div>
    </body>
</html>