<#ftl encoding="utf-8">
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <style>
            
            /*TARGET CSS (su chi deve essere applicata la regola)*/
            .bloccoTesto /* . = classe HTML */
            {
                /*REGOLA CSS*/
                width: 35%;
                display:inline-block;
                padding:40px;
            }

            #primo /* # = id HTML */
            {
                background-color:yellow;
                margin-right:10%;
            }

            #secondo
            {
                background-color:blue;
            }

            input
            {
                width:50% !important;
            }
        </style>
    </head>
    <body style="font-family: Lucida Console, Courier New, monospace;">
        <!-- <h2 style="border-style: solid;display:inline-block;padding-left:20px;padding-right:20px;margin-left:20px;margin-right:20px">CIAO SONO UNA FRASE</h2>
        SECONDA FRASE <input id="" name="" type="" value=""/><input style="margin:20px" id="" name="" type="" value=""/><input id="" name="" type="" value=""/>-->
        <h1 style="text-align:center; color:green; font-family: Lucida Console, Courier New, monospace"> Titolo CSS colorato</h1>
        <p id="primo" class="w3-text-yellow bloccoTesto" style="text-shadow:1px 1px 0 #444">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc tristique nunc eget orci pulvinar faucibus. Vestibulum vitae nulla vel elit faucibus maximus convallis ac lorem. Nam a eros eleifend, condimentum purus non, elementum nulla. Integer blandit felis dui, quis pharetra eros bibendum eu. Pellentesque condimentum elit ac urna luctus suscipit. Praesent ac magna rhoncus, tempor dui tempor, semper urna. Aenean et libero hendrerit, rhoncus ligula blandit, lacinia sem. Suspendisse et nisi quis diam fringilla lobortis ultrices vitae elit. Sed ut est tristique, commodo augue vitae, sagittis libero. Aliquam euismod magna sapien, ut tincidunt orci ultricies a. Phasellus nec sodales nisl. Nulla suscipit libero at felis eleifend iaculis. Suspendisse maximus semper leo vel euismod. Donec sapien justo, dignissim a pretium ut, varius eu nulla.</p>
        <p id="secondo" class="bloccoTesto" >Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc tristique nunc eget orci pulvinar faucibus. Vestibulum vitae nulla vel elit faucibus maximus convallis ac lorem. Nam a eros eleifend, condimentum purus non, elementum nulla. Integer blandit felis dui, quis pharetra eros bibendum eu. Pellentesque condimentum elit ac urna luctus suscipit. Praesent ac magna rhoncus, tempor dui tempor, semper urna. Aenean et libero hendrerit, rhoncus ligula blandit, lacinia sem. Suspendisse et nisi quis diam fringilla lobortis ultrices vitae elit. Sed ut est tristique, commodo augue vitae, sagittis libero. Aliquam euismod magna sapien, ut tincidunt orci ultricies a. Phasellus nec sodales nisl. Nulla suscipit libero at felis eleifend iaculis. Suspendisse maximus semper leo vel euismod. Donec sapien justo, dignissim a pretium ut, varius eu nulla.</p>
        <input class="w3-input" id="" name="" type="" value="" placeholder = "input1" style="display:block"/>
        <input class="w3-input" style="width:30% !important;" id="" name="" type="" value="" placeholder = "input2" />

    </body>
</html>