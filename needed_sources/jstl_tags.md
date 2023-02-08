# Dependency

````
<dependency>
      <groupId>jakarta.servlet.jsp.jstl</groupId>
      <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
      <version>3.0.0</version>
</dependency>

<dependency>
      <groupId>org.glassfish.web</groupId>
      <artifactId>jakarta.servlet.jsp.jstl</artifactId>
      <version>3.0.1</version>
</dependency>        
````

# Jakarta EE JSTL Tags

[https://jakarta.ee/specifications/tags/3.0/tagdocs/](https://jakarta.ee/specifications/tags/3.0/tagdocs/)

````html
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
````
## Core Libraries

| tag name      | description                                                                                                                        |
|:--------------|:-----------------------------------------------------------------------------------------------------------------------------------|
| <c:out>       | Like <%= ... >, but for expressions.                                                                                               |
| <c:set>       | Sets the result of an expression evaluation in a 'scope'                                                                           |
| <c:remove>    | Removes a scoped variable (from a particular scope, if specified).                                                                 |
| <c:catch>     | Catches any Throwable that occurs in its body and optionally exposes it.                                                           |
| <c:if>        | Simple conditional tag which evaluates its body if the supplied condition is true.                                                 | 
| <c:choose>    | Simple conditional tag that establishes a context for mutually exclusive conditional operations, marked by <when> and <otherwise>. |
| <c:when>      | Subtag of <choose> that includes its body if its condition evaluates to 'true'.                                                    |
| <c:otherwise> | Subtag of <choose> that follows the <when> tags and runs only if all of the prior conditions evaluated to 'false'.                 |
| <c:import>    | Retrieves an absolute or relative URL and exposes its contents to either the page, a String in 'var', or a Reader in 'varReader'.  |
| <c:forEach>   | The basic iteration tag, accepting many different collection types and supporting submitting and other functionality .             |
| <c:forTokens> | Iterates over tokens, separated by the supplied delimiters.                                                                        |
| <c:param>     | Adds a parameter to a containing 'import' tag's URL.                                                                               |
| <c:redirect>  | Redirects to a new URL.                                                                                                            |
| <c:url>       | Creates a URL with optional query parameters                                                                                       |

## Formatting Tags

| tag name              | description                                                                                              |
|:----------------------|:---------------------------------------------------------------------------------------------------------|
| <fmt:formatNumber>    | To render numerical value with specific precision or format.                                             |
| <fmt:parseNumber>     | Parses the string representation of a number, currency, or percentage.                                   |
| <fmt:formatDate>      | Formats a date and/or time using the supplied styles and pattern.                                        |
| <fmt:parseDate>       | Parses the string representation of a date and/or time                                                   |
| <fmt:bundle>          | Loads a resource bundle to be used by its tag body.                                                      |
| <fmt:setLocale>       | Stores the given locale in the locale configuration variable.                                            |
| <fmt:setBundle>       | Loads a resource bundle and stores it in the named scoped variable or the bundle configuration variable. |
| <fmt:timeZone>        | Specifies the time zone for any time formatting or parsing actions nested in its body.                   |
| <fmt:setTimeZone>     | Stores the given time zone in the time zone configuration variable                                       |
| <fmt:message>         | Displays an internationalized message.                                                                   |
| <fmt:requestEncoding> | Sets the request character encoding                                                                      |

## SQL Tags

| tag name            | description                                                                                                             |
|:--------------------|:------------------------------------------------------------------------------------------------------------------------|
| <sql:setDataSource> | Creates a simple DataSource suitable only for prototyping                                                               |
| <sql:query>         | Executes the SQL query defined in its body or through the sql attribute.                                                |
| <sql:update>        | Executes the SQL update defined in its body or through the sql attribute.                                               |
| <sql:param>         | Sets a parameter in an SQL statement to the specified value.                                                            |
| <sql:dateParam>     | Sets a parameter in an SQL statement to the specified java.util.Date value.                                             |
| <sql:transaction>   | Provides nested database action elements with a shared Connection, set up to execute all statements as one transaction. |

## Function Tags

| tag name                  | description                                                                                       |
|:--------------------------|:--------------------------------------------------------------------------------------------------|
| <fn:contains()>           | Tests if an input string contains the specified substring.                                        |
| <fn:containsIgnoreCase()> | Tests if an input string contains the specified substring in a case insensitive way.              |
| <fn:endsWith()>           | Tests if an input string ends with the specified suffix.                                          |
| <fn:escapeXml()>          | Escapes characters that can be interpreted as XML markup.                                         |
| <fn:indexOf()>            | Returns the index withing a string of the first occurrence of a specified substring.              |
| <fn:join()>               | Joins all elements of an array into a string.                                                     |
| <fn:length()>             | Returns the number of items in a collection, or the number of characters in a string.             |
| <fn:replace()>            | Returns a string resulting from replacing in an input string all occurrences with a given string. |
| <fn:split()>              | Splits a string into an array of substrings.                                                      |
| <fn:startsWith()>         | Tests if an input string starts with the specified prefix.                                        |
| <fn:substring()>          | Returns a subset of a string.                                                                     |
| <fn:substringAfter()>     | Returns a subset of a string following a specific substring.                                      |
| <fn:substringBefore()>    | Returns a subset of a string before a specific substring.                                         |
| <fn:toLowerCase()>        | Converts all of the characters of a string to lower case.                                         |
| <fn:toUpperCase()>        | Converts all of the characters of a string to upper case.                                         |
| <fn:trim()>               | Removes white spaces from both ends of a string.                                                  |

## XML Tags

| tag name      | description                                                                                                                             |
|:--------------|:----------------------------------------------------------------------------------------------------------------------------------------|
| <x:out>       | Like <%= ... >, but for XPath expressions.                                                                                              |
| <x:parse>     | Used to parse the XML data specified either via an attribute or in the tag body.                                                        |
| <x:set>       | Sets a variable to the value of an XPath expression.                                                                                    |
| <x:if>        | Evaluates a test XPath expression and if it is true, it processes its body. If the test condition is false, the body is ignored.        |
| <x:forEach>   | To loop over nodes in an XML document.                                                                                                  |
| <x:choose>    | Simple conditional tag that establishes a context for mutually exclusive conditional operations, marked by <when> and <otherwise> tags. |
| <x:when>      | Subtag of <choose> that includes its body if its expression evaluates to 'true'.                                                        |
| <x:otherwise> | Subtag of <choose> that follows the <when> tags and runs only if all of the prior conditions evaluates to 'false'.                      |
| <x:transform> | Applies an XSL transformation on a XML document                                                                                         |
| <x:param>     | Used along with the transform tag to set a parameter in the XSLT stylesheet                                                             |




