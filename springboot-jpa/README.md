> 介绍：项目中实现了JdbcTemplate和JPA两种操作数据库方式
> JdbcTemplate偏向底层，使用起来较为不便，但是灵活性高，便于封装处理，个人较为推崇


# JPA命名

# JPA通用策略生成器
```java
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GeneratedValue {
    GenerationType strategy() default GenerationType.AUTO;

    String generator() default "";
}
```

* TABLE：使用一个特定的数据库表格来保存主键。
* SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
* IDENTITY：主键由数据库自动生成（主要是自动增长型）
* AUTO：主键由程序控制。

| Keyword           | Sample                                                  | JPQL snippet                                                   |
| ----------------- | ------------------------------------------------------- | -------------------------------------------------------------- |
| And               | findByLastnameAndFirstname                              | … where x.lastname = ?1 and x.firstname = ?2                   |
| Or                | findByLastnameOrFirstname                               | … where x.lastname = ?1 or x.firstname = ?2                    |
| Is,Equals         | findByFirstname,findByFirstnameIs,findByFirstnameEquals | … where x.firstname = ?1                                       |
| Between           | findByStartDateBetween                                  | … where x.startDate between ?1 and ?2                          |
| LessThan          | findByAgeLessThan                                       | … where x.age < ?1                                             |
| LessThanEqual     | findByAgeLessThanEqual                                  | … where x.age <= ?1                                            |
| GreaterThan       | findByAgeGreaterThan                                    | … where x.age > ?1                                             |
| GreaterThanEqual  | findByAgeGreaterThanEqual                               | … where x.age >= ?1                                            |
| After             | findByStartDateAfter                                    | … where x.startDate > ?1                                       |
| Before            | findByStartDateBefore                                   | … where x.startDate < ?1                                       |
| IsNull            | findByAgeIsNull                                         | … where x.age is null                                          |
| IsNotNull,NotNull | findByAge(Is)NotNull                                    | … where x.age not null                                         |
| Like              | findByFirstnameLike                                     | … where x.firstname like ?1                                    |
| NotLike           | findByFirstnameNotLike                                  | … where x.firstname not like ?1                                |
| StartingWith      | findByFirstnameStartingWith                             | … where x.firstname like ?1 (parameter bound with appended %)  |
| EndingWith        | findByFirstnameEndingWith                               | … where x.firstname like ?1 (parameter bound with prepended %) |
| Containing        | findByFirstnameContaining                               | … where x.firstname like ?1 (parameter bound wrapped in %)     |
| OrderBy           | findByAgeOrderByLastnameDesc                            | … where x.age = ?1 order by x.lastname desc                    |
| Not               | findByLastnameNot                                       | … where x.lastname <> ?1                                       |
| In                | findByAgeIn(Collection<Age> ages)                       | … where x.age in ?1                                            |
| NotIn             | findByAgeNotIn(Collection<Age> ages)                    | … where x.age not in ?1                                        |
| True              | findByActiveTrue()                                      | … where x.active = true                                        |
| False             | findByActiveFalse()                                     | … where x.active = false                                       |
| IgnoreCase        | findByFirstnameIgnoreCase                               | … where UPPER(x.firstame) = UPPER(?1)                          |
