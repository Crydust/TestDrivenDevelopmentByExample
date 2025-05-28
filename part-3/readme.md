# Part 3 - Chapter 30  - Design patterns

## Command

Store a method call and all required parameters in an object.
In java that would often be a class implementing one of:
* `java.lang.Runnable`
* `java.lang.Callable`
* `javax.swing.Action`
Since Java 8 you can use a lambda to succinctly create one of these.

## Value object

Immutable object wrapping a value.
This avoids the aliasing problem where you fear someone altering your fields because that would invalidate cached calculations.

## Null object

An object representing the empty state.
Use an object with noop behavior instead of having null checks and conditions everywhere.
