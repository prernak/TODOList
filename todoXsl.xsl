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
function getTaskDetailsAjax(id){
  
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

xmlhttp.open("GET","ajaxTaskDetail?taskId="+id,true);

xmlhttp.send();

  
}
</script>
  </head>
  
 
  <body>
<table  width="900px">
<tr>
<td colspan="2" width="50%">
<h2>Welcome User</h2> 
</td>

</tr>
<tr>
<td colspan="2">
<FORM METHOD="LINK" ACTION="addtask.html">
<input type="submit" name="button" id="button" value="Add" style="width:100px;font-size:Larger;height:30px"/>
<input type="submit" name="button" id="button" value="Delete" style="width:100px;font-size:Larger;height:30px"/>
<input type="submit" name="button" id="button" value="Mark Completed" style="width:150px;font-size:Larger;height:30px"/>
<input  type="submit" name="button" id="button" value="Logout" style="width:100px;font-size:Larger;height:30px"/>
</FORM>
</td>
</tr>
<tr>
<td valign='top' width="50">
  <h2>Task List</h2>
    <ul>
	<li>House Chores </li>
		<ul>  
    	<xsl:for-each select="/todolist/user[@ID=$userid]/category[name='House Chores']//Task">
	   <p>
		<input type="checkbox" id="{@ID}" name="{@ID}" /> 
		<a href="#"  >
		<xsl:attribute name="href">javascript: getTaskDetailsAjax("<xsl:value-of select="./@ID"/>")</xsl:attribute>		
		<xsl:value-of select="title"/></a></p>
       </xsl:for-each>
	   </ul>
	   <li>Shopping</li>
		<ul>  
    	<xsl:for-each select="/todolist/user[@ID=$userid]/category[name='Shopping']//Task">
	   <p>
		<input type="checkbox" id="{@ID}" name="{@ID}" /> 
		<a href="#"  >
		<xsl:attribute name="href">javascript: getTaskDetailsAjax("<xsl:value-of select="./@ID"/>")</xsl:attribute>		
		<xsl:value-of select="title"/></a></p>
       </xsl:for-each>
	   </ul>
	   <li>Work </li>
		<ul>  
    	<xsl:for-each select="/todolist/user[@ID=$userid]/category[name='Work']//Task">
	   <p>
		<input type="checkbox" id="{@ID}" name="{@ID}" /> 
		<a href="#"  >
		<xsl:attribute name="href">javascript: getTaskDetailsAjax("<xsl:value-of select="./@ID"/>")</xsl:attribute>		
		<xsl:value-of select="title"/></a></p>
       </xsl:for-each>
	   </ul>
	   
	   <li>School</li>
		<ul>  
    	<xsl:for-each select="/todolist/user[@ID=$userid]/category[name='School']//Task">
	   <p>
		<input type="checkbox" id="{@ID}" name="{@ID}" /> 
		<a href="#"  >
		<xsl:attribute name="href">javascript: getTaskDetailsAjax("<xsl:value-of select="./@ID"/>")</xsl:attribute>		
		<xsl:value-of select="title"/></a></p>
       </xsl:for-each>
	   </ul>
	   
	   <li>Other </li>
		<ul>  
    	<xsl:for-each select="/todolist/user[@ID=$userid]/category[name='Other']//Task">
	   <p>
		<input type="checkbox" id="{@ID}" name="{@ID}" /> 
		<a href="#"  >
		<xsl:attribute name="href">javascript: getTaskDetailsAjax("<xsl:value-of select="./@ID"/>")</xsl:attribute>		
		<xsl:value-of select="title"/></a></p>
       </xsl:for-each>
	   </ul>
    </ul>
  
 
  
</td>
<td valign='top' halign='left' ><div id="taskDetail"   > </div></td>
</tr>
</table>
</body>
  </html>
</xsl:template>
</xsl:stylesheet>
