# Spring Data JPA query methods

## Keyword Expressions

* `And` creates a conjunction of multiple expressions
* `Or` creates a disjunction of multiple expressions
* `Between` finds values within a given range
* `LessThan` finds values less than a given value
* `LessThanEqual` finds values less than or equal to a given value
* `GreaterThan` finds values greater than a given value
* `GreaterThanEqual` finds values greater than or equal to a given value
* `IsNull` finds null values
* `IsNotNull` finds non-null values
* `Like` finds values that match a given pattern
* `NotLike` finds values that do not match a given pattern
* `StartingWith` finds values that start with a given prefix
* `EndingWith` finds values that end with a given suffix
* `Containing` finds values that contain a given substring
* `NotContaining` finds values that do not contain a given substring
* `OrderBy` sorts the results by a given property in ascending or descending order

## Logical Expressions

* `True`  returns all results
* `False`  returns no results
* `And, Or, Not`  creates more complex logical expressions

## Ignoring Case

* `IgnoreCase` ignores case when comparing strings

## Regex Expressions

* `Regexp` finds values that match a given regular expression
* `NotRegexp` finds values that do not match a given regular expression
* `Like (with % or _)` supports % as a wildcard for any number of characters and _ as a wildcard for a single character

## Nested Property Expressions

* `Nested` creates a nested property expression
* `And and Or` can be used within nested property expressions

## Collection Expressions

* `In` finds values that match any of the given values
* `NotIn` finds values that do not match any of the given values
* `True, False, And, Or, Not` can be used within collection expressions
* `OrderBy` sorts the collection results by a given property in ascending or descending order

## Distinct Results

* `Distinct` returns only distinct results

```java
List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
List<Customer> findByAgeGreaterThanEqualOrderByLastNameAscFirstNameAsc(int age);
List<Customer> findByLastNameIgnoreCaseContaining(String lastName);
List<Customer> findByOrdersProductPriceGreaterThanEqual(BigDecimal price);
```