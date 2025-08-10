# Breadth First Search + Queue

### Description

#### Context

As a user, I'd like to know the nearest city from a certain coordinate. Whenever I inform a coordinate which is a pair of line and column in a map, I want to know which city is the closest one from this coordinate. The line and column numbers are simple integer numbers starting from 0.

#### Given

There is a map of cities where every coordinate has a distance of 1 from its neighbors. Each coordinate is a pair of line and column numbers. For example, (3,5), where 3 is the line and 5 the column.

| São Joaquim da Barra | 1 | 1 | 1 | 1 | 1 |
|:--------------------:|:-:|:-:|:-:|:-:|:-:|
| 1                    | 1 | 1 | 1 | 1 | 1 |
| 1                    | 1 | Ribeirão Preto | 1 | 1 | 1 |
| 1                    | 1 | 1 | 1 | 1 | 1 |
| 1                    | 1 | 1 | Serrana | 1 | 1 |
| 1                    | 1 | 1 | 1 | 1 | 1 |


#### When

A coordinate is passed through the endpoint /nearest-city?line=2&column=1

#### Then

The name of the nearest city from this coordinate is returned as a json

```json
{
  "nearest_city": "Ribeirão Preto"
}
```
