<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- Edited by XMLSpy® -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
<table>
<tr>
<td width="50%">
<h2>Welcome User</h2> 
</td>
<td>

</td>
</tr>
<tr>
<td>
<input type="submit" name="button" id="button" value="Add" style="width:100px;font-size:Larger;height:30px"/>
<input type="submit" name="button" id="button" value="Delete" style="width:100px;font-size:Larger;height:30px"/>
<input type="submit" name="button" id="button" value="Mark Completed" style="width:150px;font-size:Larger;height:30px"/>
<input  type="submit" name="button" id="button" value="Logout" style="width:100px;font-size:Larger;height:30px"/>
  <h2>Task List</h2>
<ul>
      <xsl:for-each select="//task">
        <li><a href=""><xsl:value-of select="title"/></a></li>
      </xsl:for-each>
      </ul>
  
</td>
</tr>
</table>
</body>
  </html>
</xsl:template>
</xsl:stylesheet>
