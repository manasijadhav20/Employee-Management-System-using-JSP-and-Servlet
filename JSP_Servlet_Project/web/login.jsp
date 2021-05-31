<%-- 
    Document   : signin
    Created on : 3 Feb, 2021, 8:43:40 PM
    Author     : MANASI
--%>

<html>
    <head>
        <title>Employee Management System</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <center>
    <body style="background-image: linear-gradient(to right,#00467f, #a5cc82);">
    <center>
        <form action="loginpage.jsp" method="POST">
            <table width="400px" border="1" align="center" >
                <tr>
                    <td style="text-align:center" colspan="5"><h1>Employee Login</h1></td>
                     
                </tr>
                
                <tr>
                    <td style="text-align:center"><b>Email Address</b></td>
                    <td style="text-align:center"><input type="email" name="email" id="email"></td>   
                </tr>
                <tr>
                    <td style="text-align:center"><b>Password</b></td>
                    <td style="text-align:center"><input type="password" name="password" id="password"></td>   
                </tr>
                
                <tr>
                    <td style="text-align:center" colspan="2"><input type="submit" value="submit" style="background-color: white; color: black;"></td>   
                </tr>
             
            </table>    
        </form>
        </center>
     
    </body>
    </center>
</html>
