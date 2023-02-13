# Standard Built-In Constraints

| Annotation            | Description                                                                                            | 
|:----------------------|--------------------------------------------------------------------------------------------------------|
| _**@Null**_           | The annotated element must be null                                                                     |
| _**@NotNull**_        | The annotated element must not be null                                                                 |
| _**@AssertTrue**_     | The annotated element must be true                                                                     |
| _**@AssertFalse**_    | The annotated element must be false                                                                    |
| _**@Min**_            | The annotated element must be a number with a value that is higher or equal to the  specified minimum  |
| _**@Max**_            | The annotated element must be a number with a value that is lower or equal to the specified maximum    |
| _**@DecimalMin**_     | The annotated element must be a decimal with a value that is higher or equal to the  specified minimum |
| _**@DecimalMax**_     | The annotated element must be a decimal with a value that is lower or equal to the  specified maximum  |
| _**@Negative**_       | The annotated element must be a strictly negative number                                               |
| _**@NegativeOrZero**_ | The annotated element must be a negative number or zero                                                |
| _**@Positive**_       | The annotated element must be a strictly positive number                                               |
| _**@PositiveOrZero**_ | The annotated element must be strictly positive or zero                                                |
| _**@Size**_           | The annotated element size must fall within the specified boundaries                                   |
| _**@Digits**_         | The annotated element must be a number in the accepted range                                           |
| _**@Past**_                 | The annotated element must be an instant, date, or time in the past                                    |     
| _**@PastOrPresent**_        | The annotated element must be an instant, date, or time in the past or present                         |
| _**@Future**_               | The annotated element must be an instant, date, or time in the future                                  |
| _**@FutureOrPresent**_      | The annotated element must be an instant, date, or time in the future or present                       |
| _**@Pattern**_              | The annotated element must fall within the constraints of the specified regular expression             |
| _**@NotEmpty**_             | The annotated element must not be empty or null                                                        |
| _**@NotBlank**_             | The annotated element must not be null and must contain at least one character                         |
| _**@Email**_                | The annotated string must be a well-formed email address                                               |
