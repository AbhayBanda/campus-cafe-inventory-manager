# Java Warmup Questions and Answers

## 1. What did you predict for `Warmup.java`, and what did it actually print? Explain the surprising lines.

It printed:

```text
7 5.0 -126
Two
Three
```

- `(int) 7.9` truncates the decimal part, producing `7`.
- Assigning the integer `5` to a `double` widens it to `5.0`.
- Casting `130` to a `byte` produces `-126` because a byte can represent values only from `-128` to `127`.
- The `switch` has no `break` statements, so execution continues from `case 2` into `case 3`, printing both `Two` and `Three`.

## 2. What is the difference between the static variable `totalProducts` and the instance variable `name`?

`totalProducts` belongs to the `Product` class and is shared by all `Product` objects. Each `Product` object has its own instance variable `name`.

## 3. What does the copy constructor do, and why does changing `p2.name` not change `p1.name`?

The copy constructor creates a new `Product` object and copies the field values from another `Product`. The two objects have separate `name` fields, so assigning a new value to `p2.name` does not change `p1.name`.

## 4. Why does Java require `(int)` when converting a `double` to an `int`, and what happens to the decimal part?

Java requires an explicit cast because converting a `double` to an `int` can lose information. The fractional part is discarded by truncating toward zero.
