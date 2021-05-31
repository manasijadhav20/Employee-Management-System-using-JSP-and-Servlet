<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Employee Management System</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <center>
    <body style="background-image: linear-gradient(to right,#00467f, #a5cc82);">
    <center>
        <form method="POST" action="employee">
            <table width="500px" border="1" align="center" >
                <tr><br><br>
                    <td style="text-align:center" colspan="5"><h1>Employee Registration</h1></td>
                     
                </tr>
                <tr>
                    <td style="text-align:center"><b>Employee ID</b></td>
                    <td style="text-align:center"><input type="text" name="empid" id="empid"></td>   
                </tr>
                <tr>
                    <td style="text-align:center"><b>First Name</b></td>
                    <td style="text-align:center"><input type="text" name="fname" id="fname"></td>   
                </tr>
                <tr>
                    <td style="text-align:center"><b>Last Name</b></td>
                    <td style="text-align:center"><input type="text" name="lname" id="lname"></td>   
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
                    <td style="text-align:center" colspan="2"><input type="submit" value="Submit" style="background-color: white; color: black;"></td>   
                </tr>
                <tr>
                    <td style="text-align:center" colspan="2"><input type="reset" value="Reset" style="background-color: white; color: black;"></td>   
                </tr>
             
            </table>    
        </form>
    </center><br>
        <p><a href="viewemployee" style="color: whitesmoke">View Employee List</a></p>
        <p><a href="login.jsp" style="color: whitesmoke">Already a User?</a></p>
     
    </body>
    </center>
</html>
