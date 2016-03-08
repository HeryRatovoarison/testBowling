<%-- 
    Document   : index
    Created on : 30 déc. 2015, 00:42:09
    Author     : herisata
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Score Bowling</title>
        <%
            Integer nbFrame=(Integer)request.getAttribute("frame");
            Integer nbLancer=(Integer)request.getAttribute("lancer");
            Integer score=(Integer)request.getAttribute("score");
            String erreur=(String)request.getAttribute("erreur");
            Integer maxQuilles=(Integer)request.getAttribute("maxQuilles");
            
            nbFrame=(nbFrame!=null)?nbFrame:1;
            nbLancer=(nbLancer!=null)?nbLancer:1;
            score=(score!=null)?score:0;
            erreur=(erreur!=null)?erreur:"";
            //maxQuilles=(maxQuilles!=null)?maxQuilles:15;
            
        %>
    </head>
    <body>
        <span>Frame Num&eacute;ro : <%=nbFrame%> </span><br/>
        <span>Lancer Num&eacute;ro : <%=nbLancer%></span><br/>
        <form method="POST" action="./ScoreServlet">
            <span>Nombre de quilles touchées:</span>
            <input type="number" name="quilles" min="0" max="<%=maxQuilles%>"/>
            <input type="submit" <% if(nbFrame==0) out.print("disabled=''");%>/>
        </form>
        <hr>
        <div>
            Score <% if(nbFrame!=0) out.print("actuel"); else out.println("final");%>: <%=score%><br>
            <%=(erreur!=null)?erreur:""%>
            <a href="./ScoreServlet"><input type="submit" value="Nouveau jeu"/></a>
        </div>
    </body>
</html>
