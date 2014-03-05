<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- Edited by XMLSpy® -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:param name="taskId"/>
<xsl:param name="username"/>
<xsl:template match="/">
  <html>
  
  <head>

  </head>
  
 
  <body>
<table>
<tr>
<td/>
<td/>
</tr>
<tr>
<td>
  <h3>Task Details</h3>
  
  
<ul>	


	<xsl:for-each select="/todolist/user//Task[@ID=$taskId]">

	<p><b>Title :</b>  <xsl:value-of select="./title"/></p>
	<p><b>Description :</b>  <xsl:value-of select="./description"/></p>
	<p><b>Priority : </b> <xsl:value-of select="./priority/@ID"/></p>
	<p><b>Duedate : </b> <xsl:value-of select="./duedate"/></p>
	<p><b>Status :</b>  <xsl:value-of select="./status/@ID"/></p>
	<p><b>Contributors :</b> </p> <p> <xsl:for-each select=".//contributor">
							<li> <xsl:value-of select="."/></li>
						</xsl:for-each>
	</p>
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
