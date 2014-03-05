<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- Edited by XMLSpyÂ® -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:param name="userid"/>
<xsl:param name="username"/>
<xsl:template match="/">
  <html>
  
  <head>
  <script>
function getTaskDetailsAjax()
{
  
var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if( (xmlhttp.readyState==4)){
  	if( xmlhttp.status==200){
    document.getElementById("taskDetail").innerHTML=xmlhttp.responseText;
    }
    }
  }
xmlhttp.open("GET","ajaxTaskDetail",true);
xmlhttp.send();
  
}
</script>
  </head>
  
 
  <body>
<table>
<tr>
<td colspan="2" width="50%">
<h2>Welcome User</h2> 
</td>

</tr>
<tr>
<td colspan="2">
<input type="submit" name="button" id="button" value="Add" style="width:100px;font-size:Larger;height:30px"/>
<input type="submit" name="button" id="button" value="Delete" style="width:100px;font-size:Larger;height:30px"/>
<input type="submit" name="button" id="button" value="Mark Completed" style="width:150px;font-size:Larger;height:30px"/>
<input  type="submit" name="button" id="button" value="Logout" style="width:100px;font-size:Larger;height:30px"/>
</td>
</tr>
<tr>
<td>
  <h2>Task List</h2>
<ul>
	<xsl:for-each select="/todoList/user[@id=$userid]//task">
        <li id="{@id}"><a href="#" onclick="getTaskDetailsAjax()"><xsl:value-of select="title"/></a></li>
      </xsl:for-each>
      </ul>
  
</td>
<td><div id="taskDetail"> </div></td>
</tr>
</table>
</body>
  </html>
</xsl:template>
</xsl:stylesheet>
