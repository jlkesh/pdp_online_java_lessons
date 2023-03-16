# jakarta.persistence.Query Interface Methods
| Method                 | Description                                                                                                                            |
|:-----------------------|:---------------------------------------------------------------------------------------------------------------------------------------|
| executeUpdate          | Executes an update or delete statement (returns: int)                                                                                  |
| getFirstResult         | Specifies the position of the first result the query object was set to retrieve (returns: int)                                         |
| getFlushMode           | Gets the flush mode in effect for the query execution (returns: FlushModeType)                                                         |
| getHints               | Gets the properties and hints and associated values that are in effect for the query instance (returns: java.util.Map<String, Object>) |
| getLockMode            | Gets the current lock mode for the query (returns: LockModeType)                                                                       |
| getMaxResults          | Specifies the maximum number of results the query object was set to retrieve (returns: int)                                            |
| getParameter           | Gets the parameter object corresponding to the declared positional parameter (returns: Parameter<?>)                                   |
| getParameters          | Gets the parameter objects corresponding to the declared parameters of the query (returns: java.util.Set<Parameter<?>>)                |
| getParameterValue(int) | Returns the value bound to the positional parameter (returns: Object)                                                                  |
| getResultList          | Executes a SELECT query and then returns the query results as an untyped List (returns: java.util.List)                                |
| getSingleResult        | Executes a SELECT query and then returns a single untyped result (returns: java.lang.Object)                                           |
| isBound                | Returns a Boolean indicating whether a value has been bound to the parameter                                                           |


